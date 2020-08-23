package wkai.navmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import wkai.navmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    init()
  }

  //初始化
  private fun init() {
    //下選單
    val navController = findNavController(R.id.nav_host_fragment)
    val appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.nav_home, R.id.nav_dashboard, R.id.nav_notifications, R.id.nav_checkin
      )
    )
    setupActionBarWithNavController(navController, appBarConfiguration)
    binding.navView.setupWithNavController(navController)
  }
}