package com.franksuarez.mappos.model

open class PriceUPC : UPC {
    val factor2MinusTable: List<Int> = listOf(
        0,
        2,
        4,
        6,
        8,
        9,
        1,
        3,
        5,
        7,
    )

    val factor3Table: List<Int> = listOf(
        0,
        3,
        6,
        9,
        2,
        6,
        8,
        1,
        4,
        7,
    )

    val factor5PlusTable: List<Int> = listOf(
        0,
        5,
        9,
        4,
        8,
        3,
        7,
        2,
        6,
        1,
    )

    val factor5MinusTable: List<Int> = listOf(
        0,
        5,
        9,
        4,
        8,
        3,
        7,
        2,
        6,
        1,
    )

    val fourDigitPriceFactors: List<List<Int>> = listOf(
        factor2MinusTable,
        factor2MinusTable,
        factor3Table,
        factor5MinusTable,
    )

    val fiveDigitPriceFactors: List<List<Int>> = listOf(
        factor5PlusTable,
        factor2MinusTable,
        factor5MinusTable,
        factor5PlusTable,
        factor2MinusTable,
    )

    constructor() : super()
    constructor(dataString: String) : super(dataString)

    fun calculateFourDigitPriceCheckDigit(): Int {
        // position             0   1   2   3
        // weighing factor      2-  2-  3   5-

        // test price
        val price = listOf<Int>(2, 8, 7, 5)

        var sum = fourDigitPriceFactors[0][price[0]] +
                fourDigitPriceFactors[1][price[1]] +
                fourDigitPriceFactors[2][price[2]] +
                fourDigitPriceFactors[3][price[3]]

        sum *= 3

        return (sum % 10)
    }
}