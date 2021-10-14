package exceptions

import java.sql.SQLException

object Example {
  @throws[SQLException] // only for interoperability with Java
  def divider(x: Int, y: Int): Int = {
    if (y == 0) throw new SQLException("can't divide by zero")
    return x / y
  }

  def main(args: Array[String]): Unit = {
    try {
      val res = divider(4, 0)
      println(res)
    } catch {
      case sqe: SQLException =>
        println(s"That broke with an SQLException ${sqe}")
      case iae: IllegalArgumentException =>
        println(s"Illegal ARg... ${iae}")
      case _ => println("don't know what the heck happened")
    }
  }
}
