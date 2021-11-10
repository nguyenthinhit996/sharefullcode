
** Default value of function

 function fn (arugment1 = 10, argument2 = "string", argument3 = arugment1 , ...str) {
    console.log(arugment1);
    console.log(argument2);
    console.log(arugment3);
    console.log(str);
 }

fn()
    10
    "string"
    10
    []

fn(23)
    23
    "string"
    23
    []

fn(23,"hello", 1,2,3,4,"ee");
    23
    "hello"
    1
    [2, 3, 4, "ee"]