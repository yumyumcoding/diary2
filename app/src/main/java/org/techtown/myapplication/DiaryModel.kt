package org.techtown.myapplication

import java.io.Serializable

/**
 * 다이어리 리스트 아이템을 구성하는 모델(표본)
 */
data class DiaryModel(
    var id: Int = 0,           // 게시물 고유 id 값
    var title: String = "",    // 게시물 제목
    var content: String = "",  // 게시물 내용
    var weatherType: Int = 0,  // 날씨 값 (0:맑음,1:흐림 뒤 갬,2:흐림,3:매우 흐림,4:비,5:눈)
    var userDate: String = "", // 사용자가 지정한 날짜(일시)
    var writeDate: String = "" // 게시글 작성한 날짜(일시)
) : Serializable
