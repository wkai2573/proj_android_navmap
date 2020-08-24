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
      closeBtn.setOnClickListener { requireActivity().finish() }
      scorePlusBtn.setOnClickListener { viewModel.scorePlus(3) }
      scoreMinusBtn.setOnClickListener { viewModel.scoreMinus(2) }
    }
    viewModel.apply {
      score.observe(viewLifecycleOwner) { newScore ->
        binding.scoreTv.text = newScore.toString()
      }
    }
    return binding.root
  }

}