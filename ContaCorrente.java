public class ContaCorrente extends Conta{

    

    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

     @Override
    public void imprimirExtrato() {
        // TODO Auto-generated method stub
        System.out.println("------CONTA CORRENTE--------");
        super.imprimirExtrato();
    }
}