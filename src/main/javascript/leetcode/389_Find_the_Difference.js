/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function (s, t) {
    let mapS = map(s), mapT = map(t);

    let keys = Object.keys(mapT);
    let missing = "";
    keys.every(c => {
        if (mapT[c] !== mapS[c]){
            missing = c;
            return false;
        }else{
            return true;
        }
    });

    return missing;

    function map(str) {
        return str.split("").reduce((prev, c) => {
            if (c in prev) {
                prev[c]++;
            } else {
                prev[c] = 1;
            }
            return prev;
        }, {});
    }

    /*let length = t.length;
    for (let i = 0; i < length; i++) {
        if (i >= s.length) {
            return t.charAt(i);
        } else if (t.charAt(i) !== s.charAt(i)) {
            return t.charAt(i);
        }
    }*/
};

const chai = require("chai");

describe("findTheDifference", function () {
    [
        {
            input: {s: "abcd", t: "abcde"},
            expected: "e"
        }
    ].forEach(({input, expected}) =>
        it(`should pass: findTheDifference([${input.toString()}])`, function () {
            let actual = findTheDifference(input.s, input.t);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
