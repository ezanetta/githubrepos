package com.androiddevsbsas.githubrepos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.androiddevsbsas.githubrepos.model.GitHubRepo
import com.androiddevsbsas.githubrepos.networking.GitHubApiClient
import com.androiddevsbsas.githubrepos.ui.GitHubRepoItemDecoration
import com.androiddevsbsas.githubrepos.ui.RepoListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<GitHubRepo>> {

    private lateinit var repositories: List<GitHubRepo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* TODO EJERCICIO
        * Consumir el listado de repositorios publicos utilizando la clase GitHubApiClient
        * GitHubApiClient.gitHubApi.getPublicRepositories() // Devuelve un listado de GitHubRepo. List<GitHubRepo>
        * Crear un adapter para mostrarlos los repos en un RecyclerView. Utilizar layout item_repo.xml
        * Configurar e inicializar RecyclerView y adapter
        * */

        val call = GitHubApiClient.gitHubApi.getPublicRepositories()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<List<GitHubRepo>>?, t: Throwable?) {
        setupErrorResponse()
    }

    override fun onResponse(call: Call<List<GitHubRepo>>?, response: Response<List<GitHubRepo>>?) {
        if (response?.isSuccessful!!) {
            repositories = response.body()!!
            setupRecycler()
            hideLoading()
        } else {
            setupErrorResponse()
        }
    }

    private fun hideLoading() {
        loading.visibility = View.GONE
    }

    private fun setupRecycler() {
        val adapter = RepoListAdapter(repositories)
        val layoutManager = LinearLayoutManager(this)
        repoRecycler.addItemDecoration(GitHubRepoItemDecoration(resources.getDimensionPixelOffset(R.dimen.mid_size)))
        repoRecycler.layoutManager = layoutManager
        repoRecycler.adapter = adapter
    }

    private fun setupErrorResponse() {
        hideLoading()
        repositories = arrayListOf()
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }

}
