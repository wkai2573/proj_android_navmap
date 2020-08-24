package wkai.navmap.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

  var score = MutableLiveData<Int>().apply { value = 0 }

  fun scorePlus(_score: Int) {
    score.value = (score.value)?.plus(_score)
  }

  fun scoreMinus(_score: Int) {
    score.value = (score.value)?.minus(_score)
  }

}