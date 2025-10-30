const express = require('express')
const path=require('path')
const app=express();
const port=5000
app.get('/',(req,res)=>{
    console.log('You requested index.html')
    res.sendFile(path.join(__dirname+'/views/index.html'))
})
app.get('/home',(req,res)=>{
    console.log('You requested home.html')
    res.sendFile(path.join(__dirname+'/views/home.html'))
})
app.get('/about',(req,res)=>{
    console.log('You requested home.html')
    res.sendFile(path.join(__dirname+'/views/home.html'))
})
app.get('/user',(req,res)=>{
    res.sendFile(path.join(__dirname+'/views/user.html'))
})

app.get('/resuser',(req,res)=>{
    res.json({username:req.query.username, USN:req.query.usn})
})
app.listen(port,()=>{
    console.log("Listning on port 5000")
})