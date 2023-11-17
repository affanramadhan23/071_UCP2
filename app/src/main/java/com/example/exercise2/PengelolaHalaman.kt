package com.example.exercise2

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exercise2.data.FormUIState

enum class PengelolaHalaman {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ContactApp(
    viewModel: FormViewModel = ViewModel,
    navController: NavController = rememberNavController()
) {
    Scaffold {
            innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Formulir.name,
            modifier = Modifier.padding(innerPadding)

        ) {
            composable(PengelolaHalaman.Formulir.name) {
                HalamanSatu(
                    OnSubmitButtonClicked = {
                        viewModel.setContact(it)
                    }
                )
            }
            composable(PengelolaHalaman.Formulir.name) {
                HalamanSatu(
                    OnSubmitButtonClicked = {
                        viewModel.setContact(it)
                        navController.navigate(PengelolaHalaman.Detail.name)
                    }
                )
            }
            composable(PengelolaHalaman.Detail.name) {
                HalamanDua(
                    FormUIState = uiState,
                    onBackButtonClicked = {
                        navController.popBackStack(PengelolaHalaman.Formulir.name, false)
                    }
                )
            }
        }
    }
}
