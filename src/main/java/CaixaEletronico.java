public class CaixaEletronico {
    int saldo;
    int valorAnulado;
    int somatorioDeCedulas;
    String naoEDivisivelPorCinco;
    QuantidadeDeCedulasRestantes cedulas = new QuantidadeDeCedulasRestantes();
    ContadorDeCedulasUtilizadas contador = new ContadorDeCedulasUtilizadas();

    public void sacar(int valorASacar) {

        this.saldo = valorASacar;
        valorAnulado = valorASacar;

        valorASacar = getValorASacar(valorASacar);

        if (valorASacar % 5 == 0) {
            somatorioDeCedulas = contador.getQuantidade50()+contador.getQuantidade10()+contador.getQuantidade5();
            System.out.println("Quantidade de nota de 50: " +
                    contador.getQuantidade50() + "\nquantidade de nota de 10: " +
                    contador.getQuantidade10() + "\nquantidade de nota de 05: " +
                    contador.getQuantidade5() + "\nQuantidade total de cédulas sacadas é de: "+
                    somatorioDeCedulas);
        } else {
            naoEDivisivelPorCinco = "Não é possível sacar: " + valorAnulado + "!! ";
            System.out.println(naoEDivisivelPorCinco);
        }
    }

    private int getValorASacar(int valorASacar) {
        while (valorASacar >= 50 && cedulas.quantidade50 != 0) {
            this.saldo -= 50;
            contador.setQuantidade50(contador.quantidade50 += 1);
            cedulas.quantidade50 -= 1;
            valorASacar = this.saldo;
        }
        while (valorASacar >= 10 && cedulas.quantidade10 != 0) {
            this.saldo -= 10;
            contador.setQuantidade10(contador.quantidade10 += 1);
            cedulas.quantidade10 -= 1;
            valorASacar = this.saldo;
        }
        while (valorASacar >= 5 && cedulas.quantidade5 != 0) {
            this.saldo -= 5;
            contador.setQuantidade5(contador.quantidade5 += 1);
            cedulas.quantidade5 -= 1;
            valorASacar = this.saldo;
        }
        return valorASacar;
    }
}
