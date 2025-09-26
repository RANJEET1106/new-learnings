let num1=10
let num2=num1++

console.log(num1)  // 11
console.log(num2)  // 10

num2=0
num1=10
let num3=num2++ && num1++
console.log(num1)  // 10
console.log(num2)  // 1
console.log(num3)  // 0

console.log(3 & 4)  // 0 cause its bitwise and
console.log(3 | 4)  // 7 cause its bitwise and

let a = 5, b = 10;

a = a + b;  
b = a - b;  
a = a - b;  

console.log("After Swap: a = " + a + ", b = " + b);


// switch case

console.log("Switch Case")

let day=2
switch(day){
    case 1:
        console.log("Monday")
        break;
    case 2:
        console.log("Tuesday")
        break;
    case 3:
        console.log("Wednesday")
        break;
    default:
        console.log("Invalid Number")
        break;
}

num1=5
num2=10

let op='+'

switch(op){
    case '+':
        console.log(num1+num2)
        break;
    case '-':
        console.log(num2-num1)
        break;
    case '*':
        console.log(num2*num1)
        break;
    case '/':
        console.log(num2/num1)
        break;
    default:
        console.log("Invalid Operator")
        break;
}

num=1
while(num<10){
    console.log(num)
    num+=2
}

num=1234
num1=0
num2=0
while(num>0){
    num1++;
    num2+=num%10;
    num=Math.floor(num/10);
}
console.log("NUmber of digits is "+num1)
console.log("Sum of digits is : "+num2)

function reverseNum(num){
    num1=0;
    while(num>0){
        num1=num1*10+num%10;
        num=Math.floor(num/10)
    }

    return num1;
}

num=112;
num2=reverseNum(num)
console.log(num2)
if(num===num2) {
    console.log("Palindrome")
}
else {
    console.log("Not Palindrome")
}

console.log("Fibonachi Series")
let n = 10;
let a1 = 0, b1 = 1, i = 1;

console.log("Fibonacci Series:");

do {
    console.log(a1);   
    let next = a1 + b1; 
    a1 = b1;
    b1 = next;
    i++;
} while (i <= n);


console.log("For loop example")
let count=1
for(; count<=10;count++)
    console.log(count)

console.log("Table")
num = 8;
for (let i = 1; i <= 15; i++) {
    console.log(num + " * " + i + " = " + (num * i));
}

function factorial(n) {
    if (n === 0 || n === 1) return 1;
    let result = 1;
    for (let i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}


function isStrongNumber(num) {
    let sum = 0;
    let temp = num;
    
    while (temp > 0) {
        const digit = temp % 10;
        sum += factorial(digit);
        temp = Math.floor(temp / 10);
    }
    
    return sum === num;
}

console.log(isStrongNumber(145));    

let student={name:"RANJEET", age:20, course:"BE CSE"}
for (let key in student){
    console.log(key+" : "+student[key])
}

let colors=['green','red','orange']
for(let i in colors) console.log(colors[i])

let nums=[1,2,3,4,5]
let sum=0
for(let i in nums) sum+=nums[i]

console.log(sum)

//  to check weather the given number is prime 
//  to print first n prime numbers