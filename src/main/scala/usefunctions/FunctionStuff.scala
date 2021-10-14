package usefunctions

object FunctionStuff {
  def manyArgs(day: Int = 1, month: Int, year: Int = 2022): Unit = {
    println(s"day is ${day}, month is ${month}, year is ${year}")
  }

  def moreArgs(s: String, ss: String *): Unit = {
    println(s"first is ${s}")
    println(s"type of vararg is ${ss.getClass}")
    val args = ss.toIterator
    while (args.hasNext) {
      println(s"> ${args.next()}");
    }
  }

  def apply(x: Int): Int = {
    println(s"executing FunctionStuff.apply(${x})")
    x * 2
  }

  def addOne(x: Int): Int = {
    println("Calculating.....")
    x + 1 // return keyword exists, but is rarely needed/used
  }

  def main(args: Array[String]): Unit = {
    val number = {
      println("calculating a number")
//      val n = (math.random() * 1000).asInstanceOf[Int]
      val n = (math.random() * 1000).toInt
      println(s"calculated the number ${n}")
      n
    }

    println(s"number has value ${number}")

//    println(s"apply(3) gives ${FunctionStuff.apply(3)}")
    println(s"apply(3) gives ${FunctionStuff(3)}")

    manyArgs(1, 2, 2022)
    manyArgs(month = 2, day = 1, year = 2022)
    manyArgs(month = 2, day = 1)
    manyArgs(month = 2)

    moreArgs("Fred", "Jim", "Sheila")
    val names = List("Jim", "Sheila")
    moreArgs("Fred", names:_*)
  }
}
