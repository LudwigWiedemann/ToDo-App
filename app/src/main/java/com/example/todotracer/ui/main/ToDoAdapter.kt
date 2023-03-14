package com.example.todotracer.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todotracer.R
import com.example.todotracer.ToDo

class ToDoAdapter (private val dataSet: ArrayList<ToDo>) :
    RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View
        val tv_name: TextView = view.findViewById(R.id.tv_name)
        val tv_desc: TextView = view.findViewById(R.id.tv_desc)
        val tv_cat: TextView = view.findViewById(R.id.tv_cat)
        val tv_due: TextView = view.findViewById(R.id.tv_due)
        val tv_crit: TextView = view.findViewById(R.id.tv_crit)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.todo_list_element, viewGroup, false)
        Log.i("ADAPTER", "onCreateViewHolder")
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tv_name.text = dataSet[position].name
        viewHolder.tv_desc.text = dataSet[position].description
        viewHolder.tv_cat.text = dataSet[position].category
        viewHolder.tv_due.text = dataSet[position].dueDate.toString()
        viewHolder.tv_crit.text = dataSet[position].urgency
        Log.i("ADAPTER", "onBindViewHolder")
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}