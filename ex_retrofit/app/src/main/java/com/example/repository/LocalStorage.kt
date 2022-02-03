package com.example.repository

import android.content.Context
import androidx.room.*
import com.example.data.Item
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalStorage @Inject internal constructor(@ApplicationContext context: Context) {
    val database: TradingDatabase by lazy {TradingDatabase.getDatabase(context)}

    fun getTradingData(LAWD_CD: String, DEAL_YMD: String): Flow<List<TradingItem>> {
        return database.tradingDataDao().getTradingData(LAWD_CD, DEAL_YMD)
    }
    fun insert(inItem: Item, LAWD_CD: String, DEAL_YMD: String) {
        var outItem = TradingItem().apply {
            this.LAWD_CD = LAWD_CD
            this.DEAL_YMD = DEAL_YMD
            this.DealAmount = inItem.DealAmount
            this.BuildYear = inItem.BuildYear
            this.DealYear = inItem.DealYear
            this.Dong = inItem.Dong
            this.ApartmentName = inItem.ApartmentName
            this.DealMonth = inItem.DealMonth
            this.DealDay = inItem.DealDay
            this.AreaForExclusiveUse = inItem.AreaForExclusiveUse
            this.Jibun = inItem.Jibun
            this.RegionalCode = inItem.RegionalCode
            this.Floor = inItem.Floor
            this.CancelDealType = inItem.CancelDealType
            this.CancelDealDay = inItem.CancelDealDay
            //this.REQGBN =
            //this.RdealerLawdnm =
        }
        return database.tradingDataDao().insert(outItem)
    }
}


@Database(entities = [TradingItem::class], version = 1, exportSchema = false)
abstract class TradingDatabase: RoomDatabase() {
    abstract fun tradingDataDao(): TradingDataDao

    companion object {
        @Volatile
        private var INSTANCE: TradingDatabase? = null

        fun getDatabase(context: Context): TradingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TradingDatabase::class.java,
                    "trading_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

@Dao
interface TradingDataDao {
    @Query("SELECT * FROM TradingItem WHERE LAWD_CD = :LAWD_CD AND DEAL_YMD = :DEAL_YMD")
    fun getTradingData(LAWD_CD: String, DEAL_YMD: String): Flow<List<TradingItem>>

    @Insert
    fun insert(tradingitem: TradingItem)

    @Delete
    fun delete(tradingitem: TradingItem)
}

@Entity(primaryKeys = ["LAWD_CD", "DEAL_YMD"])
data class TradingItem(
    var LAWD_CD: String = "test",
    var DEAL_YMD: String = "test",
    var DealAmount: String ?= null,
    var BuildYear: String?=null,
    var DealYear: String?=null,
    var Dong: String?=null,
    var ApartmentName: String?=null,
    var DealMonth: String?=null,
    var DealDay: String?=null,
    var AreaForExclusiveUse: String?=null,
    var Jibun: String?=null,
    var RegionalCode: String?=null,
    var Floor: String?=null,
    var CancelDealType: String?=null,
    var CancelDealDay: String?=null,
    var REQGBN: String?=null,
    var RdealerLawdnm: String?=null
)