package com.pocketfarmer.pocketfarm.src.viewmodel

import androidx.lifecycle.ViewModel
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.model.ReservationRequestData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat

class PayViewModel: ViewModel() {

    fun setReword(price: Int, percent: Double): String = DecimalFormat("###,###")
            .format((price * percent).toInt()).toString()

    fun reservation(boardIdx:Int, userIdx:Int, amount: Int, price: String, ea: Int, donatePoint:String, baeminPoint:String){
        val reservationRequestData = ReservationRequestData(amount, price, ea, donatePoint, baeminPoint)

        val result = NetworkHelper.getInstance().getService().postReservation(boardIdx, userIdx, reservationRequestData)

        result.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
            }
        })
    }
}