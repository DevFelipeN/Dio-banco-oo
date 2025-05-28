import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome = "Uniblanco";

    protected List<Conta> listContas;

    public Banco(){
        this.listContas = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
}
