package com.androiddevsbsas.githubrepos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* TODO EJERCICIO
        * Consumir el listado de repositorios publicos utilizando la clase GitHubApiClient
        * GitHubApiClient.gitHubApi.getPublicRepositories() // Devuelve un listado de GitHubRepo. List<GitHubRepo>
        * Crear un adapter para mostrarlos los repos en un RecyclerView. Utilizar layout item_repo.xml
        * Configurar e inicializar RecyclerView y adapter
        * */

    }
}
