async function getNumber() {
    return 5;
}

getNumber().then(console.log)

async function demo() {
    let num= await getNumber()
    console.log(num)
}

demo()

fetch("https://jsonplaceholder.typicode.com/posts/1")
.then(response => response.json())
.then(data =>console.log(data))
.catch(error => console.log(error))

async function fetchPost(){
    try{
        const response = await fetch("https://jsonplaceholder.typicode.com/posts/1")
        const data = await response.json()
        console.log(data)
    }catch(error){
        console.error(error)
    }
}
fetchPost()

import { XMLHttpRequest } from "xmlhttprequest";

let xhr= new XMLHttpRequest();
xhr.open("GET","https://jsonplaceholder.typicode.com/posts/1",true);
xhr.onreadystatechange=function(){
    if(xhr.readyState === 4 && xhr.status === 200){
        let user=JSON.parse(xhr.responseText);
        console.log(user)
    }
};

xhr.send()