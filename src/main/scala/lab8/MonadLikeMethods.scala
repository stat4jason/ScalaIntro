package lab8

import scala.annotation.tailrec

object MonadLikeMethods {
  // map was already in the examples
//  def map[T, U](ts: List[T])(op: T => U): List[U] = ts match {
//    case Nil => Nil
//    case h :: t => op(h) :: map(t)(op)
//  }

  // one approach to create a tail-recursive version of map is to use
  // an "accumulator" approach. This collects in reverse order, but
  // fits the requirement for tail recursion.
  // then we need to swap the order again. Hence, the accumulating
  // "reverse" method is also needed :)
  // note that defining a function inside a function is fine, though it's
  // not strictly necessary to make these functions work
  def reverse[T](ts: List[T]): List[T] = {
    @tailrec
    def accumulator(ats: List[T], acc:List[T]): List[T] = ats match {
      case Nil => acc
      case h :: t => accumulator(t, h :: acc)
    }
    accumulator(ts, Nil)
  }

  def map[T, U](ts: List[T])(op: T => U): List[U] = {
    @tailrec
    def accumulatingMapper(ats: List[T], acc:List[U]): List[U] = ats match {
      case Nil => acc
      case h :: t => accumulatingMapper(t, op(h) :: acc)
    }
    reverse(accumulatingMapper(ts, Nil))
  }

  // note this is NOT tail recursive...
  def filter[T](ts: List[T])(op: T => Boolean): List[T] = ts match {
    case Nil => Nil
    case h :: t => if (op(h)) h :: filter(t)(op) else filter(t)(op)
  }

  @tailrec
  def foreach[T](ts: List[T])(op: T => Unit): Unit = ts match {
    case Nil => Nil
    case h :: t => op(h) ; foreach(t)(op)
  }

  // also NOT tail recursive!
  def flatmap[T, U](ts: List[T])(op: T => List[U]): List[U] = ts match {
    case Nil => Nil
    // this ++ operation is really inefficient on immutable lists,
    // but it serves to illustrate the concept :)
    case h :: t => op(h) ++ flatmap(t)(op)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila")
    println(reverse(names))
    println(map(names)(_.toUpperCase()))
    println(filter(names)(_.length > 3))
    foreach(names)(x => println("> " + x))
    println(flatmap(names)(_.toCharArray.toList))
  }
}
