package com.example.ejerciciodropdown

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerciciodropdown.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit private var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get the resources
        var idiomas = resources.getStringArray(R.array.Idiomas)
        // creamos el adapter
        var arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, idiomas)
        // se lo pasamos al auto complete text view
        binding.autoCompleteTextView.setAdapter(arrayAdapter)


    }
}