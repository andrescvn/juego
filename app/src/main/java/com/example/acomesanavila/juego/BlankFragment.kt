package com.example.acomesanavila.juego


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        button.setOnClickListener(){
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent);
        }
        return inflater!!.inflate(R.layout.fragment_blank, container, false)
    }

}// Required empty public constructor
