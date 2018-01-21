var mergeSort = function (input) {
    let length = input.length;
    if (length === 0) {
        return [];
    } else {
        return mergeSortInPlace(input.slice(), 0, length - 1);
    }
};

var mergeSortInPlace = function (input, start, end) {
    if (!(Array.isArray(input))) {
        throw new Error("only array is supported now");
    }
    if (start === end) {
        return input;
    } else if ((end - start) === 1) {
        let min = Math.min(input[start], input[end]);
        let max = Math.max(input[start], input[end]);
        input[start] = min;
        input[end] = max;
        return input;
    } else {
        let mid = start + Math.floor((end - start) / 2);
        mergeSortInPlace(input, start, mid);
        mergeSortInPlace(input, mid + 1, end);
        let p1 = start, p2 = mid + 1, count = start;
        let original = input.slice(start, end + 1);
        while (p1 <= mid || p2 <= end) {
            //    if swap this would be in place
            if (p1 > mid) {
                choose(p2);
                p2++;
            } else if (p2 > end) {
                choose(p1);
                p1++;
            } else if (original[p1-start] < original[p2-start]) {
                choose(p1);
                p1++;
            } else {
                choose(p2);
                p2++;
            }

            function choose(pos){
                input[count] = original[pos-start];
                count++;
            }
        }

        return input;
    }
};

const chai = require("chai");

describe("mergeSort", function () {
    [
        {
            input: [5, 3, 1, 2],
            expected: [1, 2, 3, 5]
        },
        {
            input: [5, 3, 1, 2, 4],
            expected: [1, 2, 3, 4, 5]
        },
        {
            input: [5, 3, 7, 1, 6, 2, 4, 8],
            expected: [1, 2, 3, 4, 5, 6, 7, 8]
        }
    ].forEach(({input, expected}) =>
        it(`should pass: findComplement([${input.toString()}])`, function () {
            let actual = mergeSort(input);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});


