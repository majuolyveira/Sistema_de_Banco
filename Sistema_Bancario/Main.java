import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = Banco.getInstancia();
        int i, id;
        String nome, telefone, endereco;
        
        int opcao;
        do{
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Cadastro de Titular");
            System.out.println("2. Cadastro de Conta");
            System.out.println("3. Operar conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                cadastrarTitular(banco, scanner);
                break;
                case 2:
                cadastrarConta(banco, scanner);
                
                break;
                case 3:
                operarConta(banco, scanner);

                break;
                case 4:
                System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            } 
        } while (opcao != 4);
        
        scanner.close();
                
            }
            public static void cadastrarTitular(Banco banco, Scanner scanner) {
                System.out.println("Cadastro de Titular");
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o telefone: ");
                String telefone = scanner.nextLine();
                System.out.print("Digite o endereço: ");
                String endereco = scanner.nextLine();
                
                Titular titular = new Titular(nome, telefone, endereco);
                banco.adicionarTitular(titular);
                System.out.println("Titular cadastrado com sucesso!");
            }
            
            public static void cadastrarConta(Banco banco, Scanner scanner) {
                System.out.println("Cadastro de Conta");
                System.out.println("Escolha um titular para a conta:");
            
                List<Titular> titulares = banco.getTitulares();
                for (int i = 0; i < titulares.size(); i++) {
                    System.out.println((i + 1) + ". " + titulares.get(i).getNome());
                }
            
                int escolhaTitular = scanner.nextInt();
                Titular titularEscolhido = titulares.get(escolhaTitular - 1);
            
                System.out.print("Digite a agência da conta: ");
                String agencia = scanner.next();
                
                System.out.print("Digite o número da conta: ");
                String numero = scanner.next();
            
                Conta conta = new Conta(null, titularEscolhido, 0.0, agencia, numero);
                banco.adicionarConta(conta);
                System.out.println("Conta cadastrada com sucesso!");
            }
            
            
            public static void operarConta(Banco banco, Scanner scanner) {
                System.out.println("Operar Conta");
                System.out.println("Escolha uma conta:");
        
                List<Conta> contas = banco.getContas();
                for (int i = 0; i < contas.size(); i++) {
                    System.out.println((i + 1) + ". Conta do Titular: " + contas.get(i).getTitular().getNome());
                }
                int escolhaConta = scanner.nextInt();
                Conta contaEscolhida = contas.get(escolhaConta - 1);
        
                int opcaoOperacao;

                do{
                    System.out.println("MENU DE OPERAÇÕES");
                    System.out.println("1. Ver saldo");
                    System.out.println("2. Depositar");
                    System.out.println("3. Sacar");
                    System.out.println("4. Tranferir");
                    System.out.println("5. Voltar ao menu principal");
                    System.out.println("Escolha uma alternativa! ");
            
                    opcaoOperacao = scanner.nextInt();
                    scanner.nextLine();
            
                     switch (opcaoOperacao) {
                case 1:
                    System.out.println("Saldo atual: " + contaEscolhida.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    contaEscolhida.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (contaEscolhida.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para realizar o saque.");
                    }
                    break;
                case 4:
                    System.out.println("Escolha uma conta para transferência:");
                    for (int i = 0; i < contas.size(); i++) {
                        if (i != escolhaConta - 1) {
                            System.out.println((i + 1) + ". Conta do Titular: " + contas.get(i).getTitular().getNome());
                        }
                    }
                    int escolhaContaDestino = scanner.nextInt();
                    Conta contaDestino = contas.get(escolhaContaDestino - 1);

                    System.out.print("Digite o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    contaEscolhida.transferir(contaDestino, valorTransferencia);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma operação válida.");
                    break;
            }
        } while (opcaoOperacao != 5);
    }
}
