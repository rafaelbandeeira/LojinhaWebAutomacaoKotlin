package paginas

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage(
    browser: WebDriver
) : BasePage(browser) {
    @FindBy(id = "usuario")
    private lateinit var usr: WebElement

    @FindBy(id = "senha")
    private lateinit var snh: WebElement

    @FindBy(css = "button[type='submit'")
    private lateinit var submitBtn: WebElement

    fun informarUsuario(usuario: String): LoginPage {
        usr.sendKeys(usuario)
        return this
    }

    fun informarSenha(senha: String): LoginPage {
        snh.sendKeys(senha)
        return this
    }

    fun submeterLogin(): ListaProdutosPage {
        submitBtn.click()
        return ListaProdutosPage(browser)
    }
}