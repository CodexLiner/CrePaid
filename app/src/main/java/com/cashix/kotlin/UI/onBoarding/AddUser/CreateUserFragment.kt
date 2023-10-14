package com.cashix.kotlin.UI.onBoarding.AddUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cashix.R
import com.cashix.databinding.FragmentCreateUserBinding
import com.cashix.utils.SnakeBar
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class CreateUserFragment : Fragment() {
    private val viewModel: CreateUserViewModel by viewModels()
    lateinit var binding: FragmentCreateUserBinding

    companion object {
        fun newInstance() = CreateUserFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCreateUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.UsersName.text.toString())) {
                SnakeBar(requireActivity()).showSnackbar("Name is Required")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(binding.UsersEmail.text.toString())) {
                SnakeBar(requireActivity()).showSnackbar("Email is Required")
                return@setOnClickListener
            }
            viewModel.saveUserProfile(
                binding.UsersName.text.toString(),
                binding.UsersEmail.text.toString(),
                binding.UsersAreaPinCode.text.toString()
            )
            next()

        }
    }

    private fun next() {
        viewModel.responseAddingUser.observe(viewLifecycleOwner) {

        }
    }

}