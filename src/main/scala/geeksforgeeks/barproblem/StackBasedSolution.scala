package geeksforgeeks.barproblem

import java.util

object StackBasedSolution {

  def solution(arr:Array[Int]):Int = {
    val stack = new util.Stack[Int]
    var max_square = 0
    var i = 0

    while(i < arr.length) {
      if (stack.isEmpty || arr(stack.peek()) <= arr(i)) {
        stack.push(i)
        i += 1
      } else {
        val top = stack.pop()
        val localMaxArea = arr(top) * (if (stack.isEmpty) i else i - stack.size - 1)

        max_square = Math.max(localMaxArea, max_square)
      }
    }

    while(!stack.isEmpty) {
      println("Top:"+stack.peek())
      println("i:"+i)
      val top = stack.pop()
      println("Size:"+stack.size())
      val localMaxArea = arr(top) * (if (stack.isEmpty) i else i - stack.size - 1)

      max_square = Math.max(localMaxArea, max_square)
    }

    max_square
  }
}
