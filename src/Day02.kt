fun main() {

    val input = readInput("Day02_input")
    val regexNav = "([a-z])+".toRegex()
    val regexUnit = "([0-9])+".toRegex()
    var forwardDistance = 0
    var depth = 0
    var aim = 0

    for (item in input) {

        val navMatcher = regexNav.find(item)!!.value
        val unitMatcher = regexUnit.find(item)!!.value

        if (navMatcher == "up") {
            depth -= unitMatcher.toInt()
        }

        if (navMatcher  == "down") {
            depth += unitMatcher.toInt()
        }

        if (navMatcher  == "forward") {
            forwardDistance += unitMatcher.toInt()
        }

    }

    val navProduct = forwardDistance * depth

    println("Solution 1: $navProduct")

    forwardDistance = 0
    depth = 0

    for (item in input) {

        val navMatcher = regexNav.find(item)!!.value
        val unitMatcher = regexUnit.find(item)!!.value

        if (navMatcher == "up") {
            aim -= unitMatcher.toInt()
        }

        if (navMatcher  == "down") {
            aim += unitMatcher.toInt()
        }

        if (navMatcher  == "forward") {
            forwardDistance += unitMatcher.toInt()
            val depthModifier = unitMatcher.toInt() * aim
            depth += depthModifier
        }

    }

    val aimedNavProduct = forwardDistance * depth

    println("Solution 2: $aimedNavProduct")

}
