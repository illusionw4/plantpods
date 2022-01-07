package com.example.plantpods.Typesplant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantpods.Adapters.Plants
import com.example.plantpods.Model.Plantmodel
import com.example.plantpods.R
import com.google.firebase.firestore.*


class Flowering : Fragment() {

    private lateinit var Plantrecycle: RecyclerView
    private lateinit var Plantarray: ArrayList<Plantmodel>
    private lateinit var myadapter: Plants
    private lateinit var mfirestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flowering2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mfirestore = FirebaseFirestore.getInstance()
        Plantrecycle = view.findViewById(R.id.plantlist)
        Plantrecycle.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        Plantrecycle.setHasFixedSize(true)

        Plantarray = arrayListOf<Plantmodel>()
        myadapter = Plants(this@Flowering,Plantarray)

        EventChangeListner()
    }

    private fun EventChangeListner() {
        mfirestore = FirebaseFirestore.getInstance()
        mfirestore.collection("Flowering").
        addSnapshotListener(object: EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {
                if (error != null) {
                    Log.e("Firestore Error",error.message.toString())
                    return
                }

                for (dc : DocumentChange in value?.documentChanges!!){

                    if(dc.type == DocumentChange.Type.ADDED){
                        Plantarray.add(dc.document.toObject(Plantmodel::class.java))

                    }
                }
                Plantrecycle.adapter = Plants(this@Flowering,Plantarray)
                myadapter.notifyDataSetChanged()

            }


        })
    }
}