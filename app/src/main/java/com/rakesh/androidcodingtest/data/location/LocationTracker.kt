package com.rakesh.androidcodingtest.data.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}