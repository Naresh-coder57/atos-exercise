package com.atos.exercise

object Item {
  sealed trait Item

  case object Apple extends Item {
    val price: Double = 0.60
  }

  case object Orange extends Item {
    val price: Double = 0.25
  }

  case class AppleOffer() extends Item {
    val price: Double = 0.0

    def applyOffer(items: List[String]): List[String] = {
      items.zipWithIndex.collect {
        case ("Apple", index) if index % 2 == 1 => None
        case (item, _) => Some(item)
      }.flatten
    }
  }

  case class OrangeOffer() extends Item {
    val price: Double = 0.0

    def applyOffer(items: List[String]): List[String] = {
      items.zipWithIndex.collect {
        case ("Orange", index) if (index + 1) % 3 == 0 => None
        case (item, _) => Some(item)
      }.flatten
    }
  }

  class ShoppingCart {
    def calculateTotalCost(items: List[Item]): Double = {
      val itemsAfterDiscounts = (new AppleOffer().applyOffer(items.map(_.toString)) ++ new OrangeOffer().applyOffer(items.map(_.toString))).toList
      val itemPrices = itemsAfterDiscounts.map {
        case "Apple" => Item.Apple.price
        case "Orange" => Item.Orange.price
        case _ => 0.0 // Handle unknown items
      }
      itemPrices.sum
    }
  }
}
