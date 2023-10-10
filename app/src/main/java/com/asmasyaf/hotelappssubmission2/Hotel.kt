package com.asmasyaf.hotelappssubmission2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hotel(
    val nameHotel: String,
    val descHotel : String,
    val imgHotel : String,
    val rateHotel : String,
    val telpHoltel : String
) : Parcelable
