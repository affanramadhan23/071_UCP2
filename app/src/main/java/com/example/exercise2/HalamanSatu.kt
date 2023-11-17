package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    OnSubmitButtonClicked:(MutableList<String>) -> Unit,
) {
    var namamaha by rememberSaveable { mutableStateOf("") }
    var NIM by rememberSaveable { mutableStateOf("") }
    var konsentrasi by remember { mutableStateOf("") }
    var judulskrip by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(namamaha, NIM, konsentrasi,judulskrip)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value = namamaha ,
            onValueChange = {namamaha = it},
            label = { Text(text = "Nama Mahasiswa") })
        OutlinedTextField(
            value = NIM ,
            onValueChange = {NIM = it},
            label = { Text(text = "NIM") })
        OutlinedTextField(
            value = konsentrasi ,
            onValueChange = {konsentrasi = it},
            label = { Text(text = "konsentrasi") })
        OutlinedTextField(
            value = judulskrip ,
            onValueChange = {judulskrip = it},
            label = { Text(text = "judulskripsi") })
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {OnSubmitButtonClicked(listData)}) {
            Text(text = stringResource(id = R.string.Submit))
        }
    }
}