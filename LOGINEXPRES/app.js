const express = require('express')
const app = express()
const port = 3000
// Get the client
const mysql = require('mysql2/promise');

// Create the connection to database
const connection = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password:'E1234567890C',
    database: 'proyectorsm',
});

app.get('/', (req, res) => {
    res.send('Hello World!')
})
app.get('/login', async (req, res,) => {
    const datos = req.query;
    try {
        const [results, fields] = await connection.query(
           // 'SELECT * from jugadores where id=10'
           'SELECT * FROM `jugadores` where id=1' 
            //  WHERE `id` = 1'
        );
        if (results.length > 0) {
        res.status(200).send ('inicio de sesion correcta')
        }else {
        res.status(401).send('datos incorrectos') 
        }
        console.log(results); // results contains rows returned by server
        console.log(fields); // fields contains extra meta data about results, if available
        } 
    catch (err) {
        console.log(err);
    }

})
app.get('/Validar', (req, res) => {
    res.send('Sesion Validada!')
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})
