error id: scala/
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/ChessGame.scala
empty definition using pc, found symbol in pc: scala/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
import GameState._

object  ChessGame {
    val grid = new ChessGrid()   
    val whitePlayer = new Player("userId1", Color.White)
    val blackPlayer = new Player("userId2", Color.Black)
    var currentTurn = whitePlayer   
    var gameState: GameState = GameState.Start

    def main(args: Array[String]): Unit = {
        gameState = GameState.Ongoing
        grid.display() 
        
        while (!isGameOver(gameState)) {
            gameState = updateGame(gameState)
        }
        println("Game Over! Final State: " + gameState.toString())
    }

    def updateGame(state: GameState): GameState = {
        state match {
            case Start => 
                grid.display()
                GameState.Ongoing
            
            case Ongoing => 
                println(s"${currentTurn.color} Turn... Enter your move (e.g., e2 e4): ")
                val move = scala.io.StdIn.readLine()
                
                if (processMove(move)) {
                    switchTurn()
                }
                grid.display()
                checkGameState()
            
            case _ => 
                println("The game has finished. Final state: " + state.toString())
                GameState.Finished
        }
    }

    def processMove(move: String): Boolean = {
        val parts = move.split(" ")
        if (parts.length != 2) return false
        val (from, to) = (parts(0), parts(1))

        // Assume grid.movePiece() handles move validation
        grid.movePiece(from, to)
    }

    // Function to switch the player's turn
    def switchTurn(): Unit = {
        currentTurn = if (currentTurn == whitePlayer) blackPlayer else whitePlayer
    }

    // Function to check if the game should end
    def checkGameState(): GameState = {
        GameState.Ongoing
        /**
        if (grid.isCheckmate(currentTurn.color)) {
            println(s"Checkmate! ${currentTurn.color} loses.")
            GameState.Checkmate
        } else if (grid.isStalemate(currentTurn.color)) {
            println("Stalemate! It's a draw.")
            GameState.Stalemate
        } else {
            GameState.Ongoing
        }
            **/
    }
}
sealed trait GameState

object GameState {
  case object Start extends GameState        // Game just started
  case object Ongoing extends GameState      // Normal gameplay
  case object Stalemate extends GameState    // No legal moves, but not in check
  case object Checkmate extends GameState    // One player is checkmated
  case object Draw extends GameState         // Threefold repetition, 50-move rule, etc.
  case object Finished extends GameState     // The game has ended (by resignation, timeout, etc.)

  def isGameOver(state: GameState): Boolean = state match {
    case Checkmate | Stalemate | Draw | Finished => true
    case _ => false
  }
}
class Player(val userId: String, val color: Color)


```

#### Short summary: 

empty definition using pc, found symbol in pc: scala/