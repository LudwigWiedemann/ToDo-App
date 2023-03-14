package com.example.todotracer.ui.main

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todotracer.ToDo
import com.example.todotracer.databinding.FragmentMainBinding
import java.time.LocalDate
import java.util.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val btnOne = binding.btnOne
        val recyclerView = binding.recyclerView
        val dataSet = arrayListOf(
            ToDo("Clean kitchen", "i really should do that", "Chores", LocalDate.now(), "Medium"),
            ToDo("Read a book", "that will be relaxin", "Chill", LocalDate.now(), "High"),
            ToDo("Sleep more", "if I don' sleep enough that is not good", "MUST!!", LocalDate.now(), "Critical")
        )
        val adapter = ToDoAdapter(dataSet)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)


        btnOne.setOnClickListener {
            dataSet.add(ToDo("Code even more", "Coding is fun :) ", "Chill", LocalDate.now(), "medium"))
            adapter.notifyItemInserted(dataSet.size)
        }
        return binding.root
    }
}