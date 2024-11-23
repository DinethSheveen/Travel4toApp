package com.example.travelapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //current image which is displayed
        var currentImage = 0
        lateinit var image : ImageView
        var venueNames = arrayOf("SIGIRIYA","PERADENIYA","NUWARA ELIYA","KANDY","GALLE FORT")

        //getting the id's of the buttons to function them
        val nextButton = findViewById<ImageButton>(R.id.nextBtn)
        val prevButton = findViewById<ImageButton>(R.id.prevBtn)
        var placeName = findViewById<TextView>(R.id.venueName)

        nextButton.setOnClickListener{
            //should render the next image to the user
            var crntImageIdString = "pic$currentImage"      //IMAGE ID OF TYPE STRING

            //CONVERTING THE STRING IS INTO AN INTEGER
            var crntImageIdInt = this.resources.getIdentifier(crntImageIdString,"id",packageName)
            image = findViewById(crntImageIdInt)
            image.alpha = 0f

            currentImage = (5+currentImage+1)%5
            var nextImageString = "pic$currentImage"
            var nextImageInt = this.resources.getIdentifier(nextImageString,"id",packageName)
            image = findViewById(nextImageInt)
            image.alpha = 1f
            placeName.text = venueNames[currentImage]
        }

        prevButton.setOnClickListener{
            //Should render the previous image to the user
            var crntImageIdString = "pic$currentImage"      //IMAGE ID OF TYPE STRING

            //CONVERTING THE STRING IS INTO AN INTEGER
            var crntImageIdInt = this.resources.getIdentifier(crntImageIdString,"id",packageName)
            image = findViewById(crntImageIdInt)
            image.alpha = 0f

            currentImage = (5+currentImage-1)%5
            var nextImageString = "pic$currentImage"
            var nextImageInt = this.resources.getIdentifier(nextImageString,"id",packageName)
            image = findViewById(nextImageInt)
            image.alpha = 1f
            placeName.text = venueNames[currentImage]
        }

    }
}