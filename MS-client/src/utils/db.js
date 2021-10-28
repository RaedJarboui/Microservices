const mongoose = require("mongoose");


const connect = async (url) => { try { await mongoose.connect(url, {  
    useNewUrlParser: true,            
    useUnifiedTopology: true,            
    useCreateIndex: true}); 
    console.log("MongoDB Connected ...");    } 
        catch (err) {    console.log(err.message)
            process.exit(1);}
    
    };


module.exports = {connect}

