package usetuplesandclasses

object Tuple {
  def main(args: Array[String]): Unit = {
    val date = (2, 9, 2021)
    println(s"the day is ${date._1} month is ${date._2}")
    println(s"the day is ${date.productElement(0)} " +
      s"month is ${date.productElement(1)}")
  }
}
