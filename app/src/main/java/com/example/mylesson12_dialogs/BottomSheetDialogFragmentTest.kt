package com.example.mylesson12_dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylesson12_dialogs.databinding.BottomSheetDialogFragmentExampleBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialogFragmentTest : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogFragmentExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetDialogFragmentExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

}
