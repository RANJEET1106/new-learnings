console.log("Hello World");

var x=20;
console.log(x)


let y=9;
console.log(y);

const num=25;  // can't assign new value
console.log(num);


console.log("\n\nType of X is "+ typeof x)  // number
x="RANJEET";
console.log(x)
console.log("Type of X after changing is "+ typeof x)  // string

x=true;
console.log(x)
console.log("Type of X after changing is "+ typeof x)  // boolean

x= '6'-2;  // 4
console.log(x)

let z;
console.log('\n\n'+z)  // undefined
console.log("Type of z after changing is "+ typeof z)  // undefined

console.log(typeof 1234567899876543212345678987654321n);  // bigint
console.log(typeof 10n) //bigint

x=10n
y=3;
// console.log(x+y);  
// above statement will throw an error
// for solving the error

console.log(x+BigInt(y)) //13n

x= null
console.log(x===null) // true 

let person={name:"RANJEET", age:22}
console.log(person.name)

let colors=['blue','red','green']
console.log(colors)

function sayHello(){
    console.log("Hello World")
}

sayHello()


// Operators 
// Declare 2 numbers num1,num2 and perform all arithmatic operations
// +  - * / % ** 
// += -=
console.log("\n\nOperators")

x=30
y=10

console.log(x+y)
console.log(x-y)
console.log(x*y)
console.log(x/y)
console.log(x%y)
console.log(x**y)

// Comparision  == != ===
// Logical  && || !
// Unary ++ --


console.log("\n\nTernary Operator")
x=10
y=7
let small = (x<y)? x:y
console.log(small)

x=10
y=7
z=3
let largest = (x > y) ? (x > z ? x : z) : (y > z ? y : b);
console.log(largest);

console.log(Math.abs(y-x))

// Control Statement

console.log("\n\nControl Statement")
let year = 2000;


if (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0)){
    console.log("Leap Year");
}
else {
    console.log("Not a Leap Year");
}