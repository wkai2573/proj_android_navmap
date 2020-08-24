package wkai.navmap.ui.spot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpotViewModel(private val spotDao: SpotDao) : ViewModel() {

  val spots: LiveData<List<Spot>> = spotDao.getAll()

}