const express = require("express");
const app = express();
const port = 3000;

app.get("/api/hello", (req, res) => {
    res.json("Hola Mundo desde Node.js" );
});

app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:${port}`);
});
