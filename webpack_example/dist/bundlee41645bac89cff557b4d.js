(()=>{var e={323:e=>{function t(e,t){this.name=e,this.age=t}t.prototype.getName=function(){return this.name},t.prototype.getAge=function(){return this.age},e.exports={Person:t}}},t={};function o(n){var r=t[n];if(void 0!==r)return r.exports;var s=t[n]={exports:{}};return e[n](s,s.exports,o),s.exports}(()=>{const{Person:e}=o(323);console.log("Hello Webpack !!!");let t=new e("Asha",23);console.log(t.getName(),t.getAge())})()})();