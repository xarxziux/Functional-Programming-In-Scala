//Setup
var contacts = [
    {
        "firstName": "Akira",
        "lastName": "Laine",
        "number": "0543236543",
        "likes": ["Pizza", "Coding", "Brownie Points"]
    },
    {
        "firstName": "Harry",
        "lastName": "Potter",
        "number": "0994372684",
        "likes": ["Hogwarts", "Magic", "Hagrid"]
    },
    {
        "firstName": "Sherlock",
        "lastName": "Holmes",
        "number": "0487345643",
        "likes": ["Intriguing Cases", "Violin"]
    },
    {
        "firstName": "Kristian",
        "lastName": "Vos",
        "number": "unknown",
        "likes": ["Javascript", "Gaming", "Foxes"]
    }
];


function lookUpProfile(firstName, prop){
// Only change code below this line
  var matchArr = contacts.filter (function (next){
    return next.firstName === firstName;
  });
  
  if (matchArr.length === 0) {
    return "No such contact";
  }
  
  if (!matchArr[0].hasOwnProperty (prop)) {
    return "No such property";
  }
  
  return matchArr[0][prop];
// Only change code above this line
}

// Change these values to test your function
lookUpProfile("Akira", "likes");