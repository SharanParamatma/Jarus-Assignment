package com.ndsc.jarusbyparamatma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ndsc.jarusbyparamatma.adapter.CustomEquipment
import com.ndsc.jarusbyparamatma.databinding.ActivityMainBinding
import com.ndsc.jarusbyparamatma.viewmodel.EquipmentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EquipmentViewModel
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(EquipmentViewModel::class.java)
        binding.recyclerMain.setHasFixedSize(true)
        binding.recyclerMain.layoutManager = LinearLayoutManager(
           this,
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.recyclerMain.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        viewModel.getData.observe(this,{
            if (it != null){
                val  adapter = CustomEquipment(it)
                binding.recyclerMain.adapter = adapter
            }
        })



    }
}