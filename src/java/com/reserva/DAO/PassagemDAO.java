/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reserva.DAO;

import com.reserva.servicos.Passagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class PassagemDAO {
       public void adcionar (Passagem passagem) {
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO passagem(itinerario, valor) VALUES (?, ?, )";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, passagem.getItinerario());
            insereBD.setDouble(4, passagem.getValor());
            
            insereBD.execute();
            System.out.println("Passagem inserido com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar o passagem: " + e.getMessage());
        }finally{
            try{
                insereBD.close();
                conex.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar as conexões: " + e.getMessage());
            }
            
        }
        
    }
       public void cadastrar(Passagem passagem) throws SQLException{

        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO passagem (itinirario, valor) VALUES (?, ?)";

        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, passagem.getItinerario());
            insereBD.setDouble(4, passagem.getValor());


            insereBD.execute();
            System.out.println("Passagem cadastrada com sucesso!");

        }catch(SQLException e) {
            System.out.println("Erro ao cadastrar Passagem:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }
    
      
    
    public void excluir(int id){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from passagem where id_passagem = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("passagem  excluído com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir passagem: " + e.getMessage());
        }finally{
            try{
                excluiSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    public void atualizar(){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement atualizaSt = null;
        String SQL = "update passagem set itinerario = ?, valor = ? where id_passagem = ?";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a id da passagem: ");
        int id = sc.nextInt();
        
        System.out.print("Informe o itinerario: ");
        String itinerario = sc.next();
        
        System.out.print("Informeo valor da passagem: ");
        double valor = sc.nextDouble();
        
        try{
            atualizaSt = conexao.prepareStatement(SQL);
            atualizaSt.setString(1, itinerario);
            atualizaSt.setDouble(2, valor);
            atualizaSt.setInt(3, id);
            
            atualizaSt.executeUpdate();
            
            System.out.println("passagem atualizado com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao atualizar passagem: " + e.getMessage());
        }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
    }
    
    public Passagem buscarAlimentacao(int id){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        Passagem passagem = new Passagem();
        
        PreparedStatement buscaSt = null;
        String SQL = "select * from passagem where id_passagem = ?";
        
        try{
            buscaSt = conexao.prepareCall(SQL);
            buscaSt.setInt(1, id);
            
            ResultSet resultado = buscaSt.executeQuery();
            
            if(resultado.next()){
                
                passagem.setItinerario(resultado.getString("itinerario"));
                passagem.setValor(resultado.getDouble("valor"));
                
               
                System.out.println("itinerario: " + passagem.getItinerario());
                System.out.println("valor: " + passagem.getValor());
            }
            
        }catch(SQLException e ){
            System.out.println("Erro ao buscar passagem: " + e.getMessage());
        }finally{
            try{
                buscaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
        return passagem;
    }
}
