package com.example.projectr.ui.my

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectr.R
import com.example.projectr.bottomSheetFragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheetFragment = bottomSheetFragment()
        val supportFragmentManager = childFragmentManager

        sheetActivate.setOnClickListener{
            bottomSheetFragment.show(supportFragmentManager,"BottomSheetDialog")
        }

        toastButton.setOnClickListener{
            Toast.makeText(activity,"Main Sheet",Toast.LENGTH_SHORT).show()
        }
    }


}