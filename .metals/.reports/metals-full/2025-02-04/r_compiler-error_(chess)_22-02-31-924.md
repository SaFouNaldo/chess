file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
### java.lang.AssertionError: assertion failed: NoType

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.0
Classpath:
<WORKSPACE>\.bloop\chess\bloop-bsp-clients-classes\classes-Metals-2k_EBJvrThybahvNh6v0fg== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.10.3\semanticdb-javac-0.10.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\sourcegraph\semanticdb-javac\0.10.3\semanticdb-javac-0.10.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.0\scala3-library_3-3.3.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 653
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
          c@@
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
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.core.Types$TypeBounds.<init>(Types.scala:5097)
	dotty.tools.dotc.core.Types$AliasingBounds.<init>(Types.scala:5176)
	dotty.tools.dotc.core.Types$TypeAlias.<init>(Types.scala:5198)
	dotty.tools.dotc.core.Types$TypeAlias$.apply(Types.scala:5231)
	dotty.tools.dotc.core.Types$Type.bounds(Types.scala:1729)
	scala.meta.internal.pc.completions.CaseKeywordCompletion$.contribute(MatchCaseCompletions.scala:156)
	scala.meta.internal.pc.completions.Completions.advancedCompletions(Completions.scala:443)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:183)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: NoType