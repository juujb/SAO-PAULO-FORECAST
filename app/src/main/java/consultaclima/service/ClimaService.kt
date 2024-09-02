package consultaclima.service

import consultaclima.model.Current
import consultaclima.model.Daily
import consultaclima.model.RawResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClimaService {
    /*
    @GET("forecast?latitude={lat}&longitude={long}&current=temperature_2m,is_day,weather_code&daily=temperature_2m_max,temperature_2m_min")
    fun getClima(
        /*
        @Query("lat") lat: String,
        @Query("long") long: String
         */
        ): Call<RawResponse>
     */

    @GET("forecast")
    fun getClima(

        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String,
        @Query("current") current: String = "temperature_2m,is_day,weather_code",
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min",
        @Query("past_days") pastDays: Int = 1



    ): Call<RawResponse>
    /*
    fun getClimaSemana(
        @Path("lat") lat : String,
        @Path("long") long: String
        ): Call<List<Daily>>
     */

}