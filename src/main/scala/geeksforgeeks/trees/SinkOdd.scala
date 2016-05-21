package geeksforgeeks.trees

import scala.collection.mutable
import scala.reflect.ClassTag

object SinkOdd {
    def sinkOdd(x: Tree[Int])(implicit m: ClassTag[Int]):Array[Int] = {
      val array = createArray(x)
      var i:Int = array.length - 1

      while(i >= 0) {
        val v = array(i)

        if (v % 2 == 0) {
          val k = (i - 1) / 2
          swap(array, i, k)
        }

        i -= 1
      }

      array
    }

  def swap[A](arr:Array[A], i:Int, j:Int):Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  def createArray[A](x: Tree[A])(implicit m: ClassTag[A]): Array[A] = {
    val nodesAmount = Tree.nodesCount(x)
    val array: Array[A] = new Array[A](nodesAmount)
    val queue = new mutable.Queue[Tree[A]]()
    var i = 0

    queue.enqueue(x)

    while (!queue.isEmpty) {
      val tree = queue.dequeue()

      array(i) = tree match {
        case Node(value, l, r) => {
          queue.enqueue(l)
          queue.enqueue(r)
          value
        }
        case Leaf(value) => value
      }
      i += 1
    }

    array
  }
}
