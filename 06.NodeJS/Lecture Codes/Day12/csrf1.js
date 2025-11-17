const express = require('express')
const bodyparser = require('body-parser')
const app = express() 
const session = require('express-session')
const csrf = require('csrf-csurf')
app.use(bodyparser.urlencoded({extended:true})) 
app.use(session({
    secret:'mykey', 
    resave:false, 
    saveUninitialized:true
}))
const csrfProtection = csrf()
app.use(csrfProtection)
app.get('/',(req,res)=>{
    const form=`
    <form method="post" action="/process">
    <input type="hidden" name="csrf" value=${generateToken()}/>
    <input type="text" name="name"/>
    <button>Submit</button>
    </form>`
    res.send(form)
})
app.post('/process',(req,res)=>{
    res.send(`Hello ${req.body.name}. Your profile-submitted`)
})
app.listen(5000,()=>console.log("Server Listening"))