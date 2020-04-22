import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
data class TimeIntervalWithMultiplier(val timeInterval: TimeInterval, val multiplier: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = when (timeInterval) {
    YEAR -> addTimeIntervals(YEAR, 1)
    DAY -> addTimeIntervals(DAY, 1)
    WEEK -> addTimeIntervals(DAY, 7)
}

operator fun MyDate.plus(interval: TimeIntervalWithMultiplier): MyDate = when (interval.timeInterval) {
    YEAR -> addTimeIntervals(YEAR, interval.multiplier)
    DAY -> addTimeIntervals(DAY, interval.multiplier)
    WEEK -> addTimeIntervals(DAY, interval.multiplier * 7)
}
operator fun TimeInterval.times(multiplier: Int): TimeIntervalWithMultiplier = TimeIntervalWithMultiplier(this, multiplier)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
