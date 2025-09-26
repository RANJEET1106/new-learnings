// export const num1= 100
// export const num2= 200

const num1= 100
const num2= 200

function mul(a,b){
    return a*b;
}

export {num1 as n1, num2 as n2, mul as m}

export default function div(a,b){
    return a/b;
}

export class Student{
    constructor(name,age){
        this.name=name
        this.age=age
    }
    showDetails() {
        console.log(`${this.name} ${this.age}`)
    }
}

class Book {
    constructor(title, author, year, numOfCopies) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.numOfCopies = numOfCopies;
    }
    getDetails() {
        return `Title: ${this.title}, Author: ${this.author}, Year: ${this.year}.`;
    }
    borrow() {
        if (this.numOfCopies > 0) {
            this.numOfCopies--;
            return `You have borrowed "${this.title}".`;
        } else {
            return `Sorry, "${this.title}" is NOT available.`;
        }
    }
    returnBook() {
        this.numOfCopies++;
        return `You have returned "${this.title}".`;
    }
}
export {Book};