package com.example.nfcdemo.ui.jongjung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfcdemo.databinding.FragmentJongjungBinding

class JongjungFragment : Fragment() {

    private var _binding: FragmentJongjungBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val jongjungViewModel =
            ViewModelProvider(this).get(JongjungViewModel::class.java)

        _binding = FragmentJongjungBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView : TextView = binding.textJongjung
        jongjungViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}