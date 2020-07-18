package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.model.BoardDetailResponseData
import com.pocketfarmer.pocketfarm.src.model.DataBoard
import com.pocketfarmer.pocketfarm.src.model.DataBoardDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class DetailViewModel(boardIdx: Int) : ViewModel(){
    lateinit var board:DataBoard
    var boardDetail:LiveData<DataBoardDetail> = getBoardDetail(boardIdx)
    var amount1:MutableLiveData<String> = MutableLiveData()
    var amount2:MutableLiveData<String> = MutableLiveData()
    var amount3:MutableLiveData<String> = MutableLiveData()
    var goalAmount:MutableLiveData<String> = MutableLiveData()
    var goalRate:MutableLiveData<String> = MutableLiveData()

    private fun getBoardDetail(boardIdx: Int): LiveData<DataBoardDetail> {
        val board: MutableLiveData<DataBoardDetail> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getBoardDetail(boardIdx)
        result.enqueue(object: Callback<BoardDetailResponseData> {
            override fun onFailure(call: Call<BoardDetailResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<BoardDetailResponseData>,
                response: Response<BoardDetailResponseData>
            ) {
                val boardData : BoardDetailResponseData = response.body() ?: return
                board.value = boardData.dataBoardDetail
                amount1.value = boardData.dataBoardDetail.amount1+"kg"
                amount2.value = boardData.dataBoardDetail.amount2+"kg"
                amount3.value = boardData.dataBoardDetail.amount3+"kg"
                goalAmount.value = boardData.dataBoardDetail.goalAmount.toString() + "kg"
                goalRate.value = (boardData.dataBoardDetail.currentAmount.toDouble() /
                        boardData.dataBoardDetail.goalAmount * 100).roundToInt()
                        .toString() + "% 달성중"
            }
        })

        return board
    }

    fun setBoardData(board: DataBoard){
        this.board = board
    }
}