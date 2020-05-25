const mongoose = require('mongoose');

const schemaUser = new mongoose.Schema({
  // _id: mongoose.Schema.Types.ObjectId,
  email:String,
  mainPass:String,
  name: {
      firstName: String,
      lastName: String
  },
  validateEmail:Boolean,
  private_wallet: Array(),
  // profilePicture?: Buffer,
  chestKeys: [{
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Chest'
  }]
},{
  timestamps:true
});

module.exports = mongoose.model('User',schemaUser);
