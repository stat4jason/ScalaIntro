package recursion

import scala.annotation.tailrec

object ShowInAList {
//  def map[T, U](ts: List[T], op: T => U): List[U] = ts match {
  def map[T, U](ts: List[T])(op: T => U): List[U] = ts match {
    case Nil => Nil
//    case h :: t => op(h) :: map(t :: op)
    case h :: t => op(h) :: map(t)(op)
  }

  @tailrec
  def showAll(ss: List[_]): Unit = ss match {
//  def showAll[T](ss: List[T]): Unit = ss match {
//  def showAll(ss: List[String]): Unit = ss match {
    case Nil => //  produces, and can optionally say: ()
//    case(h, t) // can match in this style, but h and t are SINGLE elements
    // in a TWO element list
    case head :: tail => println("> " + head) ; showAll(tail)
  }

  def main(args: Array[String]): Unit = {
    // colon colon is RIGHT associative
//    val names = Nil.::("Sheila").::("Jim").::("Fred")
    val names: List[String] = "Fred" :: "Jim" :: "Sheila" :: Nil
//    val names = List("Fred", "Jim", "Sheila")
    showAll(names)

    showAll(List(1,2,3,4))

//    showAll(map(names, (x:String) => x.toUpperCase()))
//    showAll(map(names)((x) => x.toUpperCase()))
//    showAll(map(names)(x => x.toUpperCase()))
    showAll(map(names)(_.toUpperCase()))

    val adder: (Int, Int) => Int = _ + _
    println(s"two plus two is ${adder(2, 2)}")

    val subtracter: (Int, Int) => Int = _ - _
    println(s"four minus three is ${subtracter(4, 3)}")

  }
}
