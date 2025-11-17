const express = require('express')
const bodyparser = require('body-parser')
const escape = require('escape-html')
const sanitize = require('sanitize-html')
const app = express() 
app.use(bodyparser.urlencoded({extended:true}))
app.get('/',(req,res)=>{
    res.send(`
       <form action="/script" method="post">
       <input type="text" name="message"/> 
       <button>POST</button>
       </form>
        `)
})

// enter "<script>alert("This is an alert message!")</script>" in input box
app.post("/script",(req,res)=>{
    // res.send(`Hi ${escape(req.body.message)}`)
    const rawInput = req.body.message;
    const cleanInput = sanitize(rawInput,{
        allowedTags:['b','i'], 
        allowedAttributes:{}
    })
    res.send(`
        <h2>Sanitized Output</h2>
        <div>${cleanInput}</div>
        `)

})
app.listen(5000,()=>console.log("Server Listening"))