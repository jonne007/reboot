import backend.InMemoryBicycleBackend
import backend.Bicycle
object Server extends cask.MainRoutes {

  val bicycleBackend = new InMemoryBicycleBackend

  @cask.get("/cycles")
  def list() = {
    val lista = bicycleBackend.list()
    val cycles = upickle.default.writeJs(lista)
    ujson.Obj("cycles" -> cycles )
  }

  @cask.postJson("/cycles")
  def addBicycle(brand: ujson.Value, price: ujson.Value, stock: ujson.Value) = {
    val b = Bicycle(brand.str, price.num, stock.num.toInt)
    val id = bicycleBackend.addBicycle(b)
    ujson.Obj("bicycleId" -> id)
  }

  initialize()
}
