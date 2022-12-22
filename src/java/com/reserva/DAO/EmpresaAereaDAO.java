
package com.reserva.DAO;


import com.reserva.servicos.EmpresaAerea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpresaAereaDAO {
    
        public void cadastrar(EmpresaAerea aerea) throws SQLException{
        
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO empresaaerea (nome, cnpj) VALUES (?, ?)";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, aerea.getNomeEmpresa());
            insereBD.setString(2, aerea.getCnpj());
            
            insereBD.execute();
            System.out.println("Empresa Aerea cadastrado com sucesso!");

        }catch(SQLException e) {
            System.out.println("Erro ao cadastrar Empresa Aerea:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }   
public List<EmpresaAerea> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        Statement consulta = null;
        ResultSet resultado = null;
        List<EmpresaAerea> aereas = new ArrayList<>();
        
        String SQL = "SELECT * FROM empresaaerea";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                EmpresaAerea aerea = new EmpresaAerea();
                aerea.setNomeEmpresa(resultado.getString("nome"));
                aerea.setCnpj(resultado.getString("cnpj"));
                
                aereas.add(aerea);
            }
            for(EmpresaAerea e : aereas){
                System.out.println("Nome: " + e.getNomeEmpresa());
                System.out.println("Cnpj: " + e.getCnpj());
            }
        }catch(SQLException e){
            System.out.println("Erro ao carregar a lista: " + e.getMessage());
        }finally{
            try{
                consulta.close();
                resultado.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar as conexões: " + e.getMessage());
            }
        }
        return aereas;
    }
public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from empresaaerea where pkid_empresaaerea = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("Empresa Aerea excluida com sucesso");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir Empresa Aerea:" + e.getMessage());
        }finally{
            try{
                excluiSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

            public void atualizar (){
            Conexao conex = new Conexao();
            Connection conexao = conex.getConexao();
            
            PreparedStatement atualizaSt = null;
            String SQL = "update empresaaerea set nome = ?, cnpj = ?,"
                    + "where pkid_empresaaerea = ?";
            
            Scanner sc = new Scanner(System.in);
            
                System.out.print("informe a id da Empresa Aerea: ");
                int id = sc.nextInt();
                
                System.out.print("informe o nome da Empresa: ");
                String nome = sc.nextLine();
                System.out.print("informe o CNPJ: ");
                String cnpj = sc.nextLine();
                
                try{
                    atualizaSt = conexao.prepareStatement(SQL);
                    atualizaSt.setString(1, nome);
                    atualizaSt.setString(2, cnpj);
                    atualizaSt.setInt(3, id);
                    atualizaSt.executeUpdate();
                    
                    System.out.println("Empresa Aerea atualizada com sucesso!");
                    
                }catch(SQLException e){
                    System.out.println("Erro ao atualizar Empresa Aerea" + e.getMessage());
                }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
            }
                
 public EmpresaAerea buscarEmpresaAerea(int id){
         Conexao conex = new Conexao();
         Connection conexao = conex.getConexao();

         EmpresaAerea aerea = new EmpresaAerea();

         PreparedStatement buscaSt = null;
         String SQL = "select * from empresaaerea where pkid_empresaaerea = ?";

         try{
             buscaSt = conexao.prepareCall(SQL);
             buscaSt.setInt(1, id);

             ResultSet resultado = buscaSt.executeQuery();

             if(resultado.next()){
                 aerea.setNomeEmpresa(resultado.getString("Nome"));
                 aerea.setCnpj(resultado.getString("Cnpj"));


                 System.out.println("Nome: " + aerea.getNomeEmpresa());
                 System.out.println("CNPJ: " + aerea.getCnpj());

             }
         }catch(SQLException e){
                 System.out.println("Erro ao buscar pedido" + e.getMessage());
              
                 }finally{
           try{
              buscaSt.close();
              conexao.close();
           }catch(SQLException e){
               System.out.println("Erro ao fechar conexao " + e.getMessage());
           } 
       return aerea;
    }
    }  
 }

