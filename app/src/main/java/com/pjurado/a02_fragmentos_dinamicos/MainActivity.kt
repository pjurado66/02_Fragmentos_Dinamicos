package com.pjurado.a02_fragmentos_dinamicos

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pjurado.a02_fragmentos_dinamicos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.fragmento, PrimerFragment()).commit()

        var primeroCargado = true;
        binding.floatingActionButton.setOnClickListener {
            if (primeroCargado){
                supportFragmentManager.beginTransaction().replace(R.id.fragmento, SegundoFragment()).commit()
            }
            else{
                supportFragmentManager.beginTransaction().replace(R.id.fragmento, PrimerFragment()).commit()
            }
            primeroCargado = !primeroCargado
        }

    }
}