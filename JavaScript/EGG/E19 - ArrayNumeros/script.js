const arrayA = [];
const arrayB = [];

let longitud1 = 50;
let longitud2 = 20;

//Crear vector 50 numeros
function llenarArray(arrayA) {}
for (let i = 0; i < longitud1; i++) {
  let n = Math.floor(Math.random() * 100); //Acerca n al número entrero inferior

  arrayA.push(n);
}

console.log("Array A aleatorio " + arrayA);
alert("Array A aleatorio " + arrayA);

function compareNumeric(n, m) {
  if (n > m) return 1;
  if (n == m) return 0;
  if (n < m) return -1;
}

arrayA.sort(compareNumeric);

for (let i = 0; i < longitud2; i++) {
  if (i < 10) {
    arrayB.push(arrayA[i]);
  } else {
    arrayB.push(0.5);
  }
}

console.log(`Array A ordenado ${arrayA} 
Array B ${arrayB}`);
alert(`Array A ordenado ${arrayA} 
Array B ${arrayB}`);

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
