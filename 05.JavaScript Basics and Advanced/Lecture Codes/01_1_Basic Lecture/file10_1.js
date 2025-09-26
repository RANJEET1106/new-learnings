// Exception Handling

try{
    let result=10/0
    console.log('Result is '+result)
}catch(error){
    console.log(error.message)
}finally{
    console.log('finally')
}

try{
    let num=10
    
    console.log(num.toUpperCase())
}catch(error){
    console.log(error.message)
}finally{
    console.log('finally')
}


function divide(a,b){
    if(b===0){
        throw new Error("Cannot Devide by 0")
    }
    else return a/b
}

try {
    console.log(divide(10,0))
}catch(error){
    console.log(error.message)
}

function parseUserData(jsonString) {
    try {
        const res = JSON.parse(jsonString);
        return res;
    } catch (error) {
        console.log(error.message)
        return { name: "unknown", age: 0 };
    }
}

console.log(parseUserData('{"name":"RANJEET", "age": 22}'))
console.log(parseUserData('{"name"}'))

// ES6 module
console.log('\nES6 module')

import div,{ n1,n2,m } from "./file10_2.js"
console.log(n1+n2)
console.log(m(n1,n2))
console.log(div(10,2))

import { Student as s } from "./file10_2.js"
const st=new s('Ram',24)
st.showDetails()

import { Book } from "./file10_2.js"


let book1 = new Book("A Song of Ice and Fire", "George R. R. Martin", 1991, 1);
console.log(book1.getDetails());
console.log(book1.borrow());
// it will say not available
console.log(book1.borrow());
console.log(book1.returnBook());


console.log('\nRegular Expression')

// lieral syntax
let pattern=/hello/

// Constructor
let pattern1=new RegExp('hello') // this is not used much

let str='sdfgdgs world'
console.log(pattern1.test(str)) // false

// \d (0 9) \w eord characters(letters digits _) 
// \s white space . any character except newline

console.log(/\d/.test('2045')) // true
console.log(/\w/.test('Hello_123')) // true
console.log(/\s/.test('hello')) // false

/*
    * 0 or more
    + 1 or more
    ? 0 or 1
    {n} exactly n
    {n, } atleast n
    {n,m} between n and m
*/

console.log(/a{2,3}/.test('aaabb')) // true

/*
    brackets [abc] matches a,b or c
    [^abc] NOT a,b or c
    [0-9] any digit
    [A-Z] uppercase
*/

console.log(/[aeiou]/.test('stvq')) // false
console.log(/[aeiou]/.test('satvq')) //true
console.log(/[^0-9]/.test('123')) // false

// anchors ^ start of string
// $ end of string

console.log(/hello$/.test('word hello')) // true

pattern=/abc/
str='ABC abc abc abc ABC ab'

console.log(str.match(pattern))

pattern=/abc/gi

console.log(...str.matchAll(pattern))

let regex=/test/
str='This is test string test'
console.log(regex.exec(str))
console.log(str.search(regex))
console.log(str.replace(pattern,'sample'))

console.log('yellow,red,green;blue'.split([/,;/]))

// valid phone number 10 digits

let phone='9876543210'
pattern=/^[6-9]\d{9}$/
console.log(pattern.test(phone))

// Email validation
// strong password validation
// min 8 chars uper,lower case number special
// find all numbers in string
// extract all hashtags from tweet
// validate indian pincode
// remove extra spaces from a string
// check palindrome using regex
// 