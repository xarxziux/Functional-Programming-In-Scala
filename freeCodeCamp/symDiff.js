function sym (args) {

    function diff (arr1, arr2) {
        
        var diff1 = arr1.filter (function (next) {
            return (arr2.indexOf (next) === -1);
        }, []);
        
        var diff2 = arr2.filter (function (next) {
            return (arr1.indexOf (next) === -1);
        }, []);
        
        return diff1.concat (diff2);
            
    }
    
    function removeDuplicates (uncArr) {
        return uncArr.filter ( function (next, index, obj) {
            return (obj.slice (0,index).indexOf (next) === -1);
        });
    }
    
    var argArr = Array.prototype.slice.call(arguments);
    
    var cleanArgArr = argArr.map (function (next) {
        return removeDuplicates (next);
    });    
    
    return cleanArgArr.reduce (function (acc, next) {
        return diff (acc, next);
    }, []);
    
}

