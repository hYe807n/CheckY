package com.example.nfcdemo

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nfcdemo.databinding.ActivityMainBinding
import com.example.nfcdemo.ui.login.LoginActivity
import com.example.nfcdemo.ui.login.StartActivity
import com.google.android.material.navigation.NavigationView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        val headerView: View = navView.getHeaderView(0)
        val textUsername : TextView = headerView.findViewById<TextView>(R.id.nav_header_username)
        val textId : TextView = headerView.findViewById<TextView>(R.id.nav_header_id)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_checkin, R.id.nav_inform, R.id.nav_cyber, R.id.nav_jongjung, R.id.nav_timetable
            ), drawerLayout

        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //val textUsername : TextView = findViewById(R.id.nav_header_username)

        // TODO : text_username -> database의 username , text_id -> database의 userid
        textUsername.text = "김하연"
        textId.text = "202178016"
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // hayeon) logout function
    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        when (item.itemId) {

            R.id.log_out -> {   // Go back to the login window and exit mainActivity
                val intent = Intent(this, StartActivity::class.java)

                val dlg: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity,  android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
                dlg.setMessage("로그아웃 하시겠습니까?")
                dlg.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which -> })
                dlg.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(
                        applicationContext,
                        "로그아웃",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(intent)
                    finish()
                })
                dlg.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


