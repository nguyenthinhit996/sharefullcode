

**** arrow function systax:

one line , one argrument: const fn = argrument => console.log(argrument) ;

the lines:  const fn = () => {
    //somethings code here
}

**** Quang trọng của sự khác nhau của function truyền thống vào arrow function là chỗ xử lí this:

ví dụ đơn giản:

var chopper = {
    owner: 'Zed',
    getOwner: function() { return this.owner; }
};

var chopper2 = {
    owner: 'John',
    getOwner: () => { return this.owner; }
};

console.log(chopper.getOwner()); // Zed
console.log(chopper2.getOwner()); // undefined vì this này không phải this current mà this windown


ví dụ phức tap:

var buttonXXX = document.querySelector('button');

function fn () {
  console.log(this) // output [object HTMLButtonElement]
}

const fn2 = () => {
  console.log(this); //output [object Window]
}

const fn22 = () => {
  console.log(this.buttonXXX); // same result with function traditional output [object HTMLButtonElement]
}

buttonXXX.addEventListener('click',fn2);

