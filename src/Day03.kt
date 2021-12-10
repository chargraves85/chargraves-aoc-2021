fun main() {
    val input: List<String> = readInput("Day03_input")
    var gamma = ""
    var epsilon = ""
    val oGen = input.toMutableList()
    val co2Scrubber = input.toMutableList()


    // part one
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

    // part 2
    for (bitPosition: Int in oGen.first().indices) {

        var oneCounter = 0
        for (item in oGen) {
            if (Character.getNumericValue(item[bitPosition]) == 1) {
                oneCounter += 1
            }
        }

        oGen -= if (oneCounter >= oGen.size.toInt() - oneCounter) {
            oGen.filter { Character.getNumericValue(it[bitPosition]) != 1 && oGen.size != 1 }.toSet()
        } else {
            oGen.filter { Character.getNumericValue(it[bitPosition]) != 0 && oGen.size != 1 }.toSet()
        }
    }

    for (bitPosition: Int in co2Scrubber.first().indices) {

        var oneCounter = 0
        for (item in co2Scrubber) {
            if (Character.getNumericValue(item[bitPosition]) == 1) {
                oneCounter += 1
            }
        }

        co2Scrubber -= if (oneCounter >= co2Scrubber.size.toInt() - oneCounter) {
            co2Scrubber.filter { Character.getNumericValue(it[bitPosition]) != 0 && co2Scrubber.size != 1 }.toSet()
        } else {
            co2Scrubber.filter { Character.getNumericValue(it[bitPosition]) != 1 && co2Scrubber.size != 1 }.toSet()
        }
    }

    println("Power consumption: " + epsilon.toInt(2) * gamma.toInt(2))
    println("Life Support Rating: " + oGen[0].toInt(2) * co2Scrubber[0].toInt(2))

}