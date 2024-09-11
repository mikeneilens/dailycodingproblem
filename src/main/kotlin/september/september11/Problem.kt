package september.september11

//A sorted array of integers was rotated an unknown number of times.
//
//Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.
//
//For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
//
//You can assume all the integers in the array are unique.

//Use a version of divide and conquer
fun List<Int>.findVal(target:Int, start:Int = 0, end:Int = lastIndex, mid:Int = (start + end)/2 ):Int?  = when {
    (get(start) == target) -> start
    (get(end) == target) -> end
    start == end -> null
    (get(start) < get(mid) && target in (get(start)..get((mid)))  ) -> findVal(target, start, mid)
    (get(start) < get(mid) && target !in (get(start)..get((mid)))  ) -> findVal(target, mid + 1, end)
    (get(mid + 1) < get(end) && target in (get(mid + 1)..get((end)))  ) -> findVal(target, mid + 1, end)
    else -> findVal(target, start, mid)
}
