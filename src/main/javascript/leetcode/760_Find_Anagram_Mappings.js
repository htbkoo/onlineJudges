/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number[]}
 */
var anagramMappings = function (A, B) {
    let mapping = B.reduce((obj, curr, index) => {
        if (curr in obj) {
            obj[curr].push(index);
        } else {
            obj[curr] = [index];
        }
        return obj;
    }, {});
    return A.map(value => {
        let pos = mapping[value][0];
        mapping[value] = mapping[value].splice(1);
        return pos;
    });
};

const chai = require("chai");

describe("anagramMappings", function () {
    [
        {
            input: {
                A: [12, 28, 46, 32, 50],
                B: [50, 12, 32, 46, 28]
            },
            expected: [1, 4, 3, 2, 0]
        },
        {
            input: {
                A: [12, 28, 46, 32, 50, 12, 12],
                B: [50, 12, 32, 46, 28, 12, 12]
            },
            expected: [1, 4, 3, 2, 0, 5, 6]
        },
    ].forEach(({input, expected}) =>
        it(`should pass: anagramMappings([${input.toString()}])`, function () {
            let actual = anagramMappings(input.A, input.B);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
