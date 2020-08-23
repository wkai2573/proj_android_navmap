package wkai.navmap.ui.spot

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Spot(
  @PrimaryKey(autoGenerate = true) var id: Int? = null,
  @ColumnInfo(name = "place") var place: String? = null,
  @ColumnInfo(name = "chickIn") var checkIn: Boolean = false,
//  @ColumnInfo(name = "chickInTime") var checkInTime: LocalDateTime? = null,
//  @ColumnInfo(name = "addedTime") var addedTime: LocalDateTime = LocalDateTime.now(),
  @Ignore var picture: Bitmap? = null,
)