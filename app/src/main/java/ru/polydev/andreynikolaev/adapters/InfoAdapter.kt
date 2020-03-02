package ru.polydev.andreynikolaev.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.polydev.andreynikolaev.R

class InfoAdapter(private val dataSet: Array<Array<String>>) :
    RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v)
    {
        val type:TextView;
        val info:TextView;
        init {
            type = v.findViewById(R.id.Type)
            info =v.findViewById(R.id.InfoRecycleView)
        }


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.info_view, viewGroup, false)

        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //Log.d(TAG, "Element $position set.")

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        //viewHolder.textView.text = dataSet[position]
        viewHolder.type.text = dataSet[position][0]
        viewHolder.info.text = dataSet[position][1]

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