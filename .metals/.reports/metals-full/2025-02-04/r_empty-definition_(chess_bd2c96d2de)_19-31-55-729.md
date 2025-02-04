error id: file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/Pieces/Piece.scala:1
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/Pieces/Piece.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -piece.
	 -piece#
	 -piece().
	 -scala/Predef.piece.
	 -scala/Predef.piece#
	 -scala/Predef.piece().

Document text:

```scala
case object Piece(name: String, symbol: String, isAlive: Boolean = true){
  def eatPiece(piece:Piece): Void = {
     piece.isAlive = false
  }
  case Pawn extends Piece(name = "Pawn", symbol = "♙") 
  case Knight extends Piece(name = "Knight", symbol = "♘")
  case Bishop extends Piece (name = "Bishop", symbol = "♗")
  case Rook extends Piece (name = "Rook", symbol = "♖")
  case Queen extends Piece  (name = "Queen", symbol = "♕")
  case King extends Piece (name = "King", symbol = "♔")
}
  

```

#### Short summary: 

empty definition using pc, found symbol in pc: 