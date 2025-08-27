import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<String> historico = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

@Override
public void sacar(double valor) {
    saldo -= valor;
    historico.add(String.format("Saque: R$ %.2f", valor));
}

@Override
public void depositar(double valor) {
    saldo += valor;
    historico.add(String.format("Depósito: R$ %.2f", valor));
}

@Override
public void transferir(double valor, IConta contaDestino) {
    this.sacar(valor);
    contaDestino.depositar(valor);
    historico.add(String.format("Transferência: R$ %.2f para conta %d", valor, ((Conta)contaDestino).getNumero()));

	
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

	public void exibirSaldoFormatado() {
    System.out.printf("Saldo em reais: R$ %.2f%n", saldo);
	
}

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        exibirSaldoFormatado();
    }
	public void exibirHistorico() {
    System.out.println("=== Histórico de operações ===");
    for (String operacao : historico) {
        System.out.println(operacao);
    }
}
}
