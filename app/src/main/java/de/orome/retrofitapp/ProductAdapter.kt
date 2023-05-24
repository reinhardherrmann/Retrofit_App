package de.orome.retrofitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(private val mList: List<Products>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = mList[position]

        holder.textView.setText(product.title)
        Picasso.get().load(product.images.get(0)).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = ItemView.findViewById(R.id.image_view)
        val textView: TextView = ItemView.findViewById(R.id.text_view)

    }



}