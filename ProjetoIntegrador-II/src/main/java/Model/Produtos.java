
package Model;

/**
 *
 * @author GuiMikami
 */
public class Produtos {
    
    private int id;
    private String descricao;
    private String valor;
    private int Quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Produtos(int id, String descricao, String valor, int Quantidade) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.Quantidade = Quantidade;
    }

    public Produtos() {
    }

    
    
    
    
    
}
