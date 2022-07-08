package com.example.ecolime.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecolime.Activities.BattleStrategyActivity
import com.example.ecolime.Interface.MessageListener
import com.example.ecolime.Util
import com.example.ecolime.databinding.FragmentBattleStrategyBinding


private const val ARG_PARAM_TITLE="title"
private const val ARG_PARAM_DESCRIPTION="description"
private const val ARG_PARAM_IMG="image"
private const val ARG_PARAM_STRATEGY="strategy"

class BattleStrategyFragment : Fragment() {
    private var title: String?=null
    private var description: String?=null
    private var strategy: BattleStrategyActivity.BattleStrategy?=null
    private var image: Int=0

    private lateinit var binding: FragmentBattleStrategyBinding
    private lateinit var battleStrategyActivity: BattleStrategyActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title=it.getString(ARG_PARAM_TITLE)
            description=it.getString(ARG_PARAM_DESCRIPTION)
            image=it.getInt(ARG_PARAM_IMG)
            strategy= BattleStrategyActivity.BattleStrategy.valueOf(it.getString(ARG_PARAM_STRATEGY)!!)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding=FragmentBattleStrategyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        battleStrategyActivity=requireActivity() as BattleStrategyActivity
        binding.apply {

            btnTitle.text=title
            btnDesc.text=description
            imgStrategy.setImageResource(image)

           checkbox.setOnCheckedChangeListener { compoundButton, b ->

               if(b)
               {
                   Util.showMessageDialog(requireContext(),"Are you Sure to select $title as battle strategy ? ",object:MessageListener
                   {
                       override fun onSelected(isYesSelected: Boolean)
                       {

                           if(isYesSelected)
                           {
                               battleStrategyActivity.onStrategySelected(strategy!!)
                           }
                           else
                           {
                               checkbox.isChecked=false
                           }
                       }
                   })
               }

           }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, description: String, image: Int,strategy: BattleStrategyActivity.BattleStrategy)=
            BattleStrategyFragment().apply {
                arguments=Bundle().apply {
                    putString(ARG_PARAM_TITLE, title)
                    putString(ARG_PARAM_DESCRIPTION, description)
                    putString(ARG_PARAM_STRATEGY, strategy.toString())
                    putInt(ARG_PARAM_IMG, image)
                }
            }
    }
}