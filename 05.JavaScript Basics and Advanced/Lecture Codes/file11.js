console.log('task1')

// Asyncronous function
setTimeout(()=>{
    console.log('Task 2 after 2 sec')
},2000);

console.log('task3')

function greet(name,callback){
    console.log('Hello '+name)
    callback()
}
function sayBye(){
    console.log('Bye')
}
greet('RANJEET',sayBye)

let users=[
    {id:1,name:'RANJEET'},
    {id:2,name:'Akalank'}
];

function getUser(id,callback){
    setTimeout(()=>{
        let user=users.find(u=> u.id===id);
        // console.log('User Fetched ',user );
        // return user
        callback(user)
    },4000)
}

console.log('start')
let result=getUser(1,(user)=>{
    console.log('user: ',user)
})
console.log('end')


let posts=[
    {postId: 101, userId: 1, title:'Post1'},
    {postId: 102, userId: 2, title:'Post2'}
];

let comments={
    101:['Its a great post '],
    102:['okay ... not bad article']
};

function getPosts(userId,callback){
    setTimeout(()=>{
        let userPosts=posts.filter(p=> p.userId === userId)
        callback(userPosts)
    },3000)
}


function getComments(postId,callback){
    setTimeout(()=>{
        let postComments=comments[postId];
        callback(postComments)
    },3000)
}

getUser(1,(user)=>{
    console.log('User: ',user);
    getPosts(user.id,(userPosts)=>{
        console.log("Posts: ",userPosts);
        getComments(userPosts[0].postId,(postComments)=>{
            console.log('Post Comments: ',postComments)
        })
    })
})

function add(a, b, cb){
    console.log(`${a} + ${b} = ${a+b}`)
    cb(a+b);
}

function sub(a, b, cb){
    console.log(`${a} - ${b} = ${a-b}`)
    cb(a-b);
}

function mul(a, b, cb){
    console.log(`${a} * ${b} = ${a*b}`)
    cb(a*b);
}

add(5, 10, (sum) => {
    mul(sum, 2, (mul) => {
        sub(mul, 5, (sub) => {
            console.log(sub);
        })
    })
})

let myPromise= new Promise((resolve,reject)=>{
    let success=true;
    if(success){
        resolve('Task Completed Successfully')
    }else{
        reject('task failed')
    }
});

myPromise
.then(result=> console.log(result))
.catch(error=> console.log(error))
.finally(()=>console.log('Promise settled'))


let promise=new Promise((resolve,reject)=>{
    resolve(10)
});

promise
.then(result=>{
    console.log(result)
    return result*2
})
.then(result=>{
    console.log(result)
    return result+2
})
.then(result=> console.log(result))
.catch(error => console.log('error '+error))

let p1=Promise.resolve(10)
let p2=new Promise((resolve,reject)=>setTimeout(resolve,1000,20))
let p3=new Promise((resolve,reject)=>setTimeout(reject,2000,30))

Promise.all([p1,p2,p3])
.then(results=>console.log('All results ',results))
.catch(error=>console.log('Caught error ',error))