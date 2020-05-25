const express = require('express');
const app = express();
const cors = require('cors') // modulo para la facil integracion entre el servidor de angular y node
const database = require('./config/database');

// const sha512 = require("./helper/crypto")
// sha512.generateAccessKeyForChest("boodah");


app.use(cors());
app.use(express.json()); //Convierte los datos del servidor a objeto js
app.use('/api', require('./routes/routes'))
    // app.set('port',process.env.PORT || 3300);
app.listen(3300);
console.log('*******************************************************')
console.log('Starting and gathering information on -> [\x1b[32mcrocoKEY\x1b[0m] ...')
console.log('[\x1b[32mcrocoKEY\x1b[0m] -> \x1b[33mactive\x1b[0m -> \x1b[31m%s\x1b[0m', 3300)