package ru.levelp.dagger2.api

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.RequestManager
import ru.levelp.dagger2.R


class CarsAdapter(val cars: List<Car>, val imageRequestManager: RequestManager): RecyclerView.Adapter<CarsAdapter.Companion.ViewHolder>() {
    override fun getItemCount() = cars.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_car, parent, false)
        return ViewHolder(view, imageRequestManager)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindTo(cars[position])
    }

    companion object {
        class ViewHolder(itemView: View, val imageRequestManager: RequestManager): RecyclerView.ViewHolder(itemView){

            private val imageView = itemView.findViewById(R.id.imageView) as ImageView
            private val nameView = itemView.findViewById(R.id.nameView) as TextView
            private val vinView = itemView.findViewById(R.id.vinView) as TextView

            fun bindTo(car: Car){

                imageRequestManager.load(car.image).into(imageView)
                nameView.text = car.name
                vinView.text = car.vin
            }

        }
    }
}