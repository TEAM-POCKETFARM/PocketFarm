package com.pocketfarmer.pocketfarm.src.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.model.DataProfile
import com.pocketfarmer.pocketfarm.src.model.DataReservationDetail
import com.pocketfarmer.pocketfarm.src.model.ReservationDetailResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReservationDetailViewModel(boardIdx: Int) : ViewModel(){
    val reservationDetail = getReservationDetail(boardIdx)
    val profileTitle: MutableLiveData<String> = MutableLiveData()

    private fun getReservationDetail(boardIdx: Int): LiveData<List<DataReservationDetail>> {
        val reservationDetail: MutableLiveData<List<DataReservationDetail>> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getReservationDetail(boardIdx)
        result.enqueue(object: Callback<ReservationDetailResponseData> {
            override fun onFailure(call: Call<ReservationDetailResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ReservationDetailResponseData>,
                response: Response<ReservationDetailResponseData>
            ) {
                val responseData : ReservationDetailResponseData = response.body() ?: return
                reservationDetail.value = responseData.data
            }
        })

        return reservationDetail
    }
}