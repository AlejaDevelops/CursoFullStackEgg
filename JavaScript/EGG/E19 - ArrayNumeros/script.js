const a = [];
const b = [];

//Crear vector 50 numeros
function llenarArray(a) {}
for (let i = 0; i < 50; i++) {
  a[i] = (Math.random() * 100).toFixed(1);
}

console.log(a);

/* SOLUCION MARIO

let numRandom =0;

let arrayA = [];
let arrayB = [];


for(let i=0; i<50; i++){
    arrayA.push(numRandom = Math.ceil(((Math.random()*1000)+1)));
}
arrayA.sort();

console.log(arrayA);
console.log(arrayA.length);
//alert(arrayA.length);

for(let i=0; i<20; i++){
    if(i<10){
        arrayB.push(arrayA[i]);

    }else{
        arrayB.push(0.5);
    }
    
}*/
