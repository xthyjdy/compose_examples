package vch.compose_ex.ex2.ui_ex2.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import vch.compose_ex.Helper.l
import vch.compose_ex.ex2.ui_ex2.components.EmptyComponent
import vch.compose_ex.ex2.ui_ex2.components.Loader
import vch.compose_ex.ex2.ui_ex2.components.NewsRowComponent
import vch.compose_ex.ex2.ui_ex2.components.NormalTextComponent
import vch.compose_ex.ex2.ui_ex2.viewmodel.Ex2ViewModel
import vch.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: Ex2ViewModel = hiltViewModel()
) {
    val newsResponse by viewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    )

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp,
        pageCount = 10 //! remove to rememberPagerState (increase dependency version)
    ) { page: Int ->
        when (newsResponse) {
            is ResourceState.Loading -> {
                Loader()
            }
            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                if (response.articles.isNotEmpty()) {
                    NewsRowComponent(page, response.articles[page])
                } else { EmptyComponent() }
            }
            is ResourceState.Error -> {
                val error = (newsResponse as ResourceState.Error)
                NormalTextComponent(textValue = "Error: $error")
                l("error: $error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}