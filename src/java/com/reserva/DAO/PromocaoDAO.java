
package com.reserva.DAO;

import com.reserva.servicos.Promocao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class PromocaoDAO {
    
        public void cadastrar(Promocao promocao) throws SQLException{
        
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO promocao (nome, beneficio,) VALUES (?, ?)";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, promocao.getNomePromocao());
            insereBD.setString(2, promocao.getBeneficio());

            
            insereBD.execute();
            System.out.println("Promoção cadastrada com sucesso!");

        }catch(SQLException e) {
            System.out.println("Erro ao cadastrar Promoção:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }   
public List<Promocao> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        Statement consulta = null;
        ResultSet resultado = null;
        List<Promocao> promocoes = new ArrayList<>();
        
        String SQL = "SELECT * FROM promocao";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Promocao promocao = new Promocao();
                promocao.setNomePromocao(resultado.getString("nome"));
                promocao.setBeneficio(resultado.getString("beneficio"));
                
                promocoes.add(promocao);
            }
            for(Promocao p : promocoes){
                System.out.println("Nome: " + p.getNomePromocao());
                System.out.println("Beneficio: " + p.getBeneficio());

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
        return promocoes;
    }
public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from promocao where pkid_promocao = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("Promoção excluido com sucesso");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir promoção:" + e.getMessage());
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
            String SQL = "update promocao set nome = ?, beneficio = ?,"
                    + "where pkid_promocao = ?";
            
            Scanner sc = new Scanner(System.in);
            
                System.out.print("informe a id da promoção: ");
                int id = sc.nextInt();
                
                System.out.print("informe o nome da Promoção: ");
                String nome = sc.nextLine();
                System.out.print("informe o Beneficio: ");
                String beneficio = sc.nextLine();
                
                try{
                    atualizaSt = conexao.prepareStatement(SQL);
                    atualizaSt.setString(1, nome);
                    atualizaSt.setString(2, beneficio);
                    atualizaSt.setInt(3, id);
                    atualizaSt.executeUpdate();
                    
                    System.out.println("promoção atualizada com sucesso!");
                    
                }catch(SQLException e){
                    System.out.println("Erro ao atualizar promoção" + e.getMessage());
                }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
            }
                
 public Promocao buscarPromocao(int id){
      Conexao conex = new Conexao();
         Connection conexao = conex.getConexao();

         Promocao promocao = new Promocao();

         PreparedStatement buscaSt = null;
         String SQL = "select * from promocao where pkid_promocao = ?";

         try{
             buscaSt = conexao.prepareCall(SQL);
             buscaSt.setInt(1, id);

             ResultSet resultado = buscaSt.executeQuery();

             if(resultado.next()){
                 promocao.setNomePromocao(resultado.getString("Nome"));
                 promocao.setBeneficio(resultado.getString("Beneficio"));

                 System.out.println("Nome: " + promocao.getNomePromocao());
                 System.out.println("Beneficio: " + promocao.getBeneficio());
             }
         }catch(SQLException e){
                 System.out.println("Erro ao buscar Promoção" + e.getMessage());
              
                 }finally{
           try{
              buscaSt.close();
              conexao.close();
           }catch(SQLException e){
               System.out.println("Erro ao fechar conexao " + e.getMessage());
           } 
       return promocao;
    }
    }  
 }

