// noprotect

console.log ("New run");
console.log ("");
console.log ("");

function smallestCommons(arr) {
  
  function gcd (x, y) {
    if (((x === 0) & (y === 0)) ||
        ((x < 0) || (y < 0))) throw new Error 
        ('Invalid input parameters to gcd() function.');
    else if (x === 0) return (y);
    else if (y === 0) return (x);
    else if (x <= y) return (gcd (x, y % x));
    else return (gcd (y, x % y));
    
  }

  if (arr.length != 2) throw new Error 
    ('Invalid number of input arguments.');
  if ((arr[0] < 1) || (arr[1] < 1)) throw new Error 
        ('Input arguments cannot be less than zero.');

  var arg1 = (arr[0] === 1) ? 2 : arr[0];
  var arg2 = (arr[1] === 1) ? 2 : arr[1];
  var start = (arg1 <= arg2) ? arg1 : arg2;
  var end = (arg1 <= arg2) ? arg2 : arg1;
  var inputArr = new Array (end-start+1).fill().map(
      function (_, index) { return (index + start);});

  return (inputArr.reduce (function (currLCM, next) {
      return ((currLCM * next) / gcd (currLCM, next));
    }, 1));
    
}

console.log ('[1, 5] = ' + smallestCommons([1,5]));
console.log ('[1, 7] = ' + smallestCommons([1,7]));
console.log ('[1, 9] = ' + smallestCommons([1,9]));
console.log ('[1, 10] = ' + smallestCommons([1,10]));
console.log ('[1, 11] = ' + smallestCommons([1,11]));
console.log ('[1, 12] = ' + smallestCommons([1,12]));
console.log ('[1, 13] = ' + smallestCommons([1,13]));  // loopCount = 291239
console.log ('[1, 14] = ' + smallestCommons([1,14]));
console.log ('[1, 15] = ' + smallestCommons([1,15]));
console.log ('[1, 16] = ' + smallestCommons([1,16]));
console.log ('[1, 17] = ' + smallestCommons([1,17]));
console.log ('[1, 18] = ' + smallestCommons([1,18]));
console.log ('[1, 19] = ' + smallestCommons([1,19]));  //  loopCount = 192,979,439

