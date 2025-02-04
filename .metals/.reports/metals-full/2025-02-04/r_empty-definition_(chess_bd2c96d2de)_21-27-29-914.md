error id: 
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
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
      def initHelper(line:Int = 8): List[List[Cell]] = {
        line match
          case 0 => Nil
          case _ => {
            val listOfCells = {
              for char <- ('a' to 'h')
              yield Cell(line, char, Piece.Empty)
            }.toList
            listOfCells :: initHelper(line - 1)
          }
      }
      val result = initHelper(8)
      return result
    }
    def display() = {
      print("- - - - - - - - \n")
      grid.foreach(list => {
        list.foreach(cell => {
          print(cell.getColor + " ")
          if(cell.column == 'h') {
            print("\n")
          }
        })
      })
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

empty definition using pc, found symbol in pc: 