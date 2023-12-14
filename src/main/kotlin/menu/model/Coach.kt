package menu.model

class Coach(private val name: String, private val restrictedMenus: List<String>) {
    private var lunchMenus = mutableListOf<String>()

    fun setLunchMenu(lunchMenu: String) {
        lunchMenus.add(lunchMenu)
    }

    fun getName() = name
    fun getRestrictedMenus() = restrictedMenus

    fun getLunchMenus() = lunchMenus
}