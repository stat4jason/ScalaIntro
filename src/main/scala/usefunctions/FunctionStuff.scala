package usefunctions

object FunctionStuff {
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
  }
}
