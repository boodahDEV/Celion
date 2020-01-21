const { Router } = require('express');
const router = new Router();
const jwt = require('jsonwebtoken')

router.get('/', (req, res) => res.send("HEllo word"))
router.post('/signup', async (req, res) => {
  //accion de la ruta
});


module.exports = router; // al final exporto las rutas al index principal

function verifyToken(req,res,next) {
    if(!req.headers.authorization){
        return res.status(401).send("No esta autorizado para ver esto!")
    }

    const token = req.headers.authorization.split(' ')[1]; // separo el token del standar Bearer
    if(token === 'null'){
        return res.status(401).send("No esta autorizado para ver esto!");
    }
    //optengo lo que hay dentro del token alv
    const payload = jwt.verify(token,'secretkey');
    // console.log(payload) // paso los datos a una variable que puedan acceder todas las rutas, ejemplo req
    req.userId = payload._id;
    next();
}
