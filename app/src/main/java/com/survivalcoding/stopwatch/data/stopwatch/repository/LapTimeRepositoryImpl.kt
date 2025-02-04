package com.survivalcoding.stopwatch.data.stopwatch.repository

import androidx.annotation.WorkerThread
import com.survivalcoding.stopwatch.data.stopwatch.data_source.dao.LapTimeRecordDao
import com.survivalcoding.stopwatch.domain.stopwatch.model.LapTimeRecord
import com.survivalcoding.stopwatch.domain.stopwatch.repository.LapTimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LapTimeRepositoryImpl @Inject constructor(private val lapTimeRecordDao: LapTimeRecordDao) :
    LapTimeRepository {
    @WorkerThread
    override fun getLapTimes(): Flow<List<LapTimeRecord>> {
        return lapTimeRecordDao.getAll()
    }

    @WorkerThread
    override suspend fun insertLapTime(lapTimeRecord: LapTimeRecord) {
        return lapTimeRecordDao.insert(lapTimeRecord)
    }

    @WorkerThread
    override suspend fun deleteLapTime(lapTimeRecord: LapTimeRecord) {
        return lapTimeRecordDao.delete(lapTimeRecord)
    }

    @WorkerThread
    override suspend fun deleteAllLapTimes() {
        return lapTimeRecordDao.deleteAll()
    }
}