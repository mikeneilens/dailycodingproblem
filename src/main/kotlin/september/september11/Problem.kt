package september.september11

//An sorted array of integers was rotated an unknown number of times.
//
//Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.
//
//For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
//
//You can assume all the integers in the array are unique.

fun List<Int>.findVal(target:Int, start:Int = 0, end:Int = lastIndex):Int {
    if (get(start) == target) return start
    if (get(end) == target) return end
    if (get(start) < get(mid(start, end))  )
        if (target in (get(start)..get((mid(start, end)))))
            return findVal(target, start, mid(start, end))
        else
            return findVal(target, mid(start, end) + 1, end)
    else
        if (target in get(mid(start, end) + 1)..get(end))
            return findVal(target, mid(start, end) + 1 , end)
        else
            return findVal(target, start, mid(start, end))
}

fun mid(start:Int, end:Int) = start + (end - start)/2