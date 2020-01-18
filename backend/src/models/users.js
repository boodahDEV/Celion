const { Schema, model } = require('mongoose');

const schemaUser = new Schema({
  email:String,
  mainPass:String,
  chestKey: {
    site: String,
    privateKey: String,
    code:String,
  }
},{
  timestamps:true
});

module.exports = model('User',schemaUser);
