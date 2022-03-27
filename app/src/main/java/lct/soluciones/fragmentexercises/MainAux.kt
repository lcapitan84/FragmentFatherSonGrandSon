package lct.soluciones.fragmentexercises

import com.google.android.material.snackbar.Snackbar

/***

 * Proyect: FragmentExercises
 * From: lct.soluciones.fragmentexercises
 * Creator by: LCTSoluciones
 * sábado - marzo - 2022

 ***/
interface MainAux {

    fun openHijo()

    fun openNieto(string: String? ="Sin dato")

    fun openPapa()

    fun showMessage(message: String, duration: Int = Snackbar.LENGTH_LONG)

    fun hideOrShowFab(isVisible: Boolean = false)


}