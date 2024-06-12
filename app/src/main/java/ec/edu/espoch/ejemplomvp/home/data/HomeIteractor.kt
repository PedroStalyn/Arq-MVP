package ec.edu.espoch.ejemplomvp.home.data

import android.os.Handler
import ec.edu.espoch.ejemplomvp.home.FavoriteTransfer
import ec.edu.espoch.ejemplomvp.home.HomeContract

class HomeIteractor {
    fun retrieveFavoriteTransferFromCache(responseCallback:HomeContract.OnResponseCallBack){
        val items = ArrayList<FavoriteTransfer>()
        items.add(
            FavoriteTransfer(
                1,
                "Gael Zambrano",
                456.010,
                "Hace 2h",
                "https://freddyvega.com/content/images/size/w2000/2020/08/freddy-vega-grande.jpg"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Eimy Rodriguez",
                210.920,
                "Ayer",
                "https://img.freepik.com/foto-gratis/retrato-hermosa-modelo-sonriente-peinado-afro-rizos-vestido-ropa-hipster-verano-mujer-divertida-positiva-moda_158538-15688.jpg?size=626&ext=jpg"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Fernando Ávila",
                456.050,
                "Hace 2h",
                "https://www.oliverwyman.com/content/dam/oliver-wyman/v2/careers/profiles/scottbk-profile-460x460.jpg"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Cristian Villamil",
                456.040,
                "Hace 2h",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTw8mKnjVErhmhl5S_aUZfvf86vwZOMJBqbUqM-guT-kv6K4xu&s"
            )
        )
        items.add(
            FavoriteTransfer(
                1,
                "Nelly Muñoz",
                456.200,
                "Hace 2h",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVSEHZQ2HJu9FEzFLU4yEAUv46sfRQjxUYkiVv7IEFxNndQ_7C&s"
            )
        )
        val runnable = Runnable {
            responseCallback.onResponse(items)
        }
        val handler = Handler()
        handler.postDelayed(runnable, 3000)
    }
}