package com.example.educationappjoram

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    private var trendNames = arrayOf(
        "Machine learning",
        "Data Science",
        "Cloud Computing",
        "Computing",
        " Security",
        " Computer Programming",
        "E Learning",
        "Artificial intelligence",
        "Mobile Trend",
        "Appliance",
        "Research",
        " Electronic Banking"
    )
    private var trendImages = intArrayOf(
        R.drawable.machine,
        R.drawable.data,
        R.drawable.cloud,
        R.drawable.computing,
        R.drawable.security,
        R.drawable.programming,
        R.drawable.elearning,
        R.drawable.artficial,
        R.drawable.mobile,
        R.drawable.appliance,
        R.drawable.research,
        R.drawable.banking
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "JK MEDIA UGANDA"
        gridView = findViewById(R.id.gridView)
        val mainAdapter = MainAdapter(this@MainActivity, trendNames, trendImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext, "You CLicked " + trendNames[+position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    internal class MainAdapter(
        private val context: Context,
        private val trendsNames: Array<String>,
        private val numberImage: IntArray
    ) :
        BaseAdapter() {
        private var layoutInflater: LayoutInflater? = null
        private lateinit var imageView: ImageView
        private lateinit var textView: TextView
        override fun getCount(): Int {
            return trendsNames.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View? {
            var convertView = convertView
            if (layoutInflater == null) {
                layoutInflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            }
            if (convertView == null) {
                convertView = layoutInflater!!.inflate(R.layout.row_items, null)
            }
            imageView = convertView!!.findViewById(R.id.imageView)
            textView = convertView.findViewById(R.id.tvName)
            imageView.setImageResource(numberImage[position])
            textView.text = trendsNames[position]
            return convertView
        }
    }
}