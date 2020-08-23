package wkai.navmap.ui.spot

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class SpotViewModel(val spotDao: SpotDao) : ViewModel() {

  val spots: LiveData<List<Spot>> = spotDao.getAll()

}