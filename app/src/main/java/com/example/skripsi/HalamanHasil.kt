package com.example.skripsi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.skripsi.data.PengajuanUIState
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Divider
import androidx.compose.foundation.layout.Spacer

@Composable
fun HalamanHasil (
    pengajuanUIState: PengajuanUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val items = listOf(
        Pair(stringResource(R.string.dosens), pengajuanUIState.dosen)
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier =
            Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement =
            Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            Column {
                Text(text = stringResource (id = R.string.nama), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(text = pengajuanUIState.nama)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                Text(text = stringResource(id = R.string.nim_mhs),fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(text = pengajuanUIState.nim)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                Text(text = stringResource(id = R.string.konsentrasi_mhs), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(text = pengajuanUIState.konsentrasi)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                Text(text = stringResource(id = R.string.judul_skripsi), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(text = pengajuanUIState.judul)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            }
            items.forEach{ item ->
                Column{
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight =
                    FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){

                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ){
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}