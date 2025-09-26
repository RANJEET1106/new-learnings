class Person {
    constructor(name = 'Anonymous', age = null) {
        this.name = name;
        this.age = age;
    }

    showDetails() {
        console.log(`Name: ${this.name} Age: ${this.age}`)
    }
}

const person1 = new Person("Ram", 22)
const person2 = new Person("Syam")
const person3 = new Person()
person1.showDetails();
person2.showDetails();
person3.showDetails();

class Employee {
    constructor(name = "null", designation = "Not assigned", salary = 0) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    displayDetails() {
        console.log(`Name: ${this.name}, Designation: ${this.designation}, Salary: ${this.salary}`);

    }

}
const e1 = new Employee("RANJEET", "Developer", 800000);
const e2 = new Employee("Ram", "Manager");
const e3 = new Employee("Shyam");
const e4 = new Employee();

e1.displayDetails();
e2.displayDetails();
e3.displayDetails();
e4.displayDetails();

class Car{
    constructor({company="unknown", model='unknown',year=nulll}={}){
        this.company=company
        this.model=model 
        this.year=year
    }

    showDetails(){
        console.log(`${this.company} ${this.model} ${this.year}`)
    }
}

const car=new Car({company:"Toyota", model:"Fortuner", year:2025});
car.showDetails()

class Car2{
    constructor({company, model,year=null}={}){
        this.company=company
        this.model=model 
        this.year=year
    }

    showDetails(){
        console.log(`${this.company} ${this.model ?? 'No Model'} ${this.year ?? 'Year ?'}`)
    }
}

const car1=new Car2({company:"Toyota"});
car1.showDetails()

class MyClass{
    static prop=0
    static demo(){
        console.log("Demo Static Method")
        console.log(`Static method inside static function ${MyClass.prop}`) 
        // We can access static properties inside static function only
    }
}

MyClass.demo()
console.log(`Static method outside static function ${MyClass.prop}`)

class Calculator{
    static add(a,b){
        return a+b;
    }
    static sustract(a,b){
        return a-b
    }
    static exponent(a,b){
        return a**b
    }
}

console.log(Calculator.add(10,5))
console.log(Calculator.sustract(10,5))
console.log(Calculator.exponent(10,5))

function Animal(name){
    this.name=name
}
Animal.prototype.speak=function(){
    console.log(`${this.name} makes a sound`)
}
function Dog(name,breed){
    Animal.call(this,name)
    this.breed=breed
}
Dog.prototype=Object.create(Animal.prototype)
Dog.prototype.constructor = Dog

Dog.prototype.speak=function(){
    console.log(`${this.name} barks`)
}

const dog=new Dog("Blacky","Lab")
dog.speak()

class Animal1{
    constructor(name){
        this.name=name
    }
    speak(){
        console.log(`${this.name} makes a sound`)
    }
}

class Dog1 extends Animal1{
    constructor(name,breed){
        super(name),
        this.breed=breed
    }
    speak(){
        super.speak()
        console.log(`${this.name} barks`)
    }
}

// class Vehicle brand displayDetails()
// Car inherits Vehicle brand+model super(brand) displayDetails() super

class Vehicle {
    constructor (brand) {
        this.brand = brand;
    }

displayDetails() {
        console.log(`${this.brand}`);
    }
}

class Car3 extends Vehicle {
    constructor(brand, model) {
        super(brand);
        this.model = model;
    }

displayDetails() {
        super.displayDetails();
        console.log(`${this.brand} ${this.model}`)
    }
}

const car3 = new Car3("Toyota", "Fortuner");
car3.displayDetails();

class Person1{
    constructor(name){
        this.name=name
    }
    showName(){
        console.log(`${this.name}`)
    }
}

class Student1 extends Person1{
    constructor(name,rollNo){
        super(name)
        this.rollNo=rollNo
    }
    showStudentDetails(){
        super.showName()
        console.log(`${this.rollNo}`)
    }
}

class EngineeringStudent1 extends Student1{
    constructor(name,rollNo,spec){
        super(name,rollNo)
        this.spec=spec
    }
    showSpecialization(){
        super.showStudentDetails()
        console.log(`${this.spec}`)
    }
}

let student=new EngineeringStudent1('RANJEET',101,'CS')
student.showSpecialization()


class ArtStudent1 extends Student1{
    constructor(name,rollNo,major){
        super(name,rollNo)
        this.major=major
    }
    showMajor(){
        super.showStudentDetails()
        console.log(`${this.major}`)
    }
}

student=new ArtStudent1('Akalank',101,'History')
student.showMajor()