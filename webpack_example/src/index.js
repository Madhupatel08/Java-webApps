const { Person } = require('./Person');

console.log("Hello Webpack 123 !!!");

let person = new Person("Asha", 23);
console.log("Person : ", person.getName(), person.getAge());