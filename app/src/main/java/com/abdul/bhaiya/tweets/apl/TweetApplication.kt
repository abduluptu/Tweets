package com.abdul.bhaiya.tweets.apl

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//step4: create application class which is used to create dagger code implicitly

@HiltAndroidApp
class TweetApplication : Application()