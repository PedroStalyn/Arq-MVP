package ec.edu.espoch.ejemplomvp.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ec.edu.espoch.ejemplomvp.R
import ec.edu.espoch.ejemplomvp.home.FavoriteTransfer

class FavoriteTransferAdapter : RecyclerView.Adapter<FavoriteTransferViewHolder>() {

    //inicializa una lista de tipo FavoriteTransfer
    private var favoriteTransferItems: List<FavoriteTransfer> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTransferViewHolder =
        FavoriteTransferViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.favorite_transfer_row,
                parent,
                false
            )
        )

    //Este método devuelve el número de elementos en la lista favoriteTransferItems.
    // El RecyclerView usa este valor para determinar cuántos elementos debe mostrar.
    override fun getItemCount(): Int = favoriteTransferItems.size

    //Este método se llama para vincular los datos de un elemento de favoriteTransferItems
    // con una vista mantenida por FavoriteTransferViewHolder
    override fun onBindViewHolder(holder: FavoriteTransferViewHolder, position: Int) =
        holder.bind(favoriteTransferItems[position])

    //Este método se usa para actualizar los datos en el adaptador.
    fun setData(favoriteTransferItems: List<FavoriteTransfer>) {
        this.favoriteTransferItems = favoriteTransferItems
        notifyDataSetChanged()
    }


}