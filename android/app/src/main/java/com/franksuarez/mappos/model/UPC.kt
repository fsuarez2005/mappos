package com.franksuarez.mappos.model

import com.franksuarez.mappos.exception.InvalidUPCData

open class UPC: GTIN {
    var data: MutableList<Int>? = null
    var checkDigit: Int? = null

    companion object {
        fun isValidString(data: String): Boolean {
            // valid for 000000000000 and 0-00000-00000-0
            val r = Regex("\\d{12}|\\d-\\d{5}-\\d{5}-\\d")
            val results = r.matchEntire(data)
            return (data == results?.value)
        }

        fun calculateCheckDigit(data: MutableList<Int>): Int {
            val oddIndex = arrayOf(0,2,4,6,8,10)
            val evenIndex = arrayOf(1,3,5,7,9)

            var oddSum = 0
            for (i: Int in oddIndex) {
                oddSum += data.get(i)
            }

            var evenSum = 0
            for (i: Int in evenIndex) {
                evenSum += data.get(i)
            }

            var finalSum = (oddSum * 3 + evenSum) % 10
            finalSum = if (finalSum != 0) 10 - finalSum else 0

            return finalSum
        }

        @Throws(InvalidUPCData::class)
        fun fromString(dataString: String): MutableList<Int> {
            if (! isValidString(dataString)) throw InvalidUPCData()

            val data = mutableListOf<Int>()
            dataString.forEach { data.add(it.digitToInt()) }
            return data
        }
    }

    constructor()
    constructor(dataString: String) {
        this.data = fromString(dataString)
    }

    fun isValidCheckDigit(): Boolean {
        // calculate check digit
        calculateCheckDigit()
        // check if the last digit is same as check digit

        val lastDigit = this.data!![11]

        return (checkDigit == lastDigit)
    }

    /**
     * TODO: generalize calculating checkdigit and put it in class GTIN
     */
    fun calculateCheckDigit() {
        this.checkDigit = calculateCheckDigit(this.data!!)
    }

    override fun toString(): String {
        var returnString = ""
        this.data!!.forEach { returnString += it.toString() }
        return returnString
    }
}
