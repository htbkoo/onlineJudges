const TreeNode = require("../util/TreeNode");

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} v
 * @param {number} d
 * @return {TreeNode}
 */
var addOneRow = function (root, v, d) {
    if (root === null) {
        return new TreeNode(v);
    } else if (d === 1) {
        let node = new TreeNode(v);
        node.left = root;
        return node;
    } else if (d === 2) {
        let newLeft = new TreeNode(v);
        newLeft.left = root.left;
        root.left = newLeft;
        let newRight = new TreeNode(v);
        newRight.right = root.right;
        root.right = newRight;
        return root;
    } else {
        if (root.left !== null) {
            root.left = addOneRow(root.left, v, d - 1);

        }
        if (root.right !== null) {
            root.right = addOneRow(root.right, v, d - 1);
        }
        return root;
    }
};

const chai = require("chai");

describe("addOneRow", function () {
    [].forEach(({input, expected}) =>
        it(`should pass: addOneRow([${input.toString()}])`, function () {
            let actual = addOneRow(input.A, input.B);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
