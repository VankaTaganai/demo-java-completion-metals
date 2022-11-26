object Main {
  def main(args: Array[String]): Unit = {
    val completionBase = new CompletionBase
    println("Start")
    completionBase.syntaxTreeNode(
      """
        |import java.util.List;
        |
        |class Simple{
        |    public static void main(String args[]){
        |        int abc;
        |        int c = abc;
        |        System.out.pri@@ntln();
        |    }
        |}
        |""".stripMargin)
  }
}
