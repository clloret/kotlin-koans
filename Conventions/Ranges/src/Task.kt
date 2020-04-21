fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    val range = first..last

    return date in range
}
