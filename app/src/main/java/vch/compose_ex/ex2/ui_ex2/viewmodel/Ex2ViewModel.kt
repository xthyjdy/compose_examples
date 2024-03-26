package vch.compose_ex.ex2.ui_ex2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import vch.compose_ex.ex2.data.Ex2AppConstants
import vch.compose_ex.ex2.data.entity.Ex2ApiNewsResponse
import vch.compose_ex.ex2.ui_ex2.repository.Ex2Repository
import vch.utilities.ResourceState
import javax.inject.Inject

@HiltViewModel
class Ex2ViewModel @Inject constructor(
    private val repository: Ex2Repository
) : ViewModel() {
    private val _news: MutableStateFlow<ResourceState<Ex2ApiNewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<Ex2ApiNewsResponse>> = _news

    init {
        getNewsHeadline(Ex2AppConstants.COUNTRY)
    }

    private fun getNewsHeadline(country: String) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.getNewsHeadline(country)
                .collectLatest { response ->
                    _news.value = response
                }
        }
    }
}