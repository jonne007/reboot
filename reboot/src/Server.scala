import backend.InMemoryBicycleBackend
import backend.Bicycle
object Server extends cask.MainRoutes {

  val bb = new InMemoryBicycleBackend

  @cask.get("/cycles")
  def list() = {
    val lista = bb.list()
    val cycles = upickle.default.writeJs(lista)
    ujson.Obj("cycles" -> cycles)
  }

  @cask.postJson("/cycles")
  def addBicycle(brand: ujson.Value, price: ujson.Value, stock: ujson.Value) = {
    val b = Bicycle(brand.str, price.num, stock.num.toInt)
    val id = bb.addBicycle(b)
    ujson.Obj("bicycleId" -> id)
  }

  @cask.postJson("/cycles/:bid/updateBrand")
  def update(bid: String, brand: ujson.Value) = {
    val b = bb.get(bid).get
    val updatedB = b.copy(brand = brand.str)
    bb.update(bid, updatedB)
    ujson.Obj("updated" -> true)
  }

  @cask.get("/cycles/:bid/searchByBrand")
  def searchByBrand(bid: String) = {
    val lista = bb.list()
    val listByBrand = lista.filter(b =>
      b.brand.toLowerCase
        .contains(bid.toLowerCase)
    )
    val searchedlist = upickle.default.writeJs(listByBrand)

    ujson.Obj("brands" -> searchedlist)
  }

  @cask.get("/cycles/searchByMaxPrice")
  def searchByMaxPrice(p: Double) = {
    val lista = bb.list()
    val listByPrice = lista.filter(b => b.price <= p)
    val maxPriceList = upickle.default.writeJs(listByPrice)

    ujson.Obj("price" -> maxPriceList)
  }

  @cask.get("/cycles/:bid/searchByPricenBrand")
  def searchByPricenBrand(bid: String, p: Double) = {
    val lista = bb.list()
    val listaByBrand = lista.filter(b =>
      b.brand.toLowerCase
        .contains(bid.toLowerCase)
    )
    val byBrandnPrice = listaByBrand.filter(b => b.price <= p)
    val byBrandnPriceList = upickle.default.writeJs(byBrandnPrice)

    ujson.Obj("brandnprice" -> byBrandnPriceList)
  }

  @cask.postJson("/cycles/")
  def delete(brand: ujson.Value, price: ujson.Value, stock: ujson.Value) = {
    val b = Bicycle(brand.str, price.num, stock.num.toInt)
    val marke = b.brand
    val remove = bb.delete(marke)
    val removed = upickle.default.writeJs(remove)

    ujson.Obj("removed" -> removed)
  }

  initialize()

}
