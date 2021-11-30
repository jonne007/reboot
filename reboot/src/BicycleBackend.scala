package backend

case class Bicycle(brand: String, price: Double, stock: Int, sort: Aou)
case class Aou(allround: String, gravel: String, racer: String)

trait BicycleBackend {

  def get(b: String): Bicycle
  def addBicycle(b: Bicycle)
  def list(): List[Bicycle]
  def updateStock(c: String, s: Int): Unit
  def searchByBrand(b: String): Bicycle
  def searchByPrice(p: Double): Bicycle
  def searchBysort(s: Aou): Bicycle
  def buy(b: String, amount: Int): Double
}
class InMemoryBicycleBackend extends BicycleBackend {
  var cycles: List[Bicycle] = List()

  def test(i: Int): String = "test " * i
  def get(b: String): Bicycle = {
    cycles.find(c => c.brand == b).get
  }
  def addBicycle(b: Bicycle) = cycles = cycles :+ b
  def list(): List[Bicycle] = cycles
  def updateStock(c: String, s: Int): Unit = {
    // hitta en cykel, lägg till, ta bort, uppdatera
    val h = get(c)
    val lt = h.copy(stock = s)
    val tb = cycles.filterNot(h => h.brand == c)
    cycles = tb :+ lt
  }
  def searchByBrand(b: String): Bicycle = {
    cycles.find(c => c.brand.toLowerCase == b).get
  }
  def searchByPrice(p: Double): Bicycle = cycles.find(c => c.price == p).get
  def searchBysort(s: Aou): Bicycle = cycles.find(c => c.sort == s).get
  def buy(b: String, amount: Int): Double = {

    val c = get(b)
    val newAmount = c.stock - amount
    updateStock(b, newAmount)
    c.price * amount

  }
}
