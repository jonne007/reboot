import utest._

object BicycleTestSuite extends TestSuite {

  val tests = Tests {
    test("test 1") - {
      val dut = new BicycleTest()

      val r = dut.test(3)
      
      r ==> "test test test "
    }
  }
}