const mongoose = require('mongoose');

const schemaChest = new mongoose.Schema({
  // _id: mongoose.Schema.Types.ObjectId,
  site: [{
    name: String,
    keyGenerate: String, // password de entrada encriptado
    codeKey: String, //El codigo de bloqueo del codigo temporal
    segments: Number //segmentos utilizados para el tipo de bloqueo
  }],
  chest_Key: String, //El codigo de bloqueo del baul
  single_access_key:String
},{
  timestamps:true
});

module.exports = mongoose.model('Chest',schemaChest);
