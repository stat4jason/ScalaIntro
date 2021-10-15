package filereading

import scala.io.Source

import java.util.regex.Pattern

object ReadAFile {
  val wordBoundaries = Pattern.compile("\\W+")
//  wordBoundaries.split(myLine) ... gives us an array of String
  def main(args: Array[String]): Unit = {
    Source.fromFile("text.txt")
      .getLines()
      .map(_.toUpperCase())
      .foreach(println(_))
  }
}
