package com.proj.greenspades

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.proj.greenspades.network.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {
    lateinit var disposable:Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api=Service.retrofit.create(Service::class.java)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val list= mutableListOf<Data.Transactions>()
        val adapter=TranscationsAdapter(list)
        recyclerView.adapter=adapter
        recyclerView.addItemDecoration(SpaceItemDecorater(10))
        val date= SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        disposable=api.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
            label1.text=it.kpis[0].text1
            label2.text=it.kpis[1].text1
            label3.text=it.kpis[2].text1
            label4.text=it.kpis[3].text1
            value1.text=it.kpis[0].value.toString()
            value2.text=it.kpis[1].value.toString()
            value3.text=it.kpis[2].value.toString()
            value4.text=it.kpis[3].value.toString()
            it.transactions.forEach {
                it.createdDate=(Utils.getFormattedDate(date.parse(it.createdDate)))
            }
            list.addAll(it.transactions)
            adapter.notifyDataSetChanged()
        },{
            it.printStackTrace()
        })
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
