enum Piece(name: String, symbol: String):
  case Pawn(firstMove:Boolean) extends Piece(name = "Pawn", symbol = "♙")
  case Knight extends Piece(name = "Knight", symbol = "♘")
  case Bishop extends Piece (name = "Bishop", symbol = "♗")
  case Rook extends Piece (name = "Rook", symbol = "♖")
  case Queen extends Piece  (name = "Queen", symbol = "♕")
  case King extends Piece (name = "King", symbol = "♔")
  case Empty extends Piece("","")
  def getSymbol = symbol
  def getName = name


