package com.gcssloop.kotlindemo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.gcssloop.apputils.startActivity
import com.gcssloop.kotlindemo.activitys.ClassActivity
import com.gcssloop.kotlindemo.activitys.DataTypeActivity
import com.gcssloop.kotlindemo.activitys.ForecastActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private var items = listOf(
            ActivityItem("天气预报", ForecastActivity().javaClass),
            ActivityItem("基本数据类型", DataTypeActivity().javaClass),
            ActivityItem("类的定义方法", ClassActivity().javaClass)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ActivityAdapter(this, items)
    }

    //----------------------------------------------------------------------------------------------

    data class ActivityItem(val text: String, val clazz: Class<Activity>)

    class ActivityAdapter(val context: Context, val items: List<ActivityItem>) :
            RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {
        override fun getItemCount(): Int = items.size

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent?.context).
                    inflate(R.layout.item_button, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.button?.text = items[position].text
            holder?.button?.setOnClickListener {
                var datas = LinkedHashMap<String, Serializable>()
                datas.put("title", items[position].text)
                context.startActivity(items[position].clazz, datas)
            }
        }

        class ViewHolder(item_view: View) : RecyclerView.ViewHolder(item_view) {
            var button: Button = item_view.findViewById(R.id.button) as Button
        }
    }
}

