package lct.soluciones.fragmentexercises

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.flow.combine
import lct.soluciones.fragmentexercises.databinding.FragmentBluePadreBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BluePapaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BluePapaFragment : Fragment(), BluePadreAux {

    private  var mBinding: FragmentBluePadreBinding? = null

    private var mainAux: MainAux? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentBluePadreBinding.inflate(inflater, container, false)
        mBinding?.let {
            return it.root
        }

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Abre el BottomSheetDialogFragment
        mBinding?.let { binding->
            binding.fabBlue.setOnClickListener {
                mainAux?.openHijo()
                hideFab()
            }
        }



    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainAux = activity as MainAux?
    }



    override fun hideFab(isVisible: Boolean) {
        mainAux?.showMessage("Valor entregado en BluePadre: $isVisible")
        println("Valor entregado en BluePadre: $isVisible")

        mBinding?.let {
            if(isVisible){
                it.fabBlue.show()
            }
            else{
                it.fabBlue.hide()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding= null
    }
}