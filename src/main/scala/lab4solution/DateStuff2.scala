package lab4solution

object DateStuff2 {
  val longMonths = Set(1, 3, 5, 7, 8, 10, 12)
  def isLeap(year: Int): Boolean =
    year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)

  def daysInMonth(month: Int, year: Int): Int = {
    if (month < 1 || month > 12) throw new IllegalArgumentException("bad month")
    else if (longMonths.contains(month)) 31
    else if (month == 2) {
      if (isLeap(year)) 29 else 28
    } else 30
  }

  def main(args: Array[String]): Unit = {
//    val names = Set("Fred", "Jim")
//    val hasFred = names contains "Fred"
//    println(s"has fred? ${hasFred}")
    val month = 2
    val year = 2000
    println(s"days in ${month} of ${year} are ${daysInMonth(month, year)}")
  }
}
