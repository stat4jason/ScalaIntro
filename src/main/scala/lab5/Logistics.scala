package lab5

import inheritance.{Car, Truck}

case class Car(seats: Int, color: String)

case class Truck(payload: Int)

object Logistics {
  // could pass vehicle as "Any", but don't expect primitives to be helpful
  def canThisCarryThat(vehicle: AnyRef, load: Int): Boolean =
    load <= (vehicle match{
      case Car(seats, _) => 170 * (seats - 1)
      case Truck(payload) => payload
      case _ => -1
    })

  def main(args: Array[String]): Unit = {
    val toCarry = 350

    val candidateVehicles = List(
      inheritance.Car(5, "Red"),
      inheritance.Car(3, "Black"),
      inheritance.Truck(10000),
      inheritance.Truck(300))

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
  }
}
