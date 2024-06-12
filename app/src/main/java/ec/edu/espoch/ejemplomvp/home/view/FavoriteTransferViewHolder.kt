package ec.edu.espoch.ejemplomvp.home.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ec.edu.espoch.ejemplomvp.R
import ec.edu.espoch.ejemplomvp.home.FavoriteTransfer

class FavoriteTransferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

      fun bind(item: FavoriteTransfer) {
       val photoImageView = view.findViewById<ImageView>(R.id.profilePhotoImageView)
       Picasso.get().load(item.photoUrl).into(photoImageView)
       val name = view.findViewById<TextView>(R.id.nameTextView)
       name.text=item.name
       val transferAmount = view.findViewById<TextView>(R.id.transferredAmountTextView)
       transferAmount.text=item.amount.toString()
       val transferTime = view.findViewById<TextView>(R.id.transferTimeTextView)
       transferTime.text=item.date
   }
}