import com.sun.source.util.{JavacTask, TreePath, Trees}

class TypeAnalyzer(task: JavacTask) {
  def hoverType(path: TreePath): String = {
    val typeMirror = Trees.instance(task).getTypeMirror(path)

    typeMirror.getKind.toString
  }
}
