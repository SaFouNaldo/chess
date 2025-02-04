error id: _empty_/Color.
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol _empty_/Color#
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
/**
  * The chess grid is 8x8 cells 
  */

  class ChessGrid {
    private val grid : List[List[Cell]] = init()
    def init(): List[List[Cell]] = {
      val aux_grid = List.empty
      return aux_grid
    }
    def display() = {
      print("- - - - - - - - \n")
    }
  }
  class Cell(val line: Int, val column: Char, val piece: Piece){
    def getColor = {
      if (line % 2 == 1 && fileToNumber(column) % 2 == 0) {
        Color.White
      } else if (line % 2 == 0 && fileToNumber(column) % 2 == 1) {

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

empty definition using pc, found symbol in pc: 