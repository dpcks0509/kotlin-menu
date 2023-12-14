package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.utils.Validator.validateCoachNames

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
}