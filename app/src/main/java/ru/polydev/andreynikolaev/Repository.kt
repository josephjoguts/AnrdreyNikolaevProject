package ru.polydev.andreynikolaev

import android.content.Context

class Repository: Contract.Repository {
    private lateinit var mPresenter: Contract.Presenter
    override fun attachPresenter(presenter: Contract.Presenter) {
        mPresenter = presenter;
    }

    override fun loadInfo(which:Int,now:Int,context:Context):Array<Array<String>> {

        var add = now;
        var unreadyArray = when(which){
            0 -> context.resources.getStringArray(R.array.Info);
            1 -> context.resources.getStringArray(R.array.Dates);
            else ->context.resources.getStringArray(R.array.Info);

        }
        if(which == 1)
        {
            if(add>=unreadyArray.size)
            {
                add=unreadyArray.size-1;
            }
            try {
                if(unreadyArray[now+1].equals("end!end")){add++}
            }catch (e:Exception)
            {

            }

            unreadyArray = unreadyArray.sliceArray(0..add)


        }

        val readyArray = Array<Array<String>>(unreadyArray.size,{i -> unreadyArray[i].split("!").toTypedArray()})
        return readyArray;
    }
}