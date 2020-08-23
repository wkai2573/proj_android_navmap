package wkai.navmap.ui.spot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import wkai.navmap.databinding.ItemSpotBinding
import kotlin.concurrent.thread

class SpotAdapter(private val spotDao: SpotDao) : ListAdapter<Spot, SpotAdapter.SpotHolder>(
  //實現DiffUtil.ItemCallback，判斷是否相同，用以自動更新
  object : DiffUtil.ItemCallback<Spot>() {
    override fun areItemsTheSame(oldItem: Spot, newItem: Spot) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Spot, newItem: Spot) = oldItem == newItem
  }
) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = ItemSpotBinding.inflate(layoutInflater, parent, false)
    return SpotHolder(binding, this, spotDao)
  }

  override fun onBindViewHolder(holder: SpotHolder, position: Int) {
    val spot: Spot = getItem(position)
    holder.bind(spot)
  }

  class SpotHolder(private val binding: ItemSpotBinding,
                   private val adapter: SpotAdapter,
                   private val spotDao: SpotDao): RecyclerView.ViewHolder(binding.root) {
    fun bind(spot: Spot) {
      binding.tv.text = spot.toString()
      binding.delBtn.setOnClickListener {
        thread {
          spotDao.delete(spot)
        }
      }
      binding.checkInBtn.setOnClickListener {
        thread {
          spot.checkIn = !spot.checkIn
          spotDao.update(spot)
        }
        adapter.notifyDataSetChanged()
      }
    }
  }
}



