package types

object UseVariables {
  def <<<():Unit = ()

  def weird(x: Int):Unit =
    println(s"you called +++ with ${x}")

  def weird(x: Int, y: Int):Unit =
    println(s"you called +++ with two args ${x} and ${y}")

  def main(args: Array[String]): Unit = {
//    var x: Int = 99;
    var x = 99; // type inferencing

    // String type is double-quote, single implies Char
//    println("The value of x is " + x)
    println(s"The value of x is $x")
    println(s"The value of x is ${x + 10}")
    println(f"The value of Pi is ${math.Pi}%7.5f")

    x = x + 10
    x += 1
//    x++ // these don't exist
      // cannot reassign to different type
//    x = "Hello"

    val two = 2
    val three = 3
//    val five = two.+(three)
    val five = two + three
    println(five)

    // Scala permits object-dot-method-parens-args-close-parens
    // OR object method single-argument
    UseVariables.weird(99)
    UseVariables weird 101

    UseVariables weird (99, 200)
    // "gatling" test tool does this kind of "domain specific language"
    // behavior... it can feel very strange, but it's just
    // Scala's "infix" notation
  }
}
