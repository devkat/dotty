import scala.language.`3.0`

trait Foo[A]

object Example {

  given as Foo[Int] {
  }

  def foo0[A: Foo]: A => A = identity
  def foo1[A](implicit foo: Foo[A]): A => A = identity
  def foo2[A](using Foo[A]): A => A = identity

  def test(): Unit = {
    foo0(32) // error
    foo1(32) // error
    foo2(32)
  }

}
