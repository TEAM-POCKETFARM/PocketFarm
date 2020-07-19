package com.pocketfarmer.pocketfarm.src.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class DetailViewModel(boardIdx: Int) : ViewModel(){
    lateinit var board:DataBoard

    val boardDetail:LiveData<DataBoardDetail> = getBoardDetail(boardIdx)
    val amount1:MutableLiveData<String> = MutableLiveData()
    val amount2:MutableLiveData<String> = MutableLiveData()
    val amount3:MutableLiveData<String> = MutableLiveData()
    val goalAmount:MutableLiveData<String> = MutableLiveData()
    val goalRate:MutableLiveData<String> = MutableLiveData()

    val productData = getProduct(boardIdx)
    val productDetail:MutableLiveData<String> = MutableLiveData()

    val farmData = getFarm(boardIdx)
    val farmDescription:MutableLiveData<String> = MutableLiveData()

    val reviews = getReview(boardIdx)
    val userTexts:MutableLiveData<List<String>> = MutableLiveData()
    val averageScore:MutableLiveData<Double> = MutableLiveData()
    val averageScoreText:MutableLiveData<String> = MutableLiveData()

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

    private fun getProduct(boardIdx: Int): LiveData<DataProduct> {
        val product: MutableLiveData<DataProduct> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getProduct(boardIdx)
        result.enqueue(object: Callback<ProductResponseData> {
            override fun onFailure(call: Call<ProductResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ProductResponseData>,
                response: Response<ProductResponseData>
            ) {
                val responseData : ProductResponseData = response.body() ?: return
                product.value = responseData.dataProduct
                productDetail.value = responseData.dataProduct.goodsContent.replace("<br>".toRegex(), "\n")
            }
        })

        return product
    }

    private fun getFarm(boardIdx: Int): LiveData<DataFarm> {
        val farm: MutableLiveData<DataFarm> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getFarm(boardIdx)
        result.enqueue(object: Callback<FarmResponseData> {
            override fun onFailure(call: Call<FarmResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<FarmResponseData>,
                response: Response<FarmResponseData>
            ) {
                val responseData : FarmResponseData = response.body() ?: return
                farm.value = responseData.dataFarm
                farmDescription.value = responseData.dataFarm.description.replace("<br>".toRegex(), "\n")
            }
        })

        return farm
    }

    private fun getReview(boardIdx: Int): LiveData<List<DataReview>> {
        val reviewList: MutableLiveData<List<DataReview>> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getReviewList(boardIdx)
        result.enqueue(object: Callback<ReviewResponseData> {
            override fun onFailure(call: Call<ReviewResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ReviewResponseData>,
                response: Response<ReviewResponseData>
            ) {
                val responseData : ReviewResponseData = response.body() ?: return
                reviewList.value = responseData.data

                var sumScore = 0.0
                val list = arrayListOf<String>()
                for(i in responseData.data.indices){
                    val nickname = responseData.data[i].nickname
                    val id = responseData.data[i].userId
                    list.add(nickname + "(" + id.replaceRange(id.length - 4, id.length, "****") + ")")

                    sumScore += responseData.data[i].starScore
                }
                userTexts.value = list
                averageScore.value = sumScore / responseData.data.size
                averageScoreText.value = ((sumScore / responseData.data.size * 10).roundToInt() / 10.0).toString()
            }
        })

        return reviewList
    }

    fun setBoardData(board: DataBoard){
        this.board = board
    }
}