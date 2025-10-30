//*************************Using Error Object********************* */

// const err=new Error('Something went wrong');

// console.log(err.message);
// throw new Error('I am an error object')

//***************using Custom error *****************************/



// export class CustomError extends Error{
//     constructor(message){
//         super(message);
//     }
// }


//*****************Try Catch ************************************ */


try{
    console.log('EveryThing is fine')
}catch(e){  
    console.log("there is an error")

}

//************************callBack ************************/

function task(cb){
    setTimeout(()=>{
        cb("hello ");
    },0)
}
task((err,data)=>{
    if(err) throw err;
    else console.log("callback data: ",data);
});

//***************************event listeners********************* */


function dosomething(){
    console.log('hello');
}
process.on('uncaughtException',(e)=>{
    console.log('there is an error',e.message);
    process.exit(1);
});
dosomething();

//***************Promise Error **************************** */

const promise=new Promise((resolve,reject)=>{
    if(false){
        resolve("Hurray program is working")
    }
    else{
        reject("There is an error");
    }
});
promise
.then((val)=>{console.log(val)})
.catch((err)=>{
    console.log(err);
});




