@file:OptIn(ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class)

package com.example.skripsi

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skripsi.data.SumberData.dosen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class PengelolaHalaman{
    Home,
    Form,
    Summary
}

@Composable
fun FormulirAppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(title = { Text(stringResource(id = R.string.app_name))},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor =
            MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (bisaNavigasiBack){
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription =
                        stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirApp(
    viewModel: TampilViewModel = viewModel(),
    viewModelForm: TampilViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold(
        topBar = {
            FormulirAppBar(
                bisaNavigasiBack = false,
                navigasiUp = { /*TODO*/
                }
            )
        }
    ){ innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Form.name)
                    })
            }
            composable(route = PengelolaHalaman.Form.name){
                val context = LocalContext.current
                HalamanForm(
                    pilihanDosen = dosen.map { id ->
                        context.resources.getString(id) },
                    onSelectionChanged = { viewModelForm.setDosen(it) },
                    onSubmitButtonClicked = {
                        viewModelForm.setBiodata(it)
                        navController.navigate(PengelolaHalaman.Summary.name)
                    },
                    onBackButtonClicked = {
                        navController.popBackStack(
                            PengelolaHalaman.Form.name,
                            false
                        )
                    })
            }
            composable(route = PengelolaHalaman.Summary.name) {
                HalamanHasil(
                    pengajuanUIState = uiState,

                    onCancelButtonClicked = {
                        cancelAndNavigateToForm(
                            viewModel,
                            navController,
                        )
                    }
                    )
            }

            }
        }
    }


private fun cancelAndNavigateToForm(
    viewModel: TampilViewModel,
    navController: NavHostController
){
    viewModel.resetForm()
    navController.popBackStack(PengelolaHalaman.Form.name, inclusive = false)
}
