  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0)
      1
    else if(money > 0 && !coins.isEmpty)
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
    else
      0
  }
  
}

  /**
   * Exercise 3 in JavaScript
   */

var WshShell = new ActiveXObject ('WScript.Shell');

function countChange (money, coins) {
  
  if (money == 0) {
    return 1;
  } else if ((money > 0) && (coins.length > 0)) {
    return countChange (money - coins[0], coins) 
            + countChange (money, coins.slice (1));
  } else {
    return 0;
  }
}

WshShell.Popup (countChange(300, [500,5,50,100,20,200,10])); // 1022
WshShell.Popup (countChange(301, [5,10,20,50,100,200,500])); // 0




