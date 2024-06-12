package ec.edu.espoch.ejemplomvp.home.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ec.edu.espoch.ejemplomvp.R
import ec.edu.espoch.ejemplomvp.home.FavoriteTransfer
import ec.edu.espoch.ejemplomvp.home.HomeContract
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import ec.edu.espoch.ejemplomvp.home.presenter.HomePresenter


class HomeFragment : Fragment(),HomeContract.View {

    //Instancia de objeto de la clase FavoriteTransferAdapter que es parte del Recicle View
    private val favoriteTransferAdapter=FavoriteTransferAdapter()
    // Conecta la lógica de negocio y la interacción con la vista.
    private var homePresenter:HomeContract.Presenter?=null


    //Este método infla el layout fragment_home y lo devuelve como la vista para este fragmento.
    override fun onCreateView(
        //Inflar (convertir) el archivo XML en una jerarquía de vistas.
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

        //es el identificador del archivo XML que define el diseño del fragmento
        //container es el ViewGroup padre en el que se insertará la vista inflada.
        // indica que la vista inflada no debe adjuntarse inmediatamente al contenedor.

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Inicializa el RecyclerView
        initRecyclerView(view)
        //Se instancia y se asigna un presentador.
        homePresenter=HomePresenter(this)
        //Llama al método del presentador para recuperar las transferencias favoritas
        homePresenter?.retrieveFavoriteTransfers()
        val circularProgress: CircularProgressBar = view.findViewById(R.id.circularProgress)
        val profilePhotoImagePrincipal: ImageView = view.findViewById(R.id.profilePhotoImagePrincipal)
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://scholar.googleusercontent.com/citations?view_op=medium_photo&user=hc8M2p4AAAAJ&citpid=2")
            .into(profilePhotoImagePrincipal)
    }

    private fun initRecyclerView(view: View) {

        val favoriteTransfersRecyclerView: RecyclerView = view.findViewById(R.id.favoriteTransfersRecyclerView)

        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        // inicializar la variable, le da valor a la variable
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter
    }

    override fun showLoader() {

        //homeLoader.visibility=View.VISIBLE
    }

    override fun hideLoader() {

        //homeLoader.visibility=View.GONE
    }

    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
       //Muestra las transferencias favoritas
        favoriteTransferAdapter.setData(favoriteTransfer)
    }
}