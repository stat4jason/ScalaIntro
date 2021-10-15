package usetuplesandclasses

// case class provides dot-equals (and hashCode) automatically
// based on the "tuple fields" declared
// also provides toString
case class Date(day: Int, month: Int, year: Int) {
  println("Hello, making a Date!")
  if (day < 1 || day > 31 || month < 1 || month > 12)
    throw new IllegalArgumentException("Bad date")
}

object UseCaseClass {
  def main(args: Array[String]): Unit = {
    val today = Date(15, 10, 2021)
    val tomorrow = Date(16, 10, 2021)
    val anotherDate = Date(16, 10, 2021)
    println(s"today is ${today}, day is ${today.day}")
    // In Scala == calls the dot-equals Java method
    // Identity comparison is dot-eq
    println(s"tomorrow equals another date? ${tomorrow == anotherDate}")
    println(s"tomorrow and another date are same object? " +
      s"${tomorrow.eq(anotherDate)}")

    // case class fields are PUBLIC, but also FINAL (val)
    // if they are mutable objects, things aren't truly immutable
    println(s"today's day is ${today.day}")
//    today.day = 99

//    Date(-1, 1, 1)

    val value: Any = 99//Date(1, 2, 2023)
    val message = value match {
      case Date(1, 1, 2022) => "It's new year's day next year"
      case Date(1, 1, _) => "It's new year's day some other year"
      case Date(d, m, y) if y >= 2020 && y <= 2022 =>
        s"It's ${d} of month ${m} around about this year"
      case Date(d, m, y) => s"It's ${d} of month ${m} of year ${y}"
      case x: Int => s"It's an Int with value ${x}"
    }
    println(message)
  }
}
