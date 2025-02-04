error id: _empty_/Utils$package.fileToNumber.
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
empty definition using pc, found symbol in pc: _empty_/Utils$package.fileToNumber.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -fileToNumber.
	 -fileToNumber#
	 -fileToNumber().
	 -scala/Predef.fileToNumber.
	 -scala/Predef.fileToNumber#
	 -scala/Predef.fileToNumber().

Document text:

```scala
/**
  * The chess grid is 8x8 cells 
  */

  class ChessGrid {
    private val grid : List[List[Cell]] = init()
    def init(): List[List[Cell]] = {

      initHelper(8)
      def initHelper(line:Int, char:Char = 'a') = {
        (line, char) match
          case (_,c) => Cell(line, 'a', Piece.Empty) :: initHelper(line, charToNumber)
      }
    }
    def display() = {
      print("- - - - - - - - \n")
    }
  }
  class Cell(val line: Int, val column: Char, val piece: Piece){
    def getColor = {
      if (line % 2 == 1 && charToNumber(column) % 2 == 0 ||
          line % 2 == 0 && fileToNumber(column) % 2 == 1 ) 
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

#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Utils$package.fileToNumber.