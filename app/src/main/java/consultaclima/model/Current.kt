package consultaclima.model

import com.google.gson.annotations.SerializedName
data class Current (
    @SerializedName("temperature_2m" ) var climaAtual  : Double? = null,
    @SerializedName("is_day"         ) var dia         : Boolean?  = null,
    @SerializedName("weather_code"   ) var codigoClima : Int?    = null
)
