package inheritance

// traits are much like interfaces in Java, but also like
// abstract classes (permitted to have abstrace elements
trait Payload {
  def payload: Int
//  def load(item: String):Unit
}

case class Car(seats: Int, color: String) extends Payload /* with... */ {
    println("Constructing a Car")
//  var fuel: Int = _ // "let me have default initialization"
    var fuel: Int = 100 // percent of a tankfull
  val payload: Int = 170 * (seats - 1)

  override def toString(): String = s"Car(${seats}, ${color}, ${fuel})"
}

case class Truck(payload: Int) extends Payload

object Logistics {
  // could pass vehicle as "Any", but don't expect primitives to be helpful
  def canThisCarryThat(vehicle: Payload, load: Int): Boolean =
    load <= vehicle.payload

  def main(args: Array[String]): Unit = {
    val toCarry = 350

    val redCar = Car(5, "Red")
    val candidateVehicles = List(
      redCar,
      Car(3, "Black"),
      Truck(10000),
      Truck(300))

    var idx = 0
    while (idx < candidateVehicles.size) {
      val theVehicle = candidateVehicles(idx)
      if (canThisCarryThat(theVehicle, toCarry)) {
        println(s"${theVehicle} can carry the load ${toCarry}")
      } else {
        println(s"${theVehicle} is no use here")
      }
      idx += 1
    }
    redCar.fuel -= 20
    println(s"redCar is ${redCar}")
    println(s"redCar payload is ${redCar.payload}")
    println(s"Truck(5000) payload is ${Truck(5000).payload}")
  }
}
