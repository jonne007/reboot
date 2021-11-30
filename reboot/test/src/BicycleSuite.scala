package backend

import utest._

object BicycleSuite extends TestSuite {

  val tests = Tests {
    test("test 1") - {
      val bb = new InMemoryBicycleBackend()

      val r = bb.test(3)
      
      r ==> "test test test "
    }
   // test("test get") - {
  //  val bb = new InMemoryBicycleBackend()
  //    val bc = Bicycle("cresent", 202.2, 44)
//
  //    val r = bb.get("cresent")
//
  //    r ==> "cresent"
    //}
    test("test list") - {
      val bb = new InMemoryBicycleBackend()

      val r = bb.list()
      
      r.size ==> 0
    }
    test("test updateStock") - {
      val bb = new InMemoryBicycleBackend()
      val nyb = List() :+ Bicycle("Cresent", 1112.3, 11)  
      val nys = bb.updateStock("Cresent", 100)

      val r = bb.test(2)
      
      r.size ==> 111 
    }
  }
}