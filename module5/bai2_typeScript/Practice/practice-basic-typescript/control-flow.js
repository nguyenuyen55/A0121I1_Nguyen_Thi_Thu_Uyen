//if -else
var count = 50;
if (count > 0) {
    count--;
}
else {
    count = 0;
}
console.log(count);
// loop
// console.log("for loop");
var keys = "look at you and look at me";
for (var index_1 = 0; index_1 < keys.length; index_1++) {
    console.log(keys[index_1]);
}
//loop while
console.log("while loop");
var index = 0;
while (index < keys.length) {
    console.log(keys[index]);
    index++;
}
console.log("do while loop");
var index1 = 0;
do {
    console.log(keys[index1]);
    index1++;
} while (index1 < keys.length);
console.log("for-of loop");
for (var _i = 0, keys_1 = keys; _i < keys_1.length; _i++) {
    var item = keys_1[_i];
    console.log(item);
}
console.log("for-in loop");
var user = {
    name: 'Bob',
    age: 55
};
for (var key in user) {
    console.log(key + ": " + user[key]);
}
