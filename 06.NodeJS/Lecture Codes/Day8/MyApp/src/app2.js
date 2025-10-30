const express = require('express')
const path=require('path')
const app=express();
const port=5000
// app.get('/user/:username',(req,res)=>{
//     res.send('<h1>Hello '+req.params.username+'</h1>')
// })

app.get('/user',(req,res)=>{
    res.sendFile(path.join(__dirname+'/views/user.html'))
})

app.get('/resuser',(req,res)=>{
    res.json({username:req.query.username})
})

// app.get('/user',(req,res)=>{
//     res.send('<h1>Hello '+req.query.username+'</h1>')
// })
// http://localhost:8080/user?username=RANJEET
app.listen(port,()=>{
    console.log("Listning on port 5000")
})