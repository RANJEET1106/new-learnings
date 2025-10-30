const express = require('express')
const path=require('path')
const app=express();
app.get('/',(req,res)=>{
    res.send("Welcome to the express session")
})
app.get('/home',(req,res)=>{
    res.send("Good Evining")
})
app.get('/file07.html',(req,res)=>{
    res.sendFile(path.join(__dirname,'file07.html'))
})
app.get('/1.html',(req,res)=>{
    res.redirect(301,'file07.html')
})
app.listen(8080,()=>{console.log('Hello')})