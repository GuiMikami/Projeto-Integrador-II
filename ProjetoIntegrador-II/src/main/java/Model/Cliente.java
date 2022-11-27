package Model;

import java.util.Date;

/**
 *
 * @author GuiMikami
 */
public class Cliente {
    
    private int id;
    private String CPF;  
    private String nome;
    private String sexo;
    private String EstadoCivil;
    private String  dataNascimento;
    private String telefone;
    private String email;
    private String Logradouro,Bairro,UF,Complemnto;
    private String Numero;
    private String CEP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getComplemnto() {
        return Complemnto;
    }

    public void setComplemnto(String Complemnto) {
        this.Complemnto = Complemnto;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Cliente(int id, String CPF, String nome, String sexo, String EstadoCivil, String dataNascimento, String telefone, String email, String Logradouro, String Bairro, String UF, String Complemnto, String Numero, String CEP) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.sexo = sexo;
        this.EstadoCivil = EstadoCivil;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.Logradouro = Logradouro;
        this.Bairro = Bairro;
        this.UF = UF;
        this.Complemnto = Complemnto;
        this.Numero = Numero;
        this.CEP = CEP;
    }

    public Cliente() {
    }

   
    
    
}
