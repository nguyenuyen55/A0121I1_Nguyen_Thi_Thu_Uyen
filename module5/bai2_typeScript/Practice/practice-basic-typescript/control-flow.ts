//if -else
let count =50;
if(count>0){
    count--;
}else{
    count=0;
}
console.log(count);
// loop
// console.log("for loop");
const keys ="look at you and look at me";

for(let index=0;index <keys.length;index++){
    console.log(keys[index]);
}
//loop while
console.log("while loop");
let index=0;
while(index<keys.length){
    console.log(keys[index]);
    index++;
}

console.log("do while loop");
let index1=0;
do{
    console.log(keys[index1]);
    index1++;   
}
while(index1<keys.length)

console.log("for-of loop");
for (const item of keys) {
    console.log(item);
}

console.log("for-in loop");
const user = {
    name: 'Bob',
    age: 55
};
for (const key in user) {
    console.log(`${key}: ${user[key]}`);
}


