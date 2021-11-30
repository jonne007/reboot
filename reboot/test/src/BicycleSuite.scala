package backend

import utest._

object BicycleSuite extends TestSuite {

  val tests = Tests {
    test("test 1") - {
      val dut = new BicycleBackend()

      val r = dut.test(3)
      
      r ==> "test test test "
    }
  }
}