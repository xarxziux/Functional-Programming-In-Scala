package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
    test("pascal: col=0,row=2") {
      assert(pascal(0,2) === 1)
  }

    test("pascal: col=1,row=2") {
      assert(pascal(1,2) === 2)
  }

    test("pascal: col=1,row=3") {
      assert(pascal(1,3) === 3)
  }

    test("pascal: col=3,row=6") {
      assert(pascal(3,6) === 20)
  }

    test("pascal: col=4,row=8") {
      assert(pascal(4,8) === 70)
  }

    test("pascal: col=6,row=10") {
      assert(pascal(6,10) === 210)
  }

    test("pascal: col=7,row=13") {
      assert(pascal(7,13) === 1716)
  }

    test("pascal: col=3,row=14") {
      assert(pascal(3,14) === 364)
  }

}
