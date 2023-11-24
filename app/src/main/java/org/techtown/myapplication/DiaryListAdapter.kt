package org.techtown.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.myapplication.R

class DiaryListAdapter : RecyclerView.Adapter<DiaryListAdapter.ViewHolder>() {
    private var mLstDiary: ArrayList<DiaryModel> = ArrayList() // 다이어리 데이터들을 들고 있는 자료형 (배열)
    private lateinit var mContext: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_weather: ImageView = itemView.findViewById(R.id.iv_weather) // 날씨 이미지
        var tv_title: TextView = itemView.findViewById(R.id.tv_title) // 다이어리 제목
        var tv_user_date: TextView = itemView.findViewById(R.id.tv_user_date) // 사용자 지정 날짜

        init {
            // 일반 클릭 (상세보기)
            itemView.setOnClickListener {
                val currentPosition = adapterPosition
                val diaryModel = mLstDiary[currentPosition]

                // 화면 이동 및 다이어리 데이터 전달
                val diaryDetailIntent = Intent(mContext, DiaryDetailActivity::class.java)
                diaryDetailIntent.putExtra("diaryModel", diaryModel) // 다이어리 데이터 전달
                diaryDetailIntent.putExtra("mode", "detail") // 상세보기 모드로 설정
                mContext.startActivity(diaryDetailIntent)
            }

            // 롱 클릭 (선택지 옵션 팝업: 수정, 삭제)
            itemView.setOnLongClickListener {
                val currentPosition = adapterPosition
                val diaryModel = mLstDiary[currentPosition]

                val strChoiceArray = arrayOf("수정 하기", "삭제 하기")
                AlertDialog.Builder(mContext)
                    .setTitle("원하시는 동작을 선택하세요")
                    .setItems(strChoiceArray) { dialogInterface: DialogInterface, position: Int ->
                        if (position == 0) {
                            // 수정 하기 버튼을 눌렀을 때
                            val diaryDetailIntent = Intent(mContext, DiaryDetailActivity::class.java)
                            diaryDetailIntent.putExtra("diaryModel", diaryModel) // 다이어리 데이터 전달
                            diaryDetailIntent.putExtra("mode", "modify") // 수정 하기 모드로 설정
                            mContext.startActivity(diaryDetailIntent)
                        } else {
                            // 삭제 하기 버튼을 눌렀을 때
                            mLstDiary.removeAt(currentPosition)
                            notifyItemRemoved(currentPosition)
                        }
                    }.show()
                false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val holder = LayoutInflater.from(mContext).inflate(R.layout.list_item_diary, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 생성된 아이템 뷰가 실제 연동이 되어지는 곳
        val weatherType = mLstDiary[position].weatherType
        when (weatherType) {
            0 -> holder.iv_weather.setImageResource(R.drawable.img_sunny)
            1 -> holder.iv_weather.setImageResource(R.drawable.img_cloud)
            2 -> holder.iv_weather.setImageResource(R.drawable.img_bad_cloud)
            3 -> holder.iv_weather.setImageResource(R.drawable.img_rainy)
            4 -> holder.iv_weather.setImageResource(R.drawable.img_snow)
        }

        val title = mLstDiary[position].title
        val userDate = mLstDiary[position].userDate

        holder.tv_title.text = title
        holder.tv_user_date.text = userDate
    }

    override fun getItemCount(): Int {
        return mLstDiary.size
    }

    fun setSampleList(lstDiary: ArrayList<DiaryModel>) {
        mLstDiary = lstDiary
    }
}
