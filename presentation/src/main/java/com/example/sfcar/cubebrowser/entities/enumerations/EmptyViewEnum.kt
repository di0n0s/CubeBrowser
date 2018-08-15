package com.example.sfcar.cubebrowser.entities.enumerations

import com.example.sfcar.cubebrowser.R

enum class EmptyViewEnum(var imageId: Int, var title: Int, var subtitle: Int) {
    EMPTY_CUBE_LIST(R.drawable.ic_movie_placeholder, R.string.cube_list_empty_title, R.string.cube_list_empty_subtitle)
}