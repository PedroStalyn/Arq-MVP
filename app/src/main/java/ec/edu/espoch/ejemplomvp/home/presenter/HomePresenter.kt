package ec.edu.espoch.ejemplomvp.home.presenter

import ec.edu.espoch.ejemplomvp.home.FavoriteTransfer
import ec.edu.espoch.ejemplomvp.home.HomeContract
import ec.edu.espoch.ejemplomvp.home.data.HomeIteractor

class HomePresenter(private val view: HomeContract.View) :HomeContract.Presenter {
    private val homeInteractor=HomeIteractor()
    override fun retrieveFavoriteTransfers(){
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object:HomeContract.OnResponseCallBack{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {

                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }
}