class Singleton private constructor() {

    private var value: String? = null

    companion object {
        private lateinit var sObject: Singleton

        fun getInstance(): Singleton {
            if (!(this::sObject.isInitialized)) {
                sObject = Singleton()
            }
            return sObject
        }
    }

    fun getValue(): String? {
        return value
    }

    fun setValue(value: String) {
        this.value = value
    }
}
