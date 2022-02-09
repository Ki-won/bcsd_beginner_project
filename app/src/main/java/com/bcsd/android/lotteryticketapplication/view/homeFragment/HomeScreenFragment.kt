package com.bcsd.android.lotteryticketapplication.view.homeFragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bcsd.android.lotteryticketapplication.R

class HomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_homescreen_main, null)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    private fun setNumberBackground(number: Int, textView: TextView) {
        when (number) {
            in 1..10 -> textView.background =
                context?.let { ContextCompat.getDrawable(it, R.drawable.circle_yellow) }
            in 11..20 -> textView.background =
                context?.let { ContextCompat.getDrawable(it, R.drawable.circle_blue) }
            in 21..30 -> textView.background =
                context?.let { ContextCompat.getDrawable(it, R.drawable.circle_red) }
            in 31..40 -> textView.background =
                context?.let { ContextCompat.getDrawable(it, R.drawable.circle_purple) }
        }
        true
    }
}