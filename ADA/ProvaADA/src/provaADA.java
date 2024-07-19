import java.util.Scanner;

public class provaADA{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitação dos nomes e salários brutos
        System.out.print("Digite o nome do funcionário 1: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite o salário bruto do funcionário 1: ");
        double salario1 = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.print("Digite o nome do funcionário 2: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite o salário bruto do funcionário 2: ");
        double salario2 = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.print("Digite o nome do funcionário 3: ");
        String nome3 = scanner.nextLine();
        System.out.print("Digite o salário bruto do funcionário 3: ");
        double salario3 = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.print("Digite o nome do funcionário 4: ");
        String nome4 = scanner.nextLine();
        System.out.print("Digite o salário bruto do funcionário 4: ");
        double salario4 = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.print("Digite o nome do funcionário 5: ");
        String nome5 = scanner.nextLine();
        System.out.print("Digite o salário bruto do funcionário 5: ");
        double salario5 = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha restante

        // Salarios
        salario(nome1, salario1);
        salario(nome2, salario2);
        salario(nome3, salario3);
        salario(nome4, salario4);
        salario(nome5, salario5);

        scanner.close();
    }


    //Informações de salarios
    private static void salario(String nome, double salarioBruto) {
        double inss = INSS(salarioBruto);
        double impostoDeRenda = ImpostoDeRenda(salarioBruto - inss);
        double salarioLiquido = salarioBruto - inss - impostoDeRenda;

        System.out.println("\nFuncionário: " + nome);
        System.out.printf("Salário bruto: R$ %.2f%n", salarioBruto);
        System.out.printf("Desconto INSS: R$ %.2f%n", inss);
        System.out.printf("Desconto Imposto de Renda: R$ %.2f%n", impostoDeRenda);
        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);
    }
    //INSS
    private static double INSS(double salario) {
        double inss = 0;
        if (salario <= 1212.00) {
            inss = salario * 0.075;
        } else if (salario <= 2427.35) {
            inss = 1212.00 * 0.075 + (salario - 1212.00) * 0.09;
        } else if (salario <= 3641.03) {
            inss = 1212.00 * 0.075 + (2427.35 - 1212.00) * 0.09 + (salario - 2427.35) * 0.12;
        } else if (salario <= 7087.22) {
            inss = 1212.00 * 0.075 + (2427.35 - 1212.00) * 0.09 + (3641.03 - 2427.35) * 0.12 + (salario - 3641.03) * 0.14;
        } else {
            inss = 1212.00 * 0.075 + (2427.35 - 1212.00) * 0.09 + (3641.03 - 2427.35) * 0.12 + (7087.22 - 3641.03) * 0.14;
        }
        return inss;
    }

    //Imposto de renda
    private static double ImpostoDeRenda(double salario) {
        double imposto = 0;
        if (salario <= 1903.98) {
            imposto = 0;
        } else if (salario <= 2826.65) {
            imposto = (salario - 1903.98) * 0.075;
        } else if (salario <= 3751.05) {
            imposto = (2826.65 - 1903.98) * 0.075 + (salario - 2826.65) * 0.15;
        } else if (salario <= 4664.68) {
            imposto = (2826.65 - 1903.98) * 0.075 + (3751.05 - 2826.65) * 0.15 + (salario - 3751.05) * 0.225;
        } else {
            imposto = (2826.65 - 1903.98) * 0.075 + (3751.05 - 2826.65) * 0.15 + (4664.68 - 3751.05) * 0.225 + (salario - 4664.68) * 0.275;
        }
        return imposto;
    }
}