package com.atos.exercise

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  "ShoppingCart" should "return the correct total cost for an empty list of items" in {
    val cart = new Item.ShoppingCart()
    val items = List.empty[Item.Item]
    cart.calculateTotalCost(items) shouldEqual 0.0
  }

  it should "return the correct total cost for a list of items with no discounts" in {
    val cart = new Item.ShoppingCart()
    val items = List(Item.Apple, Item.Orange, Item.Apple, Item.Orange)
    cart.calculateTotalCost(items) shouldEqual 2.35
  }

  it should "return the correct total cost for a list of items with an Apple offer" in {
    val cart = new Item.ShoppingCart()
    val items = List(Item.Apple, Item.Orange, Item.Apple, Item.Orange, Item.Apple)
    cart.calculateTotalCost(items) shouldEqual 2.2
  }

  it should "return the correct total cost for a list of items with an Orange offer" in {
    val cart = new Item.ShoppingCart()
    val items = List(Item.Orange, Item.Orange, Item.Orange, Item.Apple, Item.Orange, Item.Orange)
    cart.calculateTotalCost(items) shouldEqual 1.1
  }

  it should "return the correct total cost for a list of items with both offers" in {
    val cart = new Item.ShoppingCart()
    val items = List(Item.Orange, Item.Orange, Item.Orange, Item.Apple, Item.Orange, Item.Orange, Item.Apple)
    cart.calculateTotalCost(items) shouldEqual 1.7
  }
  
}
