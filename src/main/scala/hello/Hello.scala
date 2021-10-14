package hello { // package "should" map to directory

  // the "object" declaration makes a singleton--
  // the class (type) of this is unknown--we don't care
  // we put "static-like" things in it
  /*public */ // public is NOT a keyword in Scala, default
  // accessibility IS public
  object Hello { // "sensible" to map primary type name to filename
    def main(args: Array[String]): Unit = {
      println("Hello Scala World!") // default is no semicolons
      println("two statements")
    }
  }
}

/*
Scala 3 uses indentation, rather than curlies
object Hello:
  println...
  println...

like Python, indentation controls blocks
 */

/*
if sum is a pure function (adds two things together)
sum(1, 2) = 1 + 2 = 3
 */