function ListNode(val) {
    this.val = val;
    this.next = null;
}

module.exports = {
    ListNode,
    list(arr) {
        let dummyHead = new ListNode(0);

        arr.reduce((prev, curr) => {
            prev.next = new ListNode(curr);
            return prev.next;
        }, dummyHead);

        return dummyHead.next;
    }
};