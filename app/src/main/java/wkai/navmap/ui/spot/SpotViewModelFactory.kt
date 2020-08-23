package wkai.navmap.ui.spot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SpotViewModelFactory(private val spotDao: SpotDao) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(SpotViewModel::class.java)) {
      return SpotViewModel(spotDao) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}