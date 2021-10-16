package lab7

import java.util.regex.Pattern
import scala.io.Source

object Concordance {
  val WORD_BOUNDARY = Pattern.compile("\\W+")
  val descendingCountOrder: Ordering[(String, Int)] =
    (t1, t2) => t2._2 - t1._2

  def main(args: Array[String]): Unit = {
    // files that are opened should be closed reliably.
    // Scala 2.13 gets a "using" feature that's like Python's with,
    // or Java's try-with-resources. Prior to that, various hacks
    // exist, this one is crude, but basically workable. Ugly, since
    // it requires the use of a var rather than a val, of course!
    var dataSource: Source = null;
    try {
      // open the file
      dataSource = Source.fromFile("PrideAndPrejudice.txt")
      dataSource
        // extract a "stream" of the lines
        .getLines()
        // split along word boundaries
        .flatMap(WORD_BOUNDARY.split(_))
        // the flatmap operation doesn't create a very
        // helpful data type. We need to get to something
        // that supports the groupBy operation. Traversable
        // does that (so does List, which you were more likely
        // to discover)
        .toTraversable
        // the split produces some empty strings, which
        // are not interesting
        .filter(!_.isBlank)
        // The and the should be considered as the same word
        // so standardize on lower case
        .map(_.toLowerCase())
        // group data into a Map, using the word itself as
        // the key. This creates a List[String] in the value
        // part of the map. Every word is just repeated a
        // bunch of times.
        .groupBy(w => w)
        // now iterate over the contents of the map. This gives
        // tuples with the key and the value as _1 and _2
        // change the value part from a list to the count
        // of how many times the word was found (that is,
        // the size of the list)
        .map(e => (e._1, e._2.size))
        // make this into an actual list, so we can sort it
        // note, my lab suggestion did not include sorting
        // but it's prettier that way!
        .toList
        // sort it into descending order of the counts
        // see the lambda declared above
        .sorted(descendingCountOrder)
        // Let's just show the most frequent 200 words
        // (also not part of the original instructions)
        .take(200)
        // format the data into a pretty string
        // (this could be done in the print, but I prefer
        // to separate logic, and presentation layoug is a
        // different "concern" from where we do that
        // presentation (e.g. we might want to send this
        // over a network instead.)
        .map(t => f"${t._1}%20s : ${t._2}")
        // print the formatted results
        .foreach(t => println(t))
    } finally {
      if (dataSource != null) {
        println("closing the file")
        dataSource.close()
      }
    }
  }
}
