package dev.vengateshm.samplekmm.android.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.samplekmm.stock_app.domain.model.StockExchange
import dev.vengateshm.samplekmm.stock_app.domain.usecase.GetAllStockExchangesListUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getAllStockExchangesListUseCase: GetAllStockExchangesListUseCase,
) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())

    init {
        getAllStockExchanges()
    }

    private fun getAllStockExchanges() {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            uiState = try {
                val result = getAllStockExchangesListUseCase()
                uiState.copy(stockExchangeList = result, loading = false)
            } catch (e: Exception) {
                uiState.copy(
                    errorMessage = "Error loading Stock Exchange list ${if (!e.localizedMessage.isNullOrEmpty()) " : ${e.localizedMessage}" else ""}",
                    loading = false
                )
            }
        }
    }
}

data class HomeScreenState(
    var loading: Boolean = false,
    var stockExchangeList: List<StockExchange> = emptyList(),
    var errorMessage: String = "",
)