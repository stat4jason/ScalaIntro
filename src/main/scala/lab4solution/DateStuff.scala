package lab4solution

object DateStuff {
  def isLeap(year: Int): Boolean =
    year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)

  def daysInMonth(month: Int, year: Int): Int = {
    if (month == 9 || month == 4 || month == 6 || month == 11) 30
    else if (month == 2) {
      if (isLeap(year)) 29 else 28
    }
    else if (month == 1 || month == 3 || month == 5 || month == 7
      || month == 8 || month == 10 || month == 12) 31
    else throw new IllegalArgumentException("bad month")
  }

  def main(args: Array[String]): Unit = {
    val month = 2
    val year = 2000
    println(s"days in ${month} of ${year} are ${daysInMonth(month, year)}")
  }
}
