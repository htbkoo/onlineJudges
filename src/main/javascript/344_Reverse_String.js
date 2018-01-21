/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    return s.split("").reverse().join("");
};

const chai = require("chai");

describe("ReverseString", function () {
    [
        {
            input: {
                s: "hello"
            },
            expected: "olleh"
        },
        {
            input: {
                s: ""
            },
            expected: ""
        },
        {
            input: {
                s: "Reverse"
            },
            expected: "esreveR"
        }
    ].forEach(({input, expected}) =>
        it(`should pass: findComplement(${input.s})`, function () {
            let actual = reverseString(input.s);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});

