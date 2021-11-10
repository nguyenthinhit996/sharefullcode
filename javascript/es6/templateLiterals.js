
let name = 'max';

let template = `
    hello ${name + ' hihi '} hihi
    view use \${name + 'hihi'}
`
console.log(template)
"
    hello max hihi  hihi
    view use ${name + 'hihi'}
"