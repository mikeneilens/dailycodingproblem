package october.october14

//What does the below code snippet print out? How can we fix the anonymous functions to behave as we'd expect?
//
//functions = []
//for i in range(10):
//    functions.append(lambda : i)
//
//for f in functions:
//    print(f())

fun main() {
    //I think this is the equivalent kotlin. Kotlin does not allow mutable for loops so have to use a while loop.
    val functions = mutableListOf<()->Int>()
    var i = 0
    while (i < 10) {
        functions.add({ i })
        i++
    }

    //this always prints 10 as the function added encloses the same variable which has a final value of 10.
    functions.forEach{f -> println(f())}

    //this is what I think it needs to do:
    functions.clear()
    i = 0
    while (i < 10) {
        val j = i
        functions.add({ j })
        i++
    }
    //this prints 0 to 9 as the enclosed value is new each time.
    println("Improved version:")
    functions.forEach{f -> println(f())}
}
