package com.example.fiapclimatempo.screens

import android.os.Build
import android.view.WindowInsetsAnimation
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import consultaclima.model.DadosDiaFuturo
import consultaclima.model.RawResponse
import consultaclima.service.ClimaService
import consultaclima.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date


// Fazer telinha para mostra o clima (se necessário, fazer componentes na pasta específica)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClimateForecast(navController: NavController, lat: String?, long: String?, city: String?) {
    var listaClimaState by remember { mutableStateOf(listOf<DadosDiaFuturo>()) }
    var atualTemperaturaState by remember { mutableStateOf(0.0) }
    var atualTempsMinState by remember { mutableStateOf(0.0) }
    var atualTempsMaxState by remember { mutableStateOf(0.0) }
    var nivelNuvensState by remember { mutableStateOf("") }

    Box(modifier = Modifier.background(Color.Cyan)){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "$city",
                fontSize = 32.sp)

            Text(text = "$atualTemperaturaState")
            Row(){
                Text(text = "$nivelNuvensState")
            }
            Row(){
                Text(text = "$atualTempsMinState")
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "$atualTempsMaxState")
            }
            LazyColumn {
                items(listaClimaState) {
                    Row() {
                        Text(text = it.dataDia.toString())
                        Spacer(modifier = Modifier.width(160.dp))
                        Text(text = it.minTemp.toString())
                        Spacer(modifier = Modifier.width(160.dp))
                        Text(text = it.maxTemp.toString())
                    }
                }
            }
        }
    }



        var lista = mutableListOf<DadosDiaFuturo>()
        if (lat != null && long != null) {
            val call = RetrofitFactory().getClimaService().getClima(lat, long)
            call.enqueue(object : Callback<RawResponse> {
                override fun onResponse(
                    call: Call<RawResponse>,
                    response: Response<RawResponse>
                ) {
                    //pega a temp atual e lista todas as temperaturas dos 6 dias seguintes
                    atualTemperaturaState = response.body()?.current?.temperaturaAtual!!
                    atualTempsMinState = response.body()?.daily?.temperature2mMin?.get(0)!!
                    atualTempsMaxState = response.body()?.daily?.temperature2mMax?.get(0)!!
                    nivelNuvensState = getNivelNuvens(response.body()?.current?.codigoClima!!)

                    val responseDias = response.body()!!?.daily
                    if (responseDias != null) {
                        for (i in 1..responseDias.temperature2mMax.size-1) {
                            val dadosDia = DadosDiaFuturo(
                                responseDias.temperature2mMin[i],
                                responseDias.temperature2mMax[i],
                                formatDate(responseDias.time[i])
                            )

                            lista.add(dadosDia)
                        }
                        listaClimaState = lista!!
                    }
                }

                override fun onFailure(call: Call<RawResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        }

    }
fun getNivelNuvens(codigoClima: Int) : String{
    var result = ""
    if(codigoClima in 0..2){
        result = "Ensolarado"
    }
    if(codigoClima in 3..5){
        result = "Parcialmente nublado"
    }
    if(codigoClima in 6..8){
        result = "Nublado"
    }
    if(codigoClima in 9..10){
        result = "Extremamente nublado"
    }

    return result
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(data : String) : String{
    val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val newformat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM")
    return LocalDate.parse(data, formatter).format(newformat)

}