package lab6

import lab6.Date.daysInMonth

class Date(val day: Int, val month: Int, val year: Int) {
  // note daysInMonth throws exception for bad month already...
  if (day < 1 || day > daysInMonth(month, year))
    throw new IllegalArgumentException("Bad day")

  override def toString: String = s"Date d=${day}, m=${month}, y=${year}"

  // note that equals would be created automatially by a case class :)
  override def equals(obj: Any): Boolean = obj match {
    case d: Date => d.day == this.day && d.month == this.month && d.year == this.year
    case _ => false // only a Date (or perhaps a Holiday, which is actually bad!) can equal a date
  }

  def startNextMonth: Date = {
    val monthPlusOne = month + 1
    if (monthPlusOne > 12) new Date(1, 1, year + 1)
    else new Date(1, monthPlusOne, year)
  }

  def tomorrow: Date = {
    val dayPlusOne = day + 1
    if (dayPlusOne > daysInMonth(month, year)) startNextMonth
    else new Date(dayPlusOne, month, year)
  }
}

object Date {
  // Factory:
  def apply(day: Int, month: Int, year: Int): Date =
    new Date(day, month, year)

  def isLeapYear(year: Int): Boolean =
    year % 4 == 0 || year % 100 != 0 && year % 400 == 0

  def daysInMonth(month: Int, year: Int): Int = month match {
    case 1 | 3 | 5 | 7 | 8 | 10 | 12 => 31
    case 4 | 6 | 9 | 11 => 30
    case 2 => if (isLeapYear(year)) 29 else 28
    case _ => throw new IllegalArgumentException(s"Bad Month ${month}")
  }
}

class Holiday(day: Int, month: Int, year: Int, val name: String) extends Date(day, month, year) {
  override def toString: String = super.toString + s" a holiday called ${name}"
}

object UseDate {
  def tryToMakeADate(t: (Int, Int, Int, Boolean)): String = {
    try {
      val d = Date(t._1, t._2, t._3)
      s"${d} created OK which was ${if (t._4) "" else "NOT "}expected"
    } catch {
      case _: IllegalArgumentException =>
        s"Date d=${t._1}, m=${t._2}, y=${t._3} failed to create which was ${if (t._4) "NOT " else ""}expected"
    }
  }

  def main(args: Array[String]): Unit = {
    val dateValues = List(
      (1, 1, 2021, true),
      (29, 2, 2021, false),
      (31, 3, 2021, true),
      (-1, 1, 2020, false),
      (31, 4, 2021, false),
    )
    dateValues.map(tryToMakeADate(_)).foreach(println(_))

    val h: Date = new Holiday(1, 1, 2022, "New year's day")
    println(h)

    val tomorrowWorks =
      List( // List[(Int, Int, Int, Int, Int, Int)]
      (3, 4, 2021, 4, 4, 2021),
      (30, 4, 2021, 1, 5, 2021),
      (28, 2, 2021, 1, 3, 2021),
      (31, 10, 2021, 1, 11, 2021),
      (31, 12, 2021, 1, 1, 2022),
    )
      .map(t => (Date(t._1, t._2, t._3), Date(t._4, t._5, t._6)))
      // show the contents of the pipeline, but leave it unchanged
      .map(t => {println(s"> ${t}"); t})
      // change first date to "tomorrow"
      .map(t => (t._1.tomorrow, t._2))
      // show the contents again
      .map(t => {println(s">> ${t}"); t})
      // verify all comparisons are equal
      .forall(t => t._1 == t._2)

    println(s"Tomorrow works? ${tomorrowWorks}")
  }
}