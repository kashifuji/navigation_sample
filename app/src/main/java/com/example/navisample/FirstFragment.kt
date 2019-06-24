package com.example.navisample

import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FIrstFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FIrstFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FIrstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        button1.setOnClickListener { view ->
//            plantDetailViewModel.addPlantToGarden()
//            Snackbar.make(view, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
//        }
        // Inflate the layout for this fragment
        //val binding =  inflater.inflate(R.layout.fragment_first, container, false)

//        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
//            inflater, R.layout.fragment_plant_detail, container, false).apply {
//            viewModel = plantDetailViewModel
//            lifecycleOwner = this@PlantDetailFragment
//            fab.setOnClickListener { view ->
//                plantDetailViewModel.addPlantToGarden()
//                Snackbar.make(view, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
//            }
//        }

//        val binding = FragmentBinding.inflate(inflater, container, false);
//        val button: Button = findViewById(R.id.button) as Button
//        button.setOnClickListener(object:View.OnClickListener {
//            override fun onClick(v: View?) {
//                //Toast.makeText(this@MainActivity, "Tapped", Toast.LENGTH_SHORT).show()
//            }
//        })

//        button1.setOnClickListener { Log.v(TAG, "clicked") }


        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            Log.v(TAG, "clicked")
            Navigation.findNavController(it).navigate(R.id.action_FIrstFragment_to_secondFragment)
            //Toast.makeText(this, "テストメッセージです", Toast.LENGTH_SHORT).show()
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FIrstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FIrstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
