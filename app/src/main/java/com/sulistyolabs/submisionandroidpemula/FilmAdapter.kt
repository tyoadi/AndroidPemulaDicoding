package com.sulistyolabs.submisionandroidpemula

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter(private val ctx: Context, private val listItem: List<FilmModel>, private val  listener: (FilmModel) -> Unit)
    : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilmAdapter.ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_film, parent, false))

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listItem[position],listener, ctx)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(itemFilm: FilmModel, listener: (FilmModel) -> Unit, context: Context) {
            itemView.tv_film_name.text = itemFilm.name
            itemView.tv_film_quotes.text = itemFilm.quote
            Glide.with(itemView.context)
                .load(itemFilm.img)
                .apply(RequestOptions().override(55, 55))
                .into(itemView.img_film)
        }
    }

}