
// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    return customers.fold(setOf(customers.first().getOrderedProducts().first())) { acc, customer -> acc.plus(acc.intersect(customer.getOrderedProducts())) }
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }