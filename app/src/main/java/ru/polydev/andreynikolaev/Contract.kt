package ru.polydev.andreynikolaev

import android.content.Context
import android.view.View

interface Contract {
    interface View
    {
        fun showNewDates(dataSrc:Array<Array<String>>)
        fun removeView(view:android.view.View);
        fun showDatesRecycle(dataSrc:Array<Array<String>>)
        fun showInfoRecycle(dataSrc:Array<Array<String>>)

    }
    interface Presenter
    {
        fun attachView(view: View)
        fun detachView()
        fun onBtnAddNewClick(view: android.view.View)
        fun onAdapterCreate(which:Int);

    }
    interface Repository
    {
        fun attachPresenter(presenter: Presenter)
        fun loadInfo(which:Int,now:Int,context: Context):Array<Array<String>>
    }

}