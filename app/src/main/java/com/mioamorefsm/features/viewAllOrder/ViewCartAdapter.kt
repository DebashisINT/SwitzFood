package com.mioamorefsm.features.viewAllOrder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mioamorefsm.R
import com.mioamorefsm.app.Pref
import com.mioamorefsm.app.domain.OrderProductListEntity
import com.mioamorefsm.features.dashboard.presentation.DashboardActivity
import kotlinx.android.synthetic.main.inflate_cart.view.*

/**
 * Created by Saikat on 21-11-2018.
 */
class ViewCartAdapter(private val context: Context, private val selectedProductList: List<OrderProductListEntity>) :
        RecyclerView.Adapter<ViewCartAdapter.MyViewHolder>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    init {
        (context as DashboardActivity).totalPrice.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = layoutInflater.inflate(R.layout.inflate_cart, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(context, selectedProductList)
    }

    override fun getItemCount(): Int {
        return selectedProductList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(context: Context, categoryList: List<OrderProductListEntity>) {

            if (!Pref.IsnewleadtypeforRuby) {
                itemView.ll_inflate_cart_scheme.visibility = View.GONE

            } else {
                itemView.ll_inflate_cart_scheme.visibility = View.VISIBLE
//                itemView.tv_category_item_scheme.text = "Sche.Qty: ₹ " + String.format("%.2f", categoryList[adapterPosition].scheme_qty?.toFloat())
//                itemView.tv_brand_item_scheme.text = "Sche.Rate: ₹ " + String.format("%.2f", categoryList[adapterPosition].scheme_rate?.toFloat())
            }

            if(categoryList[adapterPosition].scheme_qty!=null){
                itemView.tv_category_item_scheme.text = "Sch.Qty:" + categoryList[adapterPosition].scheme_qty?.toFloat()?.toInt()
            }
            else{
                itemView.tv_category_item_scheme.text = "Sch.Qty: " + "0"
            }
            if(categoryList[adapterPosition].scheme_rate!=null){
                itemView.tv_brand_item_scheme.text = "Sch.Rate: ₹ " + String.format("%.2f", categoryList[adapterPosition].scheme_rate?.toFloat())
            }
            else{
                itemView.tv_brand_item_scheme.text = "Sch.Rate: ₹ " +  "0"
            }


            try {
                val totalScPrice = String.format("%.2f", categoryList[adapterPosition].total_scheme_price?.toFloat())
                itemView.tv_watt_item_scheme.text = "Sch.Price: ₹ $totalScPrice"  //categoryList?.get(adapterPosition)?.watt
            } catch (e: Exception) {
                e.printStackTrace()
            }

//            if (categoryList[adapterPosition].scheme_qty?.contains(".")!! )
//                itemView.tv_category_item.text = "Sch.Qty: " + categoryList[adapterPosition].scheme_qty?.toFloat()?.toInt()
//            else
//                itemView.tv_category_item.text = "Sch.Qty: " + categoryList[adapterPosition].scheme_qty


            /*if (adapterPosition % 2 == 0)
                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.report_screen_bg))
            else
                itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.white))*/

            itemView.tv_particular_item.text = categoryList[adapterPosition].product_name
            /*itemView.tv_brand_item.text = "Rate : ₹ " + categoryList.get(adapterPosition).rate*/ //categoryList?.get(adapterPosition)?.brand

            itemView.tv_brand_item.text = "Rate: ₹ " + String.format("%.2f", categoryList[adapterPosition].rate?.toFloat())

            if (categoryList[adapterPosition].qty?.contains(".")!!)
                itemView.tv_category_item.text = "Quantity: " + categoryList[adapterPosition].qty?.toFloat()?.toInt() //categoryList?.get(adapterPosition)?.category
            else
                itemView.tv_category_item.text = "Quantity: " + categoryList[adapterPosition].qty

            try {
                //val totalPrice = DecimalFormat("##.##").format(categoryList[adapterPosition].total_price?.toDouble())
                val totalPrice = String.format("%.2f", categoryList[adapterPosition].total_price?.toFloat())
                itemView.tv_watt_item.text = "Total Price: ₹ $totalPrice"  //categoryList?.get(adapterPosition)?.watt
            } catch (e: Exception) {
                e.printStackTrace()
            }
            //(context as DashboardActivity).totalPrice.add((context as DashboardActivity).rateList[adapterPosition].toInt() * (context as DashboardActivity).qtyList[adapterPosition].toInt())
            //itemView.tv_edit_product.visibility = View.GONE
            itemView.ll_edit_delete.visibility = View.GONE
        }
    }
}