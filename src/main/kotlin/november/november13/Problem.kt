package november.november13

//Implement the singleton pattern with a twist.
// First, instead of storing one instance, store two instances.
// And in every even call of getInstance(), return the first instance and
// in every odd call of getInstance(), return the second instance.


object Singleton{
    private const val MAXSIZE = 2
    private var count = 0
    private var values = mutableListOf("","")

    fun set(s:String)= this.also { values[count++] = s; count %= MAXSIZE }

    fun getInstance() = values[count++].also { count %= MAXSIZE }
}
