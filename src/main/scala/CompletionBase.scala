class CompletionBase {
  private val CURSOR_SYMBOLS = "@@"
  private val parser = new JavaParser

  def syntaxTreeNode(code: String): Unit = {
    val pos = code indexOf CURSOR_SYMBOLS
    val codeToComplete = code.replace(CURSOR_SYMBOLS, "")


    println("CODE: " + codeToComplete)
    println("POS: " + pos)
    parser.parse(codeToComplete, pos)
  }

}
