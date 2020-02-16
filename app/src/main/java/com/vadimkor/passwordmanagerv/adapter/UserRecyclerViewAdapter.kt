package com.vadimkor.passwordmanagerv.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vadimkor.passwordmanagerv.R
import com.vadimkor.passwordmanagerv.model.UserEntity


class UserRecyclerViewAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<UserRecyclerViewAdapter.UserVH>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<UserEntity>() // Cached copy of users

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserVH {
        val itemView = inflater.inflate(R.layout.rv_item, parent, false)
        return UserVH(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val current = users[position]
        holder.userItemWebsite.text = current.website.toUpperCase()
        holder.userItemLogin.text = current.login
        holder.userItemPassword.text = current.password

        val isExpanded: Boolean = users[position].expanded
        holder.expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE

        if (isExpanded) {
            holder.imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp)
        } else {
            holder.imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp)
        }

        holder.imageView.setOnClickListener {
            val user = users[position]
            user.expanded = !user.expanded
            notifyItemChanged(position)
        }
    }

    inner class UserVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val userItemWebsite: TextView = itemView.findViewById(R.id.website_rv_item)
        val userItemLogin: TextView = itemView.findViewById(R.id.username_or_email_rv_item)
        val userItemPassword: TextView = itemView.findViewById(R.id.password_rv_item)
        val imageView: ImageView = itemView.findViewById(R.id.iv_rv_item)
        val expandableLayout: androidx.appcompat.widget.LinearLayoutCompat =
            itemView.findViewById(R.id.expandable_layout)
    }

    internal fun setUsers(users: List<UserEntity>) {
        this.users = users
        notifyDataSetChanged()
    }
}
