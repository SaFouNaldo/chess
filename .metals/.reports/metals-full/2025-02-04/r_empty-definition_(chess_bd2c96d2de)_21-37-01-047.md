error id: _empty_/
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Pieces/Piece.scala
empty definition using pc, found symbol in pc: _empty_/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
object enum Piece(name: String, symbol: String, alive: Boolean = true):
  case  Pawn extends Piece(name = "Pawn", symbol = "♙")
  case Knight extends Piece(name = "Knight", symbol = "♘")
  case Bishop extends Piece (name = "Bishop", symbol = "♗")
  case Rook extends Piece (name = "Rook", symbol = "♖")
  case Queen extends Piece  (name = "Queen", symbol = "♕")
  case King extends Piece (name = "King", symbol = "♔")
  case Empty extends Piece("","", false)
  def getSymbol = name
  def isAlive = alive
  

```

#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/