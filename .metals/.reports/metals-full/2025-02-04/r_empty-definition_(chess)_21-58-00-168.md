error id: _empty_/Utils$package.charToNumber.
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Logic/ChessGrid.scala
empty definition using pc, found symbol in pc: _empty_/Utils$package.charToNumber.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -charToNumber.
	 -charToNumber#
	 -charToNumber().
	 -scala/Predef.charToNumber.
	 -scala/Predef.charToNumber#
	 -scala/Predef.charToNumber().

Document text:

```scala
import Utils.foreachCell
/**
  * The chess grid is 8x8 cells 
  */

  class ChessGrid {
    val grid : List[List[Cell]] = init()
    def init(): List[List[Cell]] = {
      def initHelper(line:Int = 8): List[List[Cell]] = {
        line match
          case 0 => Nil
          case _ => {
            val listOfCells = ('a' to 'h').map(char => Cell(line, char, Piece.Empty)).toList
            listOfCells :: initHelper(line - 1)
          }
      }
      def addPawns(grid : List[List[Cell]]) = List[List[Cell]] {
        grid.foreach(list => {
          list.foreach()
        })
      }
      val result = initHelper(8)

      return result
    }
    def display() = {
      print("----------------\n")
      this.foreachCell { cell =>
        print(cell.getColor + " ")
        if (cell.column == 'h') println()
    }
      print("----------------\n")
    }

  }
  class Cell(val line: Int, val column: Char, val piece: Piece){
    def getColor = {
      if (line % 2 == 1 && charToNumber(column) % 2 == 0 ||
          line % 2 == 0 && charToNumber(column) % 2 == 1 ) 
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

#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Utils$package.charToNumber.