package com.pocketfarmer.pocketfarm.src

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.databinding.ReservationBottomSheetDialogBinding
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.activity.PayActivity
import com.pocketfarmer.pocketfarm.src.viewmodel.DetailViewModel

class ReservationBottomSheetDialog(private val boardIdx:Int): BottomSheetDialogFragment(), View.OnClickListener{
    private lateinit var linearLayout:LinearLayout
    private lateinit var numberTextView: TextView
    private var price: String = ""

    companion object{
        fun getInstance(boardIdx: Int): ReservationBottomSheetDialog = ReservationBottomSheetDialog(boardIdx)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil
            .inflate<ReservationBottomSheetDialogBinding>(inflater,
                R.layout.reservation_bottom_sheet_dialog, container, false)
        binding.viewModel = ViewModelProvider(this,
            DetailActivity.DetailViewModelFactory(boardIdx)).get(DetailViewModel::class.java)
        binding.lifecycleOwner = this

        linearLayout = binding.priceDialogLayout
        numberTextView = binding.priceNumberText

        setLayoutClickListener()
        binding.priceNumberMinusButton.setOnClickListener(this)
        binding.priceNumberPlusButton.setOnClickListener(this)
        binding.priceDialogReservationButton.setOnClickListener(this)

        return binding.root
    }

    private fun setLayoutClickListener(){
        for(i in 0..2){
            linearLayout[i].setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.price_dialog_layout1, R.id.price_dialog_layout2, R.id.price_dialog_layout3 -> {
                for(i in 0..2){
                    if(linearLayout[i].id == view.id){
                        linearLayout[i].background =
                            resources.getDrawable(R.drawable.price_background_on, null)
                        price = (((linearLayout[i] as LinearLayout)[1] as LinearLayout)[0] as TextView).text.toString()
                    }else{
                        linearLayout[i].background =
                            resources.getDrawable(R.drawable.price_background_off, null)
                    }
                }
            }
            R.id.price_number_minus_button -> {
                if(numberTextView.text.toString() != "1")
                    numberTextView.text = (Integer.parseInt(numberTextView.text.toString()) - 1).toString()
            }
            R.id.price_number_plus_button -> {
                numberTextView.text = (Integer.parseInt(numberTextView.text.toString()) + 1).toString()
            }
            R.id.price_dialog_reservation_button -> {
                if(price == "") {
                    Toast.makeText(context, "상품을 선택해주세요", Toast.LENGTH_LONG).show()
                    return
                }
                val totalPrice
                        = Integer.parseInt(price.replace(",".toRegex(), "")) *
                        Integer.parseInt(numberTextView.text.toString())
                val intent = Intent(context, PayActivity::class.java).apply {
                    putExtra("price", totalPrice)
                }
                startActivity(intent)
                activity?.finish()
                dismiss()
            }
        }
    }
}