// function divideNumbers(a, b) {
//     try {
//         if (isNaN(a) || isNaN(b)) {
//             throw new Error("Both inputs must be numbers");
//         }
//         if (b === 0) {
//             throw new Error("Cannot divide by zero");
//         }
//         const result = a / b;
//         console.log(`Result: ${result}`);
//     } catch (error) {
//         console.error(`Error: ${error.message}`);
//     }
// }

// divideNumbers(50, 10);    
// divideNumbers(50, 0);    
// divideNumbers("R", 10);  

// *************** Using Callback *******************

// function divideNumbers(a, b, callback) {
//     if (isNaN(a) || isNaN(b)) {
//         callback(new Error("Both inputs must be numbers"), null);
//         return;
//     }
//     if (b === 0) {
//         callback(new Error("Cannot divide by zero"), null);
//         return;
//     }

//     const result = a / b;
//     callback(null, result);
// }



// divideNumbers(50, 10, (error, result) => {
//     if (error) {
//         console.error(`Error: ${error.message}`);
//     } else {
//         console.log(`Result: ${result}`);
//     }
// });

// divideNumbers(50, 0, (error, result) => {
//     if (error) {
//         console.error(`Error: ${error.message}`);
//     } else {
//         console.log(`Result: ${result}`);
//     }
// });

// divideNumbers("R", 10, (error, result) => {
//     if (error) {
//         console.error(`Error: ${error.message}`);
//     } else {
//         console.log(`Result: ${result}`);
//     }
// });

// ************************ Using Promises ********************

// function divideNumbers(a, b) {
//     return new Promise((resolve, reject) => {
//         if (isNaN(a) || isNaN(b)) {
//             reject(new Error("Both inputs must be numbers"));
//         }
//         if (b === 0) {
//             reject(new Error("Cannot divide by zero"));
//         }

//         const result = a / b;
//         resolve(result);
//     });
// }

// divideNumbers(50, 10)
//     .then(result => console.log(`Result: ${result}`))
//     .catch(error => console.error(`Error: ${error.message}`));

// divideNumbers(50, 0)
//     .then(result => console.log(`Result: ${result}`))
//     .catch(error => console.error(`Error: ${error.message}`));

// divideNumbers("R", 10)
//     .then(result => console.log(`Result: ${result}`))
//     .catch(error => console.error(`Error: ${error.message}`));


process.on('uncaughtException', (error) => {
    console.error(`Global Error: ${error.message}`);
});

function divideNumbers(a, b) {
    if (isNaN(a) || isNaN(b)) {
        throw new Error("Both inputs must be numbers");
    }
    if (b === 0) {
        throw new Error("Cannot divide by zero");
    }
    const result = a / b;
    console.log(`Result: ${result}`);
}

divideNumbers(50, 10);    
divideNumbers(50, 0);    
// divideNumbers("R", 10);
