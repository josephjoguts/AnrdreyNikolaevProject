package ru.polydev.andreynikolaev.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import ru.polydev.andreynikolaev.R


class PhotosAdapter(private val dataSet: Array<Int>) :
    RecyclerView.Adapter<PhotosAdapter.Andrei>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */


    class Andrei(var v: android.widget.ImageView) : RecyclerView.ViewHolder(v)
    {
        init {
           v.setOnClickListener { }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Andrei {
        // Create a new view.
        val v = ImageView(viewGroup.context)
        v.layoutParams = LinearLayout.LayoutParams(600 ,400)

        return Andrei(v)
    }



    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: Andrei, position: Int) {
        //Log.d(TAG, "Element $position set.")

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        //viewHolder.textView.text = dataSet[position]
        viewHolder.v.setImageResource(dataSet[position])
        viewHolder.v.tag="regular"
        viewHolder.v.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?)
            {
                if(viewHolder.v.tag.equals("regular")){
                viewHolder.v.setImageResource(R.drawable.p4);
                viewHolder.v.tag = "army"
                }
                else
                {
                    viewHolder.v.setImageResource(R.drawable.p1);
                    viewHolder.v.tag = "regular"
                }
            }

        })
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