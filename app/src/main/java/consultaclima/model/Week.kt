package consultaclima.model
import com.google.gson.annotations.SerializedName


data class Week (
    @SerializedName("time"               ) var time             : ArrayList<String> = arrayListOf(),
    @SerializedName("temperature_2m_max" ) var temperature2mMax : ArrayList<Double> = arrayListOf(),
    @SerializedName("temperature_2m_min" ) var temperature2mMin : ArrayList<Int>    = arrayListOf()

)