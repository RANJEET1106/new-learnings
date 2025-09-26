// Higher order function 
//  -> is the function which takes another function as argument
//  -> is the function which returns the fuction
//  -> or do both
{
function greet(name){
    return `hello, ${name}`
}

console.log(`Message is : ${greet("RANJEET")}`)
let num1=10
let num2=20

function prepareInput(callback){
    let name="RANJEET"
    return callback(name)
}

console.log(prepareInput(greet))

function calculateSquare(num){
    return `The square of ${num} is ${num**2}`
}

function processNumber(num,callback){
    return callback(num)
}

console.log(processNumber(4,calculateSquare))
}


// Arrow Function
{
const a=(num1,num2) =>{
    return num1+num2
}

const b=(num1,num2) => num1+num2

console.log(a(10,2))
console.log(b(10,2))

const greet2 = () => console.log("Welcome")
greet2()

const findSquare = (x=2) => x*x;
console.log(findSquare(6))
console.log(findSquare())

const findAvg = (w,x,y,z) => (w+x+y+z)/4;
console.log(findAvg(10,20,30,40))

// Pure vs Impure function
// Pure => same output for same input

let count=0

function counter(){  // Impure Function
    count++;
    return count;
}

console.log(counter())
console.log(counter())
}


// Built In Function
{
console.log(parseInt("42")) // 42
console.log(parseInt("42.98"))  // 42
console.log(parseFloat("42.69"))    // 42.69

console.log(isNaN("a")) // true
console.log(isNaN(10))  // false

console.log(isFinite(1900)) // true
console.log(isFinite(1900/0)) // false

console.log(Number("a122"))     // NaN

let num=10
console.log(String(num)+20) // 1020

console.log(typeof num.toString()) // string

let n=123.456789
console.log(n.toFixed(2))   // 123.45
console.log(n.toPrecision(4))   // 123.5

}


// Array
{
let colors=['red','green','blue']
console.log(colors)

let nums=new Array(10,20,30,40,"Hello",true)
console.log(nums)

nums[2]="RANJEET"
console.log(nums)

nums.push(100)
console.log(nums)
nums.pop()
console.log(nums)
console.log("--------------")
console.log(nums.shift())
console.log(nums)
console.log(nums.unshift(200))

// splice

// array.splice(start,deleteCount,item1,item2,...)
let rem=nums.splice(1,2)
console.log(nums)
console.log(rem)

nums.splice(1,0,15,17)
console.log(nums)

let names=['RANJEET','Akalank','Yash','Mayank']
console.log(names)
names.splice(2,0,'Sanket')
console.log(names)
names[2]='Suraj'
console.log(names)
names.splice(2,1)
console.log(names)

let nums1=[90,80,70,60]
console.log(nums.concat(nums1))

// Join
console.log(nums.join(';'))
console.log(nums.join(' '))

let nums2=[[1,[2],3],[4,[[5],6]],[7,8,9]]
console.log(nums2)
console.log(nums2.flat())
console.log(nums2.flat(2))
console.log(nums2.flat(3))
console.log(nums2.flat(Infinity))
}
