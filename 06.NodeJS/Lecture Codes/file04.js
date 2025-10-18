const fs = require('fs')
console.log('start')
let data = fs.readFileSync('hello.txt', 'utf-8')
fs.readFile('hello.txt', 'utf-8', (err, data) => {
    if (err) throw err;
    console.log('Async read: ', data)
});
console.log(data)
console.log('end')

fs.writeFile('hello.txt', 'this is sample text', (err) => {
    if (err) throw err;
    console.log('File created and written data successfully')
});

fs.appendFile('hello.txt', ' this is another text append', (err) => {
    if (err) throw err;
    console.log('Text Appended')
})

// open(fileName, Permission, Mode(optional), callBack)
fs.open('file.txt', 'w', (err, file) => {
    if (err) {
        console.log('Error opening file', err)
        return;
    }
    console.log('file created successfully')
    fs.writeFile(file, 'Welcome to node js', (err) => {
        if (err) throw err;
        console.log('Data Written')
    })
});

fs.readFile('numbers.txt', 'utf-8', (err, data) => {
    if (err) {
        return console.error(err);
    }
    const numbers = data.split(' ').map(Number);
    const evenNumbers = numbers.filter(num => num % 2 === 0);
    const oddNumbers = numbers.filter(num => num % 2 !== 0);
    fs.writeFile('even.txt', evenNumbers.join(' '), (err) => {
        if (err) {
            return console.error(err);
        }
        console.log('Even numbers written to even.txt');
    });
    fs.writeFile('odd.txt', oddNumbers.join(' '), (err) => {
        if (err) {
            return console.error(err);
        }
        console.log('Odd numbers written to odd.txt');
    });
});

function isPrime(n) {
    if (n <= 1)
        return false;
    for (let i = 2; i < n; i++)
        if (n % i == 0)
            return false;
    return true;
}
fs.readFile('numbers.txt', 'utf-8', (err, data) => {
    if (err) {
        return console.error(err);
    }
    const numbers = data.split(' ').map(Number);
    const primeNumbers = numbers.filter(num => isPrime(num) );
    fs.writeFile('prime.txt', primeNumbers.join(' '), (err) => {
        if (err) {
            return console.error(err);
        }
        console.log('Even numbers written to even.txt');
    });
});


const data1 = fs.readFileSync('unique.txt', 'utf-8');

const lines = data1.split('\n');

const uniqueLines = [...new Set(lines)];

fs.writeFileSync('unique.txt', uniqueLines.join('\n'));

console.log('Duplicates removed and saved to unique.txt');