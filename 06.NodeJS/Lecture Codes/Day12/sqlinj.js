const express = require('express')
const bodyparser = require('body-parser')
const mysql=require('mysql2/promise') 
const app = express() 
app.use(bodyparser.urlencoded({extended:true})) 
app.use(express.json())
app.use(express.urlencoded({extended:true}))
const pool = mysql.createPool({
    host:'localhost',
    user:'root',
    password:'1106',
    database:'node'
})
app.post('/login',async(req, res)=>{
    const {id,name,branch} = req.body
    try{
        // const[rows] = await pool.execute(`Select * from student where id="${id}" and name="${name}"`)
        const[rows] = await pool.execute(`Select * from student where id=? and name=? and branch=?`,[id,name,branch])
        if (rows.length > 0){
            res.send("sql login successfull")
        }else{
            res.send("sql login failed")
        }
    }catch{
        res.send(500)
    }
})
app.listen(5000,()=>console.log("Server Listening"))