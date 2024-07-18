package com.example.s7_ejerciciobasedatos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.s7_ejerciciobasedatos.adapter.CityViewModel
import com.example.s7_ejerciciobasedatos.adapter.CityViewModelFactory
import com.example.s7_ejerciciobasedatos.dao.DatabaseBuilder
import com.example.s7_ejerciciobasedatos.databinding.FragmentEditCityBinding
import com.example.s7_ejerciciobasedatos.databinding.FragmentListCityBinding
import com.example.s7_ejerciciobasedatos.entities.City
import java.security.acl.Owner
import kotlin.concurrent.fixedRateTimer


class editCityFragment : Fragment() {
    private lateinit var binding: FragmentEditCityBinding

    private val cityViewModel : CityViewModel by viewModels {
        CityViewModelFactory(DatabaseBuilder.getInstance(requireContext()).cityDAO())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditCityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments ?: return
        val city_id = arguments.getInt("city_id")

        showData(city_id)

        binding.btnSave.setOnClickListener{
            val updateCity = City(
                id = binding.tvIdCity.text.toString().toInt(),
                name = binding.tfName.editText?.text.toString(),
                description = binding.tfDescription.editText?.text.toString(),
                 population = binding.tfPopulation.editText?.text.toString().toInt()
            )
            cityViewModel.updateCity(updateCity)
            Toast.makeText(context, "Registro Actualizado", Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        }
    }

    private fun showData(cityId: Int) {
        cityViewModel.getCity(cityId).observe(viewLifecycleOwner, Observer {
            city-> city?.let{
                binding.tvIdCity.text = it.id.toString()
                binding.tfName.editText?.setText(it.name)
                binding.tfDescription.editText?.setText(it.description)
                binding.tfPopulation.editText?.setText(it.population.toString())
        }
        })
    }

}