import express from "express";
import cors from "cors";
import { config } from './config.js'; // Ajustado para importar desde config.mjs

// SDK de Mercado Pago
import pkg from "mercadopago";
const { MercadoPagoConfig, Preference } = pkg;

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

        const preference = new Preference(client);
        const result = await preference.create({body});
        res.json({
            id: result.id,
        });
    }catch (error){
        console.log(error);
        res.status(500).json({
            error: "Error al crear la preferencia",
        });
    }
});

app.listen(port, ()=>{
    console.log(`Servidor corriendo en el puerto ${port}`);
})
