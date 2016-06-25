function steamrollArray(arr) {
  return (arr.reduce (function (outArr, elem) {
    if (Array.isArray (elem)) {
      return (outArr.concat (steamrollArray (elem)));
    } else {
      return (outArr.concat(elem));
    }
  }, [])); 
}
