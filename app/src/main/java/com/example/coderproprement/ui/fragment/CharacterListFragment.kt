package com.example.coderproprement.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coderproprement.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coderproprement.ui.CharacterListViewModel

class CharacterListFragment : Fragment() {

    private val viewModel: CharacterListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.allCharacters()
        return inflater.inflate(R.layout.character_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}