package org.techtown.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // onCreate(): Activity(화면)이 시작될 때 가장 먼저 실행되는 곳! 안드로이드 액티비티 생명주기

        // 딜레이를 발생시켜서 (1~2초) 그 이후에 MainActivity로 이동해야 함.
        Handler(mainLooper).postDelayed({
            // 메인 액티비티로 이동하는 부분
            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            // SplashActivity 출발 -> MainActivity 도착
            startActivity(mainIntent) // mainIntent를 실행
            // 실행이 되었을 때 처음 시작 화면을 종료해야 함.
            finish()
        }, 1500) // 1.5초 딜레이 함수 생성
    }
}