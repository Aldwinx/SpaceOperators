package com.cci.spaceoperators.players.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "players_id")
    val id: Int,

    @ColumnInfo(name = "players_username")
    val name: String,

    val port: String,

    val status: Boolean,
)



