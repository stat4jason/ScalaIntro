package casting

object Example {
  def main(args: Array[String]): Unit = {
    var s: AnyRef = "Hello"
    s = List()
//    s = "Goodbye"
    // instance of test is BAD STYLE in Scala
    val isString: Boolean = s.isInstanceOf[String]
    println(s"s refers to a String? ${isString}")

    // test MUST be a) Boolean and b) in parens
    if (isString) {
      println("It's a String...")
      // this kind of cast is TERRIBLE STYLE in Scala
      val theString = s.asInstanceOf[String]
      println(s"the length of the string is ${theString.length}")
    }
  }
}
