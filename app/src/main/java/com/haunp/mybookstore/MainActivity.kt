package com.haunp.mybookstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.haunp.mybookstore.view.fragment.User.category.CategoryFragment
import com.haunp.mybookstore.view.fragment.User.main.HomeFragment
import com.haunp.mybookstore.view.fragment.User.search.SearchFragment
import com.haunp.mybookstore.view.fragment.User.setting.SettingFragment
import com.haunp.mybookstore.view.fragment.login_register.LoginFragment
import com.haunp.mybookstore.view.fragment.login_register.RegisterFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // Thêm LoginFragment vào Activity ban đầu
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_bottom_view)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    showFragment(HomeFragment())
                    true
                }
                R.id.nav_category -> {
                    showFragment(CategoryFragment())
                    true
                }
                R.id.nav_search -> {
                    showFragment(SearchFragment())
                    true
                }
                R.id.nav_setting -> {
                    showFragment(SettingFragment())
                    true
                }
                else->false
            }
        }
    }
    fun showRegisterFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RegisterFragment())
            .addToBackStack(null) // Thêm vào back stack để có thể quay lại fragment trước
            .commit()
    }
    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Thêm vào back stack để có thể quay lại fragment trước
            .commit()
    }
}