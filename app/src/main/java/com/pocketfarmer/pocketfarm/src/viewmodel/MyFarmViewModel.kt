package com.pocketfarmer.pocketfarm.src.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.model.DataProfile
import com.pocketfarmer.pocketfarm.src.model.DataReservation
import com.pocketfarmer.pocketfarm.src.model.ProfileResponseData
import com.pocketfarmer.pocketfarm.src.model.ReservationResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyFarmViewModel(userIdx: Int): ViewModel(){
    val profile = getProfile(userIdx)
    val profileTitle:MutableLiveData<String> = MutableLiveData()

    val reservations = getReservation(userIdx)
    val progressRate:MutableLiveData<List<String>> = MutableLiveData()
    val remainPeriod:MutableLiveData<List<String>> = MutableLiveData()

    private fun getProfile(userIdx: Int): LiveData<DataProfile> {
        val profile: MutableLiveData<DataProfile> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getProfile(userIdx)
        result.enqueue(object: Callback<ProfileResponseData> {
            override fun onFailure(call: Call<ProfileResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ProfileResponseData>,
                response: Response<ProfileResponseData>
            ) {
                val responseData : ProfileResponseData = response.body() ?: return
                profile.value = responseData.dataProfile
                profileTitle.value = responseData.dataProfile.name + "님의 팜"
            }
        })

        return profile
    }

    private fun getReservation(userIdx: Int): LiveData<List<DataReservation>> {
        val reservations: MutableLiveData<List<DataReservation>> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getReservation(userIdx)
        result.enqueue(object: Callback<ReservationResponseData> {
            override fun onFailure(call: Call<ReservationResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ReservationResponseData>,
                response: Response<ReservationResponseData>
            ) {
                val responseData : ReservationResponseData = response.body() ?: return
                reservations.value = responseData.data

                val rateList = arrayListOf<String>()
                val periodList = arrayListOf<String>()
                for(d in responseData.data){
                    rateList.add(d.progressRate.toString() + "%")
                    periodList.add(d.remainPeriod.toString() + "d")
                }
                progressRate.value = rateList
                remainPeriod.value = periodList
            }
        })

        return reservations
    }
}