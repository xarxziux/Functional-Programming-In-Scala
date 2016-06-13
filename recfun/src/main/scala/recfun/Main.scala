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
    def balance(chars: List[Char]): Boolean = ???
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
    
    
  
  
  
  }
