package backend

import utest._

object BicycleSuite extends TestSuite {

  val tests = Tests {
//    test("test get") - {
//      val bb = new InMemoryBicycleBackend()
//      val bc = Bicycle("cresent", 202.2, 44)
//     
//      val r =
//      
//      r ==> 
//    }
//    test("test addBicycle") - {
//      val bb = new InMemoryBicycleBackend()
//      val bc = Bicycle("Cresent", 1112.3, 11)  
//      val id = createID()
//
//      val r = 
//      
//      r ==> 
//    }
    test("test list") - {
      val bb = new InMemoryBicycleBackend()
      
      val r = bb.list()
      
      r.size ==> 0
    }
//    test("test updateStock") - {
//      val bb = new InMemoryBicycleBackend()
//      val nyb = List() :+ Bicycle("Cresent", 1112.3, 11)  
//      
//      val r = bb.updateStock("Cresent", 100)
//
//      
//      r ==> 
//    }
  }
}