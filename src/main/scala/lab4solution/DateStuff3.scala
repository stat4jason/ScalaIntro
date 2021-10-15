package lab4solution

object DateStuff3 {
  def isLeap(year: Int): Boolean =
    year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)

  def daysInMonth(month: Int, year: Int): Int = month match {
    case 1 | 3 | 5 | 7 | 8 | 10 | 12 => 31
    case 4 | 6 | 9 | 11 => 3
    case 2 => if (isLeap(year)) 29 else 28
    case _ => throw new IllegalArgumentException("bad month")
  }

  def main(args: Array[String]): Unit = {
//    val names = Set("Fred", "Jim")
//    val hasFred = names contains "Fred"
//    println(s"has fred? ${hasFred}")
    val month = 12
    val year = 2021
    println(s"days in ${month} of ${year} are ${daysInMonth(month, year)}")
  }
}
