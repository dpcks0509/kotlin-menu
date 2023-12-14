package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category.Companion.getMenusByCategoryNumber
import menu.model.Category.Companion.getTypeByCategoryNumber
import menu.utils.Constants.JAPANESE_NUMBER
import menu.utils.Constants.MAX_NUMBER_OF_CATEGORY
import menu.utils.Constants.NUMBER_OF_LUNCH
import menu.utils.Constants.POSTFIX
import menu.utils.Constants.PREFIX
import menu.utils.Constants.SEPARATOR
import menu.utils.Constants.WESTERN_NUMBER

class Service(private val coaches: List<Coach>) {
    private val categories = MutableList(NUMBER_OF_LUNCH + 1) { 0 }
    private val categoryTypes = mutableListOf("카테고리")

    init {
        for (index in 0 until NUMBER_OF_LUNCH) {
            generateRandomCategory()
            generateRandomMenu(categories[index], coaches)
        }
    }

    private fun generateRandomCategory() {
        var categoryNumber = Randoms.pickNumberInRange(JAPANESE_NUMBER, WESTERN_NUMBER)
        while (categories[categoryNumber] == MAX_NUMBER_OF_CATEGORY) {
            categoryNumber = Randoms.pickNumberInRange(JAPANESE_NUMBER, WESTERN_NUMBER)
        }
        categoryTypes.add(getTypeByCategoryNumber(categoryNumber))
        categories[categoryNumber] += 1
    }

    private fun generateRandomMenu(categoryNumber: Int, coaches: List<Coach>) {
        coaches.forEach { coach ->
            val menus = getMenusByCategoryNumber(categoryNumber)
            var menu = Randoms.shuffle(menus)[0]
            while (coach.getRestrictedMenus().contains(menu) || coach.getLunchMenus().contains(menu)) {
                menu = Randoms.shuffle(menus)[0]
            }
            coach.setLunchMenu(menu)
        }
    }

    fun getServiceResult(): String {
        val stringBuilder = StringBuilder()

        stringBuilder.append(categoryTypes.joinToString(SEPARATOR, PREFIX, POSTFIX)).append("\n")
        coaches.forEach { coach ->
            val nameAndLunchMenus = mutableListOf(coach.getName())
            nameAndLunchMenus.addAll(coach.getLunchMenus())
            stringBuilder.append(nameAndLunchMenus.joinToString(SEPARATOR, PREFIX, POSTFIX)).append("\n")
        }
        return stringBuilder.toString()
    }
}