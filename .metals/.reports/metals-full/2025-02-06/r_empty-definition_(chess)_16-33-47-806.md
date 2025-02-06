error id: column.
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
empty definition using pc, found symbol in pc: column.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -Piece.fromCell.column.
	 -Piece.fromCell.column#
	 -Piece.fromCell.column().
	 -fromCell/column.
	 -fromCell/column#
	 -fromCell/column().
	 -scala/Predef.fromCell.column.
	 -scala/Predef.fromCell.column#
	 -scala/Predef.fromCell.column().

Document text:

```scala
import Utils.charToNumber
import Piece.* 
import Utils.numberToChar
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

    def movePiece(from: String, to: String): Boolean = {
    if (from.length != 2 || to.length != 2) {
      println("The piece selected as a string should be of length 2")
      return false
  }

    val fromRow = 8 - from(1).asDigit  // Converts chess notation row (1-8) to grid index (0-7)
    val toRow = 8 - to(1).asDigit
    val fromCol = charToNumber(from(0)) - 1  // Converts chess column ('a' to 'h') to grid index (0-7)
    val toCol = charToNumber(to(0)) - 1

  // Debug prints to check correct values
    println(s"Converted positions -> fromRow: $fromRow, fromCol: $fromCol | toRow: $toRow, toCol: $toCol")

    if (fromRow < 0 || fromRow > 7 || toRow < 0 || toRow > 7 || 
        fromCol < 0 || fromCol > 7 || toCol < 0 || toCol > 7) {
      println("Out of bound, only values from 1 to 8 and a to h are permissible!")
      return false
    }

    val fromCell = grid(fromRow)(fromCol)
    val toCell = grid(toRow)(toCol)

  // Debug prints after getting actual cells
    println(s"From Cell: [${fromCell.line}, ${fromCell.column}] -> Piece: ${fromCell.piece}")
    println(s"To Cell: [${toCell.line}, ${toCell.column}] -> Piece: ${toCell.piece}")

    if (fromCell.isEmpty) {
      println("Please select a piece!")
      return false
    }

    if (!isValidMove(fromCell, toCell)) {
      println("Invalid move for this piece!")
      return false
    }

    if (!toCell.isEmpty && toCell.pieceColor == fromCell.pieceColor) {
      println("The destination cell is occupied!")
      return false
    }

    // Update grid
    grid = grid.updated(fromRow, grid(fromRow).updated(fromCol, Cell(fromRow + 1, numberToChar(fromCol + 1), Piece.Empty, PieceColor.White)))
     grid = grid.updated(toRow, grid(toRow).updated(toCol, Cell(toRow + 1, numberToChar(toCol + 1), fromCell.piece, fromCell.pieceColor)))

    println("Move successful!")
    return true
    }

  }
    def isValidMove(from: Cell, to: Cell): Boolean = {
    from.piece match {
      case Pawn(firstMove) =>
          // Debug prints after getting actual cells
          println(s"From Cell: [${fromCell.line}, ${fromCell.column}] -> Piece: ${fromCell.piece}")
          println(s"To Cell: [${toCell.line}, ${toCell.column}] -> Piece: ${toCell.piece}")
        // Forward 2 if first time moving
        if ((from.column == to.column && Math.abs((from.line - to.line)) == 2 && firstMove) ||
         (from.column == to.column && Math.abs((from.line - to.line)) == 1)) {
          println("The Pawn is in a valid move !")
          true
         } else {
          println("The pawn should move forward with one cell or two cells if first move !")
          false
         }
      case Rook => if (from.line == to.line || from.column == to.column) {
        println("The Rook  is in a valid move ! from line = " + from.line + " to line = " + to.line + " and from column = " + from.column + " to column = " + to.column)
        true
      } else {
        println("The Rook should move in lines or columns and cannot jump over pieces ! from line = " + from.line + " to line = " + to.line + " and from column = " + from.column + " to column = " + to.column)
         false
      }
      case Knight =>
        val rowDiff = Math.abs(from.line - to.line)
        val colDiff = Math.abs(charToNumber(from.column) - charToNumber(to.column))
        if ((rowDiff, colDiff) == (2, 1) || (rowDiff, colDiff) == (1, 2)) {
          println("The Knight is in a valid move ! ")
          true
        } else {
          println("Thee knight should move in a L shape ! ")
          false
        } 
      case Bishop =>
        if (Math.abs(from.line - to.line) == Math.abs(charToNumber(from.column) - charToNumber(to.column))) {
          println("The Bishop is in a valid move !") 
          true
        } else {
          println("The Bishop should move diagonaly with the same cccolor as it's first position !")
          false
        }
      case Queen => if (from.line == to.line || from.column == to.column ||
          Math.abs(from.line - to.line) == Math.abs(charToNumber(from.column) - charToNumber(to.column))) {
            println("The Queen is in a valid move !")
            true
      } else {
        println("The Queen can move in all direcction except L shapes and cannot jump over pieces ! ")
        false
      }
      case King => if (Math.abs(from.line - to.line) <= 1 && Math.abs(charToNumber(from.column) - charToNumber(to.column)) <= 1) {
        println("The King is in a valid move!")
        true
      } else {
        println("The King can move in All direction but with size of 1 !")
        false
      }
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

#### Short summary: 

empty definition using pc, found symbol in pc: column.