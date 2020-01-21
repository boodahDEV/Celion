const { Schema, model } = require('mongoose');

const schemaUser = new Schema({
  _id: mongoose.Schema.Types.ObjectId,
  email:String,
  mainPass:String,
  name: {
      firstName: String,
      lastName: String
  },
  profilePicture?: Buffer,
  chestKey: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Chest'
  }
},{
  timestamps:true
});

module.exports = model('User',schemaUser);
