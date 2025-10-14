function fetchData(callback) {
    setTimeout(() => {
        console.log("Data");
        callback("Done");
    });
}

fetchData((result) => {
    console.log("Callback:", result);
});


function wakeUp(callback) {
    setTimeout(() => {
        console.log("Woke up");
        callback();
    }, 1000);
}

function takeShower(callback) {
    setTimeout(() => {
        console.log("Taking shower");
        callback();
    }, 1000);
}

function leavingSchool() {
    setTimeout(() => {
        console.log("Leaving school");
    }, 1000);
}

function routine() {
    wakeUp(() => {
        takeShower(() => {
            leavingSchool();
        });
    });
}

routine();

function getProductDetails() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const product = {
                id: 101,
                name: "Smartphone",
                price: 50000,
                quantity: 50
            };
            resolve(product);
        }, 2000);
    });
}
console.log("Fetching product details");

getProductDetails()
    .then(product => {
        console.log("Product Details:", product);
    })
    .catch(error => {
        console.error("Error:", error);
    });

console.log("Doing other tasks while waiting");

const url = "https://jsonplaceholder.typicode.com/users/1";; 

async function fetchData() {
  try {
    console.log("Fetching data");
    const response = await fetch(url);
    const data = await response.json();
    console.log("Data received:", data);
  } catch (error) {
    console.error("Error:", error);
  }
}

fetchData();