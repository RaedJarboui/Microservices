const express = require("express");
const cors = require("cors");
const { config } = require("./config");
const { connect } = require("./utils/db");
const PORT = config.port.PORT || 5000;
const eurekaHelper = require("./helpers/eureka-helper");
const app = express();
app.use(cors());

const clientRouter = require("./routes/clientCrud");

connect(config.mongo.url);

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.use("/api/client", clientRouter);

app.listen(PORT, () => {
  console.log("The server is running");
});

setTimeout(function () {
  eurekaHelper.registerWithEureka("client-service", PORT);
}, 120000);
