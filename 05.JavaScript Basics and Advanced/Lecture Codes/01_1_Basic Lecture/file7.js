let student = {
    name: 'RANJEET',
    gender: 'Male',
    course: 'CS',

    showDetails:function(){
        console.log(`${this.name} ${this.course}`)
    }
    // Can't use arrow function for this.name
    
}

console.log(student.name)
console.log(student['course'])
student.showDetails()

console.log("\n\nNestead Object")
// nestead object
let person = {
    name:'RANJEET',
    address:{
        houseNo: 101,
        city: 'Pune',
        pincode: 411018
    }
}

console.log(`${person.name}`)
console.log(`${person.address.houseNo}`)
console.log(`${person.address.city}`)
console.log(`${person.address.pincode}`)

console.log("\n\nArray in Object")
let employees = {
    name:'RANJEET',
    skills:['JavaScript', 'PostgreSQL', 'C++', 'Python']
}
console.log(`${employees.name}`)
console.log(`${[...employees.skills]}`)
for(let skill of employees.skills) console.log(skill)

console.log("\n\nDynamic Properties")

let propName='salary'
let employee = {
    name:'RANJEET',
    [propName]:50000
}
console.log(employee.salary)

let i=1;
let marks={
    ['subject'+i++]:'JavaScript',
    ['subject'+i++]:'React'
}

console.log(marks.subject1)
console.log(marks.subject2)

let book={
    title:"A Song of Ice and Fire",
    author:"George R. R. Martin",
    showDetails(){
        console.log(`Author of ${this.title} is ${this.author}`);
    }
}

book.showDetails()

let laptop={
    name:'HP 15s',
    specs:{
        processor:'Intel',
        ram:'8 GB'
    }
}
console.log(laptop)

let students ={
    name:'RANJEET',
    marks:[80,88,85,90,83,86],

    getAverage(){
        return this.marks.reduce((a, b) => a + b, 0) / this.marks.length;
    }
}

console.log(students.getAverage())


console.log("\n\nDeleting Property")

console.log(person)
delete person.address
console.log(person)

employee = {  
    name: "RANJEET",  
    age: 22,  
    dept: "Product",  
    salary: 60000 
};  
console.log(employee)  
employee.designation="Developer";  
console.log(employee)


