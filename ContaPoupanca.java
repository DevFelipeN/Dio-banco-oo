public class ContaPoupanca extends Conta{   

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        // TODO Auto-generated method stub
        System.out.println("------CONTA POUPANÇA--------");
        super.imprimirExtrato();
    }


}