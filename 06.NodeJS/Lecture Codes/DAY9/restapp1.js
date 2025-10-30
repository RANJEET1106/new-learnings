const express = require('express')
const app = express()
const fs= require('fs')
app.use(express.json())
let usrs= fs.readFileSync('MOCK_DATA.json')

var users= JSON.parse(usrs)
app.get('/app1',(req,res)=>{
    res.send(users)
})
app.get('/brow',(req,res)=>{
    const html=`<ul>${users.map((users)=>
        `<li>${users.id}${users.first_name}${users.email}</li>`).join("")}
        </ul>`
    res.send(html)
})

app.get('/app1/users/:id',(req,res)=>{
    const id=req.params.id 
    const usr=users.find((u)=>u.id==id)
    res.send(usr)
})

app.post('/app1',(req,res)=>{
    // const body=req.body
    const newId = users.length+1
    const {first_name,email}= req.body
    users.push({"id":newId,"first_name":first_name,"email":email})
    fs.writeFile('./MOCK_DATA.json',JSON.stringify(users),(err,data)=>{
        res.send(users)
    })
    // res.send("user added")
})

app.put('/app1/:id',(req,res)=>{
    const id=req.params.id 
    const {first_name}=req.body
    const usr=users.find((u)=>u.id==id)
    usr.first_name = first_name
    fs.writeFile('./MOCK_DATA.json',JSON.stringify(users),(err,data)=>{
        res.send(`user with id ${id} updated`)
    })
})

app.delete('/app1/:id',(req,res)=>{
    const id=parseInt(req.params.id)
    const userId=users.findIndex((u)=>u.id===id)
    users.splice(userId,1)
    fs.writeFile('./MOCK_DATA.json',JSON.stringify(users,null,2),(err,data)=>{
        const updatedUsers=users
        res.send(`user with id ${id} deleted`)
    })
})

app.listen(5000,()=>{
    console.log('Server Listening on port 5000')
})