package paginas

import org.openqa.selenium.WebDriver

class EdicaoProdutoPage(
    browser: WebDriver
) : BasePage(browser) {
    fun lerMensagem(): String = capturarMensagem()
}