package br.senai.sp.jandira.gamesapplication.dao

import android.content.Context
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.models.Game

class GamesDAO {

    companion object{
        fun getGamesRegistered(context: Context): List<Game>{
            val g1 = Game(1,
            "Street Fighter",
            "Capcom",
            "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta na qual o jogador controla lutadores de diversas partes do mundo, cada qual com seus golpes especiais.",
            )
            g1.imagem = context.getDrawable(R.drawable.street_fighter)

            val g2 = Game(2,
                "CSGO",
                "Valve",
                "Counter-Strike: Global Offensive é um jogo online desenvolvido pela Valve Corporation e pela Hidden Path Entertainment, sendo uma sequência de Counter-Strike: Source. É o quarto título principal da franquia.",
            )
            g2.imagem = context.getDrawable(R.drawable.csgo)

            val g3 = Game(3,
                "God of War",
                "Santa Monica",
                "God of War é uma série de jogos eletrônicos de ação-aventura criada por David Jaffe da Santa Monica Studio, da Sony. Iniciada em 2005 no console PlayStation 2",
            )
            g3.imagem = context.getDrawable(R.drawable.god_of_war)

            val g4 = Game(4,
                "World of Warcraft",
                "Blizzard",
                "World of Warcraft é um jogo on-line do gênero MMORPG, desenvolvido e distribuído pela produtora Blizzard Entertainment e lançado em 2004. O jogo se passa no mundo fantástico de Azeroth, introduzido no primeiro jogo da série.",
            )
            g4.imagem = context.getDrawable(R.drawable.wow)

            val gamesRegistered =  listOf<Game>(g1, g2, g3, g4)

            return gamesRegistered
        }
    }
}