var fill = function (image, sr, sc, newColour, visited, oldColour) {
    visited[sr][sc] = true;
    image[sr][sc] = newColour;
    [
        [0, -1],
        [0, 1],
        [-1, 0],
        [1, 0],
    ].forEach(([dr, dc]) => {
        let nr = sr + dr, nc = sc + dc;
        if (isInBoundary(nr, nc)) {
            if (!visited[nr][nc]) {
                if (image[nr][nc] === oldColour) {
                    fill(image, nr, nc, newColour, visited, oldColour);
                }
            }
        }
    });

    return image;

    function isInBoundary(r, c) {
        return (r >= 0) && (c >= 0) && (r < image.length) && (c < image[0].length);
    }
};

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
var floodFill = function (image, sr, sc, newColor) {
    const visited = new Array(image.length).fill(0).map(() => new Array(image[0].length).fill(false));
    return fill(image, sr, sc, newColor, visited, image[sr][sc]);
};

const chai = require("chai");

describe("floodFill", function () {
    [].forEach(({input, expected}) =>
        it(`should pass: floodFill([${input.toString()}])`, function () {
            let actual = floodFill(input.A, input.B);

            chai.expect(actual).to.be.deep.equal(expected);
        })
    );
});
