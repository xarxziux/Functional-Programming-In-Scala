// Factorial with no tail call optimisation
var factorial1 = function (n) {
    
    var recFact = function (accum, n) {
        
        if (n < 2) {
            console.trace();
            return accum;
        } else {
            console.trace()
            return recFact (accum * n, n-1);
        }
    };
    
    return recFact (1, n);
    
};

var factorial2 = function (n) {
    
    var recfact = function (accum, x) {
    
        if (x === n) {
            // console.trace();
            return (accum * n);
        } else {
            // console.trace();
            return recfact (accum * x, x + 1);
        }
    };
    
    return recfact (1, 1);

};

var factorial1CPS = function (n) {
    var cpsfun = function (x, cont) {
        if (x < 2) {
            console.trace();
            return cont (x);
        } else {
            console.trace();
            var new_cont = function (y) {
                var result = x * y;
                return cont (result);
            };
        }
        return cpsfun (x-1, new_cont);
    };
    return cpsfun (n, function (a) { return a; }); 
};

console.log (factorial1 (5));
// console.log (factorial1 (8));
// console.log (factorial1 (12));
// console.log (factorial1 (120));
// console.log (factorial1 (150));

// console.log (factorial2 (5));
// console.log (factorial2 (8));
// console.log (factorial2 (12));
// console.log (factorial2 (120));
// console.log (factorial2 (150));

// console.log (factorial1CPS (5));
// console.log (factorial1CPS (8));
// console.log (factorial1CPS (12));
// console.log (factorial1CPS (120));
// console.log (factorial1CPS (150));

