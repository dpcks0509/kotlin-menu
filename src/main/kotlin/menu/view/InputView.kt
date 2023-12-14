package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.utils.Validator.validateCoachNames
import menu.utils.Validator.validateRestrictedMenus

class InputView {
    fun readCoachNames(): List<String> {
        println()
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        return try {
            val coachNames = Console.readLine()
            validateCoachNames(coachNames)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            readCoachNames()
        }
    }

    fun readRestrictedFoods(coachName: String): List<String> {
        println()
        println("${coachName}(이)가 못 먹는 메뉴를 입력해 주세요.")
        return try {
            val restrictedFoods = Console.readLine()
            validateRestrictedMenus(restrictedFoods)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            readRestrictedFoods(coachName)
        }
    }
}