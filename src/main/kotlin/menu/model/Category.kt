package menu.model

import menu.utils.Constants.ASIAN_NUMBER
import menu.utils.Constants.CHINESE_NUMBER
import menu.utils.Constants.JAPANESE_NUMBER
import menu.utils.Constants.KOREAN_NUMBER
import menu.utils.Constants.WESTERN_NUMBER

enum class Category(private val menus: List<String>) {
    JAPANESE(
        listOf(
            "규동", "우동", "미소시루", "스시", "가츠동",
            "오니기리", "하이라이스", "라멘", "오코노미야끼"
        )
    ),
    KOREAN(
        listOf(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥",
            "칼국수", "불고기", "떡볶이", "제육볶음"
        )
    ),
    CHINESE(
        listOf(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕",
            "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
        )
    ),
    ASIAN(
        listOf(
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수",
            "똠얌꿍", "반미", "월남쌈", "분짜"
        )
    ),
    WESTERN(
        listOf(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트",
            "바게트", "스파게티", "피자", "파니니"
        )
    );

    companion object {
        fun isMenuExists(menu: String): Boolean {
            values().forEach { category ->
                if (menu in category.menus) {
                    return true
                }
            }
            return false
        }

        fun getMenusByCategoryNumber(categoryNumber: Int): List<String> {
            val category = when (categoryNumber) {
                JAPANESE_NUMBER -> JAPANESE
                KOREAN_NUMBER -> KOREAN
                CHINESE_NUMBER -> CHINESE
                ASIAN_NUMBER -> ASIAN
                else -> WESTERN
            }
            return category.menus
        }
    }
}