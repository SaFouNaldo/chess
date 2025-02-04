error id: foreach.
file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/scala/Utils/Utils.scala
empty definition using pc, found symbol in pc: foreach.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -grid/grid/foreach.
	 -grid/grid/foreach#
	 -grid/grid/foreach().
	 -scala/Predef.grid.grid.foreach.
	 -scala/Predef.grid.grid.foreach#
	 -scala/Predef.grid.grid.foreach().

Document text:

```scala
object Utils {
    val charToNumber = ('a' to 'h').map(c => c -> (c - 'a' + 1)).toMap
      extension (grid: ChessGrid)
    def foreachCell(f: Cell => Unit): Unit =
      grid.grid.foreach(_.foreach(f))
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: foreach.