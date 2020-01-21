const mongoose = require("mongoose");
const user_access = mongoose.connect("mongodb://localhost/T800", {
  useNewUrlParser: true,
  useUnifiedTopology: true
});

/**
 *    TEST
 */

const user = require("../models/users");
const chest = require("../models/chest");

function saveDataTest() {
  baul = new chest({
    site: [
      {
        name: "test",
        keyGenerate: "test", // password de entrada encriptado
        codeKey: "test", //El codigo de bloqueo del codigo temporal
        segments: 4 //segmentos utilizados para el tipo de bloqueo
      }
    ],
    chest_Key: "test", //El codigo de bloqueo del baul
    single_access_key: "test"
  });


  baul.save(function(err) {
    if (err) throw err;
    console.log('Chest successfully saved.');

    var usuarios = new user({
      email: "boodah.com",
      mainPass: "12345678",
      name: {
        firstName: "boodah",
        lastName: ""
      },
      chestKey: baul._id
    });
    usuarios.save(function(err) {
      if (err) throw err;
      console.log('Users successfully saved.');
    })

  })
}//fin test


saveDataTest()

/**
 *    TEST
 */

user_access
  .then(db => console.log("Database is connected!"))
  .catch(err => console.log(err));
