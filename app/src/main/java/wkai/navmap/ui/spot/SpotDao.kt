package wkai.navmap.ui.spot

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface SpotDao {
  @Query("SELECT * FROM spot")
//  fun getAll(): DataSource.Factory<Int, Spot>
  fun getAll(): LiveData<List<Spot>>

  @Query("SELECT * FROM spot WHERE id = :id LIMIT 1")
  fun getById(id: Int): LiveData<Spot>

  @Query("SELECT * FROM spot WHERE id IN (:ids)")
  fun getByIds(ids: IntArray): LiveData<List<Spot>>

//  @Query("SELECT * FROM spot WHERE addedTime >= DATE('now', '-:days day')")
//  fun getLastDaysRecord(days: Int): LiveData<List<Viewpoint>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(vararg spot: Spot)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(spots: List<Spot>)

  @Update
  fun update(spot: Spot)

  @Delete
  fun delete(vararg spot: Spot)

  @Query("DELETE FROM spot")
  fun deleteAll()
}