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
 * @param {number} L
 * @param {number} R
 * @return {TreeNode}
 */
var trimBST = function (root, L, R) {
    if (root === null) {
        return root;
    }
    if (L > root.val) {
        return trimBST(root.right, L, R);
    } else if (R < root.val) {
        return trimBST(root.left, L, R);
    } else {
        let newRoot = new TreeNode(root.val);
        newRoot.left = trimBST(root.left, L, R);
        newRoot.right = trimBST(root.right, L, R);
        return newRoot;
    }
};

const chai = require("chai");

describe("trimBST", function () {
    [].forEach(({input, expected}) =>
        it(`should pass: trimBST([${input.toString()}])`, function () {
            let actual = trimBST(input.A, input.B);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
