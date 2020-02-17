package com.vadimkor.passwordmanagerv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class AddUserFragment : Fragment() {

    companion object {
        fun newInstance() = AddUserFragment()
    }

    private lateinit var viewModel: AddUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
