import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CaixaEletronicoTest {
    CaixaEletronico caixaEletronico = new CaixaEletronico();

    @Test
    void deveConseguirSacarUmaNotaDeCinquentaEDuasDeDez() {
        int quantidadeDeNotaDeCinquenta = 1;
        int quantidadeDeNotaDeDez = 2;
        int valorASacar = 70;

        caixaEletronico.sacar(valorASacar);

        Assert.assertEquals(caixaEletronico.contador.getQuantidade50(), quantidadeDeNotaDeCinquenta);
        Assert.assertEquals(caixaEletronico.contador.getQuantidade10(), quantidadeDeNotaDeDez);
    }

    @Test
    void deveConseguirSacarDuasNotasDeCinquentaTresDeDezEQuatroDeCinco() {
        int quantidadeDeNotaDeCinquenta = 2;
        int quantidadeDeNotaDeDez = 3;
        int quantidadeDeNotaDeCinco = 4;
        int valorASacar = 150;

        caixaEletronico.sacar(valorASacar);

        Assert.assertEquals(caixaEletronico.contador.getQuantidade50(), quantidadeDeNotaDeCinquenta);
        Assert.assertEquals(caixaEletronico.contador.getQuantidade10(), quantidadeDeNotaDeDez);
        Assert.assertEquals(caixaEletronico.contador.getQuantidade5(), quantidadeDeNotaDeCinco);
    }

    @Test
    void deveConseguirSacarUmaNotaDeCinco() {
        int quantidadeDeNotaDeCinquenta = 0;
        int quantidadeDeNotaDeDez = 0;
        int quantidadeDeNotaDeCinco = 1;
        int valorASacar = 5;

        caixaEletronico.sacar(valorASacar);

        Assert.assertEquals(caixaEletronico.contador.getQuantidade50(), quantidadeDeNotaDeCinquenta);
        Assert.assertEquals(caixaEletronico.contador.getQuantidade10(), quantidadeDeNotaDeDez);
        Assert.assertEquals(caixaEletronico.contador.getQuantidade5(), quantidadeDeNotaDeCinco);
    }

    @Test
    void naoDeveSacarValorASacarQueNaoSejaDivisivelPorCinco() {
        int valorASacar = 113;
        String valorDivisivel = "Não é possível sacar: " + valorASacar + "!! ";

        caixaEletronico.sacar(valorASacar);

        Assert.assertEquals(caixaEletronico.naoEDivisivelPorCinco, valorDivisivel);
    }
}
