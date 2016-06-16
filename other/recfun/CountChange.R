countChange <- function (money, coins) {
  if (money[1] == 0) {
    1
  } else if ((money[1] > 0) & (length (coins > 0))) {
    countChange (money [1] - coins [1], coins) +
        countChange (money, coins [-1])
  } else {
    0
  }
}



