const express=require('express');
const oracledb = require('oracledb');
var cors = require('cors');


const app=express();
const port= process.env.port || 3001;

let connection;
let userId;
let userPassword;

app.use(express.json());
app.use(cors());

app.post('/connect', async (req, res)=>{
    userId=req.body.id;
    userPassword= req.body.password
    try{
         connection = await oracledb.getConnection(  {
            user          : userId,
            password      : userPassword,
            connectString : '(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))'
            
     })
     console.log(connection);
     res.status(200).send(connection);
     }
     catch (e) {
         res.status(401).send(e)
     }
});

app.post('/sql', async (req, res)=>{
    const query=req.body.query;
    console.log(query)
    try{
         connection = await oracledb.getConnection(  {
        user          : userId,
        password      : userPassword,
        connectString : '(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))'
         })

        const result = await connection.execute(query)
        
     
     console.log(result);
     res.status(200).send(result);
     }
     catch (e) {
         res.status(400).send(e)
     }
     finally {
        if (connection) { // conn assignment worked, need to close
          try {
            await connection.close();
          } catch (err) {
            console.log(err);
          }
        }
      }
});

app.listen(port, ()=>{
    console.log("Server is running!")
})


