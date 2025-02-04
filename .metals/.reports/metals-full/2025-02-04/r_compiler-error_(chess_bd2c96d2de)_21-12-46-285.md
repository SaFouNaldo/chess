file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.0
Classpath:
<WORKSPACE>\.scala-build\chess_bd2c96d2de\classes\main [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.0\scala3-library_3-3.3.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\sourcegraph\semanticdb-javac\0.7.4\semanticdb-javac-0.7.4.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE> -release 17


action parameters:
offset: 351
uri: file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
text:
```scala
/**
  * The chess grid is 8x8 cells 
  */

  class ChessGrid {
    private val grid : List[List[Cell]] = init()
    def init(): List[List[Cell]] = {

      val result = initHelper(8)
      def initHelper(line:Int = 8, char:Char = 'a'): List[List[Cell]] = {
        (line, char) match
          case (_,c) => {
            val listOfCells [@@]
          }
          case (0,_) => Nil
      }
      return result
    }
    def display() = {
      print("- - - - - - - - \n")
    }
  }
  class Cell(val line: Int, val column: Char, val piece: Piece){
    def getColor = {
      if (line % 2 == 1 && charToNumber(column) % 2 == 0 ||
          line % 2 == 0 && charToNumber(column) % 2 == 1 ) 
      {
        Color.White
      } else {
        Color.Black
      }
    }
  }
  enum Color:
    case White
    case Black
```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2576)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:96)
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