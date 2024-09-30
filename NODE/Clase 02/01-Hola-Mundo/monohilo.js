console.log("Hola clase 5 Node");


var i =0;
// Funcion anónima 
setInterval(function() {
    console.log(i);
    i++;
    // if(i===5){
    //     console.log('Forzamos un error')
    //     var a = 3+z;
    // }
},1000); // intervalo en el que se repetira la funcion cada 1000 milisegundos

console.log('Segunda instrucción');