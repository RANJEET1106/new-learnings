const express = require('express')
const logger=require('./app2')
const bodyParser = require('body-parser')
const app= express()

app.use(bodyParser.json())
app.post('/register',(req,res)=>{
    const {username,email} =req.body
    if(!username || !email){
        logger.error('Validation failed: Username and Email are required')
        return res.status(400).json({error:'Username and Email are required'})
    }
    if(!email.includes('@')){
        logger.error('Validation warning: Invalid Email')
        return res.status(400).json({error:'Invalid Email'})
    }
    logger.info(`User  ${username} register successfully`)
    res.status(200).json({message:`welcome ${username}`})
})
app.use((err, req, res, next)=>{
    logger.error(`unhandeled error: ${err.message}`)
    res.status(500).json({error:"Internal Server error"})
})

app.listen(5000,()=>{
    logger.info("Server is running on port 5000")
})