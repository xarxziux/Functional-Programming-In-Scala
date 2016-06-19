function findClosing (cDepth, cList) {
	
	if (cList.length === 0) {
		return (-1);
	} else if (cList[0] === ')') {
		return (cDepth);
	} else if (cList[0] === '(') {
		var cIndex = findClosing (1, cList.slice (1));
		if (cIndex === -1) {
			return -1;
		} else {
			findClosing (cDepth + cIndex + 1, cList.slice (cIndex + 1));
		}
	} else {
		findClosing (cDepth + 1, cList.slice(1));
	}
}