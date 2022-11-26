import com.sun.source.util.JavacTask

import java.util.ServiceLoader
import javax.tools.JavaCompiler
import scala.jdk.CollectionConverters._

class JavaParser {
  private val COMPILER: JavaCompiler = ServiceLoader.load(classOf[JavaCompiler]).iterator.next

  def parse(code: String, cursor: Int): Unit = {
    val javaFileObject = SourceJavaFileObject.make(code)

    val task: JavacTask = COMPILER.getTask(
      null,
      null,
      null,
      null,
      null,
      List(javaFileObject).asJava
    ).asInstanceOf[JavacTask]

    val elems = task.parse()
    task.analyze()
    val root = elems.iterator().next()

    val curNode = new JavaTreeScanner(task, root).scan(root, cursor)
    val nodeType = new TypeAnalyzer(task).hoverType(curNode)

    println("kind: " + curNode.getLeaf.getKind)
    println("type: " + nodeType)
  }
}
