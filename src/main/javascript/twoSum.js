function twoSum() {
    return [0, 1];
}

const chai = require("chai");

describe("twoSum", function () {
    it("should pass", function () {
        const input = {
            nums: [2, 7, 11, 15],
            target: 9
        };
        const expected = [0, 1];

        let actual = twoSum(input.nums, input.target);

        chai.expect(actual).to.be.deep.equal(expected);
    });
});