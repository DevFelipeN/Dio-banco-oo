import java.util.Scanner;
import java.util.stream.IntStream;

class Main{
    public static void main(String[] args){

        // Inicia o Banco
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int b = 0;

        do{
            System.out.println("=============++++++++++++++++++================\n\n");
            System.out.println("Bem vindo ao Uniblanco\n");

            System.out.println("(1) - CRIAR CONTA");
            System.out.println("(2) - Entrar");
            System.out.println("(3) - Encerrar sessão");

            System.out.printf("opção: ");
            b = scanner.nextInt();

            if (b == 3) break;
            
            if (b == 1){
                Cliente cliente = new Cliente();
                    System.out.printf("Informe seu Nome: ");
                    cliente.setNome(scanner.next());
                    System.out.printf("Informe seu CPF: ");
                    cliente.setCpf(scanner.nextLong()); 

                    System.out.println("---------------+++++++++++++++");
                    System.out.println("---------------+++++++++++++++");
                    System.out.println("---------------+++++++++++++++");

                    System.out.println("Selecione o tipo de conta que deseja criar:");
                    System.out.println("(1) - Corrente");
                    System.out.println("(2) - Poupança");
                    System.out.printf("opção: ");

                    int tp = scanner.nextInt();

                    Conta conta = null;

                    if (tp == 1 ){
                        conta = new ContaCorrente(cliente);
                        banco.listContas.add(conta);
                    }
                    if (tp == 2 ){
                        conta = new ContaPoupanca(cliente);
                        banco.listContas.add(conta);
                    }

                    

                    System.out.println("---------------+++++++++++++++");
                    System.out.println("---------------+++++++++++++++");
                    System.out.println("---------------+++++++++++++++");

                    System.out.println("Prontinho sua conta foi criada com sucesso!");
                    System.out.println("Para acesso a sua conta ultilize seu cpf e a senha crida!");
                    conta.imprimirExtrato();
                    System.out.println("Sua senha é: "+conta.getSenha());                                        
                    System.out.println("---------------+++++++++++++++");

            }

            Conta contaAtual = null;
            System.out.println("=============Para acesso a sua conta=================\n\n");
            System.out.printf("Informe seu CPF:");
            Long cpf = scanner.nextLong();

            // Verifica se existe alguma conta nesse banco com o cpf informado!

            //boolean existCpf = banco.listContas.stream()
                //.anyMatch(p -> p.cliente.getCpf().equals(cpf));   

            int index = IntStream.range(0, banco.listContas.size())
                .filter(i -> banco.listContas.get(i).cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(-1);

            if (index != -1){
                contaAtual = banco.listContas.get(index);
            }

            boolean acesso = false;


            if (contaAtual != null){
                System.out.println("Olé senhor(a) "+contaAtual.cliente.getNome()+"!");
                System.out.printf("Informe sua senha: ");
                String senhaInfo = scanner.next();

                if (contaAtual.senha.equals(senhaInfo)){
                    acesso = true;
                }else{
                    System.out.println("SENHA INVÁLIDA");
                }

            }
            

            if (acesso){

                System.out.println("Acesso concedido\n");
                System.out.println("Bem vindo ao Uniblanco\n");

                int op = 0;

                do {

                    System.out.println("Selecione a opção desejada:");
                    System.out.println("(1) - DEPOSITO");
                    System.out.println("(2) - SAQUE");
                    System.out.println("(3) - TRANFERÊNCIA");
                    System.out.println("(4) - EXTRATO");
                    System.out.println("(5) - SAIR");
                    System.out.printf("opção: ");

                    op = scanner.nextInt();

                    if(op < 1 || op > 5){
                        System.out.println("Opção invalida!!\n\n");
                        System.out.println("Escolha uma opção válida!\n\n");
                    }

                    switch (op) {
                        case 1:

                            System.out.println("Qual o valor do depósito?");
                            System.out.printf("valor:");
                            double valor = scanner.nextDouble();
                            contaAtual.depositar(valor);
                            System.out.println("---------------+++++++++++++++");
                            System.out.println("---------------+++++++++++++++");
                            System.out.println("Valor depositado em sua conta!");
                            System.out.println("---------------+++++++++++++++");
                            break;                

                        case 2:

                        case 3:

                        case 4:
                            contaAtual.imprimirExtrato();
                            break;
                        case 5:
                            break;                       
                                        
                        default:    
                            System.out.println("Opção invalida!!\n\n");
                            System.out.println("Escolha uma opção válida!\n\n");       
                            break;
                    }


                } while (op != 5);
            }else{
                System.out.println("DADO DE CLIENTE INVÁLIDO");
            }
        }while (b != 3);
        scanner.close();

    }
}