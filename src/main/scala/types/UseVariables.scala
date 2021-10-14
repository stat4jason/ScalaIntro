package types

object UseVariables {
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
  }
}
