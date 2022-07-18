package com.example.mydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // To open the first tab as default

        val firstFragment = HomeFragment()
        openFragment(firstFragment)

    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.navigation_home -> {
                    val firstFragment = HomeFragment()
                    openFragment(firstFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_whishlist -> {
                    val secondFragment = WhishListFragment()
                    openFragment(secondFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_scan -> {
                    val thirdFragment = ScanFragment()
                    openFragment(thirdFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_collection -> {
                    val thirdFragment = CollectionFragment()
                    openFragment(thirdFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    val thirdFragment = ProfileFragment()
                    openFragment(thirdFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}