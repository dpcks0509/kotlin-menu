package menu.utils

enum class Exception(private val message: String) {
    INVALID_COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자이다."),
    INVALID_COACH_NAME_FORMAT("코치의 이름은 첫 글자나 마지막 글자가 공백이 아니다."),
    INVALID_COACH_NAMES_SIZE("코치는 최소 2명, 최대 5명이다."),
    INVALID_COACH_NAMES_DUPLICATE("코치의 이름은 중복되지 않는다.");

    fun getMessage() = "[ERROR] $message"
}