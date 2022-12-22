
package com.reserva.DAO;

import com.reserva.servicos.Alimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlimentacaoDAO {
    
    public void cadastrar(Alimentacao alimentacao) throws SQLException{
        
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO alimentacao (nome, categoria, valor) VALUES (?, ?, ?)";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, alimentacao.getNome());
            insereBD.setString(2, alimentacao.getCategoria());
            insereBD.setDouble(3, alimentacao.getValor());
            
            insereBD.execute();
            System.out.println("Pedido cadastrado com scesso!");

        }catch(SQLException e) {
            System.out.println("Erro ao cadastrar pedido:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }   
public List<Alimentacao> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        Statement consulta = null;
        ResultSet resultado = null;
        List<Alimentacao> alimentacoes = new ArrayList<>();
        
        String SQL = "SELECT * FROM alimentacao";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Alimentacao alimentacao = new Alimentacao();
                alimentacao.setNome(resultado.getString("nome"));
                alimentacao.setCategoria(resultado.getString("categoria"));
                alimentacao.setValor(resultado.getDouble("valor"));
                
                alimentacoes.add(alimentacao);
            }
            for(Alimentacao a : alimentacoes){
                System.out.println("Nome: " + a.getNome());
                System.out.println("Categoria: " + a.getCategoria());
                System.out.println("Valor: " + a.getValor());
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
        return alimentacoes;
    }
public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from alimentacao where pkid_alimentacao = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("Pedido excluido com sucesso");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir pedido:" + e.getMessage());
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
            String SQL = "update alimentacao set nome = ?, categoria = ?, valor = ?,"
                    + "where pkid_alimentacao = ?";
            
            Scanner sc = new Scanner(System.in);
            
                System.out.print("informe a id do pedido: ");
                int id = sc.nextInt();
                
                System.out.print("informe seu nome para o pedido: ");
                String nome = sc.nextLine();
                System.out.print("informe a categoria: ");
                String categoria = sc.nextLine();
                System.out.print("informe o quarto: ");
                String quarto = sc.nextLine();
                System.out.print("informe o valor: ");
                double valor = sc.nextDouble();
                
                try{
                    atualizaSt = conexao.prepareStatement(SQL);
                    atualizaSt.setString(1, nome);
                    atualizaSt.setString(2, categoria);
                    atualizaSt.setString(3, quarto);
                    atualizaSt.setDouble(4, valor);
                    atualizaSt.setInt(5, id);
                    atualizaSt.executeUpdate();
                    
                    System.out.println("Pedido atualizado com sucesso!");
                    
                }catch(SQLException e){
                    System.out.println("Erro ao atualizar pedido" + e.getMessage());
                }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
            }
                
 public Alimentacao buscarPedido(int id){
      Conexao conex = new Conexao();
         Connection conexao = conex.getConexao();

         Alimentacao alimentacao = new Alimentacao();

         PreparedStatement buscaSt = null;
         String SQL = "select * from alimentacao where pkid_alimentacao = ?";

         try{
             buscaSt = conexao.prepareCall(SQL);
             buscaSt.setInt(1, id);

             ResultSet resultado = buscaSt.executeQuery();

             if(resultado.next()){
                 alimentacao.setNome(resultado.getString("Nome"));
                 alimentacao.setCategoria(resultado.getString("Categoria"));
                 alimentacao.setValor(resultado.getDouble("Valor"));

                 System.out.println("Nome: " + alimentacao.getNome());
                 System.out.println("Categoria: " + alimentacao.getCategoria());
                 System.out.println("Valor: " + alimentacao.getValor());
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
       return alimentacao;
    }
    }  
 }

