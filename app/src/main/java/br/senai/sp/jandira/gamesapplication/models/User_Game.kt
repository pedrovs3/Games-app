package br.senai.sp.jandira.gamesapplication.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class User_Game (
  @Embedded val user: User,
  @Relation(
      parentColumn = "user_id",
      entityColumn = "created_by"
  )
  val games: List<Game>
)