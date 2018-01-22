function Heap() {
    const heap = [];

    this.insert = i => {
        heap.push(i);
        let pos = heap.length - 1;
        while (pos > 0) {
            let parentPos = Math.floor((pos - 1) / 2);
            if (isCorrectOrder(pos, parentPos)) {
                break;
            } else {
                swap(pos, parentPos);
                pos = parentPos;
            }
        }
    };

    this.extract = () => {
        if (heap.length > 1) {
            let val = heap[0];
            let last = heap.length - 1;
            heap[0] = extractFromHeap(last);
            maxHeapify(0);
            return val;
        } else if (heap.length === 1) {
            return extractFromHeap(0);
        } else {
            throw new Error("heap is empty, cannot extract");
        }
    };

    function maxHeapify(pos) {
        let leftPos = pos * 2 + 1, rightPos = pos * 2 + 2;
        let {hasBetterPos, betterPos} = getBetterPos(rightPos, leftPos);
        if (hasBetterPos) {
            if (!isCorrectOrder(betterPos, pos)) {
                swap(pos, betterPos);
                maxHeapify(betterPos);
            }
        }
    }

    function getBetterPos(rightPos, leftPos) {
        let leftValid = leftPos < heap.length, rightValid = rightPos < heap.length;
        let betterPos = -1;
        if (!leftValid && !rightValid) {
            return {hasBetterPos: false}
        } else if (!leftValid) {
            betterPos = rightPos;
        } else if (!leftValid) {
            betterPos = leftPos;
        } else {
            let rightVal = heap[rightPos];
            let leftVal = heap[leftPos];

            let isRightBetter = rightVal > leftVal;
            betterPos = isRightBetter ? rightPos : leftPos;
        }
        return {
            hasBetterPos: true,
            betterPos
        };
    }

    function extractFromHeap(pos) {
        return heap.splice(pos, 1)[0];
    }

    function isCorrectOrder(pos, parentPos) {
        return heap[parentPos] > heap[pos];
    }

    function swap(pos, otherPos) {
        let temp = heap[pos];
        heap[pos] = heap[otherPos];
        heap[otherPos] = temp;
    }
}

const chai = require("chai");

describe("Heap", function () {
    it('should work', function () {
        let heap = new Heap();
        [3, 2, 1, 6, 0, 5].forEach(i => heap.insert(i));

        [6, 5, 3, 2, 1, 0].forEach(i =>
            chai.expect(heap.extract()).to.equal(i)
        );
    });
});

