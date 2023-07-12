package com.example.kotlin_orders_app.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_orders_app.domain.use_case.GetOrdersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

const val TAG = "OrderViewModel"

class OrderViewModel(
    private val orderUseCase: GetOrdersUseCase,
) : ViewModel() {

    //for internal usage
    private val _ordersUiState =
        MutableStateFlow<OrderUiState>(OrderUiState.Loading(isLoading = true))

    //for public outsiders usage
    val ordersUiState: StateFlow<OrderUiState> = _ordersUiState

    init {
        fetchOrders()
    }

    private fun fetchOrders() {
        viewModelScope.launch(Dispatchers.IO) {
            orderUseCase.fetchOrders().let { response ->

                response.collect {
                    //success case
                    if (it.status) {
                        _ordersUiState.value = OrderUiState.Success(it.data.orders)
                        //error case
                    } else {
                        _ordersUiState.value = OrderUiState.Error("Something went wrong")
                    }
                }
            }
        }
    }
}