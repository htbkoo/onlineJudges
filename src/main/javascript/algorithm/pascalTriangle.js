// noinspection JSUnusedLocalSymbols
var pascalTriangleIterative = function (layer) {
    let result = "";
    for (let i=1;i<=layer;i++){
        let current=1;
        for (let j=0;j<i;j++){
            if (j>0){
                current=Math.floor(current*(i-j)/j);
            }
            result=result.concat(current.toString());
        }
        if (i<layer){
            result= result.concat("\n");
        }
    }
    return result;
};

var pascalTriangle = function (layer) {
    let result="";
    if (layer<=1){
        return "1";
    }else{
        result = pascalTriangle(layer-1);
        let row = "", current = 1;
        for (let i=0;i<layer;i++){
            if (i>0){
                current = Math.floor(current*(layer-i)/i);
            }
            row=row.concat(current.toString());
        }

        return result.concat("\n").concat(row);
    }
};

const chai = require("chai");

describe("pascalTriangle", function () {
    [
        {
            input: 1,
            expected: `1`
        },
        {
            input: 2,
            expected: "1\n11"
        },
        {
            input: 3,
            expected: "1\n11\n121"
        },
        {
            input: 4,
            expected: "1\n11\n121\n1331"
        },
        {
            input: 5,
            expected: "1\n11\n121\n1331\n14641"
        }
    ].forEach(({input, expected}) =>
        it(`should pass: pascalTriangle([${input.toString()}])`, function () {
            let actual = pascalTriangle(input);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
