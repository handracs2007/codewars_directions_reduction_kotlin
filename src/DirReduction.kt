object DirReduction {
    fun dirReduc(arr: Array<String>): Array<String> {
        val opposite = mapOf("NORTH" to "SOUTH", "SOUTH" to "NORTH", "EAST" to "WEST", "WEST" to "EAST")
        var result = arr

        do {
            var removed = false

            for (i in 0 until result.size - 1) {
                if (result[i].isNotEmpty() && result[i + 1].isNotEmpty() && opposite[result[i]] == result[i + 1]) {
                    result[i] = ""
                    result[i + 1] = ""

                    removed = true
                }
            }

            result = result.toMutableList().filter { it.isNotBlank() }.toTypedArray()
        } while (removed)

        return result
    }
}

fun main() {
    var a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")
    println(DirReduction.dirReduc(a).toList())
    a = arrayOf("NORTH", "WEST", "SOUTH", "EAST")
    println(DirReduction.dirReduc(a).toList())
    a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")
    println(DirReduction.dirReduc(a).toList())
    a = arrayOf("NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH")
    println(DirReduction.dirReduc(a).toList())
    a = arrayOf("")
    println(DirReduction.dirReduc(a).toList())
}