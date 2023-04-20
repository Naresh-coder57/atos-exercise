object ShoppingCart {
  val priceList = Map("apple" -> 0.6, "orange" -> 0.25)

  def calculateTotalCost(items: List[String]): Double = {
    items.map(priceList.getOrElse(_, 0.0)).sum
  }

  def applyAppleOffer(items: List[String]): List[String] = {
    val appleCount = items.count(_ == "apple")
    val offerCount = appleCount / 2
    val remainingApples = appleCount - offerCount
    val remainingItems = items.filter(_ != "apple") ++ List.fill(remainingApples)("apple")
    remainingItems
  }

  def applyOrangeOffer(items: List[String]): List[String] = {
    val orangeCount = items.count(_ == "orange")
    val offerCount = orangeCount / 3
    val remainingOranges = orangeCount - offerCount
    val remainingItems = items.filter(_ != "orange") ++ List.fill(remainingOranges)("orange")
    remainingItems
  }

}
