package algoritms

object FactorialScala {
  def factorial(x: BigInt): BigInt =
    if (x == 0) 1 else x * factorial(x - 1)

  def main(args: Array[String]): Unit =
    Console.println(factorial(20))
}
