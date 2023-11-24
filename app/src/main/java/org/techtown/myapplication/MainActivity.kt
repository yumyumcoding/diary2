package org.techtown.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    // 리스트 화면 만들기
    private lateinit var mRvDiary: RecyclerView // 리사이클러 뷰 (리스트 뷰)
    private lateinit var mAdapter: DiaryListAdapter // 리사이클러 뷰와 연동할 어댑터
    private lateinit var mLstdiary: ArrayList<DiaryModel> // 리스트에 표현할 다어어리 데이터들 (배열)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLstdiary = ArrayList()

        mRvDiary = findViewById(R.id.rv_diary)
        mAdapter = DiaryListAdapter()

        // 다이어리 샘플 아이템 3개 생성
        val item = DiaryModel().apply {
            id = 0
            title = "다이어리 앱 제작 도전기! 1일차"
            content = "첫 날부터 도전적이었다!"
            userDate = "2023/11/25 Sat"
            writeDate = "2023/11/25 Sat"
            weatherType = 0
        }
        mLstdiary.add(item)

        val item2 = DiaryModel().apply {
            id = 0
            title = "다이어리 앱 제작 도전기! 2일차"
            content = "첫 날부터 도전적이었다!"
            userDate = "2023/11/26 Sun"
            writeDate = "2023/11/26 Sun"
            weatherType = 2
        }
        mLstdiary.add(item2)

        val item3 = DiaryModel().apply {
            id = 0
            title = "다이어리 앱 제작 도전기! 3일차"
            content = "첫 날부터 도전적이었다!"
            userDate = "2023/11/27 Mon"
            writeDate = "2023/11/27 Mon"
            weatherType = 4
        }
        mLstdiary.add(item3)

        mAdapter.setSampleList(mLstdiary)
        mRvDiary.adapter = mAdapter

        // 액티비티가 실행될 때 가장 먼저 호출되는 곳
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.btn_write)
        floatingActionButton.setOnClickListener {
            // 작성하기 버튼을 누를 때 호출되는 곳
        }
    }
}
