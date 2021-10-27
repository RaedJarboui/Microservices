const express = require("express");
const path = require("path");
const bodyParser = require("body-parser");
const request = require("request");
const MongoClient = require("mongodb").MongoClient;
const ObjectID = require("mongodb").ObjectID;

const port = 3939;
const app = express();

app.use(bodyParser.json());

const dbUrl = "mongodb://Mongo:27017/ClientService";
const dbClient = new MongoClient(dbUrl, { useNewUrlParser: true });

dbClient.connect((err) => {
  if (err) throw err;
});

app.get("/get-all", (req, res) => {
  console.log("clients v2: Returns clients list.");
  dbClient
    .db("test")
    .collection("clients")
    .find({})
    .toArray((err, objects) => {
      res.send(objects);
    });
});
app.get("/get-one/:id", (req, res) => {
  console.log("clients v2: Returns a client.");
  dbClient
    .db("test")
    .collection("clients")
    .find({ _id: req.params.id })
    .toArray((err, objects) => {
      res.send(objects);
    });
});

app.post("/add", (req, res) => {
  console.log("clients v2: Adding client.");
  dbClient.db("test").collection("clients").insertOne(req.body);
  res.send("client added with succes");
});
app.delete("/delete/:id", (req, res) => {
  console.log("clients v2: Deleting client.");
  dbClient
    .db("test")
    .collection("clients")
    .deleteOne({ _id: new ObjectID(req.params.id) });
  res.send("client deleted with succes");
});
app.put("/update", (req, res) => {
  console.log("clients v2: Updating client.");
  dbClient
    .db("test")
    .collection("clients")
    .updateOne(
      { _id: new ObjectID(req.body._id) },
      {
        $set: {
          email: req.body.email,
          password: req.body.password,
          firstName: req.body.firstName,
          lastName: req.body.lastName,
          phone: req.body.phone,
          email: req.body.email,
        },
      }
    );
  res.send("client updated with succes");
});
app.use("/img", express.static(path.join(__dirname, "img")));

require("../eureka-helper/eureka-helper").registerWithEureka(
  "clients-service",
  port
);

console.log(`clients service listening on port ${port}.`);
app.listen(port);
