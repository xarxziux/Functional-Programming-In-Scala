package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  test("balance: custom1") {
    assert(balance("999((9((((9(99())0)0))000()0()(00())0))99(99))".toList))
  }

  test("balance: custom2") {
    assert(!balance("999((9((((9(99)0)0))000()0()(00()0))99(99))".toList))
  }

  test("balance: custom3") {
    assert(!balance("999((9((((9(99)0)0))000()0()(00()0))99(99))".toList))
  }

  test("balance: custom4") {
    assert(balance("999((9(((9(99)0))0))000()0()(00()0))99(99)".toList))
  }

  test("balance: custom5") {
    assert(!balance("999((9)00)0)((((9(99)0)0))000()0()(00()0))9(9(99))".toList))
  }

  test("balance: custom6") {
    assert(balance("999".toList))
  }

  test("balance: custom7") {
    assert(balance("()".toList))
  }

  test("balance: custom8") {
    assert(balance("".toList))
  }

}
