
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
            val listOfCells = ('a' to 'h').map(char =>
            if (line == 2 || line == 7)
              Cell(line, char, Piece.Pawn)
            else if ((line == 8 || line == 1) ) {
              if ( char == 'a' || char == 'h') Cell(line, char, Piece.Rook)
              else if ( char == 'b' || char == 'g') Cell(line, char, Piece.Knight)
              else if ( char == 'c' || char == 'f') Cell(line, char, Piece.Bishop)
              else if ( char == 'd') Cell(line, char, Piece.Queen)
              else Cell(line, char, Piece.King)
            }
            else Cell(line, char, Piece.Empty)
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
      print("----------------\n")
      foreachCell { cell =>
        if (cell.isEmpty)
          print(cell.getColor + " ")
        else print(cell.piece.getSymbol + " ")
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
    def getColumn = column
    def getLine = line
    def isEmpty = piece.equals(Piece.Empty)
  }
  enum Color(colored_icon:String):
    case White extends Color("■")
    case Black extends Color("□")
    def getIcon() = colored_icon