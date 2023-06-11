package com.example.nfcdemo.ui.inform

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfcdemo.MainActivity
import com.example.nfcdemo.R
import com.example.nfcdemo.databinding.ActivityMainBinding
import com.example.nfcdemo.databinding.FragmentInformBinding
import com.google.android.material.navigation.NavigationView

class InformFragment : Fragment() {

    private var _binding: FragmentInformBinding? = null
    private val binding get() = _binding!!
    private lateinit var informViewModel : InformViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        informViewModel =
            ViewModelProvider(this).get(InformViewModel::class.java)

        _binding = FragmentInformBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // hayeon)
        val username: TextView = binding.informUsername
        val userid: TextView = binding.informUserid
        val userprofile: ImageView = binding.informProfile

        // hayeon) sharedPreference for name, id
        val sharedPreference = context?.getSharedPreferences("file name", Context.MODE_PRIVATE)
        val informName = sharedPreference?.getString("username", "")
        val informId = sharedPreference?.getString("userid", "")

        informViewModel.name.observe(viewLifecycleOwner) {
            username.text = informName
        }
        informViewModel.id.observe(viewLifecycleOwner) {
            userid.text = informId
        }

        userprofile.setImageResource(R.drawable.profile)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}