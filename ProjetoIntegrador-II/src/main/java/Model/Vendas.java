



package Model;

import java.util.Date;

public class Vendas {
    
    private int CodigoPrduto;
    private String Nome;
    private String Produto;
    private String Quantidade;
    private String Valor;
    private Date DatadaCompra ;
    private int IdVendas;
    private int Cliente;
    private String CPF;

    public int getCodigoPrduto() {
        return CodigoPrduto;
    }

    public void setCodigoPrduto(int CodigoPrduto) {
        this.CodigoPrduto = CodigoPrduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public Date getDatadaCompra() {
        return DatadaCompra;
    }

    public void setDatadaCompra(Date DatadaCompra) {
        this.DatadaCompra = DatadaCompra;
    }

    public int getIdVendas() {
        return IdVendas;
    }

    public void setIdVendas(int IdVendas) {
        this.IdVendas = IdVendas;
    }

    public int getCliente() {
        return Cliente;
    }

    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Vendas(int CodigoPrduto, String Nome, String Produto, String Quantidade, String Valor, Date DatadaCompra, int IdVendas, int Cliente, String CPF) {
        this.CodigoPrduto = CodigoPrduto;
        this.Nome = Nome;
        this.Produto = Produto;
        this.Quantidade = Quantidade;
        this.Valor = Valor;
        this.DatadaCompra = DatadaCompra;
        this.IdVendas = IdVendas;
        this.Cliente = Cliente;
        this.CPF = CPF;
    }

    public Vendas() {
    }

 
  

}
