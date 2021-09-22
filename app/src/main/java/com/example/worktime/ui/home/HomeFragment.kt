package com.example.worktime.com.example.worktime.ui.home

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.worktime.R
//import com.example.worktime.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.example.worktime.data.Work
import com.example.worktime.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.absoluteValue

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

//    lateinit var binding: FragmentHomeBinding

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val TAG = "HomeFragment"
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val binding = FragmentHomeBinding.bind(view)
        var startH = 0
        var startM = 0
        var endH = 0
        var endM = 0
        var difH = 0
        var difM = 0
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.apply {

            timePickerStart.setOnTimeChangedListener { view, hourOfDay, hour ->
                startH = view.hour
                startM = view.minute
            }
            timePickerEnd.setOnTimeChangedListener { view, hourOfDay, hour ->
                endH = view.hour
                endM = view.minute
            }
            //start time picker
            tvStartTimeH.setOnClickListener {
                timePickerStart.isVisible = true
            }
            tvStartTimeM.setOnClickListener {
                timePickerStart.isVisible = true
            }
            fabStartSave.setOnClickListener {
                timePickerStart.isVisible = false
                tvStartTimeH.text = startH.toString()
                tvStartTimeM.text = startM.toString()
            }
            //end time picker
            tvEndTimeH.setOnClickListener {
                timePickerEnd.isVisible = true
            }
            tvEndTimeM.setOnClickListener {
                timePickerEnd.isVisible = true
            }
            fabEndSave.setOnClickListener {
                timePickerEnd.isVisible = false
                tvEndTimeH.text = endH.toString()
                tvEndTimeM.text = endM.toString()

                //calc  total time
                difH = (endH - startH).absoluteValue
                difM = (endM - startM).absoluteValue

                binding.tvTTimeH.text = difH.toString()
                binding.tvTTimeM.text = difM.toString()
            }
            //nav to list
            btnList.setOnClickListener {
                view.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToWokeTimesFragment())
            }

            //save to db
            binding.btnDone.setOnClickListener { mview ->
                saveWork(mview)
            }
        }
    }

    private fun saveWork(mView: View) {
        val startTimeHTxt = binding.tvStartTimeH.text.toString()
        val startTimeMTxt = binding.tvStartTimeM.text.toString()
        val endTimeHTxt = binding.tvEndTimeH.text.toString()
        val endTimeMTxt = binding.tvEndTimeM.text.toString()
        val totalTimeHTxt = binding.tvTTimeH.text.toString()
        val totalTimeMTxt = binding.tvTTimeM.text.toString()
            if (startTimeHTxt.isNotEmpty()) {
                val work = Work(
                    startTimeHTxt,
                    startTimeMTxt,
                    endTimeHTxt,
                    endTimeMTxt,
                    totalTimeHTxt.toInt(),
                    totalTimeMTxt.toInt()
                )

            viewModel.insertW(work)

            Snackbar.make(mView, "Work Saved", Snackbar.LENGTH_SHORT).show()

            view?.findNavController()
                ?.navigate(HomeFragmentDirections.actionHomeFragmentToWokeTimesFragment())

        } else {
            val toast = Toast.makeText(activity, "can not be empty", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }

    }

}