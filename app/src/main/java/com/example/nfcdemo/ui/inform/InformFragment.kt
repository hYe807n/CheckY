package com.example.nfcdemo.ui.inform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfcdemo.databinding.FragmentInformBinding

class InformFragment : Fragment() {

    private var _binding: FragmentInformBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val informViewModel =
            ViewModelProvider(this).get(InformViewModel::class.java)

        _binding = FragmentInformBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textInform
        informViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}