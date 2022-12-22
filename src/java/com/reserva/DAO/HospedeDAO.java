
package com.reserva.DAO;

import com.reserva.pessoas.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HospedeDAO {
    
    public void adicionar(Hospede hospede) throws SQLException{
        
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO hospede (nome, email, cpf, renda) VALUES (?, ?, ?, ?)";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, hospede.getNome());
            insereBD.setString(2, hospede.getEmail());
            insereBD.setString(3, hospede.getCpf());
            insereBD.setDouble(4, hospede.getRenda());
            
            insereBD.execute();
            System.out.println("Hospede inserido com scesso!");

        }catch(SQLException e) {
            System.out.println("Erro ao cadastrar o Hospede:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }   
    public List<Hospede> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        Statement consulta = null;
        ResultSet resultado = null;
        List<Hospede> hospedes = new ArrayList<>();
        
        String SQL = "SELECT * FROM hospede";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Hospede hospede = new Hospede();
                hospede.setNome(resultado.getString("nome"));
                hospede.setEmail(resultado.getString("email"));
                hospede.setCpf(resultado.getString("cpf"));
                hospede.setRenda(resultado.getDouble("renda"));
                
                hospedes.add(hospede);
            }
            for(Hospede h : hospedes){
                System.out.println("Nome: " + h.getNome());
                System.out.println("Email: " + h.getEmail());
                System.out.println("CPF: " + h.getCpf());
                System.out.println("Renda: " + h.getRenda());
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
        return hospedes;
    }
public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from hospede where pkid_hospede = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("Hospede excluido com sucesso");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir hospede:" + e.getMessage());
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
            String SQL = "update hospede set nome = ?, email = ?, cpf = ?, renda = ?,"
                    + "where pkid_hospede = ?";
            
            Scanner sc = new Scanner(System.in);
            
                System.out.print("informe a id do hospede: ");
                int id = sc.nextInt();
                
                System.out.print("informe o nome do hospede: ");
                String nome = sc.nextLine();
                System.out.print("informe o emaill do hospede: ");
                String email = sc.nextLine();
                System.out.print("informe o cpf do hospede: ");
                String cpf = sc.nextLine();
                System.out.print("informe a renda do hospede: ");
                double renda = sc.nextDouble();
                
                try{
                    atualizaSt = conexao.prepareStatement(SQL);
                    atualizaSt.setString(1, nome);
                    atualizaSt.setString(2, email);
                    atualizaSt.setString(3, cpf);
                    atualizaSt.setDouble(4, renda);
                    atualizaSt.setInt(5, id);
                    atualizaSt.executeUpdate();
                    
                    System.out.println("Hospede atualizado com sucesso!");
                    
                }catch(SQLException e){
                    System.out.println("Erro ao atualizar hospede" + e.getMessage());
                }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
            }
                
 public Hospede buscarHospede(int id){
      Conexao conex = new Conexao();
         Connection conexao = conex.getConexao();

         Hospede hospede = new Hospede();

         PreparedStatement buscaSt = null;
         String SQL = "select * from hospede where pkid_hospede = ?";

         try{
             buscaSt = conexao.prepareCall(SQL);
             buscaSt.setInt(1, id);

             ResultSet resultado = buscaSt.executeQuery();

             if(resultado.next()){
                 hospede.setNome(resultado.getString("Nome"));
                 hospede.setEmail(resultado.getString("Email"));
                 hospede.setCpf(resultado.getString("Cpf"));
                 hospede.setRenda(resultado.getDouble("Renda"));

                 System.out.println("Nome: " + hospede.getNome());
                 System.out.println("Email: " + hospede.getEmail());
                 System.out.println("Cpf: " + hospede.getCpf());
                 System.out.println("Renda: " + hospede.getRenda());
             }
         }catch(SQLException e){
                 System.out.println("Erro ao buscar hospede" + e.getMessage());
              
                 }finally{
           try{
              buscaSt.close();
              conexao.close();
           }catch(SQLException e){
               System.out.println("Erro ao fechar conexao " + e.getMessage());
           } 
       return hospede;
    }
    }  
 }