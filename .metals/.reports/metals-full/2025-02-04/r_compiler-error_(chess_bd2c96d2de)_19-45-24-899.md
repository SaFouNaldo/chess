file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
### java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/Hamid/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10-sources.jar!/scala/collection/immutable/List.scala

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.0
Classpath:
<WORKSPACE>\.scala-build\chess_bd2c96d2de\classes\main [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.0\scala3-library_3-3.3.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\sourcegraph\semanticdb-javac\0.7.4\semanticdb-javac-0.7.4.jar [exists ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE> -release 17


action parameters:
offset: 269
uri: file:///C:/Users/Hamid/Desktop/desk/MyProjects/chess/chess/src/main/logic/ChessGrid.scala
text:
```scala
/**
  * The chess grid is 8x8 squares 
  */

  class ChessGrid {
    private val  gridState : List[List[Piece]] = init()
    def init(): List[List[Piece]] = {
      val aux_grid = List.empty
      return aux_grid
    }
    def display() = {
      gridState m@@
    }
  }
```



#### Error stacktrace:

```
java.base/sun.nio.fs.WindowsPathParser.normalize(WindowsPathParser.java:182)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:153)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:77)
	java.base/sun.nio.fs.WindowsPath.parse(WindowsPath.java:92)
	java.base/sun.nio.fs.WindowsFileSystem.getPath(WindowsFileSystem.java:232)
	java.base/java.nio.file.Path.of(Path.java:147)
	java.base/java.nio.file.Paths.get(Paths.java:69)
	scala.meta.io.AbsolutePath$.apply(AbsolutePath.scala:58)
	scala.meta.internal.metals.MetalsSymbolSearch.$anonfun$definitionSourceToplevels$2(MetalsSymbolSearch.scala:70)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.metals.MetalsSymbolSearch.definitionSourceToplevels(MetalsSymbolSearch.scala:69)
	scala.meta.internal.pc.completions.CaseKeywordCompletion$.sortSubclasses(MatchCaseCompletions.scala:312)
	scala.meta.internal.pc.completions.CaseKeywordCompletion$.matchContribute(MatchCaseCompletions.scala:260)
	scala.meta.internal.pc.completions.Completions.advancedCompletions(Completions.scala:385)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:183)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/Hamid/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10-sources.jar!/scala/collection/immutable/List.scala