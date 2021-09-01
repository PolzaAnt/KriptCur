package com.ex.kriptcur


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ex.kriptcur.network.entity.Rates
import com.ex.kriptcur.network.utils.DataConst.IMG_BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.bitcoin_rate_item.view.*

class RateAdapter:RecyclerView.Adapter<RateAdapter.RateViewHolder>() {

    private var listRates = ArrayList<Rates>()


    fun updateList(list: List<Rates>?){
        listRates = list as ArrayList<Rates>
        notifyDataSetChanged()
    }

    class RateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(rates: Rates) {
            itemView.apply {
                text_view_bitcoin.text = rates.name
                text_view_price_bitcoin.text = rates.price.toString()
                text_view_percent.text = rates.percentChange.toString()
                Picasso.get().load(IMG_BASE_URL + rates.id + ".png").into(image_bitcoin)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bitcoin_rate_item, parent, false)
        return RateViewHolder(view)
    }

    override fun getItemCount() = listRates.size

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.bind(listRates[position])
    }


}