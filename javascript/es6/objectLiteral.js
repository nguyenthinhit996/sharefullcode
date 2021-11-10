
let age = 15;
let name = "max";
let identified = "id"

let objects = {
    age,
    name,
    "class room": "12cb12",
   [identified]: 1522,
   callName() {
        console.log(this.age + "," + this.name);
    }
}
console.log(objects.age); //15
console.log(objects.name); // max
console.log(objects["class room"]); // 12cb12
console.log(objects.id); // 1522
console.log(objects[identified]); //1522
objects.callName(); //"15,max"


