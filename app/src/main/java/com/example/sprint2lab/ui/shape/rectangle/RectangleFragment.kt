package com.example.sprint2lab.ui.shape.rectangle

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sprint2lab.databinding.FragmentRectangleBinding

class RectangleFragment : Fragment() {
    private var _binding: FragmentRectangleBinding? = null
    val binding get() = _binding!!
    private val rectangleViewModel: RectangleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRectangleBinding.inflate(inflater, container, false)
        setForm()
        return binding.root
    }

    private fun setForm() {
        binding.wvForm.setBackgroundColor(Color.TRANSPARENT)
        binding.wvForm.loadDataWithBaseURL(
            null,
            rectangleViewModel.returnRectangleForm(),
            "text/html",
            "UTF-8",
            null
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getBase(): Double? {
        return binding.etBase.text.toString().toDoubleOrNull()
    }

    fun getHeight(): Double? {
        return binding.etHeight.text.toString().toDoubleOrNull()
    }
}