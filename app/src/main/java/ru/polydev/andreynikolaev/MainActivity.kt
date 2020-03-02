package ru.polydev.andreynikolaev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.polydev.andreynikolaev.adapters.DateViewAdapter
import ru.polydev.andreynikolaev.adapters.InfoAdapter
import ru.polydev.andreynikolaev.adapters.PhotosAdapter
import java.lang.Exception

class MainActivity : AppCompatActivity(),Contract.View {
    private  var add  =5;
    private val mPresenter by lazy {Presenter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.attachView(this);
        setAdapters()

    }

    private fun setAdapters() {
        mPresenter.onAdapterCreate(0);
        mPresenter.onAdapterCreate(1);
    }

    override fun onStop() {
        super.onStop()
        mPresenter.detachView()

    }

    private fun setUI() {
        setRecycleViews()
        setListeners()

    }

    private fun setListeners() {
        addNewButton.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v:View?)
            {
                mPresenter.onBtnAddNewClick(v!!)
            }

        })
    }

    private fun setRecycleViews() {

        ImagesRecycleView.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false);
            adapter = PhotosAdapter(arrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3));
        }
        InfoRecycleView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        InfoRecycleView.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity);
        }


        DatesRecycleView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        DatesRecycleView.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity);

        }

    }


    override fun showNewDates(dataSrc: Array<Array<String>>) {
        DatesRecycleView.adapter = DateViewAdapter(dataSrc);
    }

    override fun removeView(view:View) {
        val t = view.parent as ViewGroup;
        t.removeView(view)
    }

    override fun showDatesRecycle(dataSrc: Array<Array<String>>) {
        DatesRecycleView.adapter = DateViewAdapter(dataSrc)
    }

    override fun showInfoRecycle(dataSrc: Array<Array<String>>) {
       InfoRecycleView.adapter = InfoAdapter(dataSrc)
    }
}
