package com.example.nfcdemo.ui.checkin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfcdemo.databinding.FragmentCheckinBinding

class CheckinFragment : Fragment() {

    private var _binding: FragmentCheckinBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val checkinViewModel =
            ViewModelProvider(this).get(CheckinViewModel::class.java)

        _binding = FragmentCheckinBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCheckin
        checkinViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}