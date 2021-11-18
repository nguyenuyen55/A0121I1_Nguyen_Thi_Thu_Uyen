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
function main(){
    let message: string;
    let total:number=100;
    let isProduction =true;
    let prices: Array<number> =[120,88,60];
    let language:string[] =['vi','en-us'];
    let now = new Date();
    let unknown:any;


enum Direction{
    UP,DOWN,LEFT,RIGHT
};
function log(masg :string):void{
    console.log(masg);
}


isProduction=false;
unknown=Direction.UP;
unknown="changed";

// const  post: IPost = {

// };
// message=50;



};
interface IPost{
    id:string;
    titile :string;
    body? :string;
}

function getPost(postId:string):IPost{
    //do something to retrieve post
    return {
        id:postId,
        titile :"Post Title",
        // body:'Post Body',
        extra:'data'
    }as IPost
}
console.log(getPost("hi"));
