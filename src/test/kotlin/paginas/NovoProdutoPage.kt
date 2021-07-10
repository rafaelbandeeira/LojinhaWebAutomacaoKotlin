package paginas

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class NovoProdutoPage(
    browser: WebDriver
) : BasePage(browser) {
    @FindBy(id = "produtonome")
    private lateinit var nome: WebElement

    @FindBy(id = "produtovalor")
    private lateinit var valor: WebElement

    @FindBy(id = "produtocores")
    private lateinit var cores: WebElement

    @FindBy(css = "button[type='submit'")
    private lateinit var submitBtn: WebElement

    fun inserirNomeProduto(nomeProduto: String): NovoProdutoPage {
        nome.sendKeys(nomeProduto)
        return this
    }

    fun inserirValorProduto(valorProduto: String): NovoProdutoPage {
        valor.sendKeys(valorProduto)
        return this
    }

    fun inserirCoresProduto(coresProduto: String): NovoProdutoPage {
        cores.sendKeys(coresProduto)
        return this
    }

    fun submeterItem() = submitBtn.click()

    fun submeterItemComErro(): ListaProdutosPage {
        submeterItem()
        return ListaProdutosPage(browser)
    }

    fun submeterItemComSucesso(): EdicaoProdutoPage {
        submeterItem()
        return EdicaoProdutoPage(browser)
    }

}