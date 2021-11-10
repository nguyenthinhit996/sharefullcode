
******************** Detructoring ***************************
null => null
undefined => default || undefined (có default sẽ lấy default ko thì vẫn là undefined)


******** Detructoring Array ********
use position get element
vẫn sử dụng rest operator ... get all element
use skip some index arrays
use swap for some element of arrays.

ví dụ:
let arrays = [
    obj1 = null,
    obj2 = undefined,
    obj3 = {
        a: 13,
        b: 15
    }
]

let [a = "default a", b = "default b", c , d = b]  = arrays;
console.log(a) // null
console.log(b) // default b
console.log(c) // {object}
console.log(d) // default b

*** sử dung rest operator
let [...a]  = arrays;
[null, undefined, [object Object] {
  a: 13,
  b: 15
}]

*** use skip
let [a,,c]  = arrays;
let [a,,c]  = arrays;
console.log(a) // null
console.log(c) // {object}

**** use swap
let a = 10;
let b = 50;
[b, a] = [a, b];
console.log(b); // 10
console.log(a); // 50



*************  Detructoring Object *************
use name exactly get property
can use alias

let object = {
    name: 'max',
    age: 15,
    school: 'unniversity',
    variableNull: null,
    variableUndefined: undefined
}

let {name, age, variableNull = 3333, variableUndefined : alias = "default"} = object

console.log(name) //max
console.log(age) // 15
console.log(variableNull) // null
console.log(alias) // default

