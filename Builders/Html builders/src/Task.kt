fun renderProductTable(): String {
    return html {
        table {
            tr(color = getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            products.forEach {
                val row = products.indexOf(it)
                tr {
                    td(color = getCellColor(0, row)) {
                        text(it.description)
                    }
                    td(getCellColor(1, row)) {
                        text(it.price)
                    }
                    td(getCellColor(2, row)) {
                        text(it.popularity)
                    }
                }
            }

        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
