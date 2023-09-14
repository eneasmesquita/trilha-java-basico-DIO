import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {

        System.out.println("BEM VINDO A NOSSA SINGELA APP DE PROCESSO SELETIVO!\n");
        System.out.println(
                "SELECIONE UMA DAS OPCOES DESEJADAS: TECLE 1 PARA SELECIONAR case1 | 2 PARA SELECIONAR case2 | 3 PARA SELECIONAR case3 | 4 PARA SELECIONAR case4");

        try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // salario base maior que salario pretendido
                    case1(2000.0, 1900.0);

                    // salario base igual que salario pretendido4
                    case1(2000.0, 2000.0);

                    // salario base igual que salario pretendido
                    case1(1900.0, 2000.0);
                    break;

                case 2:
                    case2();
                    break;

                case 3:
                    case3();
                    break;

                case 4:
                    String[] candidatosSelecionados = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };
                    // primeiro um for para selecionar os candidatos
                    for (String candidato : candidatosSelecionados) {
                        case4(candidato);
                    }
                    break;

                default:
                    System.out.println("VOCÊ NÃO INSERIU UMA OPCAO VÁLIDA! TENTE NOVAMENTE!");
            }
        }

    }

    static void case1(double salarioBase, double salarioPretendido) {

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static void case2() {
        double salarioBase = 2000.0;
        String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA",
                "DANIELA", "JORGE" };
        int totalSelecionados = 0;
        int proximoCandidato = 0;
        while (totalSelecionados < 5 && proximoCandidato < candidatos.length) {
            String candidato = candidatos[proximoCandidato++];
            double valorPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " está pedindo " + valorPretendido);
            if (valorPretendido > salarioBase) {
                System.out.println("QUE PENA!! O candidato " + candidato + " NÃO foi selecionado ");

            } else {
                System.out.println("LEGAL!! O candidato " + candidato + " foi selecionado ");
                totalSelecionados++;
            }

        }
        System.out.println("Total de selecionados: " + totalSelecionados);
        System.out.println("Total de consultados: " + proximoCandidato);
    }

    static void case3() {
        String[] candidatosSelecionados = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };

        // forma indexada
        // quando preciso do indice para complementar a lógica
        System.out.println("Imprimindo com a ordem de seleção pelo índice");
        for (int x = 0; x < candidatosSelecionados.length; x++) {
            System.out.println((x + 1) + "° Candidato é " + candidatosSelecionados[x]);
        }

        // forma abrevida
        // interação total sem precisar da posição ou indice
        System.out.println("Imprimindo todos sem a necessidade de exibir o índice");

        for (String candidato : candidatosSelecionados) {
            System.out.println(candidato);
        }

    }

    static void case4(String candidato) {

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO TENTATIVAS "
                    + tentativasRealizadas + " REALIZADA");

    }

    // método auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
