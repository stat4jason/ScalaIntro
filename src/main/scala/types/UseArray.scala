package types

object UseArray {
  def main(args: Array[String]): Unit = {
    // this is a factory, not a constructor
//    val numbers = Array[Int](1, 2, 3, 4)
//    val numbers = Array()
    // Array is a java array. Cannot extend or shrink!!!
//    val numbers = Array(1, 2, 3, 4)
    val numbers = Array.apply(1, 2, 3, 4)
    println(s"The first element of the array is ${numbers(0)}")
    println(s"The first element of the array is ${numbers.apply(0)}")
    numbers(1) = 100
    numbers.update(1, 200)
    var idx = 0
    while (idx < numbers.length) {
      println(s"number is ${numbers(idx)}")
      idx += 1
    }

    val empty = new Array(4)
    println(s"array has length ${empty.length}")
  }
}
