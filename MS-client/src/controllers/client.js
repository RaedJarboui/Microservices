const mongoose = require("mongoose");
const axios = require("axios");
const {
  createClientService,
  clientByIdService,
  allClientService,
  updateClientService,
  deleteClientService,
} = require("../services/client");

const createClient = async (req, res) => {
  try {
    //const authorize = await axios.get('http://localhost:8050/auth-service/api/auth/veriflogin')
    const client = await createClientService(req.body);

    res.status(200).send(client);
  } catch (err) {
    res.status(500).json({
      errors: [
        {
          value: err.message,
          msg: "Problem with data server",
          param: "Server",
          location: "body",
        },
      ],
    });
  }
};

const clientById = async (req, res) => {
  try {
    const client = await clientByIdService(req.params.id);
    res.status(200).send(client);
  } catch (err) {
    res.status(500).json({
      errors: [
        {
          value: err.message,
          msg: "Problem with data server",
          param: "Server",
          location: "body",
        },
      ],
    });
  }
};

const allClient = async (req, res) => {
  try {
    // const authorize = await axios.get('http://localhost:8050/auth-service/api/auth/veriflogin', {withCredentials: true})
    const clients = await allClientService();
    res.status(200).send(clients);
  } catch (err) {
    res.status(500).json({
      errors: [
        {
          value: err.message,
          msg: "Problem with data server",
          param: "Server",
          location: "body",
        },
      ],
    });
  }
};

const updateClient = async (req, res) => {
  try {
    console.log(req.body);
    const client = await updateClientService(req.params.id, req.body);
    res.status(200).send(client);
  } catch (err) {
    res.status(500).json({
      errors: [
        {
          value: err.message,
          msg: "Problem with data server",
          param: "Server",
          location: "body",
        },
      ],
    });
  }
};

const deleteClient = async (req, res) => {
  try {
    const client = await deleteClientService(req.params.id);
    res.status(200).send(client);
  } catch (err) {
    res.status(500).json({
      errors: [
        {
          value: err.message,
          msg: "Problem with data server",
          param: "Server",
          location: "body",
        },
      ],
    });
  }
};

module.exports = {
  createClient,
  clientById,
  allClient,
  updateClient,
  deleteClient,
};
