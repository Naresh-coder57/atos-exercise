import com.atos.exercise.Item
import com.atos.exercise.ShoppingCart
import org.scalatest.flatspec.AnyFlatSpec

class ShoppingCartSpec extends AnyFlatSpec {
  val cart = new ShoppingCart()

  "calculateTotalCost" should "return 0 for an empty list of items" in {
    val items = List()
    assert(cart.calculateTotalCost(items) == 0.0)
  }

  it should "return the correct total cost for a list of items with no discounts" in {
    val items = List(Item.Apple, Item.Orange, Item.Apple, Item.Orange, Item.Apple)
    assert(cart.calculateTotalCost(items) == 2.35)
  }

  it should "apply the correct discounts for a list of items with discounts" in {
    val items = List(Item.Apple, Item.Orange, Item.Orange, Item.Apple, Item.Apple)
    assert(cart.calculateTotalCost(items) == 1.7)
  }

  it should "handle unknown items by ignoring them" in {
    val items = List(Item.Apple, Item.Orange, Item.Apple, Item.Orange, Item.Orange, "banana")
    assert(cart.calculateTotalCost(items) == 1.35)
  }
}
