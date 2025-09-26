// Date Object

// Ways to declare date

let now = new Date();
console.log(now)

now = new Date("2025-09-20")
console.log(now)

// year,month,date,hr,min,sec,mili sec
// month index start from 0
now = new Date(2025, 8, 15, 16, 35, 16, 200)
console.log(now)

// milis from 1st jan 1970
now = new Date(0)
console.log(now)

now = new Date()
now.setFullYear(2022)
now.setMonth(6)
console.log(now.getFullYear())
console.log(now.getMonth())
console.log(now.getDate())
console.log(now.getDay())  // gives day of week
console.log(now.getHours())
console.log(now.getMinutes())
console.log(now.getSeconds())
console.log(now.getMilliseconds())

console.log(now.toDateString()) // Wed Jul 20 2022
console.log(now.toLocaleDateString())  // 20/7/2022
console.log(now.toLocaleString())  // 20/7/2022, 6:49:09 pm
console.log(now.toLocaleTimeString())  // 6:49:09 pm

console.log(Date.now()) // time in mili from 1st jan 1970
console.log(Date.parse("2025-09-20")) // gives milis from 01-01-1970
console.log(Date.UTC(2025, 8, 20))  // gives milis from 01-01-1970

function giveDay(date) {
    let day = new Date(date)
    const days = ["Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday",
        "Saturday"];
    console.log(days[day.getDay()])
}

giveDay("2025-09-20")

function age(str) {
    let date = new Date(str).getFullYear();
    let now = new Date().getFullYear();
    console.log(`Age : ${now - date}`)

}

age("2004-11-25")

function add10Days() {
    let now = new Date()
    now.setDate(now.getDate() + 10)
    console.log(now)
}
add10Days()

function daysLeft() {
    let now = new Date()
    let date = new Date("2025-10-30")
    let diff = date - now
    console.log(Math.ceil(diff / (1000 * 60 * 60 * 24)))
}

daysLeft()

function formatDate(str) {
    let date = new Date(str)
    let year = date.getFullYear()
    let month = date.getMonth() + 1
    let day = date.getDate()
    console.log(`${year}/${month}/${day}`)
}

formatDate("2025-09-20")

function isLeapYear(year) {
    if ((year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0)) {
        return true;
    } else {
        return false;
    }
}

let year = 2024;
if (isLeapYear(year)) {
    console.log(year + " is a leap year");
} else {
    console.log(year + " is not a leap year");
}

let sd = new Date();


for (let i = 0; i < 7; i++) {
    let nextday = new Date(sd);
    nextday.setDate(sd.getDate() + i);
    console.log(nextday);
}


// Math

console.log(Math.PI)
console.log(Math.E)
console.log(Math.LN2)
console.log(Math.LN10)
console.log(Math.LOG2E)
console.log(Math.SQRT2)
console.log(Math.SQRT1_2)
console.log(Math.sqrt(16))
console.log(Math.round(4.4))
console.log(Math.ceil(4.708))
console.log(Math.floor(9.089))
console.log(Math.trunc(8.45))
console.log(Math.pow(4, 3))
console.log(Math.cbrt(64))
console.log(Math.abs(-78))
console.log(Math.sign(-2))
console.log(Math.min(10, 20, 40, 5, 2, 34))
console.log(Math.max(10, 20, 40, 5, 2, 34))
console.log(Math.random())
console.log(Math.log10(10))
console.log(Math.log2(8))
console.log(Math.exp(4))
console.log(Math.sin(60))

function generateOTP() {
    let otp = Math.floor(1000 + Math.random() * 9000);
    return otp;
}

console.log(generateOTP())

const areaOfCircle = (r) => {
    return (Math.PI * r * r).toFixed(2);
}
console.log(areaOfCircle(5));

// ... Unpacking
let nums1 = [10, 20, 30, 40]
let nums2 = [1, 2, 3]
let nums3 = [...nums1, ...nums2]
console.log(...nums3)

let str = 'Hello'
console.log(...str)

function sum(a1, b1, c1) {
    return a1 + b1 + c1
}

let res = sum(...nums2)
console.log(res)

let a = [1, 2, 3, 4, 5]
let b = [...a, 6, 7]

console.log(b)

console.log(Math.max(...nums3))
console.log(Math.min(...nums3))

str = "1234.56"
let num = 1234.56789
console.log(Number(str))
console.log(parseInt(str))
console.log(num.toFixed(2))
console.log(num.toExponential())
console.log(num.toPrecision())
console.log(num.toLocaleString("en-IN"))  // convert number into string using local formatting
console.log(Number.MAX_VALUE)
console.log(Number.MIN_VALUE)
console.log(Number.POSITIVE_INFINITY)
console.log(Number.NEGATIVE_INFINITY)
console.log(Number.NaN)

let amt = 573506
let inr = amt.toLocaleString("en-IN", {
    style: "currency",
    currency: "INR"
});

// Dollars (USD)
let usd = amt.toLocaleString("en-US", {
    style: "currency",
    currency: "USD"
});

console.log("In Rupees:", inr);
console.log("In Dollars:", usd);

// BMI rounded to 2 decimal pts
