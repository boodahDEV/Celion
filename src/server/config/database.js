const mongoose = require("mongoose");
const uri = "mongodb://localhost/T800";
mongoose
  .connect(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true
  })
  .then(db => {
    if (db.Connection.STATES.connected)
      console.log("\x1b[42mT800\x1b[0m -> [\x1b[32mconnected successfully\x1b[0m]");

  })
  .catch(err => console.log(err));


  mongoose.connection.on('connected',_=>{
    console.log("\x1b[42mDatabase\x1b[0m -> [\x1b[32mconnected to services\x1b[0m]");
  })
  mongoose.connection.on('disconnected',err=>{
    console.log("\x1b[41mDatabase\x1b[0m -> [\x1b[31mdisconnected to services\x1b[0m]");
  })
/**
 *    TEST
 */

// const user = require("../models/users");
// const chest = require("../models/chest");

// function saveDataTest() {
//   baul = new chest({
//     site: [
//       {
//         name: "test",
//         keyGenerate: "test", // password de entrada encriptado
//         codeKey: "test", //El codigo de bloqueo del codigo temporal
//         segments: 4 //segmentos utilizados para el tipo de bloqueo
//       }
//     ],
//     chest_Key: "test", //El codigo de bloqueo del baul
//     single_access_key: "test"
//   });

//   baul.save(function(err) {
//     if (err) throw err;
//     console.log(
//       "[\x1b[32mChest\x1b[0m] -> Make \x1b[33msuccessfully\x1b[0m saved."
//     );

//     var usuarios = new user({
//       email: "boodah.com",
//       mainPass: "12345678",
//       name: {
//         firstName: "boodah",
//         lastName: ""
//       },
//       chestKey: baul._id
//     });
//     usuarios.save(function(err) {
//       if (err) throw err;
//       console.log(
//         "[\x1b[32mUser\x1b[0m]  -> \x1b[33mSuccessfully\x1b[0m saved."
//       );
//     });
//   });
// } //fin test

// saveDataTest()

/**
 *    TEST
 */
