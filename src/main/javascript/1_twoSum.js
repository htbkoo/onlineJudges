function twoSum(nums, target) {
    // const sorted = nums.slice().sort((a, b) => a - b);
    const sorted = nums.slice();
    const length = sorted.length;
    for (let i = 0; i < length - 1; i++) {
        for (let j = i + 1; j < length; j++) {
            if (j === i) {
                continue;
            }
            if (sorted[i] + sorted[j] === target) {
                return [i, j];
            }
            // if (sorted[i] + sorted[j] > target) {
            //     break;
            // }

        }
    }
    throw new Error("no solution - should not be possible according to problem description");
}

const chai = require("chai");

describe("twoSum", function () {
    [
        {
            input: {
                nums: [2, 7, 11, 15],
                target: 9
            },
            expected: [0, 1]
        },
        {
            input: {
                nums: [2, 7, 11, 15],
                target: 13
            },
            expected: [0, 2]
        },
        {
            input: {
                nums: [3, 2, 4],
                target: 6
            },
            expected: [1, 2]
        }
    ].forEach(({input, expected}) =>
        it(`should pass: twoSum([${input.nums.toString()}], ${input.target.toString()})`, function () {
            let actual = twoSum(input.nums, input.target);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});