package com.george.sample_timepicker_v4

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.george.sample_timepicker_v4.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timePicker1.setOnTimeChangedListener{ view, hour, minute ->
            Toast.makeText(this, hour.toString() + " : " + minute.toString() , Toast.LENGTH_SHORT).show()
        }

        binding.textView1.setOnClickListener{ view ->
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR)
            val minute = c.get(Calendar.MINUTE)

            val tpd = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener(function = { view, hour, minute ->
                Toast.makeText(this, hour.toString() + " : " + minute.toString() , Toast.LENGTH_SHORT).show()
            }),hour,minute,false)
            tpd.show()
        }
    }
}

