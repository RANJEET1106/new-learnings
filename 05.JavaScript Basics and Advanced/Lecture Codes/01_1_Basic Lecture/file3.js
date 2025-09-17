//  Functions

function greet(){
    console.log("Hello")
}

greet();


// Immidiately Invoked Function Expression
// IIFE
(function greet1(){
    console.log("Hello");
})(); 

function addNUmbers(num1,num2){
    return num1+num2;
}

console.log(addNUmbers(5,3));

function factorial(num1){
    num2=1;
    for(let i=1;i<=num1;i++){
        num2*=i;
    }
    return num2
}

console.log(factorial(5));

console.log("Clouser")

function outer(){
    let outVariable="This is outer veriable";

    function inner(){
        console.log(outVariable)
    }

    return inner;
}
let closure=outer()
closure()


function counter(){
    let count = 0;

    function increment(){
        count++;
        console.log(count);
    }
    return increment;
}
let counter1 = counter();
counter1()
counter1()

function avg(... numbers){
    let sum=0,count=0;
    for(let num of numbers) {
        sum+=num
        count++;
    }
    return sum/count
}

console.log(avg(10,20,30,40))

function update(a){
    a++
    console.log(a)
}

let a=10
console.log(a)  // 10
update(a)       // 11
console.log(a)  // 10

function showData({name="unknown",age=0}={}){
    console.log(name)
    console.log(age)
}
showData({name:"RANJEET",age:20,city:"Karad"})
showData();


// Anonymus function Expression
let greet2=function(name){
    console.log("Hello "+name)
}
greet2("RANJEET")

let square=function(num){
    return num**2
}
console.log(square(14))

