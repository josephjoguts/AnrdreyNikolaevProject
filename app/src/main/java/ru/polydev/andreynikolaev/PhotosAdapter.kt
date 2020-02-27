package ru.polydev.andreynikolaev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class PhotosAdapter(private val dataSet: Array<Int>) :
    RecyclerView.Adapter<PhotosAdapter.ImageView>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */


    class ImageView(var v: android.widget.ImageView) : RecyclerView.ViewHolder(v)
    {

        init {


        }


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ImageView {
        // Create a new view.
        val v = ImageView(viewGroup.context)
        v.layoutParams = LinearLayout.LayoutParams(600 ,400)

        return ImageView(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ImageView, position: Int) {
        //Log.d(TAG, "Element $position set.")

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        //viewHolder.textView.text = dataSet[position]
        viewHolder.v.setImageResource(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    companion object {
        private val TAG = "CustomAdapter"
    }
}