package com.proj.greenspades

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import eu.davidea.flipview.FlipView
import kotlinx.android.synthetic.main.item_adapter_transaction.view.*
import kotlinx.android.synthetic.main.item_front_layout.view.*

/**
 * Created by karan on 23/11/17.
 */
class TranscationsAdapter(var items:List<Data.Transactions>):RecyclerView.Adapter<TranscationsAdapter.ViewHolder>() {
    lateinit var  context:Context
    var flippedViews= hashSetOf<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_adapter_transaction,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.flipView.setOnClickListener {
            holder.flipView.flip(!holder.flipView.isFlipped)
            if(holder.flipView.isFlipped) {
                flippedViews.remove(position)
            }
            else{
                flippedViews.add(position)
            }
        }
        holder.number.text= items[position].customer.mobileNumber
        holder.date.text=  items[position].createdDate
        holder.amount.text=items[position].amountPaid.toString()
        holder.name.text=items[position].customer.name
        holder.transactionId.text="Transaction id "+items[position]._id.toString()
        if(flippedViews.contains(position)){
            holder.flipView.flipSilently(true)
        }
        else{
            holder.flipView.flipSilently(false)
        }

    }

    override fun getItemCount(): Int = items.size
    class ViewHolder( itemView: View):RecyclerView.ViewHolder(itemView){
        var amount:TextView = itemView.amount
        var flipView:FlipView=itemView.flipView
        var number:TextView=itemView.number
        var date:TextView=itemView.date
        var name:TextView=itemView.name
        var transactionId=itemView.transaction_id

    }

}