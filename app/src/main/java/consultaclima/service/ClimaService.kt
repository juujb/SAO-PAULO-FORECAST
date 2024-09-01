package consultaclima.service

import consultaclima.model.Current
import consultaclima.model.Week
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClimaService {
    @GET("https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={long}&current=temperature_2m,is_day,weather_code&daily=temperature_2m_max,temperature_2m_min")
    fun getClima(
        @Path("lat") lat: String,
        @Path("long") long: String
        ): Call<Current>
    fun getClimaSemana(
        @Path("lat") lat : String,
        @Path("long") long: String
        ): Call<List<Week>>

}