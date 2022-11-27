
package Dao;
import static Dao.Dao.login;
import static Dao.Dao.senha;
import static Dao.Dao.url;
import static Dao.DaoProduto.login;
import static Dao.DaoProduto.senha;
import static Dao.DaoProduto.url;





import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.spi.LoginModule;
import javax.swing.JOptionPane;
import Model.Vendas;

public class DAOVendas {
    
     public static String url= "jdbc:mysql://localhost:3306/lojamusica";
   public static String login= "root";
   public static String senha = "root";
   
   public static boolean Salvar(Vendas objvendas){
       boolean retorno = false;
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO Vendas (Nome,Descri,Quantidade,Valor,dtvendas,IdCodigo,IdCliente) VALUES(?,?,?,?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, objvendas.getNome());
             comandoSQL.setString(2, objvendas.getProduto());
             comandoSQL.setString(3,objvendas.getQuantidade() );
             comandoSQL.setString(4, objvendas.getValor());
             comandoSQL.setDate(5, new java.sql.Date(objvendas.getDatadaCompra().getTime()));
              comandoSQL.setInt(6,objvendas.getCodigoPrduto() );
              comandoSQL.setInt(7, objvendas.getCliente());
             int numeroLinha = comandoSQL.executeUpdate();
            if(numeroLinha>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs!=null){
                if(rs.next()){
                    objvendas.setIdVendas(rs.getInt(1));
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
   
   public static List<Vendas>Listar(){
       List<Vendas >listarRetornon = new ArrayList();
        Connection conexao = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM vendas");
            ResultSet rs  = comandoSQL.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Vendas venda = new Vendas();
                    venda.setIdVendas(rs.getInt("IdVendas"));
                    venda.setProduto(rs.getString("Descri"));
                    venda.setQuantidade(rs.getString("Quantidade"));
                    venda.setValor(rs.getString("Valor"));
                    venda.setDatadaCompra(rs.getDate("dtVendas"));
                    venda.setCliente(rs.getInt("IdCliente"));
                    venda.setCodigoPrduto(rs.getInt("IdCodigo"));
                    
                    listarRetornon.add(venda);
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
   
   public static boolean Excluir(int id){
       boolean retorno = false;
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL =conexao.prepareStatement("DELETE FROM vendas WHERE IdVendas=?");
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
   
   public static boolean Pagar(Vendas objVendas){
           boolean retorno = false;
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL =conexao.prepareStatement("Update produto inner join vendas on produto.IdCodigo =   vendas.IdCodigo  set produto.Quantidade = 1 produto.Quantidade - vendas.Quantidade\n" +
"where produto.IdCodigo=?");
            comandoSQL.setInt(1, objVendas.getCodigoPrduto());
            comandoSQL.setString(2, objVendas.getQuantidade());
            
            int numeroLinha = comandoSQL.executeUpdate();
            if(numeroLinha>0){
                retorno=true;
            }
            
                    
        }catch (ClassNotFoundException ex){
            retorno = false;
        }catch(SQLException ex){
            retorno=false;
            System.out.println(ex);
        }
        return retorno;
   }
   
    public static List<Vendas>Listar2(){
       List<Vendas >listarRetornon = new ArrayList();
        Connection conexao = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            PreparedStatement comandoSQL = conexao.prepareStatement("Select Nome,dtvendas,Valor  from vendas");
            ResultSet rs  = comandoSQL.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Vendas venda = new Vendas();
                    venda.setNome(rs.getString("Nome"));
                    venda.setDatadaCompra(rs.getDate("dtVendas"));
                    venda.setValor(rs.getString("Valor"));
                                        
                    
                    listarRetornon.add(venda);
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
   
   public static List<Vendas>Listar3(Vendas objVendas){
       List<Vendas >listarRetornon = new ArrayList();
        Connection conexao = null;
         try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
             
            PreparedStatement comandoSQL = conexao.prepareStatement("Select vendas.Valor,vendas.Descri,vendas.Quantidade\n" +
"from vendas right outer join cliente \n" +
"on vendas.IdCliente = cliente.IdCliente\n" +
"where cliente.CPF=?");
            comandoSQL.setString(1,objVendas.getNome());
            ResultSet rs  = comandoSQL.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Vendas venda = new Vendas();
                    venda.setCPF(rs.getString("CPF"));
                    venda.setValor(rs.getString("Valor"));
                    venda.setNome(rs.getString("Descri"));
                    venda.setQuantidade(rs.getString("Quantidade"));
                                        
                    
                    listarRetornon.add(venda);
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
}

