const TreeNode = require("../util/TreeNode");

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var constructMaximumBinaryTree = function (nums) {
    return buildTree(0, nums.length - 1);

    function buildTree(left, right) {
        if (right < left) {
            return null;
        } else if (right === left) {
            return new TreeNode(nums[left]);
        }
        let maxPos = left;
        for (let i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }
        let node = new TreeNode(nums[maxPos]);
        node.left = buildTree(left, maxPos - 1);
        node.right = buildTree(maxPos + 1, right);
        return node;
    }
};

/*
const chai = require("chai");

describe("constructMaximumBinaryTree", function () {
    // [3,2,1,6,0,5]
    [
        {input: [3, 2, 1, 6, 0, 5]}
    ].forEach(({input, expected}) =>
        it(`should pass: constructMaximumBinaryTree([${input.toString()}])`, function () {
            let actual = constructMaximumBinaryTree(input);

            // chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
*/
