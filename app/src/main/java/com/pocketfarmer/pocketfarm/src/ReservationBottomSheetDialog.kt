package com.pocketfarmer.pocketfarm.src

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pocketfarmer.pocketfarm.R
import com.pocketfarmer.pocketfarm.src.activity.PayActivity

class ReservationBottomSheetDialog: BottomSheetDialogFragment(), View.OnClickListener{
    private lateinit var linearLayout:LinearLayout
    private lateinit var numberTextView: TextView
    private var price: String = ""

    companion object{
        fun getInstance(): ReservationBottomSheetDialog = ReservationBottomSheetDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.reservation_bottom_sheet_dialog, container, false)

        linearLayout = view.findViewById(R.id.price_dialog_layout)
        numberTextView = view.findViewById(R.id.price_number_text)

        setLayoutClickListener()
        view.findViewById<Button>(R.id.price_number_minus_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.price_number_plus_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.price_dialog_reservation_button).setOnClickListener(this)

        return view
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
                        price = ((linearLayout[i] as LinearLayout)[1] as TextView).text.toString()
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
                        = Integer.parseInt(price.replace(",".toRegex(), "").dropLast(1)) *
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