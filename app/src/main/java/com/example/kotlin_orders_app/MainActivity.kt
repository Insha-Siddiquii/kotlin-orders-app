package com.example.kotlin_orders_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_orders_app.databinding.ActivityMainBinding
import com.example.kotlin_orders_app.ui.adapter.OrderItemAdapter
import com.example.kotlin_orders_app.ui.view_model.OrderUiState
import com.example.kotlin_orders_app.ui.view_model.OrderViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private val orderViewModel: OrderViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.orderRecyclerView
        fetchOrders(this)


    }

    private fun fetchOrders(mainActivity: MainActivity) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                orderViewModel.ordersUiState.collect { uiState ->
                    //here receive the new values, for example
                    //loading --> success with data
                    //loading --> error
                    when (uiState) {
                        is OrderUiState.Loading -> Log.d(
                            TAG,
                            "From mainActivity Order Data Loading.."
                        )
                        is OrderUiState.Success -> {
                            Log.d(
                                TAG,
                                "From mainActivity Order Data Success ${uiState.orders[0].status} "
                            )
                            recyclerView.adapter = OrderItemAdapter(mainActivity, uiState.orders)

                        }
                        else -> {
                            val errorState = uiState as OrderUiState.Error
                            Log.d(
                                TAG,
                                "From mainActivity Order Data Error ${errorState.errorMessage}"
                            )
                        }
                    }

                }
            }
        }

    }
}