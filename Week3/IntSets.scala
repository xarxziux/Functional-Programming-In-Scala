object IntSet {
  // def main (args: Array [String])
}

abstract class IntSet {
  def incl (x: Int): IntSet
  def contains (x: Int): Boolean
  def union (other: IntSet): IntSet
  def filterAcc1 (f: Int => Boolean, acc: IntSet): IntSet
  def filterAcc2 (f: Int => Boolean, acc: IntSet): IntSet
  
  def filter1 (f: Int => Boolean): IntSet =
    filterAcc1 (f, Empty)

  def filter2 (f: Int => Boolean): IntSet =
    filterAcc2 (f, Empty)
}

object Empty extends IntSet {
  def contains (x: Int): Boolean = false
  def incl (x: Int): IntSet = new NonEmpty (x, Empty, Empty)
  override def toString = "."
  def union (other: IntSet): IntSet = other
  def filterAcc1 (f:Int => Boolean, acc: IntSet): IntSet = acc
  def filterAcc2 (f:Int => Boolean, acc: IntSet): IntSet = acc
}

class NonEmpty (elem: Int, left: IntSet, right: IntSet) extends IntSet {
  
  def contains (x: Int): Boolean = 
    if (x < elem) left contains x
    else if ( x > elem) right contains x
    else true
    
  def incl (x: Int): IntSet =
    if (x < elem) new NonEmpty (elem, left incl x, right)
    else if (x > elem) new NonEmpty (elem, left, right incl x)
    else this
    
  override def toString = "{" + left + elem + right + "}"
  
  def union (other: IntSet): IntSet = 
    left union right union other incl elem
    
  def filterAcc1 (f: Int => Boolean, acc: IntSet): IntSet = {
    if (f(elem)) 
      right filterAcc1 (f, left filterAcc1 (f, acc)) incl elem
    else 
      right filterAcc1 (f, left filterAcc1 (f, acc))
  }
  
  def filterAcc2 (f: Int => Boolean, acc: IntSet): IntSet = {
    val lAcc = left filterAcc2 (f, acc)
    val rAcc = right filterAcc2 (f, lAcc)

    if (f (elem)) rAcc incl elem
    else rAcc
  }
}





