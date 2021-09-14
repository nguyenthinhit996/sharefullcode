
//1 let and scope,
**** phải khai báo trước khi sử dụng
trường hợp sai: let

age = 16
let age = 9; //error

let age = 16
age = 9; //correct

**** chỉ hoạt động trong scope của nó
if thì không vào nhưng function thì vào

vd1:
let age = 30
if(true){
    let = 111;
}
console.log(let) // 30

vd2:
let age = 30;
function callFunction() {
    age = 111;
}
callFunction();
console.log(age) // 111


**** sự khác nhau của var và const và let
đối với mệnh đề if chỉ có var là sẽ ảnh hưởng ra bên ngoài, const và let đều không dc
đối với function thì cả 3 đều không ảnh hưởng bên ngoài.

vd1:
if(true){
 var vari = 13;
 const con = 14;
 let lets = 15;
}
console.log(vari); //13
console.log(con); //error
console.log(lets); //error

function abc(true){
 var vari2 = 13;
 const con2 = 14;
 let lets2 = 15;
}
console.log(vari2); //error
console.log(con2); //error
console.log(lets2); //error




