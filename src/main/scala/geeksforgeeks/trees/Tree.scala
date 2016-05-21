package geeksforgeeks.trees

trait Tree[A] {
  def isEmpty:Boolean
  def getValue:A
}

case class Leaf[A](value:A) extends Tree[A] {
  override def isEmpty:Boolean = true
  override def getValue:A = value
}

case class Node[A](value:A, left:Tree[A], right:Tree[A]) extends Tree[A] {
  override def isEmpty:Boolean = false
  override def getValue:A = value
}


object Tree {

  def apply[A](value:A, left:Tree[A], right:Tree[A]):Tree[A] = new Node[A](value, left, right)

  def apply[A](value:A):Tree[A] = new Leaf[A](value)

  def nodesCount[A](x:Tree[A]):Int = nodesCount(x, 0)

  private def nodesCount[A](x:Tree[A], acc:Int):Int = x match {
    case Leaf(_) => 1
    case Node(_, l, r) => nodesCount(l, acc)+nodesCount(r, acc) + 1
  }
}