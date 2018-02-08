/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
var ListNode = require("../util/ListNode");

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    if (l1 === null) {
        return l2;
    }
    if (l2 === null) {
        return l1;
    }

    let carry = 0, last = {}, head;
    while (l1 !== null && l2 !== null) {
        let sum = l1.val + l2.val + carry;
        let next = new ListNode(sum % 10);
        carry = Math.floor(sum / 10);

        if (head === undefined) {
            head = next;
            last = head;
        } else {
            last.next = next;
            last = next;
        }

        l1 = l1.next;
        l2 = l2.next;
    }

    while (l1 !== null) {
        let sum = l1.val + carry;
        let next = new ListNode(sum % 10);
        carry = Math.floor(sum / 10);
        last.next = next;
        last = next;

        l1 = l1.next;
    }

    while (l2 !== null) {
        let sum = l2.val + carry;
        let next = new ListNode(sum % 10);
        carry = Math.floor(sum / 10);
        last.next = next;
        last = next;

        l2 = l2.next;
    }

    if (carry === 1) {
        last.next = new ListNode(1);
    }

    return head;
};

const chai = require("chai");

describe("addTwoNumbers", function () {
    [
        {
            input: {
                l1: [2, 4, 3],
                l2: [5, 6, 4]
            },
            expected: [7, 0, 8]
        },
    ].forEach(({input, expected}) =>
        it(`should pass: addTwoNumbers([${input.l1.toString()}], [${input.l2.toString()}])`, function () {
            let actual = twoSum(input.l1, input.l2);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});

