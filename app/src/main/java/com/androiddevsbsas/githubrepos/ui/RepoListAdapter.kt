package com.androiddevsbsas.githubrepos.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androiddevsbsas.githubrepos.R
import com.androiddevsbsas.githubrepos.model.GitHubRepo
import com.bumptech.glide.Glide

class RepoListAdapter(private val repositories: List<GitHubRepo>)
    : RecyclerView.Adapter<RepoListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)

        return RepositoryViewHolder(itemView)
    }

    override fun getItemCount() = repositories.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bindRepo(repositories.get(position))
    }

    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var avatar: ImageView = itemView.findViewById(R.id.avatar)
        private var description: TextView = itemView.findViewById(R.id.description)
        private var name: TextView = itemView.findViewById(R.id.name)

        fun bindRepo(githubRepo: GitHubRepo) {
            name.text = githubRepo.name
            description.text = githubRepo.description

            Glide.with(itemView)
                    .load(githubRepo.owner.avatarUrl)
                    .into(avatar)
        }
    }
}