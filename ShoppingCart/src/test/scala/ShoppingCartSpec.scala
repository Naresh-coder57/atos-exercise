package com.atos.exercise

import com.atos.exercise.Item.ShoppingCart
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  "ShoppingCart.calculateTotalCost" should "return 0.0 for an empty list" in {
    val cart = new ShoppingCart()
    val totalCost = cart.calculateTotalCost(List.empty)
    totalCost shouldBe 0.0
  }

  it should "return the correct total cost for a list of apples and oranges" in {
    val cart = new ShoppingCart()
    val totalCost = cart.calculateTotalCost(List("Apple", "Orange", "Apple", "Apple", "Orange"))
    totalCost shouldBe 2.30
  }

  "Item.AppleOffer" should "remove the price of every second apple in the list" in {
    val offer = Item.AppleOffer()
    val items = List("Apple", "Apple", "Apple", "Apple", "Apple")
    val itemsWithOffer = offer.applyOffer(items)
    itemsWithOffer shouldBe List("Apple", "Apple", "Apple")
  }

  "Item.OrangeOffer" should "remove the price of every third orange in the list" in {
    val offer = Item.OrangeOffer()
    val items = List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    val itemsWithOffer = offer.applyOffer(items)
    itemsWithOffer shouldBe List("Orange", "Orange", "Orange", "Orange","Orange")
  }

  "ShoppingCart.applyOffer" should "apply the apple offer and return the correct list of items" in {
    val cart = Item.AppleOffer()
    val items = List("Apple", "Apple", "Apple", "Apple", "Apple")
    val itemsWithOffer = cart.applyOffer(items)
    itemsWithOffer shouldBe List("Apple", "Apple", "Apple")
  }

  it should "apply the orange offer and return the correct list of items" in {
    val cart = Item.OrangeOffer()
    val items = List("Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange")
    val itemsWithOffer = cart.applyOffer(items)
    itemsWithOffer shouldBe List("Orange", "Orange", "Orange", "Orange")
  }

  it should "apply both offers and return the correct total cost" in {
    val cart = new ShoppingCart()
    val items = List("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange")
    val totalCost = cart.calculateTotalCost(items)
    totalCost shouldBe 3.05
  }
}



