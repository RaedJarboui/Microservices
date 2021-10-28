const { validationResult } = require('express-validator');

const error = (req,res,next)=>{const error =  validationResult(req);
    if(!error.isEmpty()){
      return res.status(400).send(error)
    }
    next();
}

module.exports = {error}