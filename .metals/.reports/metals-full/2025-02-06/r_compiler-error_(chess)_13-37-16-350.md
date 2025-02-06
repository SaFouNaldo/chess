file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.0
Classpath:
<WORKSPACE>\.bloop\chess\bloop-bsp-clients-classes\classes-Metals-dYu4uWJQQta4H7_66z-L8A== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.10.3\semanticdb-javac-0.10.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.0\scala3-library_3-3.3.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE>


action parameters:
offset: 2826
uri: file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
text:
```scala
import Utils.charToNumber
import Piece.* 
/**
  * The chess grid is 8x8 cells 
  */

  class ChessGrid {
    var grid : List[List[Cell]] = init()
    def foreachCell(f: Cell => Unit): Unit = {
      grid.foreach(_.foreach(f))
    }
    def init(): List[List[Cell]] = {
      def initHelper(line:Int = 8): List[List[Cell]] = {
        line match
          case 0 => Nil
          case _ => {
            val listOfCells = ('a' to 'h').map(char =>
            if (line == 2 || line == 7)
              Cell(line, char, Piece.Pawn(true), PieceColor.White)
            else if ((line == 8 || line == 1) ) {
              if ( char == 'a' || char == 'h') Cell(line, char, Piece.Rook, PieceColor.White)
              else if ( char == 'b' || char == 'g') Cell(line, char, Piece.Knight, PieceColor.White)
              else if ( char == 'c' || char == 'f') Cell(line, char, Piece.Bishop, PieceColor.White)
              else if ( char == 'd') Cell(line, char, Piece.Queen, PieceColor.White)
              else Cell(line, char, Piece.King, PieceColor.White)
            }
            else Cell(line, char, Piece.Empty, PieceColor.White)
            ).toList
            listOfCells :: initHelper(line - 1)
    }
      }
      val result = initHelper(8)
      return result
    }
    def startChessGame() = {
      display()
    }
    def display() = {
      print("----------------\na b c d e f g h\n")
      foreachCell { cell =>
        if (cell.isEmpty)
          print(cell.getColor + " ")
        else print(cell.piece.getSymbol + " ")
        if (cell.column == 'h') println()
    }
      print("----------------\na b c d e f g h\n")
    }

    def movePiece(from: String, to:String): Boolean = {
      if (from.length != 2 || to.length != 2) {
        println("The piece selected as a string should be of length 2 ")
        return false
      }
      val (fromRow, fromCol) = (8 - from(1).asDigit, from(0))
      val (toRow, toCol) = (8 - to(1).asDigit, to(0))
            if (fromRow <= 0 || fromRow >= 9 ||
          toRow <= 0 || toRow >= 9 || 
          !charToNumber.contains(fromCol) || !charToNumber.contains(toCol) ) {
            println("Out of bound, only values from 1 to 8 and a to h are permissible! ")
            return false
      }
      else {
            val fromCell = grid(fromRow).find(_.column == fromCol).get
            val toCell = grid(toRow).find(_.column == toCol).get
            if (fromCell.isEmpty) {
              println("Please select a piece !")
              false
            }
            else if (toCell.isEmpty){
              fromCell.piece match {
                case Pawn(true) => {
                  // Forward 2 if first move
                  if (fromCell.)
                }
                case Pawn(@@) => 
                case Knight =>{}
                case Bishop =>{}
                case Rook =>{}
                case Queen =>{}
                case King =>{}
                case Empty => {}
              }
                grid = grid.updated(fromRow, grid(fromRow).updated(charToNumber(fromCol) - 1, Cell(fromRow, fromCol, Piece.Empty, PieceColor.White)))
                grid = grid.updated(toRow, grid(toRow).updated(charToNumber(toCol) - 1, Cell(toRow, toCol, fromCell.piece,PieceColor.White )))
                println("updated ! ")
                true
            } else {
              println("The Cell is not empty! ")
              false
            }
      }
    }
  }
    def isValidMove(from: Cell, to: Cell): Boolean = {
    from.piece match {
      case Pawn(true) => Math.abs(from.line - to.line) == 1 && from.column == to.column
      case Rook => from.line == to.line || from.column == to.column
      case Knight =>
        val rowDiff = Math.abs(from.line - to.line)
        val colDiff = Math.abs(charToNumber(from.column) - charToNumber(to.column))
        (rowDiff, colDiff) == (2, 1) || (rowDiff, colDiff) == (1, 2)
      case Bishop =>
        Math.abs(from.line - to.line) == Math.abs(charToNumber(from.column) - charToNumber(to.column))
      case Queen =>
        from.line == to.line || from.column == to.column ||
          Math.abs(from.line - to.line) == Math.abs(charToNumber(from.column) - charToNumber(to.column))
      case King =>
        Math.abs(from.line - to.line) <= 1 && Math.abs(charToNumber(from.column) - charToNumber(to.column)) <= 1
      case _ => false
    }
  }
  class Cell(val line: Int, val column: Char, val piece: Piece, val pieceColor: PieceColor){
    def getColor = {
      if (line % 2 == 1 && Utils.charToNumber(column) % 2 == 0 ||
          line % 2 == 0 && Utils.charToNumber(column) % 2 == 1 ) 
      {
        Color.White.getIcon()
      } else {
        Color.Black.getIcon()
      }
    }
    def getColumn = column
    def getLine = line
    def isEmpty = piece.equals(Piece.Empty)
  }
  enum Color(colored_icon:String):
    case White extends Color("■")
    case Black extends Color("□")
    def getIcon() = colored_icon
  enum PieceColor :
    case Black 
    case White
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