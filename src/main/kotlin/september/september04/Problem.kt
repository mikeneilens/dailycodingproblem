package september.september04

//Given a function that generates perfectly random numbers between 1 and k (inclusive),
//where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.
//
//It should run in O(N) time.
//
//Hint: Make sure each one of the 52! permutations of the deck is equally likely.

fun problem():List<String> {
    val deck = deckGenerator().toMutableList()
    deck.shuffled()
    return deck
}

fun <E>MutableList<E>.shuffled() = indices.forEach { i -> randomSwap(i) }

//Fisher-Yates shuffle swap element at position i with a random element in the range i to lastIndex
fun <E>MutableList<E>.randomSwap(i:Int, randomGen:IntRange.()->Int = IntRange::random) =
    swap (i, (i..lastIndex).randomGen())

fun <E>MutableList<E>.swap(a:Int, b:Int) {
    Pair(this[a],this[b]).also {
        this[b] = it.first
        this[a] = it.second
    }
}

fun deckGenerator(cards:List<String> = listOf(),
                  suits:List<Char> = listOf('S','C','D','H'),
                  numbers:List<Char> = listOf('A','2','3','4','5','6','7','8','9','T','J','Q','K')):List<String> =
    if (suits.isEmpty()) cards
    else if (numbers.isEmpty()) deckGenerator(cards, suits.drop(1))
    else deckGenerator(cards + "${numbers.first()}${suits.first()}", suits, numbers.drop(1))

