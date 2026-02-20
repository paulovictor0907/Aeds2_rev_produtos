import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
    
    private static double DESCONTO = 0.2;
    private static int PRAZO_DESCONTO = 7;
    private static LocalDate dataDeValidade;

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate validade) {
        super(desc, precoCusto, margemLucro);
        if(validade.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Validade anterior ao dia de hoje!");
        }
        dataDeValidade = validade;
    }

    public double valorDeVenda() {
        if(dataDeValidade.isBefore(LocalDate.now().plusDays(PRAZO_DESCONTO))){
            return super.valorDeVenda() * (1 - DESCONTO);
        }
        return super.valorDeVenda();
    }

    public String toString() {
        return String.format("%s - Validade: %s", super.toString(), dataDeValidade);
    }
}