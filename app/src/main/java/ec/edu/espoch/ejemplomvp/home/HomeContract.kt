package ec.edu.espoch.ejemplomvp.home

interface HomeContract {
    interface View{
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>)
    }
    interface Presenter{
        fun retrieveFavoriteTransfers()
    }

    //interfaz Presenter
    interface OnResponseCallBack{
        fun onResponse(favoriteList:List<FavoriteTransfer>)
    }
}