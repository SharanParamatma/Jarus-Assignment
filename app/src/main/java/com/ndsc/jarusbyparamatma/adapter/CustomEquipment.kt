package com.ndsc.jarusbyparamatma.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ndsc.jarusbyparamatma.R
import com.ndsc.jarusbyparamatma.databinding.ItemRowBinding
import com.ndsc.jarusbyparamatma.model.Equipment

class CustomEquipment(private var list: List<Equipment>) : RecyclerView.Adapter<CustomEquipment.AlertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        val binding: ItemRowBinding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlertViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) = holder.bind(list[position])
    override fun getItemCount(): Int = list.size

    inner class AlertViewHolder(private val itemBinding: ItemRowBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        private lateinit var equipment: Equipment

        fun bind(item: Equipment) {
            this.equipment = item
            itemBinding.checkBox2.isChecked = true
            itemBinding.tvId.text = item.id.toString()
            itemBinding.tvEquipment.text=item.make

            itemBinding.constraintLayout.setOnClickListener {
                itemBinding.arrow.setBackgroundResource(R.drawable.arrow_down_24)
                itemBinding.constraintLayout1.visibility= View.VISIBLE
                itemBinding.vin.text=item.vin
                itemBinding.year.text= item.year.toString()
                itemBinding.make.text=item.make
                itemBinding.value.text= item.value.toString()
                itemBinding.length.text=item.length.toString()
            }
            itemBinding.arrow.setBackgroundResource(R.drawable.arrow_right_24)
            itemBinding.constraintLayout1.visibility= View.GONE
        }
    }
}