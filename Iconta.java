public interface Iconta {

    void sacar(double valor);

    void depositar(double valor);

    void trasferir(double valor, Conta contaDestino);

    void imprimirExtrato(); 

}