package useimplicits

object FrenchValues {
  implicit val message = "Bonjour"
}
object GermanValues {
  implicit val message = "Guten Tag"
}

object Example1 {
//  def showMessage(m: String = "Bonjour"): Unit =
  def showMessage(implicit m: String): Unit =
    println(s"Message is ${m}")

  def main(args: Array[String]): Unit = {
    showMessage("Hello!")

    {
//      implicit val bananaSplit: String = "Guten tag"
      import FrenchValues._
      showMessage
    }

    {
//      implicit val xxx = "What next"
      import GermanValues._

      showMessage("ni hao")
    }

    val numbers = List(1, 9, 3, 8, 4, 2, 6, 7)
    val inOrder = numbers.sorted
    println(s"numbers=${numbers}, sorted=${inOrder}")

  }
}
