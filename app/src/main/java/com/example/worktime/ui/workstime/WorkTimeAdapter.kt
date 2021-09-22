package com.example.worktime.com.example.worktime.ui.workstime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.worktime.data.Work
import com.example.worktime.databinding.RvItemBinding

class WorkTimeAdapter(private val listener: OnItemClickListener)
    : ListAdapter<Work, WorkTimeAdapter.WorksViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorksViewHolder {
        val binding = RvItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return WorksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorksViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class WorksViewHolder(private val binding: RvItemBinding)
        : RecyclerView.ViewHolder(binding.root) {



        fun bind(work: Work) {
            binding.apply {
                tvDate.text = work.createdDateFormatted
                val totalTimeH = work.tTimeH.toString()
                val totalTimeM = work.tTimeM.toString()
                tvWorkedTimeH.text = totalTimeH
                tvWorkedTimeM.text = totalTimeM
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(work: Work)
    }

    class DiffCallback : DiffUtil.ItemCallback<Work>(){
        override fun areItemsTheSame(oldItem: Work, newItem: Work): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Work, newItem: Work): Boolean =
            oldItem == newItem
    }
}