/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var complexNumberMultiply = function (a, b) {
    let [ra, ia] = convert(a), [rb, ib] = convert(b);
    return format(ra * rb - ia * ib, ia * rb + ib * ra);

    function convert(str) {
        let r, i;
        let parts = str.split("+");
        r = parseInt(parts[0]);
        i = parseInt(parts[1].substring(0, parts[1].length - 1));
        return [r, i];
    }

    function format(r, i) {
        return `${r}+${i}i`;
    }
};

const chai = require("chai");

describe("complexNumberMultiply", function () {
    [
        {
            input: {a: "1+1i", b: "1+1i"},
            expected: "0+2i"
        },
        {
            input: {a: "1+-1i", b: "1+-1i"},
            expected: "0+-2i"
        },
    ].forEach(({input, expected}) =>
        it(`should pass: complexNumberMultiply([${input.toString()}])`, function () {
            let actual = complexNumberMultiply(input.a, input.b);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
