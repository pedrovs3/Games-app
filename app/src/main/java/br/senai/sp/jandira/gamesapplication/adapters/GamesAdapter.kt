package br.senai.sp.jandira.gamesapplication.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.HolderLayoutBinding
import br.senai.sp.jandira.gamesapplication.models.Game

class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderPt>() {

    private var gamesList = listOf<Game>()

    fun updateGamesList(game: List<Game>){
        this.gamesList = game
        notifyDataSetChanged()
    }

    class HolderPt(view: View) : RecyclerView.ViewHolder(view) {
        val produtoraPt = view.findViewById<TextView>(R.id.text_view_produtora)
        val titlePt = view.findViewById<TextView>(R.id.text_view_title)
        val descriptionPt = view.findViewById<TextView>(R.id.text_View_description)
        val imagePt = view.findViewById<ImageView>(R.id.image_holder)

        fun bind(game: Game) {
            produtoraPt.text = game.estudio
            titlePt.text = game.titulo
            descriptionPt.text = game.descricao
            imagePt.setImageDrawable(R.drawable.street_fighter.toDrawable())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPt {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)

        return HolderPt(view)
    }

    override fun onBindViewHolder(holder: HolderPt, position: Int) {
        holder.bind(this.gamesList[position])
    }

    override fun getItemCount(): Int {
        return this.gamesList.size
    }
}