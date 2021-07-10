package paginas

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

abstract class BasePage(
    val browser: WebDriver
) {
    @FindBy(css = ".toast.rounded")
    private lateinit var mensagemToast: WebElement

    init {
        PageFactory.initElements(browser, this)
    }

    fun capturarMensagem(): String {
        return mensagemToast.text
    }
}