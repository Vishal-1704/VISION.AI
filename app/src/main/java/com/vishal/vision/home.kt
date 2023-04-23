package com.vishal.vision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.Button


class home : AppCompatActivity() {

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
        const val REQUEST_IMAGE_PICK = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cameraButton: Button = findViewById(R.id.camera_button)
        cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }

        val imageButton: Button = findViewById(R.id.image_button)
        imageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_IMAGE_PICK)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    val imageBitmap: Bitmap? = data?.extras?.get("data") as Bitmap?
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("imageBitmap", imageBitmap)
                    startActivity(intent)
                }

                REQUEST_IMAGE_PICK -> {
                    val imageUri: Uri? = data?.data
                    if (imageUri != null) {
                        // Handle the image URI here
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("imageUri", imageUri.toString())
                        startActivity(intent)

                    }
                }
            }
        }
    }
}