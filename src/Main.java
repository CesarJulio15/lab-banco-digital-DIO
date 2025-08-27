public class Main {
    public static void main(String[] args) {
        // Criando cliente
        Cliente venilton = new Cliente("Venilton");

        // Criando contas
        ContaCorrente cc = new ContaCorrente(venilton);
        ContaPoupanca poupanca = new ContaPoupanca(venilton);

        // Operações
        cc.depositar(100);               // Depósito na corrente
        cc.transferir(100, poupanca);    // Transferência da corrente para poupança

        // Imprimir extratos organizados
        System.out.println("=== Extrato Conta Corrente ===");
        cc.imprimirExtrato();

        System.out.println("=== Extrato Conta Poupança ===");
        poupanca.imprimirExtrato();

		System.out.println("=== Fim do Extrato ===");
    }
}
		