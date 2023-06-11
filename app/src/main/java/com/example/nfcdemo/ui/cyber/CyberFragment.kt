package com.example.nfcdemo.ui.cyber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfcdemo.databinding.FragmentCyberBinding

class CyberFragment : Fragment() {

    private var _binding: FragmentCyberBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cyberViewModel =
            ViewModelProvider(this).get(CyberViewModel::class.java)

        _binding = FragmentCyberBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCyber
        cyberViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}