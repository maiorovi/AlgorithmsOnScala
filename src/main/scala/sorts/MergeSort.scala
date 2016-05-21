package sorts

object MergeSort{
  def sort(xs:List[Int]):List[Int] = {
    if (xs.size == 1) {
      xs
    } else {
      val (left, right) = xs.splitAt(xs.size / 2)
      def merge(left:List[Int], right:List[Int]):List[Int] = (left,right) match {
        case (Nil, Nil) => Nil
        case (Nil, x::xs) => x::merge(left,xs)
        case (x::xs, Nil) => x::merge(xs,right)
        case (x::xs, y::ys) => if (x < y) x::merge(xs, y::ys) else y::merge(x::xs,ys)
      }

      merge(sort(left), sort(right))
    }
  }
}
