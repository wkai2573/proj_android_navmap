package wkai.navmap.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import wkai.navmap.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

  private val binding by lazy { FragmentHomeBinding.inflate(LayoutInflater.from(context)) }
  private val viewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding.apply {
      //binding component things..
    }
    viewModel.apply {
      text.observe(viewLifecycleOwner) { binding.textHome.text = it }
    }
    return binding.root
  }

}