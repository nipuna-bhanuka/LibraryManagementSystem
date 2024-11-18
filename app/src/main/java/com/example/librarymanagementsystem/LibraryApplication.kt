package com.example.librarymanagementsystem

import android.app.Application
import com.example.librarymanagementsystem.data.AppContainer
import com.example.librarymanagementsystem.data.AppDataContainer

class LibraryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        //deleteDatabase("library_database")
        container = AppDataContainer(this)
    }
}