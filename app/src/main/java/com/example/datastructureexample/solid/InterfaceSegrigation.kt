package com.example.datastructureexample.solid

/*“Clients should not be forced to depend on interfaces they do not use.”

Or commonly said as:

“Prefer small, specific interfaces instead of large (fat) interfaces.”

So your statement “do not keep fat interfaces” is actually a better way to remember ISP.*/

/* bad example
interface MediaPlayer {
    fun playAudio()
    fun playVideo()
}


*/



interface AudioPlayer {
    fun playAudio()
}

interface VideoPlayer {
    fun playVideo()
}

class MusicPlayer : AudioPlayer {
    override fun playAudio() {
        println("Playing music")
    }
}

class MoviePlayer : AudioPlayer, VideoPlayer {

    override fun playAudio() {
        println("Playing movie audio")
    }

    override fun playVideo() {
        println("Playing movie video")
    }
}
