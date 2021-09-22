package com.example.worktime.com.example.worktime.ui.workstime

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.worktime.R
import com.example.worktime.data.Work
import com.example.worktime.databinding.FragmentWokeTimesBinding
//import com.example.worktime.databinding.FragmentWokeTimesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WokeTimesFragment : Fragment(R.layout.fragment_woke_times),WorkTimeAdapter.OnItemClickListener {

    lateinit var binding: FragmentWokeTimesBinding
    val TAG = "WokeTimesFragment"
    private val viewModel: WokeTimesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentWokeTimesBinding.bind(view)
        val workAdapter = WorkTimeAdapter(this)

        binding.apply {
            rvWorktime.apply{
                adapter = workAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }


//sum operation
            btnCount.setOnClickListener{
//                val sum = viewModel.getTotalH().toString()
//                Log.i(TAG, "sumam: $sum")
            }
//                var fee = etFee.text.toString().toInt()
//                var sum = viewModel.sumH
//                var totalH = fee*sum
//                tvWorkedTime.text = totalH.toString()
//            }
        }

        viewModel.works?.observe(viewLifecycleOwner){
            workAdapter.submitList(it)
        }



    }

    override fun onItemClick(work: Work) {
        TODO("Not yet implemented")
    }


}