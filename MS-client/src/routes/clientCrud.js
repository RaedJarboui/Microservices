const express = require("express");
const router = express.Router();
const {
  createClient,
  clientById,
  allClient,
  updateClient,
  deleteClient,
} = require("../controllers/client");
const { error } = require("../middleware/error");
const { param } = require("express-validator");

router.route("/").get(allClient).post(createClient);
router
  .route("/:id")
  .get(
    [param("id").notEmpty().withMessage("il manque l'id")],
    error,
    clientById
  )
  .delete(
    [param("id").notEmpty().withMessage("il manque l'id")],
    error,
    deleteClient
  )
  .put(updateClient);

module.exports = router;
