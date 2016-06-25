function binaryAgent (str) {
  
  function strToInt (bStr) {
    return (bStr.split('').reduce (function (accum, elem, index, rArr) {
      return (elem === '1') 
        ? accum + (Math.pow (2, rArr.length - index - 1))
        : accum;
    }, 0));
  }
  
  var intArr = str.split (' ').map (function (elem) {
    return (strToInt (elem));
  });
  
  return (intArr.reduce (function (outStr, elem) {
    return (outStr.concat (String.fromCharCode(elem)));
  }, ''));
  
}

console.log (binaryAgent("01000001 01110010 01100101 01101110 00100111 01110100 00100000 01100010 01101111 01101110 01100110 01101001 01110010 01100101 01110011 00100000 01100110 01110101 01101110 00100001 00111111"));


