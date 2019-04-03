import scala.io.Source
import edu.holycross.shot.cite._



val filepath:String = "/vagrant/CSC_SpringFU/Genesis.txt"

val myBook:Vector[String] = Source.fromFile(filepath).getLines.toVector.filter( _.size > 0 )


/* How to (a) remove punctuation, and (b) tokenize by word in a short chunk */
val myTokenizedLines:Vector[Vector[String]] = myBook.map( aLine => {
  val noPunc:String = aLine.replaceAll("""[,.?;":!)(]""",""  ).replaceAll(" +"," ")
  val wordVec:Vector[String] = noPunc.split(" ").toVector
  wordVec
})


/*  "flatten" a list of lists into just a list */
val v:Vector[Int] = Vector(1,2,3,4,5)
val vv:Vector[Vector[Int]] = Vector(Vector(1,2,3), Vector(4,5))
val didItFlatten:Boolean = v == vv.flatten


val newVec:Vector[Int] = Vector(1,2,3,4,1,2,3,1,2,3,2,3,4,4,1,2)
val mySlided:Vector[Vector[Int]] = newVec.sliding(3,1).toVector
val grouped:Map[Vector[Int],Vector[Vector[Int]]] = mySlided.groupBy(i => i)
val intoAVector:Vector[(Vector[Int], Vector[Vector[Int]])] = grouped.toVector

val madeVec = intoAVector

