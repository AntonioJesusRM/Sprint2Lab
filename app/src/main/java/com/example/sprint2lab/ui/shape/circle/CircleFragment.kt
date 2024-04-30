package com.example.sprint2lab.ui.shape.circle

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sprint2lab.databinding.FragmentCircleBinding

class CircleFragment : Fragment() {
    private var _binding: FragmentCircleBinding? = null
    val binding get() = _binding!!
    private val circleViewModel: CircleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircleBinding.inflate(inflater, container, false)
        setForm()
        return binding.root
    }

    private fun setForm() {
        binding.wvForm.setBackgroundColor(Color.TRANSPARENT)
        binding.wvForm.loadDataWithBaseURL(
            null,
            circleViewModel.returnCircleForm(),
            "text/html",
            "UTF-8",
            null
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getRadius(): Double? {
        return binding.etRadio.text.toString().toDoubleOrNull()
    }
}