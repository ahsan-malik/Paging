package com.ahsanmalik.paging.db

import com.ahsanmalik.paging.db.remote.MyApi
import javax.inject.Inject

class Repository @Inject constructor(val apiService:MyApi)