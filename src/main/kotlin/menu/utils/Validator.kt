package menu.utils

import menu.model.Category.Companion.isMenuExists
import menu.utils.Constants.MAX_COACH_NAMES_SIZE
import menu.utils.Constants.MAX_COACH_NAME_LENGTH
import menu.utils.Constants.MIN_COACH_NAMES_SIZE
import menu.utils.Constants.MIN_COACH_NAME_LENGTH

object Validator {
    fun validateCoachNames(coachNames: String): List<String> {
        val validCoachNames = coachNames.split(",").map { coachName -> validateCoachName(coachName) }
        validateCoachNamesSize(validCoachNames)
        validateCoachNamesDuplicate(validCoachNames)
        return validCoachNames
    }

    private fun validateCoachName(coachName: String): String {
        validateCoachNameLength(coachName)
        validateCoachNameFormat(coachName)
        return coachName
    }

    private fun validateCoachNameLength(coachName: String) {
        require(coachName.length in MIN_COACH_NAME_LENGTH..MAX_COACH_NAME_LENGTH) { Exception.INVALID_COACH_NAME_LENGTH.getMessage() }
    }

    private fun validateCoachNameFormat(coachName: String) {
        require(coachName[0] != ' ' && coachName[coachName.length - 1] != ' ') { Exception.INVALID_COACH_NAME_FORMAT.getMessage() }
    }

    private fun validateCoachNamesSize(coachNames: List<String>) {
        require(coachNames.size in MIN_COACH_NAMES_SIZE..MAX_COACH_NAMES_SIZE) { Exception.INVALID_COACH_NAMES_SIZE.getMessage() }
    }

    private fun validateCoachNamesDuplicate(coachNames: List<String>) {
        require(coachNames.size == coachNames.toSet().size) { Exception.INVALID_COACH_NAMES_DUPLICATE.getMessage() }
    }

    fun validateRestrictedMenus(restrictedMenus: String): List<String> {
        val validRestrictedMenus =
            restrictedMenus.split(",").map { restrictedFood -> validateRestrictedMenu(restrictedFood) }
        validateRestrictedMenusSize(validRestrictedMenus)
        validateRestrictedMenusDuplicate(validRestrictedMenus)
        return validRestrictedMenus
    }

    private fun validateRestrictedMenu(restrictedMenu: String): String {
        if (restrictedMenu.isNotBlank()) {
            validateRestrictedMenuFormat(restrictedMenu)
            validateRestrictedMenuExists(restrictedMenu)
        }
        return restrictedMenu
    }

    private fun validateRestrictedMenuFormat(restrictedMenu: String) {
        require(restrictedMenu[0] != ' ' && restrictedMenu[restrictedMenu.length - 1] != ' ') { Exception.INVALID_RESTRICTED_MENU_FORMAT.getMessage() }
    }

    private fun validateRestrictedMenuExists(restrictedMenu: String) {
        require(isMenuExists(restrictedMenu)) { Exception.INVALID_RESTRICTED_MENU_EXISTS.getMessage() }
    }

    private fun validateRestrictedMenusSize(restrictedMenus: List<String>) {
        require(restrictedMenus.size in 0..2) { Exception.INVALID_RESTRICTED_MENUS_SIZE.getMessage() }
    }

    private fun validateRestrictedMenusDuplicate(restrictedMenus: List<String>) {
        require(restrictedMenus.size == restrictedMenus.toSet().size) { Exception.INVALID_RESTRICTED_MENUS_DUPLICATE.getMessage() }
    }
}