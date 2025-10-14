const g= require('./file02_02')

g.greet('RANJEET')
g.display("RANJEET")

const calc=require('./file02_03')
calc.add(6,9)
calc.sub(6,9)
calc.mult(6,9)
calc.div(9,3)

const Student = require('./file02_04')
const student = new Student(1, "RANJEET", "CS")
student.display()

const counter1= require('./file02_05')
console.log(counter1.increment())
console.log(counter1.increment())
delete require.cache[require.resolve('./file02_05')]
const counter2 = require('./file02_05')
console.log(counter2.increment()) 

const os = require('os')
console.log(`Platform ${os.platform}`)
console.log(`Architecture ${os.arch}`)
console.log(`Total Memory ${os.totalmem}`)
console.log(`Free memory ${os.freemem}`)
console.log(os.type())
console.log(os.EOL) // prints newline character 

const fs= require('fs')
fs.writeFileSync('hello.txt',"Hello world from node js")
console.log(fs.readFileSync('hello.txt','utf-8'))


// npm i chalk
const c = require('chalk'); // third party module
const chalk = new c.Chalk();
console.log(chalk.green('Hello'))
console.log(chalk.red.bold('Welcome'))
console.log(chalk.blue.underline('Learning 3rd party modules'))


// npm install axios
const axios=require('axios')
const url='https://jsonplaceholder.typicode.com/users'
async function fetchUsers(){
    try{
        const response= await axios.get(url)
        const users=response.data

        console.log('Users fetched from API')
        console.log(users)
    }catch (error){
        console.log(`error fetching data ${error.messge}`)
    }
}
fetchUsers()