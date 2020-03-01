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
    private  var add  =5;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lst = arrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3)
        Images.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false);
            adapter =PhotosAdapter(lst);
        }
        Info.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        Info.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity);
            adapter =InFoAdapter(Info(0));
        }


        Dates.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        Dates.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity);
            adapter =DateViewAdapter(Info(1));
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
                Dates.adapter = DateViewAdapter(addition)
                val t:ViewGroup = v?.parent as ViewGroup
                t.removeView(v);
                }
                else
                {
                    Dates.adapter = DateViewAdapter(addition)
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
