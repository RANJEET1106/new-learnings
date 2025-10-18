const fs=require('fs')
const fs1= require('fs/promises')

fs.readFile('even.txt','utf-8',(err,data1)=>{
    if(err) throw err;
    fs.readFile('odd.txt','utf-8',(err,data2)=>{
        if(err) throw err;
        fs.writeFile('final numbers.txt',data1+' '+data2,(err)=>{
            if(err) throw err;
            console.log('files combined successfully')
        });
    });
});


fs1.readFile('odd.txt','utf-8')
.then(data1=>{
    return fs1.readFile('even.txt','utf-8')
    .then(data2=>{
        return fs1.writeFile('final numbers.txt',data1+' '+data2)
    })
})
.then(()=>{
    console.log('files combined')
})
.catch(err=>{
    console.log(err)
})

async function appendFile(){
    try{
        const data1 = await fs1.readFile('odd.txt','utf-8')
        const data2 = await fs1.readFile('even.txt','utf-8')

        await fs1.writeFile('final numbers.txt',data1+' '+data2)
        console.log('files are combined')
    }catch(err){
        console.log(err)
    }
}
appendFile()

// fs.rename('final numbers.txt','newFile1.txt',(err)=>{
//     if(err) console.log(err);
//     else console.log('file is renamed')

//     fs.unlink('newFile1.txt',(err)=>{
//         if(err) {
//             console.error('Error deleting file: ',err);
//             return;
//         }
//         console.log('newFile1.txt was successfully deleted')
//     })
// })

async function renameDelete(){
    try{
        await fs1.rename('final numbers.txt','newFile1.txt')
        console.log('file renamed')
        await fs1.unlink('newFile1.txt')
        console.log('file deleted')
    }catch (err){
        console.error(err)
    }
}
renameDelete()