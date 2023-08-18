package br.senai.sp.jandira.retrofit_reqre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        // Click do Botão GET
        findViewById<Button>(R.id.btnGET).setOnClickListener{
            getUserById()

        } // Click do Botão POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener{
            createUser()
        }
     // Click do Botão PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener{
            updateUser()

        }
        // Click do Botão PUT
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{
            deleteUser()
        }

    }

    // RECUPERA DADOS DO USUARIO
    private fun getUserById() {
        lifecycleScope.launch {
            // Chamada para o endPoint
            val result = apiService.getUserById("4")

            if (result.isSuccessful) {

                Log.i("DSM","${result.body()?.data}")

            } else {

                Log.i("erro","${result.message()}")

            }

        }
    }

    private fun createUser() {

        lifecycleScope.launch {

            val body = JsonObject().apply {
                addProperty("name", "GUILHERME LIMA")

                addProperty("Job", "Estudante SENAI JANDIRA")
            }

            val result = apiService.createUser(body)

            if (result.isSuccessful) {

                Log.i("CreateUser", "${result.body()}")

            } else {

                Log.i("CreateERRO", "${result.message()}")

            }

        }
    }

    private fun updateUser() {

        lifecycleScope.launch {

            val body = JsonObject().apply {

                addProperty("name", "GUILHERME LIMA")

                addProperty("Job", "Estudante SENAI JANDIRA")
            }

            val result = apiService.updateUser("2", body)

            if (result.isSuccessful) {

                Log.i("UpdateUser", "${result.body()}")

            } else {

                Log.i("UpdateERRO", "${result.message()}")

            }
        }

    }

    //EXCLUIR DADOS DO USUARIO
    private fun deleteUser() {

        lifecycleScope.launch {

            val result = apiService.deleteUser("2")

            if (result.isSuccessful) {

                Log.i("DeleteUser", "${result}")


            } else {

                Log.i("DeleteERRO", "${result.message()}")


            }


        }

    }



}