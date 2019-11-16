package com.lakooz.lpctest.repositories

import com.lakooz.lpctest.MyApplication
import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.networking.RestApiClient

class PotRepository(
    application: MyApplication,
    private val potApi: RestApiClient,
    private val potDao: PotDao
) {

    fun createOrUpdate(pot: Pot) {
        potDao.createOrUpdate(pot)
    }

    fun insertAllAndSynchronize(pots: List<Pot>) {
        potDao.insertAllAndSynchronize(pots)
    }

    fun getPots(category: Int = 0) = potDao.getPots(category)

//    get rid of this instantiator and instanciate from caller : to try , and pass it manyally in the constructor for each ViewModel

    /*
    // no you need to init
    companion object {
        // TODO : initialize
        val instance : PotRepository = AppDatabase.getInstance(context = application.)
    }
    */

    /*
    init {
        val instance: PotRepository = AppDatabase.getInstance(
            application.applicationContext
        )
    }
     */
}