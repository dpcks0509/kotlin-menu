package menu.model

class Coach(private val name: String, private val restrictedMenus: List<String>) {
    private var lunchMenus = listOf<String>()

    fun setLunchMenus(lunchMenus: List<String>) {
        this.lunchMenus = lunchMenus
    }

    fun getName() = name
    fun getRestrictedMenus() = restrictedMenus
}