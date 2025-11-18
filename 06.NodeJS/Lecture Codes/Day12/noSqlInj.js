const express = require('express')
const {MongoClient} = require('mongodb')
const mongoose = require("mongoose")
const bodyParser = require("body-parser")
const app = express()
app.use(bodyparser.urlencoded({extended:true}))
mongoose.connect("mongodb://127.0.0.1:27017/test")
.then(()=> console.log("mongodb connected"))
.catch((err)=> console.log("mongo error", err)) 

const userLogin = new mongoose.Schema({
    username:{
        type:String, 
        required:true
    },
    password:{
        type:String
    }
})

const User = mongoose.model('userLgin', userLogin)
app.use(express.urlencoded({extended:false}))
app.post('/login', async(req,res)=>{
    // "username":"{ne}":null
    // "password":"{ne}":null
    const {username,password} = req.body
    const user = await User.findOne({username,password})
    if(user) return res.json(user) 
        res.status(401).send("unauthorized")
})

app.post('/login', async(req,res)=>{
    // const {username,password} = req.body
    const username = String(req.body.username??'')
    const password = String(req.body.password??'')
    const user = await User.findOne({username,password}).lean
    if(user) return res.json(user) 
        res.status(401).send("unauthorized")
})