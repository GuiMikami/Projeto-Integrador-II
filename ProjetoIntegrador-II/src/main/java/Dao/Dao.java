
package Dao;
import Model.Cliente;
import Model.Produtos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.spi.LoginModule;
import javax.swing.JOptionPane;
public class Dao {
    
    
  public static String url= "jdbc:mysql://localhost:3306/lojamusica";
   public static String login= "root";
   public static String senha = "root";
   
   
   public static boolean Salvar(Cliente objCliente){
       boolean retorno = false;
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente (CPF,Nome,Email,Telefone,Nascimento,EstadoCivil,Sexo,Logradouro,Numero,Bairro,Complemento,UF,CEP) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1,objCliente.getCPF());
            comandoSQL.setString(2,objCliente.getNome());
            comandoSQL.setString(3,objCliente.getEmail());
            comandoSQL.setString(4,objCliente.getTelefone());
            System.out.println(objCliente.getDataNascimento());
            comandoSQL.setString(5, objCliente.getDataNascimento());
            System.out.println(objCliente.getEstadoCivil());
            comandoSQL.setString(6, objCliente.getEstadoCivil());
            System.out.println(objCliente.getSexo());
            comandoSQL.setString(7,objCliente.getSexo());
            comandoSQL.setString(8, objCliente.getLogradouro());
            comandoSQL.setString(9, objCliente.getNumero());
            comandoSQL.setString(10, objCliente.getBairro());
            comandoSQL.setString(11, objCliente.getComplemnto());
            comandoSQL.setString (12,objCliente.getUF());
            comandoSQL.setString(13, objCliente.getCEP());
                        
            int numeroLinha = comandoSQL.executeUpdate();
            if(numeroLinha>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs!=null){
                if(rs.next()){
                    objCliente.setId(rs.getInt(1));
                }
            }
            }
            
        }catch(ClassNotFoundException ex){
            retorno=false;
            System.out.println(ex);
        }catch(SQLException ex){
            retorno = false;
            System.out.println(ex);
        }
        return retorno;
               
   }
    
  
    public static List<Cliente>Listar(){
        List<Cliente>listarRetornon = new ArrayList();
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente");
            ResultSet rs  = comandoSQL.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Cliente cliente = new Cliente ();
                    cliente.setId(rs.getInt("IdCliente"));
                    cliente.setCPF(rs.getString("CPF"));
                    cliente.setNome(rs.getString("Nome"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setTelefone(rs.getString("Telefone"));
                    cliente.setDataNascimento(rs.getString("Nascimento"));
                    cliente.setEstadoCivil(rs.getString("EstadoCivil"));
                    cliente.setSexo(rs.getString("Sexo"));
                    cliente.setLogradouro(rs.getString("Logradouro"));
                    cliente.setNumero(rs.getString("Numero"));
                    cliente.setBairro(rs.getString("Bairro"));
                    cliente.setComplemnto(rs.getString("Complemento"));
                    cliente.setUF(rs.getString("UF"));
                    cliente.setCEP(rs.getString("CEP"));
                    
                    System.out.println(cliente);
                    System.out.println(cliente.getCPF());
                    
                    listarRetornon.add(cliente);
                }
                
                return listarRetornon;

            }
            return null;

        } catch(ClassNotFoundException | SQLException ex){
            listarRetornon = null;
            System.out.println(ex.getMessage());
            return null;
            
        }
    }
 
    public static boolean Excluir(int id ){
         boolean retorno = false;
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL =conexao.prepareStatement("DELETE FROM cliente WHERE IdCliente=?");
            comandoSQL.setInt(1, id);
             int numeroLinha = comandoSQL.executeUpdate();
            if(numeroLinha>0){
                retorno=true;
            }
             }catch (ClassNotFoundException ex){
            retorno = false;
            
        }catch(SQLException ex){
            retorno=false;
            
        }
        return retorno;
    }
    
    public static boolean Aletera(Cliente objCliente){
         boolean retorno = false;
        Connection conexao = null;
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
              PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE cliente Set CPF=?,Nome=?,Email=?,Telefone=?,Nascimento=?,EstadoCivil=?,Sexo=?,Logradouro=?,Numero=?,Bairro=?,Complemento=?,UF=?,CEP=? WHERE IdCliente=?"
                     , Statement.RETURN_GENERATED_KEYS);
              
            comandoSQL.setString(1,objCliente.getCPF());
            comandoSQL.setString(2,objCliente.getNome());
            comandoSQL.setString(3,objCliente.getEmail());
            comandoSQL.setString(4,objCliente.getTelefone());            
            comandoSQL.setString(5, objCliente.getDataNascimento());           
            comandoSQL.setString(6, objCliente.getEstadoCivil());            
            comandoSQL.setString(7,objCliente.getSexo());
            comandoSQL.setString(8, objCliente.getLogradouro());
            comandoSQL.setString(9, objCliente.getNumero());
            comandoSQL.setString(10, objCliente.getBairro());
            comandoSQL.setString(11, objCliente.getComplemnto());
            comandoSQL.setString (12,objCliente.getUF());
            comandoSQL.setString(13, objCliente.getCEP());
            comandoSQL.setInt(14, objCliente.getId());
             int numeroLinha = comandoSQL.executeUpdate();
              if(numeroLinha>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs!=null){
                if(rs.next()){
                    objCliente.setId(rs.getInt(1));
                }
            }
            }
            
        }catch(ClassNotFoundException ex){
            retorno=false;
            System.out.println(ex);
        }catch(SQLException ex){
            retorno = false;
            System.out.println(ex);
        }
        return retorno;
               
    }
    
}
