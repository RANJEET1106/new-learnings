const express = require('express')
const path=require('path')
const app=express();
const port=5000 
app.use(express.json())
app.post('/',(req,res)=>{
    const {name}= req.body 
    res.send(res.send(`welcome ${name}`))
})

app.listen(port,()=>{
    console.log("Listning on port 5000")
})