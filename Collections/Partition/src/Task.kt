// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
  val set = mutableSetOf<Customer>()

  customers.forEach { customer ->
    val pair = customer.orders.partition { it.isDelivered }

    if (pair.first.size < pair.second.size) {
      set.add(customer)
    }
  }

  return set
}
