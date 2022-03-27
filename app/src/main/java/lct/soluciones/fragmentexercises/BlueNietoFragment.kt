package lct.soluciones.fragmentexercises

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lct.soluciones.fragmentexercises.databinding.FragmentBlueNietoBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BlueNietoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlueNietoFragment: Fragment() {

    private var mBinding: FragmentBlueNietoBinding? = null
    private var mActivity: MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentBlueNietoBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as MainActivity?

        val string = arguments?.getString("ministerio", "")
        if(string != null){
            mBinding?.tvMinisterio?.text = string
        }

        mBinding?.fabSave?.setOnClickListener {
            //si antes de pulsar el boton, doy para atras usando el boton del sistema
            //el boton en el Padre no aparece, es lo que que aun no se como hacerlo

            //Si pulso el boton usando openPapa(), aparecera el boton porque vuelve a crear
            //el fragment


//            mActivity?.openPapa()


            mActivity?.onBackPressed()


        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
        mActivity?.hideOrShowFab(true)
    }




}