package com.example.projectr

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.bottom_sheet.*

class bottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        sheetButton.setOnClickListener(clickListener)

    }

    val clickListener = View.OnClickListener {view ->
        Toast.makeText(activity,"You pressed",Toast.LENGTH_SHORT).show()
    }

}