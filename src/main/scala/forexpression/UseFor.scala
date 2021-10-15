package forexpression

object UseFor {
  def main(args: Array[String]): Unit = {
//    val numbers = 1 to 10 // until stops before the last specified element
    val numbers = (1 to 13).toList
    println(numbers)
    /*val result = */
    (for {
      v <- numbers
      u <- 1 to v
      h = math.sqrt(v * v + u * u)
      if h.toInt == h
    } yield (v, u, h))
      .map(t => s"the triple ${t} is a perfect right angle triangle")
      .foreach(println(_))

//    println(s"v is ${result}")
  }
}
