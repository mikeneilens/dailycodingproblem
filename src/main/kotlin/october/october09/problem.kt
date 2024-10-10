package october.october09

//Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to
// make the string valid (i.e. each open parenthesis is eventually closed).
//
//For example, given the string "()())()", you should return 1.
// Given the string ")(", you should return 2, since we must remove all of them.

fun problem(s:String):Int =
    if ("()" in s) problem(s.replace("()",""))
    else s.length
