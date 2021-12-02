package backend

import java.util.UUID

case class Bicycle(brand: String, price: Double, stock: Int)

 
trait BicycleBackend {
  
  def createID() = UUID.randomUUID.toString()
  def get(b: String): Option[Bicycle]
  def addBicycle(b: Bicycle): String
  def list(): List[Bicycle]
  def update(id: String, b: Bicycle): Unit
  def searchByBrand(b: String): List[Bicycle]
  //def searchByPrice(p: Double): Bicycle
  def buy(b: String, amount: Int): Double
}
class InMemoryBicycleBackend extends BicycleBackend {
  var cycles: Map[String, Bicycle] = Map.empty

  def get(id: String): Option[Bicycle] = {
    cycles.get(id)
  }
  def addBicycle(b: Bicycle): String = { 
   val id = createID()
   cycles = cycles + (id -> b)
   id

  }
  def list(): List[Bicycle] = cycles.values.toList
  def update(id: String, b: Bicycle): Unit = {
    // hitta en cykel, lägg till, ta bort, uppdatera
   cycles = cycles + (id -> b)

  }
  def searchByBrand(b: String): List[Bicycle] = search { c => 
    c.brand
    .toLowerCase()
    .contains(b.toLowerCase()) 
   
  }
  def searchByPrice(p: Double): Bicycle = ???

  def buy(b: String, amount: Int): Double = {

    val c = get(b).get
    val newAmount = c.stock - amount
    update(b, c.copy(stock = newAmount))
    c.price * amount

  }
  def search(f: Bicycle => Boolean): List[Bicycle] = list().filter(f)
}
