// private data members getters setters

function Person(name){
    let _name = name;  // private data member

    this.getName=function(){
        return _name;
    };

    this.setName=function(newName){
        if(typeof newName ==='string' && newName.length >0){
            _name=newName;
        }else{
            console.log('Invalid Name')
        }
    }
}

let p=new Person('RANJEET')
console.log(p.getName())
p.setName('Akalank')
console.log(p.getName())


class Person1{
    #name;
    constructor(name){
        this.#name=name
    }
    get name(){
        return this.#name;
    }

    set name(newName){
        if(typeof newName === 'string' && newName.length>0){
            this.#name = newName
        }else{
            console.log('Invalid Name')
        }
    }
}

p=new Person1('RANJEET')
console.log(p.name)
p.name='Akalank'
console.log(p.name)

// Student #name #age #marks constructor getters setters
console.log('\n')
class Student{
    #name
    #age
    #marks
    constructor (name,age,marks){
        this.#name=name 
        this.#age=age
        this.#marks=marks 
    }

    get name(){
        return this.#name
    }
    get age(){
        return this.#age
    }
    get marks(){
        return this.#marks
    }

    set name(newName){
        if(typeof newName === 'string' && newName.length>0){
            this.#name = newName
        }else{
            console.log('Invalid Name')
        }
    }

    set age(newAge){
        if(typeof newAge === 'number' && newAge > 0) this.#age = newAge
        else console.log("Invalid age");
    }

    set marks(newMarks){
        if(Array.isArray(newMarks) && newMarks.length > 0) this.#marks = newMarks
        else console.log("Invalid Marks");
    }
}

p=new Student("RANJEET",22,[99,98,97,96])
console.log(p.name)
console.log(p.age)
console.log(p.marks)

p.name='Akalank'
p.age=21
p.marks=[100,99,95,90]

console.log(p.name)
console.log(p.age)
console.log(p.marks)

console.log('\n')

class Animal{
    constructor(name){
        this.name=name 
    }

    eat(){
        console.log(`${this.name} is eating`)
    }
}

const CanFly=(Base) => class extends Base{
    fly(){
        console.log(`${this.name} can fly`)
    }
}

const CanSwim=(Base) => class extends Base{
    swim(){
        console.log(`${this.name} can swim`)
    }
}

class Duck extends CanFly(CanSwim(Animal)){
    makeSound(){
        console.log(`${this.name} says Quack`)
    }
}

let duck=new Duck("Donald")
duck.eat()
duck.fly()
duck.swim()
duck.makeSound()

class Employee{
    constructor(name){
        this.name = name;
    }
    greet(){
        console.log(`${this.name} says hello`);
    }
}


const CanDevelop=(Base) => class extends Base{
    develop(){
        console.log(`${this.name} can develop`);
    }
}
const CanDesign=(Base) => class extends Base{
    design(){
        console.log(`${this.name} can design`);
    }
}
const CanManageProjects=(Base) => class extends Base{
    projects(){
        console.log(`${this.name} can make projects`);
    }
}


class TechLead extends CanDesign(CanDevelop(CanManageProjects(Employee))){
    greeting(){
        console.log(`Tech lead ${this.name} says hi to everyone`);
    }
}


const tl = new TechLead('RANJEET');
tl.greet();
tl.develop();
tl.design();
tl.projects(); 


console.log('\nJAvaScript Object Notation')
// Objects: key-value Pairs {}

let person={
    'name':'RANJEET',
    'age':22,
    'isMarried':false,
    'hobbies':['Reading','Singing','Chatting'],
    'address':{
        'houseNo':101,
        'street':"Vijay Nagar",
        'city':"Bengluru"
    }
}

console.log(person)

let personData=JSON.stringify(person)
console.log(personData)

person=JSON.parse(personData)
console.log(person)

person.children=1
console.log(person)

const employeeJson = '{"name":"RANJEET","age":25,"salary":50000}';

const employee = JSON.parse(employeeJson);
console.log(employee);

employee.salary = 60000;
employee.designation = "Software Engineer";
console.log(employee);

const updatedJson = JSON.stringify(employee);
console.log(updatedJson);