const mongoose = require('mongoose');

const schemaUser = new mongoose.Schema({
  // _id: mongoose.Schema.Types.ObjectId,
  email:String,
  mainPass:String,
  name: {
      firstName: String,
      lastName: String
  },
  // profilePicture?: Buffer,
  chestKey: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Chest'
  }
},{
  timestamps:true
});

module.exports = mongoose.model('User',schemaUser);
