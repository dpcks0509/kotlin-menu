package menu.controller

import menu.model.Coach
import menu.model.Service
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printServiceStart()
        val coachNames = inputView.readCoachNames()
        val coaches = coachNames.map { coachName ->
            val restrictedFoods = inputView.readRestrictedFoods(coachName)
            Coach(coachName, restrictedFoods)
        }
        val service = Service(coaches)
        outputView.printServiceResult(service.getServiceResult())
    }
}