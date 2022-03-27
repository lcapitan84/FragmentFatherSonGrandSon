package lct.soluciones.fragmentexercises

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.snackbar.Snackbar
import lct.soluciones.fragmentexercises.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainAux {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mActiveFragment: Fragment
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupBottomNav()
    }


    private fun setupBottomNav() {
        mFragmentManager = supportFragmentManager

        val redFragment = RedFragment()
        val blueFragment = BluePapaFragment()
        val greenFragment = GreenFragment()

        mActiveFragment = redFragment

        mFragmentManager.beginTransaction()
            .add(R.id.hostFragment, greenFragment, GreenFragment::class.java.name)
            .hide(greenFragment)
            .commit()

        mFragmentManager.beginTransaction()
            .add(R.id.hostFragment, blueFragment, BluePapaFragment::class.java.name)
            .hide(blueFragment)
            .commit()

        mFragmentManager.beginTransaction()
            .add(R.id.hostFragment, redFragment, RedFragment::class.java.name)
            .commit()

        mBinding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_red -> {
                    mFragmentManager.beginTransaction()
                        .hide(mActiveFragment)
                        .show(redFragment)
                        .commit()
                    mActiveFragment = redFragment
                    true
                }

                R.id.action_blue -> {
                    mFragmentManager.beginTransaction()
                        .hide(mActiveFragment)
                        .show(blueFragment)
                        .commit()
                    mActiveFragment = blueFragment
                    true
                }

                R.id.action_green -> {
                    mFragmentManager.beginTransaction()
                        .hide(mActiveFragment)
                        .show(greenFragment)
                        .commit()
                    mActiveFragment = greenFragment
                    true
                }

                else -> false
            }
        }
    }


    //MainAux
    override fun showMessage(message: String, duration: Int) {
        Snackbar.make(mBinding.root, message, duration)
            .setAnchorView(mBinding.bottomNav)
            .show()
    }

    override fun openHijo() {
        val fragmentManager = supportFragmentManager
        BlueHijoDialog().show(fragmentManager, BlueHijoDialog::class.java.simpleName)
    }

    override fun openNieto(string: String?) {
        val mFragmentManager = supportFragmentManager
        val args = Bundle()
        args.putString("ministerio", string)

        val fragment = BlueNietoFragment()
        fragment.arguments = args
        mFragmentManager.beginTransaction()
            .replace(R.id.bluePadreFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    //Si llamo esta funcion mActivity?.openPapa() desde el nieto en lugar de mActivity?.onBackPressed()
    // si funciona, pero crea un nuevo fragment encima del que ya estaba
    override fun openPapa() {
        val fragment = BluePapaFragment()
        mFragmentManager.beginTransaction()
            .replace(R.id.bluePadreFragment, fragment)
            .commit()
    }

    override fun hideOrShowFab(isVisible: Boolean) {
        val fragment = BluePapaFragment()


            fragment.hideFab(true)



//       println("Valor entregado en MainActivity: $isVisible")

    }

}