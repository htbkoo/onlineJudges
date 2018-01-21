/**
 * @param {number} num
 * @return {number}
 */
var findComplement = function (num) {
    if (num < 0) {
        throw new Error("seems negative numbers are out of scope according to the sample test cases")
    }
    if (num === 0) {
        return 1;
    }
    return (Math.pow(2, Math.floor(Math.log2(num)) + 1) - 1) - num;
};

const chai = require("chai");

describe("NumberComplement", function () {
    [
        {
            input: {
                num: 0
            },
            expected: 1
        },
        {
            input: {
                num: 1
            },
            expected: 0
        },
        {
            input: {
                num: 2
            },
            expected: 1
        },
        {
            input: {
                num: 3
            },
            expected: 0
        },
        {
            input: {
                num: 4
            },
            expected: 3
        },
        {
            input: {
                num: 5
            },
            expected: 2
        },
        {
            input: {
                num: 6
            },
            expected: 1
        },
        {
            input: {
                num: 7
            },
            expected: 0
        },
        {
            input: {
                num: 8
            },
            expected: 7
        },
    ].forEach(({input, expected}) =>
        it(`should pass: findComplement(${input.num.toString()})`, function () {
            let actual = findComplement(input.num);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});

