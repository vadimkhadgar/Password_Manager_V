package com.vadimkor.passwordmanagerv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vadimkor.passwordmanagerv.adapter.UserRecyclerViewAdapter
import com.vadimkor.passwordmanagerv.model.UserEntity
import kotlinx.android.synthetic.main.blank_fragment.*
import kotlinx.android.synthetic.main.floating_action_button.*


class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    lateinit var user: ArrayList<UserEntity>
    private lateinit var adapter: UserRecyclerViewAdapter


    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)


        user = ArrayList()

        user.add(UserEntity("website", "username", "password", false))
        user.add(UserEntity("website", "username", "password", false))
        user.add(UserEntity("website", "username", "password", false))
        user.add(UserEntity("website", "username", "password", false))
        user.add(UserEntity("website", "username", "password", false))


        adapter = UserRecyclerViewAdapter(context!!)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        adapter.setUsers(user)

        floatingActionButton.setOnClickListener {
            replaceFragmentBlankFragment(AddUserFragment())
        }

    }

    private fun replaceFragmentBlankFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_activity_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
