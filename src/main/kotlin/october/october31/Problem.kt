package october.october31

//Given two strings A and B, return whether A can be shifted some number of times to get B.
//
//For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.

fun problem(a:String, b:String, rotationsRemaining:Int = a.length - 1):Boolean = when {
        a == b -> true
        a.length != b.length || rotationsRemaining == 0 -> false
        else -> problem(a, b.rotateLeft() , rotationsRemaining - 1)
    }

fun String.rotateLeft() = drop(1) + first()