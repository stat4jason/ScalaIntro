package inheritance

//class Animal(nLegs: Int) {
//  val legCount = nLegs
// in case class the "val" is implicit, in regular class
// it's not a field unless we say so
// var makes a mutable field (can declare a field inside the
// class too, of course
class Animal protected /*private */
  (val legCount: Int/* = 4*/, var foodLevel: Int/* = 100*/) {
  // auxiliary constructors need differing arguments from canonical:
 /* private */def this(quaduped: Boolean) = {
    this(if (quaduped) 4 else 0, 99)
    println("Created from auxiliary constructor")
  }

  def this(s:String) = this(true)

  def makeNoise: String = "Grrr"

  override def toString: String = s"I'm an animal that says ${makeNoise}"
  //  println(s"Creating an animal with ${nLegs}")
  println(s"Creating an animal with ${legCount}")
}

object Animal {
  def apply(legCount: Int = 4, foodLevel: Int = 100): Animal = {
    println("Running factory for Animal")
    new Animal(legCount, foodLevel)
  }
}

// extends declares my parent type, parens pick up the
// constructor arguments for that parent type
// class Cat(color: String) extends Animal(4, 50)
// delegation to superclass constructor ONLY happens here
// BUT, the target constructor in the parent is up to us
// and can be any of the canonical or auxiliary constructors
class Cat(val color: String) extends Animal(true) {
  override def toString: String = "I'm a cat, you can worship me, human!"
}


object RegularClasses {
  def main(args: Array[String]): Unit = {
    //    val a = new Animal(4, 80)
    //    val a = new Animal
    val a = Animal()/*.apply()*/
    println(s"The animal is ${a}")
    val b = new Animal(false)
    println(s"${b}")
    // private constructor, can't do that
//    val c = new Animal(4, 100)

    val d: Animal = new Cat("tabby")
    println(s"cat is: ${d}")
  }
}
