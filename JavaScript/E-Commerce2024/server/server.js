import express from "express";
import cors from "cors";
const config = require('./config');

// SDK de Mercado Pago
import { MercadoPagoConfig, Perference } from "mercadopago";
import e from "cors";

// Agrega credenciales
const client = new MercadoPagoConfig({
    accessToken: `${config.Access_Token}`,
});

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

app.get("/", (req, res) => {
    res.send("Server app ;)");
})

app.post("/create_preference", async (req, res) => {
    try {
        const body = {
            items: [
                {
                    title: req.body.description,
                    unit_price: Number(req.body.price),
                    quantity: Number(req.body.quantity),
                    currency_id: "ARS",
                },
            ],
            back_urls: {
                "success": "http://localhost:8080",
                "failure": "http://localhost:8080",
                "pending": ""
            },
            auto_return: "approved",
        };

        const preference = new Perference(client);
        const result = await preference.create({body});
        res.json({
            id: result.id,
        });
    }catch (error){
        console.log(error);
        res.status(500).json({
            error: " Error al creal la preferencia",
        });
    }
});

app.listen(port, ()=>{
    console.log(``)
})