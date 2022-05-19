package com.example.coderproprement.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coderproprement.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coderproprement.ui.CharacterListViewModel
import com.example.coderproprement.ui.activity.MainActivity
import com.example.coderproprement.ui.adapter.AdapterMarvel

class CharacterListFragment : Fragment() {

    private val viewModel: CharacterListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.character_list_fragment, container, false)

        val observer = viewModel.allCharacters()
        val recyclerView = root.findViewById<RecyclerView>(R.id.marvelRecyclerView)

        val navHostFragment = activity?.supportFragmentManager
            ?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        observer.observe(viewLifecycleOwner){
            val adapter = AdapterMarvel(it, navController,viewModel)
            root.let { it1 -> recyclerView?.findContainingItemView(it1) }
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
            recyclerView?.layoutManager = layoutManager
            recyclerView?.adapter = adapter
        }
        return root
    }

}