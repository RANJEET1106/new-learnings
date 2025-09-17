let a=[1,2,3,4,1,2,3]
console.log(a.indexOf(2))  // 1
console.log(a.lastIndexOf(2))   // 5
console.log(a.includes(20)) // false
console.log(a.find(n=> n>3))    // 4 

console.log(a.find(n=> (n%2==0)))   // 2
console.log(a.findIndex(n=> (n%2==0)))  // 1

a.fill(0,1,4)
console.log(a)

a=[1,2,4,3,5]
// (target,start,end)
a.copyWithin(0,2)
console.log(a)
a.reverse();
console.log(a)

a=[1,2,4,3,5,100]
console.log(a.sort())  // [ 1, 100, 2, 3, 4, 5 ]

// for numeric value use comparator
console.log(a.sort((a,b)=>a-b))     // [ 1, 2, 3, 4, 5, 100 ]
console.log(a.sort((a,b)=>b-a))     // [ 100, 5, 4, 3, 2, 1 ]

a.forEach(n=> console.log(n**2))

let squares= a.map(n=> n**2)
console.log(squares)

let results=a.filter(n=> n>4)
console.log(results)

results=a.filter(n=> n&1)
console.log(results)

a= [2,5,15,3,10,25,20,35]
results= a.filter(n=> n%5==0).map(n=> n*3).sort(((a,b)=> a-b))
console.log(results)

//  array.reduce(callback(accumulator, currentValue, index, array),initialValue)
a=[1,2,3,4,5]
let sum=a.reduce((acc,cur)=> acc+cur, 0)
console.log(sum)    // 15 
let max = a.reduce((acc, curr) => Math.max(acc,curr), 0)
console.log(max)    // 5
let diff=a.reduceRight((acc,cur)=> acc-cur, 0)
console.log(diff)   // -15

console.log(a.some(n=> n%2==0)) // true
console.log(a.every(n=> n<5))   // false
console.log(a.flatMap(n=> n*2)) // [ 2, 4, 6, 8, 10 ]

let a2=[[1,2],[3,4],[5,6]]
results= a2.flatMap(subArr=> subArr.map(x=> x*2))
console.log(results)    // [ 2, 4, 6, 8, 10, 12 ]

a=[10,20,30,40]
for(let val of a.values()) console.log(val)

for(let [k,v] of a.entries()) console.log(`${k}: ${v}`)

// String

let str1='hello welcome to javascript'
console.log(str1.length)
console.log(str1.charAt(3))
console.log(str1[3])

console.log(str1.toUpperCase())
console.log(str1)

console.log(str1.startsWith('hello'))
console.log(str1.endsWith('hello'))

console.log(str1.slice(5,9))  // start,end
console.log(str1.substring(4,10))   // start,length
console.log(str1.trimStart()) // remove start blank spaces

console.log(str1.padStart(40,"@"))

str1="red,green,blue"
let colors=str1.split(",")
console.log(colors)
console.log(colors.join("|"))

str1="Ha"
console.log(str1.repeat(5))

str1="hello"
let str2='world'

console.log(str1+" "+str2)
console.log(str1.concat(" ",str2))
