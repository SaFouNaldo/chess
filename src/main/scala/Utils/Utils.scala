object Utils {
    val charToNumber = ('a' to 'h').map(c => c -> (c - 'a' + 1)).toMap
    val numberToChar = (0 to 7).map(n => n -> ((n + 'a' ).toChar)).toMap
}
