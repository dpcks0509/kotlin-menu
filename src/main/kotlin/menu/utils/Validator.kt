package menu.utils

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
}