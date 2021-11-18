// function main(){
//     console.log("START");
//     if(true){
//         var lang ="vi";
//         let target="en-us";
//         console.log("inside block");
//         console.log(target);
//     }
//     console.log(lang);
//     //console.log(target); : nó lỗi là tại vì trong ts let phạm vi của nó là trong khối lệnh  
// }
// function main(){
//     var x=5;
//     console.log(x);
//     var x=10;
//     console.log(x);
//     let y = 55;
//     console.log(y);
//     // let y = 100; error : because let variable cannot redeclare 
//     console.log(y);
// }
// function main(){
//     console.log(x);
//     var x =5;
//     // console.log(y); .. error : in typescript let must declare before use
//     let y=10;
// }
// main()
function main() {
    var message;
    var total = 100;
    var isProduction = true;
    var prices = [120, 88, 60];
    var language = ['vi', 'en-us'];
    var now = new Date();
    var unknown;
    var Direction;
    (function (Direction) {
        Direction[Direction["UP"] = 0] = "UP";
        Direction[Direction["DOWN"] = 1] = "DOWN";
        Direction[Direction["LEFT"] = 2] = "LEFT";
        Direction[Direction["RIGHT"] = 3] = "RIGHT";
    })(Direction || (Direction = {}));
    ;
    function log(masg) {
        console.log(masg);
    }
    isProduction = false;
    unknown = Direction.UP;
    unknown = "changed";
    // const  post: IPost = {
    // };
    // message=50;
}
;
function getPost(postId) {
    //do something to retrieve post
    return {
        id: postId,
        titile: "Post Title",
        // body:'Post Body',
        extra: 'data'
    };
}
console.log(getPost("hi"));
