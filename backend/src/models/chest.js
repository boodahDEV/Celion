const { Schema, model } = require('mongoose');

const schemaChest = new Schema({
  _id: mongoose.Schema.Types.ObjectId,
  site: [{
    name: String,
    keyGenerate: undefined, // password de entrada encriptado
    codeKey: undefined, //El codigo de bloqueo del codigo temporal
    segments: Number //segmentos utilizados para el tipo de bloqueo
  }],
  chest_Key: undefined, //El codigo de bloqueo del baul
  single_access_key:undefined
},{
  timestamps:true
});

module.exports = model('Chest',schemaChest);
