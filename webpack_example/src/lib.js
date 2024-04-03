function filter (elems, predicate) {
    const output = []
    for (let i = 0; i < elems.length; i++) {
      if (predicate(elems[i])) {
        output.push(elems[i])
      }
    }
    return output
  }
  
  function map (elems, transformFn) {
    const output = []
    for (let i = 0; i < elems.length; i++) {
      output.push(transformFn(elems[i]))
    }
    return output
  }
  
  function add (x, y) {
    return x + y
  }
  
  module.exports = {
    filter, map, add
  }