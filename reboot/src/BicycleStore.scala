package bicyclebackend


case class Bicycle(brand: String, price: Double, stock: Int, sort: Aou)
case class Aou(allround: String, gravel: String, racer: String)

class BicycleStore {
  var cycles: List[Bicycle] = List() 

  def test(i: Int): String = "test " * i
  def addBicycle(b: String): Unit = cycles = cycles :+ b 
  def list(): List[Bicycle] = cycles
  def updateStock(c: String, s: Int): Unit = {
    // hitta en cykel, lägg till, ta bort, uppdatera
    val h = get(c)
    val lt = h.copy(stock = s)
    val tb = cycles.filterNot(h => brand == c)
    cycles = tb :+ lt
  }
  def searchByBrand(b: String): Bycycle = cycles.find(c => c.brand == b).get  
  def searchByPrice(p: Double): Bycycle = cycles.find(c => c.price == p).get
  def searchBysort(s: Aou): Bycycle = cycles.find(c => c.sort)
  def buy(b: String, amount: Int); Double = {
    val c = get(b)
    val newamount = c.stock - amount
    updateStock(b, lt)
    c.price * amount
    

  }
}


