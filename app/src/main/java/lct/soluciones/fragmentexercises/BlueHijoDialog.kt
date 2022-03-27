package lct.soluciones.fragmentexercises

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import lct.soluciones.fragmentexercises.databinding.FragmentBlueHijoBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BlueHijoDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlueHijoDialog : BottomSheetDialogFragment(){

    private var binding: FragmentBlueHijoBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private var mainAux: MainAux? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentBlueHijoBinding.inflate(LayoutInflater.from(activity))
        binding?.let {
            val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
            bottomSheetDialog.setContentView(it.root)

            bottomSheetBehavior = BottomSheetBehavior.from(it.root.parent as View)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

            setupButtons()

            return bottomSheetDialog
        }
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainAux = activity as MainAux
    }


    private fun setupButtons() {
        binding?.let {
            it.ibCancel.setOnClickListener {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            it.efabNext.setOnClickListener {
                mainAux?.openNieto(binding!!.tetMinistry.text.toString().trim())


                dismiss()


            }
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}