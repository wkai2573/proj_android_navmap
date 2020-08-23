package wkai.navmap.ui.spot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import wkai.navmap.DB
import wkai.navmap.databinding.FragmentSpotBinding
import kotlin.concurrent.thread

class SpotFragment : Fragment() {

  private val binding: FragmentSpotBinding by lazy { FragmentSpotBinding.inflate(LayoutInflater.from(context)) }

  private val viewModel: SpotViewModel by lazy { ViewModelProvider(this, viewModelFactory).get(SpotViewModel::class.java) }
  private val viewModelFactory: SpotViewModelFactory by lazy { SpotViewModelFactory(spotDao) }

  private val spotDao: SpotDao by lazy { DB.getInstance(requireActivity().applicationContext).viewpointDao() }

  private val adapter: SpotAdapter by lazy { SpotAdapter(spotDao) }

  //onCreateView
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    //binding
    binding.apply {
      //button
      listOf(binding.addBtn, binding.deleteAllBtn, binding.listBtn).forEach { btn ->
        btn.setOnClickListener { buttonEventInit(btn) }
      }
      //recyclerView
      binding.rv.layoutManager = LinearLayoutManager(requireContext())
      binding.rv.adapter = adapter
    }

    //viewModel
    viewModel.spots.observe(viewLifecycleOwner) {
      adapter.submitList(it)
    }

    return binding.root
  }

  //按鈕事件
  private fun buttonEventInit(btn: Button) {
    thread {
      when (btn) {
        binding.addBtn -> {
          for (i in 1..1000) {
            spotDao.insert(Spot(place = "台北"))
          }
        }
        binding.deleteAllBtn -> spotDao.deleteAll()
        binding.listBtn -> {
          val text = spotDao.getAll().toString()
          activity?.runOnUiThread {
            binding.tv.text = text
          }
        }
      }
    }
  }
}