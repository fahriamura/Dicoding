package com.example.dicoding


import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.dicoding.FancyAboutPage

class aboutme: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aboutme2)
        title = "About Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        val fancyAboutPage: FancyAboutPage = findViewById(R.id.fancyaboutpage)
        // fancyAboutPage.setCoverTintColor(Color.BLUE) // Optional
        fancyAboutPage.setCover(R.drawable.gd)
        fancyAboutPage.setName("Amura Maulidi Fachry")
        fancyAboutPage.setDescription("I'm a third-year Informatics student at Telkom University who's passionate about technology and dedicated to pursuing a career in Mobile Developer. With a strong foundation in Kotlin and Flutter.")
        fancyAboutPage.setAppIcon(R.drawable.gg)
        fancyAboutPage.setAppName("Geometry Dash Demon List")
        fancyAboutPage.setVersionNameAsAppSubTitle("1.0.0")
        fancyAboutPage.setAppDescription("Are you ready to challenge your skills and reflexes in the world of Geometry Dash? Introducing the \"Geometry Dash Demon List\" app – your ultimate companion on the thrilling journey through demons and levels in this iconic rhythm-based platformer.")
        fancyAboutPage.addEmailLink("edogawaconax@gmail.com")
        fancyAboutPage.addLinkedinLink("https://www.linkedin.com/in/amura-maulidi-fachry-0978a9199/")
        fancyAboutPage.addGitHubLink("https://github.com/fahriamura")
        fancyAboutPage.addFacebookLink("https://www.instagram.com/sansssfahri/")
    }
}
