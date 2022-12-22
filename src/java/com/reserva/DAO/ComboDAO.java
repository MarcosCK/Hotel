/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reserva.DAO;

import com.reserva.servicos.Combo;
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
public class ComboDAO {
    
    public void cadastrar (Combo combo) {
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        
        String SQL = "INSERT INTO combo (nomecombo, valor, ) VALUES (?, ?)";
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, combo.getNomeCombo());
            insereBD.setDouble(2, combo.getValor());
          
            
            
            insereBD.execute();
            System.out.println("Combo inserido com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar o combo: " + e.getMessage());
        }finally{
            try{
                insereBD.close();
                conex.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar as conexões: " + e.getMessage());
            }
            
        }
    }
    public List<Combo> todos(){
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        
        Statement consulta = null;
        ResultSet resultado = null;
        List<Combo> combos = new ArrayList<>();
        String SQL = "SELECT * FROM combo";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Combo combo = new Combo ();
                combo.setNomeCombo(resultado.getString("Nome do combo"));
                combo.setValor(resultado.getDouble("valor"));
                
             
                
                combos.add(combo);
            }
            
            for(Combo c : combos){
                System.out.println("Nome do combo : " + c.getNomeCombo());
                System.out.println("Email: " + c.getValor());
              
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
        return combos;
    }
    
    public void excluir(int id){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from combo where id_combo = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("combo excluído com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir combo: " + e.getMessage());
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
        String SQL = "update combo set nomeCombo = ?, valor = ?"
                + " where id_combo = ?";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a id do combo: ");
        int id = sc.nextInt();
        
        System.out.print("Informe o nome do combo: ");
        String nome = sc.next();
        
        System.out.print("Informe o valor do combo: ");
        Double valor = sc.nextDouble();
        

        
        try{
            atualizaSt = conexao.prepareStatement(SQL);
            atualizaSt.setString(1, nome);
            atualizaSt.setDouble(2, valor);
            atualizaSt.setInt(3, id);
            
            atualizaSt.executeUpdate();
            
            System.out.println("combo atualizado com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao atualizar Combo: " + e.getMessage());
        }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
    }
       public Combo buscarCombo(int id){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        Combo combos  = new Combo();
        
        PreparedStatement buscaSt = null;
        String SQL = "select * from combo where id_combo = ?";
        
        try{
            buscaSt = conexao.prepareCall(SQL);
            buscaSt.setInt(1, id);
            
            ResultSet resultado = buscaSt.executeQuery();
            
            if(resultado.next()){
                
                combos.setNomeCombo(resultado.getString("nome do combo"));
                combos.setValor(resultado.getDouble("valor "));
                
                
                System.out.println("Nome: " + combos.getNomeCombo());
                System.out.println("Email: " + combos.getValor());
               
            }
            
        }catch(SQLException e ){
            System.out.println("Erro ao buscar combo: " + e.getMessage());
        }finally{
            try{
                buscaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
        return combos;
       }  
}
        
        
    
       
