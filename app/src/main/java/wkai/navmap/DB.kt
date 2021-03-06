package wkai.navmap

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import wkai.navmap.ui.spot.Spot
import wkai.navmap.ui.spot.SpotDao

@Database(entities = [Spot::class], version = 1)
abstract class DB : RoomDatabase() {
  abstract fun spotDao(): SpotDao

  //靜態實例
  companion object {
    //getInstance
    fun db(context: Context): DB =
      Room.databaseBuilder(context, DB::class.java, "navmap").build()
  }
}