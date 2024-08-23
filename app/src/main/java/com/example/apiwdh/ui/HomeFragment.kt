package com.example.apiwdh.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.apiwdh.MainViewModel
import com.example.apiwdh.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
   private lateinit var binding: FragmentHomeBinding
   private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        viewModel.loadMarsImages()
        return binding.root
    }
    //http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631200305217E01_DXXX.jpg
    //https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631200305217E01_DXXX.jpg
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.ivMarsImg.load("https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631200305217E01_DXXX.jpg")
        viewModel.marsImages.observe(viewLifecycleOwner) { marsPhotos ->
            binding.textView.text = marsPhotos[0].camera.name
            binding.textView2.text = marsPhotos[0].camera.fullName
            //Klappt so nicht da der Link des Photos nicht im richtigen Format ist.
            binding.ivMarsImg.load(marsPhotos[3].getFormatedMarsPicture())
        }


    }
}