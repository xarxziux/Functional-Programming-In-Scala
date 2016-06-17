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
  def balance (chars: List[Char]): Boolean = {
    
    def iBalance (level: Int, iList: List [Char]): Int = {
      
      if (level < 0)
        -1
      else if (iList.isEmpty)
        level
      else if (iList.head == '(')
        iBalance (level + 1, iList.tail)
      else if (iList.head == ')')
        iBalance (level -1, iList.tail)
      else
        iBalance (level, iList.tail)
    }
      if (iBalance (0, chars) == 0)
        true
      else
        false
      
      
    
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0)
      1
    else if(money > 0 && !coins.isEmpty)
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
    else
      0
  }
  
}



