package july20

//cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
//
//Given this implementation of cons:
//
//def cons(a, b):
//    def pair(f):
//        return f(a, b)
//    return pair
//Implement car and cdr.

//Kotlin roughly equivalent to the python. Cons returns a function that requires a function to access enclosed variables and return Any

fun <A,B>cons(a:A, b:B) = {f:(A,B)-> Any -> f(a,b)}

fun <A,B>car(f: ((A, B)->A)->Any) = f{ a: A, _: B ->  a  }

fun <A,B>cdr(f: ((A, B)->B)->Any) = f{ _: A, b: B ->  b  }
