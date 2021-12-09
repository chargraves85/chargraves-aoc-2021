fun main() {
    val input: List<String> = readInput("Day03_input")
    var gamma = ""
    var epsilon = ""

    for (bitPosition: Int in input.first().indices) {
        var oneCounter = 0
        for (item in input) {
            if (Character.getNumericValue(item[bitPosition]) == 1) {
                oneCounter += 1
            }
        }

        gamma += if (oneCounter >= input.size.toInt() - oneCounter) {"1"} else {"0"}
        epsilon += if (oneCounter >= input.size.toInt() - oneCounter) {"0"} else {"1"}

    }

    println("Power consumption: " + epsilon.toInt(2) * gamma.toInt(2))



}