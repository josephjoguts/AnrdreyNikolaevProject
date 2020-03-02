package ru.polydev.andreynikolaev

import android.content.Context
import android.view.View

class Presenter(val context:Context):Contract.Presenter{
    var viewIsAttached = false
    var mView: Contract.View? = null
    var nowSeen = 5;

    private val mRepository: Contract.Repository by lazy {
        Repository()
    }
    override fun attachView(view: Contract.View) {
        viewIsAttached = true
        mView = view

        mRepository.attachPresenter(this)
    }

    override fun detachView() {
        viewIsAttached = false
        mView = null
    }

    override fun onBtnAddNewClick(view:View) {
        nowSeen+=3;
        var array = mRepository.loadInfo(1,nowSeen,context);
        if(array.last()[0].equals("end"))
        {
            array =array.sliceArray(0..array.size-2)
            mView?.showNewDates(array)
            mView?.removeView(view)

        }
        else
        {
            mView?.showNewDates(array);
        }

    }

    override fun onAdapterCreate(which: Int) {
        when(which)
        {
            0-> mView?.showInfoRecycle(mRepository.loadInfo(which,nowSeen,context))
            1-> mView?.showDatesRecycle(mRepository.loadInfo(which,nowSeen,context))
            else-> mView?.showDatesRecycle(mRepository.loadInfo(which,nowSeen,context))
        }

    }
}