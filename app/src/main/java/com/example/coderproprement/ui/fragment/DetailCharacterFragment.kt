package com.example.coderproprement.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.coderproprement.R
import com.example.coderproprement.ui.CharacterListViewModel
import com.example.coderproprement.ui.DetailCharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailCharacterFragment : Fragment() {

    private var viewModel: DetailCharacterViewModel by viewModel()
    private val viewModelListCharacter: CharacterListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.detail_character_fragment, container, false)
        val observerIdCharacter = viewModelListCharacter.idCharacter
        val observer = viewModel.Character(viewModelListCharacter.idCharacter.toString())
        val name: TextView = root.findViewById(R.id.nameDetail)
        val description: TextView = root.findViewById(R.id.descriptionDetail)
        val picture : ImageView = root.findViewById(R.id.pp)

        observer.observe(viewLifecycleOwner){
            name.text = it.data.result.first().name
            description.text = it.data.result.first().description
            picture.load("${it.data.result.first().thumbnail.path}.${it.data.result.first().thumbnail.extension}")
        }

        return root
    }

}
