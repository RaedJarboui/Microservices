const clientModel = require("../models/client");
const mongoose = require("mongoose");

const createClientService = async (client) => {
  var clientVerif = await clientModel.findOne({ lastName: client.lastName });
  if (clientVerif) {
    return res.status(400).json({
      errors: [
        {
          value: client.lastName,
          msg: "nom utilisé",
          param: "lastName",
          location: "body",
        },
      ],
    });
  }
  var clientVerif = await clientModel.findOne({ firstName: client.firstName });
  if (clientVerif) {
    return res.status(400).json({
      errors: [
        {
          value: client.firstName,
          msg: "code d'client existe",
          param: "firstName",
          location: "body",
        },
      ],
    });
  }
  var clientSave = { ...client, dateCreation: Date.now() };
  clientSave = new clientModel(clientSave);
  await clientSave.save();
  return clientSave;
};

const clientByIdService = async (id) => {
  if (!mongoose.Types.ObjectId.isValid(id)) {
    return res.status(400).json({
      errors: [
        {
          value: id,
          msg: "id non conforme",
          param: "id",
          location: "params",
        },
      ],
    });
  }

  var client = await clientModel.findOne({ _id: id });

  if (client == null) {
    return res.status(400).send("client n'exite pas");
  }
  return client;
};

const allClientService = async () => {
  const clients = await clientModel.find();
  return clients;
};

const updateClientService = async (id, client) => {
  if (!mongoose.Types.ObjectId.isValid(id)) {
    return res.status(400).json({
      errors: [
        {
          value: id,
          msg: "id non conforme",
          param: "id",
          location: "params",
        },
      ],
    });
  }

  var client = await clientModel.findByIdAndUpdate(id, client, {
    useFindAndModify: false,
  });
  return client;
};

const deleteClientService = (id) => {
  if (!mongoose.Types.ObjectId.isValid(id)) {
    return res.status(400).json({
      errors: [
        {
          value: id,
          msg: "id non conforme",
          param: "id",
          location: "params",
        },
      ],
    });
  }
  const client = clientModel.findByIdAndDelete(id);
  return client;
};

module.exports = {
  createClientService,
  clientByIdService,
  allClientService,
  updateClientService,
  deleteClientService,
};
