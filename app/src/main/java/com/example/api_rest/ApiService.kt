import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/hello")
    fun getHello(): Call<String>
}