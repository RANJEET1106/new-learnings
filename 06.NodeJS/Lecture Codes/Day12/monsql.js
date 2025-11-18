// Establish the connection with mongoose
// create schema 
// create model 
// perform crud operations 

const express = require('express')
const {MongoClient} = require('mongodb')
const mongoose = require("mongoose")
const app = express()
mongoose.connect("mongodb://127.0.0.1:27017/test")
.then(()=> console.log("mongodb connected"))
.catch((err)=> console.log("mongo error", err)) 

const userSchema = new mongoose.Schema({
    Name:{
        type:String, 
        required: true
    }, 
    USN:{
        type:String, 
        required: true , 
        unique: true 
    }
})

const Student= mongoose.model('student', userSchema)
app.use(express.urlencoded({extended:false}))

app.post("/app",async(req, res)=>{
    const body = req.body 
    const result = await Student.create({
        Name: body.Name, 
        USN: body.USN
    })
    console.log("result",result)
    return res.status(201).json({msg:"success"})
})

app.get("/app",async(req, res)=>{
    const allStudents = await Student.find({}) 
    const html = `<ul>${allStudents.map((student)=> `<li>${student.Name} - ${student.USN}</li>`).join("")}</ul>`
    res.send(html)
})

app.patch("/app/:id", async(req, res)=>{
    const updateStudent = await Student.findByIdAndUpdate(req.params.id,{USN:"2CS1"},{new:true})
    res.json(updateStudent)
})

app.delete("/app/:id", async(req, res)=>{
    await Student.findByIdAndDelete(req.params.id)
    return res.status(201).json({msg:"Successfully Deleted"})
})

app.listen(5000, ()=> console.log("Server running on port 5000"))