package ua.makuta.storylog.listener

import ua.makuta.storylog.model.Model

interface ItemClickListener {
    fun onItemClick(item : Model)
}