package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pocketfarmer.pocketfarm.src.model.DataBoard

class ReservationDetailViewModel(application: Application) : AndroidViewModel(application){
    lateinit var board: DataBoard

    fun setBoardData(board: DataBoard){
        this.board = board
    }
}