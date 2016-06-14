package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    
    def expandList (inc: Int, numList: List[Int]): List [Int] =
      if (numList.tail.isEmpty)
        List (inc + numList.head)
      else
        inc + numList.head :: expandList (inc + numList.head, numList.tail)

    def buildBaseList (elemCount: Int): List [Int] = 
      if (elemCount == 0)
        List (1)
      else
        1 :: buildBaseList (elemCount - 1)
        
    def expandCount (count: Int, exList: List [Int]): List [Int] =
      if (count == 0)
        exList
      else 
        expandCount (count - 1, expandList (0, exList))
      
    if ((c > r) || (c < 0) || (r < 0))
      0
    else if ((c == r) || (c == 0))
      1
    else {
      val fullList = expandCount (r - c, buildBaseList (c))
      fullList (c)
    }
  }

  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def findClosing (depth: Int, cList: List[Char]): Int = 
      if (cList.isEmpty) 
        0
      else if (cList.head == ')')
        depth
      else if (cList.head == '(') {
        val cIndex = findClosing (1, cList.tail)
        if (cIndex == 0)
          0
        else
          findClosing (depth+cIndex+1, cList.tail.drop (cIndex))
        }
          
      else
        findClosing (depth + 1, cList.tail)
    
    def findOpening (depth: Int, oList: List[Char]): Int =
      if (oList.isEmpty)
        0
      if (oList.head == '(')
        depth
      else if (oList.head == ')')
        -1
      else
        findOpening (depth+1, oList.tail)
        
    def dropBlock ()
    
    val oIndex = findOpening (1, chars)
    
    if (oIndex == -1)
      false
    else if (oIndex == 0)
      true
    else {
      bIndex = findClosing ()
    }
  
  
  }
  
      
  
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
    
    
  
  
  
  }
