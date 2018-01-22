const {ListNode, list} = require("../util/ListNode");
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function (head) {
    if (head === null || head.next === null) {
        return head;
    }

    let fast = head, slow = head;
    while (fast !== null && fast.next !== null && fast.next.next !== null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    let secondHalf = slow.next;
    slow.next = null;
    head = sortList(head);
    secondHalf = sortList(secondHalf);
    let dummyHead = new ListNode(0), curr = dummyHead;

    while (head !== null && secondHalf !== null) {
        if (head.val < secondHalf.val) {
            curr.next = head;
            head = head.next;
        } else {
            curr.next = secondHalf;
            secondHalf = secondHalf.next;
        }
        curr = curr.next;
    }
    if (head !== null) {
        curr.next = head;
    }

    if (secondHalf !== null) {
        curr.next = secondHalf;
    }

    return dummyHead.next;
};

const chai = require("chai");

describe("sortList", function () {
    [
        {
            input: list([1, 5, 3, 4, 2]),
            expected: list([1, 2, 3, 4, 5])
        }
    ].forEach(({input, expected}) =>
        it(`should pass: sortList()`, function () {
            let actual = sortList(input);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});