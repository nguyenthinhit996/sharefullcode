

******** const: nó khá giống với final của java. chỉ là con trỏ poiter chỉ,
vẫn có thể thay đổi cấu trúc bên trong object hoặc array. không được gán con trỏ đến vùng nhớ khác

const object = {
	age : 10;
}
object.age = 100 // ok
object = object b // error

const array = [1,2,4]
array.push(33) // ok
array = [bb]; // error

