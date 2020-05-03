class LazyProperty(val initializer: () -> Int) {
    private var foo: Int? = null
    val lazy: Int
        get() {
            if (foo == null) {
                foo = initializer()
            }
            return foo!!
        }
}
