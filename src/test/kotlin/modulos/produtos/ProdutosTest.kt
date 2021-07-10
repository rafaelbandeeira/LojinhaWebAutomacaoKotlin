package modulos.produtos

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import paginas.LoginPage
import java.time.Duration

class ProdutosTest {
    private lateinit var browser: WebDriver

    @BeforeEach
    fun setup() {
        WebDriverManager.chromedriver().setup()
        browser = ChromeDriver()
        browser.manage().window().maximize()
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3))
        browser.get("http://165.227.93.41/lojinha-web/v2")
    }

    @AfterEach
    fun teardown() {
        browser.quit()
    }

    @Test
    @DisplayName("Nao é permitido registrar produtos com valor igual a zero")
    fun testNaoEPermitidoRegistrarProdutosComValorIgualAZero() {
        val mensagemToast: String = LoginPage(browser)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterLogin()
            .acessarPaginaNovoProduto()
            .inserirNomeProduto("Samsung S21 Ultra")
            .inserirValorProduto("0")
            .inserirCoresProduto("preto, azul")
            .submeterItemComErro()
            .capturarMensagem()

        Assertions.assertEquals(
            "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",
            mensagemToast
        )
    }
    @Test
    @DisplayName("Não é permitido registrar produtos com valor maior que 7.000")
    fun testNaoEPermitidoRegistrarProdutosComValorMaiorQueSeteMil() {
        val mensagemToast: String = LoginPage(browser)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterLogin()
            .acessarPaginaNovoProduto()
            .inserirNomeProduto("Samsung S21 Ultra")
            .inserirValorProduto("700001")
            .inserirCoresProduto("preto, azul")
            .submeterItemComErro()
            .capturarMensagem()

        Assertions.assertEquals(
            "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",
            mensagemToast
        )
    }

    @Test
    @DisplayName("criar produto com valor de 7.000")
    fun testCriarProdutoComValorDeSeteMil() {
        val mensagemToast: String = LoginPage(browser)
            .informarUsuario("admin")
            .informarSenha("admin")
            .submeterLogin()
            .acessarPaginaNovoProduto()
            .inserirNomeProduto("Samsung S21 Ultra")
            .inserirValorProduto("700000")
            .inserirCoresProduto("preto, azul")
            .submeterItemComErro()
            .capturarMensagem()

        Assertions.assertEquals(
            "Produto adicionado com sucesso",
            mensagemToast
        )
    }
}