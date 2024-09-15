import dotenv from 'dotenv';
dotenv.config();

export const config = {
    Public_Key: process.env.Public_Key,
    Access_Token: process.env.Access_Token,
    // Otras configuraciones
};
