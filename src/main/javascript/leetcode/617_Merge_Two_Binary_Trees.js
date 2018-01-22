const TreeNode = require("../util/TreeNode");

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} t1
 * @param {TreeNode} t2
 * @return {TreeNode}
 */
var mergeTrees = function (t1, t2) {
    if (t1 === null) {
        return t2;
    } else if (t2 === null) {
        return t1;
    } else {
        let newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }
};

const chai = require("chai");

describe("mergeTrees", function () {
    [].forEach(({input, expected}) =>
        it(`should pass: mergeTrees([${input.toString()}])`, function () {
            let actual = mergeTrees(input.A, input.B);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
