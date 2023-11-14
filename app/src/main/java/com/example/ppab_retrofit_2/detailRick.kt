package com.example.ppab_retrofit_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ppab_retrofit_2.databinding.ActivityDetailRickBinding

class detailRick : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailRickBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var images = intent.getStringExtra("IMAGES")
        var names = intent.getStringExtra("NAMA")
        var species = intent.getStringExtra("SPECIES")
        var status = intent.getStringExtra("STATUS")
        var genders = intent.getStringExtra("GENDER")
        var locations = intent.getStringExtra("LOCATION")
        var location_url = intent.getStringExtra("LOCATION_URL")

        binding.name.text = "Name : ${names}"
        binding.species.text = "Species : ${species}"
        binding.status.text = "Status : ${status}"
        binding.gender.text = "Gender : ${genders}"
        binding.location.text = "Location : ${locations}"

        Glide.with(this@detailRick)
            .load(images)
            .fitCenter()
            .error(R.drawable.ic_launcher_background)
            .into(binding.gambarDetail)
    }
}