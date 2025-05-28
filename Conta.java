public abstract class Conta implements Iconta{
    protected int agencia;
    protected int numero;
    protected String senha;
    protected double saldo;
    protected Cliente cliente; 

    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1; 

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;  
        this.numero = SEQUENCIAL++;
        this.senha = "123";
        this.cliente = cliente;  
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }   

    public double getSaldo() {
        return saldo;
    }

    protected String getSenha(){
        return senha;
    }

    @Override
    public void sacar(double valor) {
        if (saldo <= valor){
            this.saldo -= valor;
        }else{
            System.out.println("Saldo insuficiente!");
        }        
        
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void trasferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        if (this.saldo <= valor)
            contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", getAgencia()));
        System.out.println(String.format("Conta: %d", getNumero()));
        System.out.println(String.format("Saldo: %.2f", getSaldo()));
    }

  
}
