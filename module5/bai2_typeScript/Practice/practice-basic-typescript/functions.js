function square(num) {
    return num * num;
}
console.log(square(5));
var squareFE = function (num) {
    return num * num;
};
console.log(squareFE(6));
//======================//
function add(a) {
    return function (b) {
        return a - b;
    };
}
var addWith5 = add(5);
console.log(add(2));
console.log(addWith5(3));
