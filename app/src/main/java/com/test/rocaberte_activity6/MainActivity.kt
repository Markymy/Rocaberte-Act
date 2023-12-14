package com.test.rocaberte_activity6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAlert = findViewById<Button>(R.id.button_alert_dialog)
        val buttonDate = findViewById<Button>(R.id.button_date_picker_dialog)
        val buttonTime = findViewById<Button>(R.id.button_time_picker_dialog)

        buttonAlert.setOnClickListener {
            showAlertDialog()
        }

        buttonDate.setOnClickListener {
            showDatePickerDialog()
        }

        buttonTime.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Alert Dialog")
            .setMessage("This is an alert dialog.")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "You clicked OK", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(this, "You clicked Cancel", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, selectedYear, selectedMonth, dayOfMonth ->
            val dateString = "You picked: $selectedYear/${selectedMonth + 1}/$dayOfMonth"
            Toast.makeText(this, dateString, Toast.LENGTH_SHORT).show()
        }, year, month, day).show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            val timeString = "You picked: $selectedHour:$selectedMinute"
            Toast.makeText(this, timeString, Toast.LENGTH_SHORT).show()
        }, hour, minute, true).show()
    }
}