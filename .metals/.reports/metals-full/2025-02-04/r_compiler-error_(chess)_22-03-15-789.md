file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.0
Classpath:
<WORKSPACE>\.bloop\chess\bloop-bsp-clients-classes\classes-Metals-2k_EBJvrThybahvNh6v0fg== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.10.3\semanticdb-javac-0.10.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\sourcegraph\semanticdb-javac\0.10.3\semanticdb-javac-0.10.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.0\scala3-library_3-3.3.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 717
uri: file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
text:
```scala
import Utils.foreachCell
/**
  * The chess grid is 8x8 cells 
  */

  class ChessGrid {
    val grid : List[List[Cell]] = init()
    def foreachCell(f: Cell => Unit): Unit = {
      grid.foreach(_.foreach(f))
    }
    def init(): List[List[Cell]] = {
      def initHelper(line:Int = 8): List[List[Cell]] = {
        line match
          case 0 => Nil
          case _ => {
            val listOfCells = ('a' to 'h').map(char => Cell(line, char, Piece.Empty)).toList
            listOfCells :: initHelper(line - 1)
          }
      }
      def addPawns(grid : List[List[Cell]]) = List[List[Cell]]{
        foreachCell {
          cell => {
            cell match
              case Cell(7, _, @@)
            
          }
        }
      }
      val result = initHelper(8)

      return result
    }
    def display() = {
      print("----------------\n")
      foreachCell { cell =>
        print(cell.getColor + " ")
        if (cell.column == 'h') println()
    }
      print("----------------\n")
    }

  }
  class Cell(val line: Int, val column: Char, val piece: Piece){
    def getColor = {
      if (line % 2 == 1 && Utils.charToNumber(column) % 2 == 0 ||
          line % 2 == 0 && Utils.charToNumber(column) % 2 == 1 ) 
      {
        Color.White.getIcon()
      } else {
        Color.Black.getIcon()
      }
    }
  }
  enum Color(colored_icon:String):
    case White extends Color("■")
    case Black extends Color("□")
    def getIcon() = colored_icon
```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2576)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:92)
	scala.meta.internal.pc.SignatureHelpProvider$.$anonfun$1(SignatureHelpProvider.scala:48)
	scala.collection.StrictOptimizedLinearSeqOps.loop$3(LinearSeq.scala:280)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile(LinearSeq.scala:282)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile$(LinearSeq.scala:278)
	scala.collection.immutable.List.dropWhile(List.scala:79)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:48)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:398)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner