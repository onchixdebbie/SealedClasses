lateinit var volume: Volume

fun main(){

    println(
        "---\nTurn the volume level to:\n" +
        "high, medium, or low? \n" +
        "---"
    )

    changeVolume()
}

private fun changeVolume(){
    val volumeLevel = readLine()

    volume = when {
        volumeLevel!!.contains("low", true) -> {
            Volume.Low("Low")
        }
        volumeLevel.contains("medium", true) -> {
            Volume.Medium("Medium")
        }
        else -> Volume.High("High")
    }

    eval(volume)

    println("---\nTo adjust it type:\n" +
            "high, medium, or low.\n" +
            "---")
    changeVolume()
}

sealed class Volume{
    class Low (var message: String): Volume()
    class Medium(var message: String): Volume()
    class High(var message: String): Volume()
}

fun eval(volume: Volume) = when (volume){
    is Volume.High -> println("Volume set to High +${volume.message}")
    is Volume.Low -> println("Volume set to Low +${volume.message}")
    is Volume.Medium -> println("Volume set to Medium +${volume.message}")
}