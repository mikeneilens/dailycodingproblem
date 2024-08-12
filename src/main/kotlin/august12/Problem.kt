package august12

//Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.
//
//More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.
//
//If you can only fit one word on a line, then you should pad the right-hand side with spaces.
//
//Each word is guaranteed not to be longer than k.
//
//For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:
//
//["the  quick brown", # 1 extra space on the left
//"fox  jumps  over", # 2 extra spaces distributed evenly
//"the   lazy   dog"] # 4 extra spaces distributed evenly

fun problem(words:List<String>, k:Int) = words.createRows(k).map{it.padRow(k).joinToString("")}

fun List<String>.createRows(k:Int):List<List<String>> =
    fold(listOf()){ rows, word ->
        when {
            (rows.isEmpty()) -> listOf(listOf(word))
            (rows.wordFitsOnLastRow(word, k)) -> rows.addWordToLastRow(" $word")
            else -> rows + listOf(listOf(word))
        }
    }

fun List<List<String>>.wordFitsOnLastRow(word: String, k: Int) = last().sumOf(String::length) + word.length < k

fun List<List<String>>.addWordToLastRow(word:String):List<List<String>> = dropLast(1) + listOf(last() + word)

fun List<String>.padRow(k:Int, n:Int = 0):List<String> = if (sumOf(String::length) == k) this else addPadding(n).padRow(k, n + 1)

fun List<String>.addPadding(n:Int) = mapIndexed { index, word -> if (n % size == index && index > 0) " $word" else word }