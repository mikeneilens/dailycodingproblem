package september.september19

//Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50
// (but also not 0-100 or 100-0). You do not know the bias of the coin.
//
//Write a function to simulate an unbiased coin toss.

fun biasedRandomOneOrZero() =
    if (((1..10).random() +  (1..5).random())/2 > 5) 1 else 0

fun unBiasedCoin(biasedRandom:()->Int = ::biasedRandomOneOrZero):String =
    when (Pair(biasedRandom() , biasedRandom())) {
        Pair(1,0) -> "heads"
        Pair(0,1) -> "tails"
        else -> unBiasedCoin()
    }
