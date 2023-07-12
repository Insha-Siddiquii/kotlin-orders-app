package com.example.kotlin_orders_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_orders_app.R
import com.example.kotlin_orders_app.data.model.Order

class OrderItemAdapter(private val context: Context, private val orderList: List<Order>) :
    RecyclerView.Adapter<OrderItemAdapter.OrderViewHolder>() {
    class OrderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val orderIdTextView: TextView = view.findViewById(R.id.orderIdTextView)
        val orderDescTextView: TextView = view.findViewById(R.id.orderDescTextView)

    }

    //Inflates a viewHolder to the parent i.e. recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.order_list_item, parent, false)

        return OrderViewHolder(adapterLayout)

    }

    //Binds the data to viewHolder widget(s)
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = orderList[position]
        holder.orderIdTextView.text = context.getString(R.string.order_id, item.id)
        holder.orderDescTextView.text = context.getString(R.string.order_name, item.description)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}