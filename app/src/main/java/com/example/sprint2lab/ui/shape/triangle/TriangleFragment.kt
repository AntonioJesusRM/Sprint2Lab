package com.example.sprint2lab.ui.shape.triangle

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sprint2lab.databinding.FragmentTriangleBinding

class TriangleFragment : Fragment() {
    private var _binding: FragmentTriangleBinding? = null
    private val binding get() = _binding!!
    private val triangleViewModel: TriangleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTriangleBinding.inflate(inflater, container, false)
        setForm()
        return binding.root
    }

    private fun setForm() {
        binding.wvForm.setBackgroundColor(Color.TRANSPARENT)
        binding.wvForm.loadDataWithBaseURL(
            null,
            triangleViewModel.returnTriangleForm(),
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