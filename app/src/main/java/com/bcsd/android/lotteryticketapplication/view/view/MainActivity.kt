package com.bcsd.android.lotteryticketapplication.view.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bcsd.android.lotteryticketapplication.R
import com.bcsd.android.lotteryticketapplication.databinding.ActivityMainBinding
import com.bcsd.android.lotteryticketapplication.view.view.homeFragment.HomeScreenFragment
import com.bcsd.android.lotteryticketapplication.view.view.mypageFragment.MyPageFragment
import com.bcsd.android.lotteryticketapplication.view.view.purchaseFragment.PurchaseFragment
import com.bcsd.android.lotteryticketapplication.view.viewmodel.MainViewModel

// 메인 액티비티 (홈, 구매, 마이페이지 프래그먼트를 가지고 있는 액티비티)
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val myPageFragment = MyPageFragment()
    private val homeScreenFragment = HomeScreenFragment()
    private val purchaseFragment = PurchaseFragment()
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // retrofit2, database 데이터 불러올 때 progressbar 띄우기
        binding.progressBar.visibility = View.VISIBLE


        manager
            .beginTransaction()
            .replace(R.id.main_frame, homeScreenFragment)
            .commit()
    }


    private fun createBottomNavigation() {
        val navigation = binding.mainNavigation
        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_navigation -> {
                    manager
                        .beginTransaction()
                        .replace(R.id.main_frame, homeScreenFragment)
                        .commit()
                }
                R.id.purchase_navigation -> {
                    manager
                        .beginTransaction()
                        .replace(R.id.main_frame, purchaseFragment)
                        .commit()
                }
                R.id.my_page_navigation -> {
                    manager
                        .beginTransaction()
                        .replace(R.id.main_frame, myPageFragment)
                        .commit()
                }
            }
            true
        }
    }
}