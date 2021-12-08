fun main() {

    val input = readInput("Day01_input").map { it.toInt() }
    var lastItem = 103
    var counter = 0

    for (item in input) {
        if (item > lastItem) {
            counter++
        }
        lastItem = item
    }

    println(counter)

    counter = 0

    for (window in input.windowed(3).windowed(2)) {
        val sumA = window[0].sum()
        val sumB = window[1].sum()

        if (sumB > sumA) {
            counter++
        }
    }
    println(counter)
}
