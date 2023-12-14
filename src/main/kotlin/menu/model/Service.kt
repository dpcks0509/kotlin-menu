package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category.Companion.getMenusByCategoryNumber
import menu.utils.Constants.JAPANESE_NUMBER
import menu.utils.Constants.MAX_NUMBER_OF_CATEGORY
import menu.utils.Constants.NUMBER_OF_LUNCH
import menu.utils.Constants.WESTERN_NUMBER

class Service(private val coaches: List<Coach>) {
    private val categories = MutableList(NUMBER_OF_LUNCH + 1) { 0 }

    init {
        generateRandomCategories(coaches)
    }

    private fun generateRandomCategories(coaches: List<Coach>) {
        val categoryNumbers = mutableListOf<Int>()
        repeat(NUMBER_OF_LUNCH) {
            var categoryNumber = Randoms.pickNumberInRange(JAPANESE_NUMBER, WESTERN_NUMBER)
            while (categories[categoryNumber] == MAX_NUMBER_OF_CATEGORY) {
                categoryNumber = Randoms.pickNumberInRange(JAPANESE_NUMBER, WESTERN_NUMBER)
            }
            categoryNumbers.add(categoryNumber)
            categories[categoryNumber] += 1
        }

        coaches.forEach { coach ->
            coach.setLunchMenus(generateRandomMenus(categoryNumbers, coach))
        }
    }

    private fun generateRandomMenus(categoryNumbers: List<Int>, coach: Coach): List<String> {
        val lunchMenus = mutableListOf<String>()

        for (categoryNumber in categoryNumbers) {
            val menus = getMenusByCategoryNumber(categoryNumber)
            var menu = Randoms.shuffle(menus)[0]
            while (coach.getRestrictedMenus().contains(menu) || lunchMenus.contains(menu)) {
                menu = Randoms.shuffle(menus)[0]
            }
            lunchMenus.add(menu)
        }

        println(categories)
        println(lunchMenus)

        return lunchMenus
    }
}