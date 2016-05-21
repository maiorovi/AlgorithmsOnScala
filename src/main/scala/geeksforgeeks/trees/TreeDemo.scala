package geeksforgeeks.trees

object TreeDemo extends App {

  println(Tree.nodesCount(Tree(5,
    Tree(6, Tree(7), Tree(8)),
    Tree(9, Tree(10), Tree(11)))))

  println(SinkOdd.createArray(Tree(5,
    Tree(6, Tree(7), Tree(8)),
    Tree(9, Tree(10), Tree(11)))).mkString(", "))

  println(SinkOdd.sinkOdd(Tree(5,
    Tree(6, Tree(7), Tree(8)),
    Tree(9, Tree(10), Tree(11)))).mkString(", "))

}
