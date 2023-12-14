package menu.utils

enum class Exception(private val message: String) {
    INVALID_COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자이다."),
    INVALID_COACH_NAME_FORMAT("코치의 이름은 첫 글자나 마지막 글자가 공백이 아니다."),
    INVALID_COACH_NAMES_SIZE("코치는 최소 2명, 최대 5명이다."),
    INVALID_COACH_NAMES_DUPLICATE("코치의 이름은 중복되지 않는다."),
    INVALID_RESTRICTED_MENU_FORMAT("각 코치의 못 먹는 메뉴는 첫 글자나 마지막 글자가 공백이 아니다."),
    INVALID_RESTRICTED_MENU_EXISTS("각 코치의 못 먹는 메뉴는 메뉴 추천 서비스에 존재하는 메뉴이다."),
    INVALID_RESTRICTED_MENUS_SIZE("각 코치의 못 먹는 메뉴는 최소 0개, 최대 2개이다."),
    INVALID_RESTRICTED_MENUS_DUPLICATE("각 코치의 못 먹는 메뉴는 중복되지 않는다.");

    fun getMessage() = "[ERROR] $message"
}