package com.example.mydemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydemo.adapter.CoinAdapter
import com.example.mydemo.databinding.FragmentHomeBinding
import com.example.mydemo.model.CoinData
import com.example.mydemo.viewmodel.CoinRepo
import com.example.mydemo.viewmodel.CoinViewModel

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {
    private lateinit var ui: FragmentHomeBinding
    private lateinit var con: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
        con = context

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ui = FragmentHomeBinding.inflate(layoutInflater, container, false)


        requestData()
        observerResponse()
        return ui.root
    }

    private fun requestData() {

        viewModel.getCoinResponse()
    }


    private val viewModel by lazy {
        ViewModelProvider(
            this,
            CoinViewModel.CoinViewModelFactory(CoinRepo())
        ).get(CoinViewModel::class.java)
    }

    private fun observerResponse() {
        viewModel.coinResponse.observe(viewLifecycleOwner) {
            Log.d(TAG, "observerResponse: $it")
            showCoinInfoList(it.data?.list)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun showCoinInfoList(iInfoList: MutableList<CoinData?>?) {
        val layoutManager = GridLayoutManager(con, 3)
        ui.recyclerView.layoutManager = layoutManager
        ui.recyclerView.hasFixedSize()

        val adapter = CoinAdapter(iInfoList)
        ui.recyclerView.adapter = adapter
    }


}