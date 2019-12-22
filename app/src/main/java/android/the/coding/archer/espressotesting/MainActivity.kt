package android.the.coding.archer.espressotesting

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recycler_view)
        val footer = findViewById<TextView>(R.id.footer)
        footer.setBackgroundColor(Color.LTGRAY)
        footer.visibility = View.GONE

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NumberedAdapter(30, object : NumberedAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                footer.text = position.toString()
                footer.visibility = View.VISIBLE
            }
        })
    }
}
