console.log('Inicio del programa'); //1

setTimeout(() => {
    console.log('Primer Timeot'); //5
}, 3000);

setTimeout(() => {
    console.log('Segundo Timeot'); //3
}, 0);

setTimeout(() => {
    console.log('Tercero Timeot'); //4
}, 0);

console.log('Fin del programa'); //2