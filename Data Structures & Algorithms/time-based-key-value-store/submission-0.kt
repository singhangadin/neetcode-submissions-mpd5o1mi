class TimeMap() {

    val map = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (key in map.keys) {
            map[key]!!.add(timestamp to value)
        } else {
            val list = mutableListOf<Pair<Int, String>>()
            list.add(timestamp to value)
            map[key] = list
        }
    }

    fun get(key: String, timestamp: Int): String {
        var result = ""
        val list = map[key]?:mutableListOf()

        var l = 0
        var r = list.size - 1

        while (l <= r) {
            val m = l + (r - l) / 2
            if (list[m].first <= timestamp) {
                result = list[m].second
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return result
    }
}
