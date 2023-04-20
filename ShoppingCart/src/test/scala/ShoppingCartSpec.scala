import org.scalatest.funsuite.AnyFunSuite

class ShoppingCartSpec extends AnyFunSuite {

  test("calculate total cost of items without offers") {
    assert(ShoppingCart.calculateTotalCost(List("apple", "apple", "orange", "apple")) == 2.05)
    assert(ShoppingCart.calculateTotalCost(List("orange", "orange", "orange")) == 0.75)
    assert(ShoppingCart.calculateTotalCost(List("apple", "orange", "orange", "orange")) == 1.35)
    assert(ShoppingCart.calculateTotalCost(List()) == 0)
  }

  test("apply buy-one-get-one-free offer on Apples") {
    assert(ShoppingCart.applyAppleOffer(List("apple", "apple", "orange", "apple")) == List("orange", "apple", "apple"))
    assert(ShoppingCart.applyAppleOffer(List("apple", "orange", "apple")) == List("orange", "apple"))
    assert(ShoppingCart.applyAppleOffer(List("apple", "apple", "apple")) == List("apple","apple"))
    assert(ShoppingCart.applyAppleOffer(List("orange", "orange")) == List("orange", "orange"))
  }

  test("apply 3-for-2 offer on Oranges") {
    assert(ShoppingCart.applyOrangeOffer(List("apple", "apple", "orange", "orange", "orange")) == List("apple", "apple", "orange", "orange"))
    assert(ShoppingCart.applyOrangeOffer(List("orange", "orange", "orange")) == List("orange", "orange"))
    assert(ShoppingCart.applyOrangeOffer(List("orange", "orange", "orange", "orange")) == List("orange", "orange","orange"))
  }
}