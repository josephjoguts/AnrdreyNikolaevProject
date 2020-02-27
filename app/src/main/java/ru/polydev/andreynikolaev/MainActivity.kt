package ru.polydev.andreynikolaev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private  lateinit var imagesView:RecyclerView
    private  lateinit var imagesViewAdapter:RecyclerView.Adapter<*>
    private  lateinit var imagesmanager:RecyclerView.LayoutManager
    private lateinit var infoView:RecyclerView
    private lateinit var infoviewAdapter: RecyclerView.Adapter<*>
    private lateinit var infoManager: RecyclerView.LayoutManager
    private lateinit var dateView:RecyclerView
    private lateinit var dateViewAdapter:RecyclerView.Adapter<*>
    private lateinit var dateManager: RecyclerView.LayoutManager
    private  var add  =5;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagesView = Images
        val lst = arrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3)
        imagesViewAdapter=PhotosAdapter(lst)
        imagesmanager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        imagesView.apply{
            setHasFixedSize(true)
            layoutManager = imagesmanager;
            adapter =imagesViewAdapter;
        }


        infoManager = LinearLayoutManager(this)
        infoView = Info
        infoviewAdapter = InFoAdapter(Info(0));
        infoView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        infoView.apply{
            setHasFixedSize(true)
            layoutManager = infoManager;
            adapter =infoviewAdapter;
        }


        dateView = Dates;
        dateViewAdapter = DateViewAdapter(Info(1))
        dateManager = LinearLayoutManager(this)
        dateView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        dateView.apply{
            setHasFixedSize(true)
            layoutManager = dateManager;
            adapter =dateViewAdapter;
        }


        val butt:Button = addNew
        butt.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v:View?)
            {
                add+=3
                var addition = Info(1);
                if(addition.last()[0].equals("end"))
                {
                addition = addition.sliceArray(0..addition.size-2)
                dateViewAdapter = DateViewAdapter(addition)
                dateView.adapter = dateViewAdapter
                val t:ViewGroup = v?.parent as ViewGroup
                t.removeView(v);
                }
                else
                {
                    dateViewAdapter = DateViewAdapter(addition)
                    dateView.adapter = dateViewAdapter
                }


            }

        })



    }
    fun Info(which:Int):Array<Array<String>>
    {
        var unreadyArray = when(which){
           0 -> resources.getStringArray(R.array.Info);
           1 -> resources.getStringArray(R.array.Dates);
           else -> resources.getStringArray(R.array.Info);

        }
         if(which == 1)
         {
             if(add>=unreadyArray.size)
             {
                 add=unreadyArray.size-1;
             }
             try {
                 if(unreadyArray[add+1].equals("end!end")){add++}
             }catch (e:Exception)
             {

             }

             unreadyArray = unreadyArray.sliceArray(0..add)


         }

        val readyArray = Array<Array<String>>(unreadyArray.size,{i -> unreadyArray[i].split("!").toTypedArray()})
        return readyArray;

    }
}
