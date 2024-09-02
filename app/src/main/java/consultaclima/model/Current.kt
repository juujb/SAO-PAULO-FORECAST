package consultaclima.model

import com.google.gson.annotations.SerializedName
data class Current (
    @SerializedName("temperature_2m" ) var temperaturaAtual  : Double? = null,
    @SerializedName("is_day"         ) var dia         : Int?  = null,
    @SerializedName("weather_code"   ) var codigoClima : Int?    = null
)
