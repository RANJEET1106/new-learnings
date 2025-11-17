const express = require('express')
const app = express()
const mysql= require('mysql2')

app.use(express.json());

const conn = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'1106',
    database:'node'
})

conn.connect((err)=>{
    if(err) console.log(err)
    else console.log("Database Connected")
})

app.get("/app1",(req,res)=>{
    conn.query("select * from student",(err,rows)=>{
        if(err) console.log(err)
        res.send(rows)
    })
})

app.get("/app1/:id",(req,res)=>{
    const id=req.params.id;
    conn.query("select * from student where id=?",[id],(err,rows)=>{
        if(err) console.log(err)
        res.send(rows)
    })
})

app.post("/app1",(req,res)=>{
    const body=req.body
    conn.beginTransaction((err)=>{
        if(err) console.log(err)
    })
    conn.query("insert into student values(?,?,?)",Object.values(body),(err)=>{
        if(err) console.log(err)
    })
    conn.commit((err)=>{
        if(err) console.log(err)
        res.send("Student Data Inserted")
    })
    console.log(body)
})

app.delete('/app1/:id',(req,res)=>{
    const id=req.params.id
    conn.query("delete from student where id=?",[id],(err)=>{
        if(err) console.log(err)
        res.send("Student deleted")
    })

})

app.put("/app1",(req,res)=>{
    const body=req.body 
    conn.query("update student set branch=? where id=?",Object.values(body),(err)=>{
        if(err) console.log(err) 
        res.send("User Data Updated")
    })
})

app.patch("/app1",(req,res)=>{
    const body=req.body 
    conn.query("update student set branch=? where id=?",Object.values(body),(err)=>{
        if(err) console.log(err) 
        res.send("User Data Updated")
    })
})

app.listen(5000,()=>{
    console.log('Server Listening on port 5000')
})