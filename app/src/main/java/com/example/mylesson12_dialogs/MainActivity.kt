package com.example.mylesson12_dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mylesson12_dialogs.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_example.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout> by lazy {
        BottomSheetBehavior.from(
            binding.root.bottomSheetParentContainer
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupBottomSheet()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnBasicAlert.setOnClickListener {
            showAlertDialog()
        }
        binding.btnDialogFragment.setOnClickListener {
            showDialogFragment()
        }
        binding.btnBottomSheetDialog.setOnClickListener {
            showBottomSheet()
        }
        binding.btnBottomSheetFragment.setOnClickListener {
            showBottomSheetFragment()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Alert Test")
            .setMessage("Sample alert message")
            .setIcon(R.drawable.ic_a)
            .setPositiveButton("Positive") { _, _ ->
                Toast.makeText(this, "Positive button clicked", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Negative") { _, _ ->
                Toast.makeText(this, "Positive button clicked", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Neutral") { _, _ ->
                Toast.makeText(this, "Neutral button clicked", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showDialogFragment() {
        supportFragmentManager.beginTransaction()
            .add(DialogFragmentTest(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun showBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })
    }

    private fun showBottomSheetFragment() {
        supportFragmentManager.beginTransaction()
            .add(BottomSheetDialogFragmentTest(), "TAG")
            .commitNowAllowingStateLoss()
    }


}



