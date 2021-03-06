class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        var current = start
        return object: Iterator<MyDate> {
            override fun hasNext(): Boolean {
                return current <= end
            }

            override fun next(): MyDate {
                val result = current
                current = current.followingDate()
                return result
            }
        }
    }

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}