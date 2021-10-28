require('dotenv').config();

const config = {  mongo: {  url: process.env.MONGO_URL  },
                  port :{PORT : process.env.PORT},
                  hostname:{HOSTNAME : process.env.HOSTNAME},
                  eurekaPort:{EUREKAPORT: process.env.EUREKAPORT},
                  ipAddr:{IPADD : process.env.IPADD},
                  eurekaHost:{EUREKAHOST : process.env.EUREKAHOST}
                };

module.exports = {config};