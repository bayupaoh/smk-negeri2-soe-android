package id.sch.smkn2soe.api

import id.sch.smkn2soe.model.Results
import id.sch.smkn2soe.model.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by DODYDMW19 on 8/3/2017.
 */

interface APIService {

    @GET("users")
    fun getMembers(
            @Query("per_page") perPage: Int,
            @Query("page") page: Int): Flowable<Results<User>>

}
