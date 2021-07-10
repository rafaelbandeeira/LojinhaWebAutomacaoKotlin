package paginas

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ListaProdutosPage(
    browser: WebDriver
) : BasePage(browser) {

    @FindBy(linkText = "ADICIONAR PRODUTO")
    private lateinit var addProdutoBtn: WebElement

    fun acessarPaginaNovoProduto(): NovoProdutoPage {
        addProdutoBtn.click()
        return NovoProdutoPage(browser)
    }

    fun lerMensagem(): String = capturarMensagem()
}