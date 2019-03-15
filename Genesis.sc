mport scala.io.Source
import edu.holycross.shot.cite._



val filepath:String = "/vagrant/CSC_SpringFU/Genesis.txt"
// Get the file as a vector of lines, ignoring empty lines
val myBook:Vector[String] = Source.fromFile(filepath).getLines.toVector.filter( _.size > 0 )


/* How to (a) remove punctuation, and (b) tokenize by word in a short chunk */
val myTokenizedLines:Vector[Vector[String]] = myBook.map( aLine => {
  val noPunc:String = aLine.replaceAll("""[,.?;":!)(]""",""  ).replaceAll(" +"," ")
  val wordVec:Vector[String] = noPunc.split(" ").toVector
  wordVec
})
