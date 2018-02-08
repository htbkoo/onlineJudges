function HashMap() {
    let map = {};

    this.put = (key, value) => map[key] = value;
    this.get = key => map[key];

    return this;
}

const chai = require("chai");

describe("mergeSort", function () {
    it('should work', function () {
        let hashMap = new HashMap();
        hashMap.put("aKey", "aValue");
        chai.expect(hashMap.get("aKey")).to.equal("aValue");
    });
});

