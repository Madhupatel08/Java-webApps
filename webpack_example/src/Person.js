// function Person(name, age) {
//     this.name = name;
//     this.age = age;
// }

// Person.prototype.getName = function () {
//     return this.name;
// }

// Person.prototype.getAge = function () {
//     return this.age;
// }

// module.exports = {
//     Person
// }

// ES 6 module system
export default class Person {
    name; // instance variable
    age; // instance variable
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    // methods
    getName() {
        return this.name;
    }
    getAge() {
        return this.age;
    }
}