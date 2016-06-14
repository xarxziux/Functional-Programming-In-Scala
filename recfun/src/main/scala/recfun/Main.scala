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

    def findClosing (cDepth: Int, cList: List[Char]): Int = {
      if (cList.isEmpty) 
        -1
      else if (cList.head == ')')
        cDepth
      else if (cList.head == '(') {
        val cIndex = findClosing (1, cList.tail)
        if (cIndex == -1)
          -1
        else
          findClosing (cDepth+cIndex+1, cList.tail.drop (cIndex))
        }
          
      else
        findClosing (cDepth + 1, cList.tail)
    }
    
    def findOpening (oDepth: Int, oList: List[Char]): Int = {
      if (oList.isEmpty)
        0
      else if (oList.head == '(')
        oDepth
      else if (oList.head == ')')
        -1
      else
        findOpening (oDepth+1, oList.tail)
    }
        
    def findBalance (bDepth: Int, bList: List[Char]): Int = {
      if (bList.isEmpty)
        0
      else if (bList.head == ')')
        -1
      else if (bList.head == '(')
        findClosing (bDepth+1, bList.tail)
      else
        findBalance (bDepth+1, bList.tail)
    }
    
    if (chars.isEmpty)
      true
    else {
  
      val dropVal = findBalance (1, chars)
      
      if (dropVal == -1)
        false
      else
        balance (chars.drop(dropVal))
    }
  }
  
  
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
    
      val total = 100
      /*def findAnswer (sCount: Int, subTotal: Int, cList: List[Int]): Int = {
        if (cList.isEmpty)
          count
        else if (subTotal == 0)
          count + 1
        else if (cList.head > subTotal)
          findAnswer (sCount, subTotal, cList.tail)
        
      }*/
      
      def checkAnswer (rCount: Int, tList: List[Int]): Int = {
        if (tList.sum > total)
          rCount
        else if (tList.sum == total)
          rCount + 1
        else
          checkAnswer (rCount, (tList.head :: tList))
      }
  
  
  }
