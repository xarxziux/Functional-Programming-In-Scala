findClosing <- function (cDepth, cList) {
  print (cList)
  if (length (cList) == 0) {
    print ("Condition 1")
    -1
  } else if (cList [1] == ")") {
    print ( c("Condition 2 returning ", cDepth))
    cDepth
  } else if (cList [1] == "(") {
    print ("Condition 3")
    cIndex = findClosing (1, cList [-1])
    if (cIndex [1] == -1) {
      -1
    } else {
	print ("Condition 3a")
      print (cDepth)
      print (cIndex)
      print (cList)
      findClosing (cDepth + cIndex + 1, cList [-c(1:cDepth)])
    }
  } else {
    print ("Condition 4")
    findClosing (cDepth + 1, cList [-1])
  }
}

balance <- function (iString) {
  
  iList <- unlist (strsplit (iString, split = ""))
  
  iBalance <- function (level, iList) {
    
    if (level < 0) {
      # print ("Condition 1")
      -1
    } else if (length (iList) == 0) {
      # print ("Condition 2")
      level
    } else if (iList [1] == ")") {
      # print ("Condition 3")
      iBalance (level - 1, iList[-1])
    } else if (iList [1] == "(") {
      # print ("Condition 4")
      iBalance (level + 1, iList[-1])
    } else {
      # print ("Condition 5")
      iBalance (level, iList[-1])
    }
  }

  result <- if (iBalance (0, iList) == 0) {
    TRUE
  } else {
    FALSE
  }
  
  result
  
}



