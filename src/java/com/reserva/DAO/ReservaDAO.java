/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reserva.DAO;

import com.reserva.servicos.Reserva;
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
 * @author Aluno
 */
public class ReservaDAO {
    public void adcionar (Reserva reserva) {
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO reserva(reserva, valor) VALUES (?, ?, )";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, reserva.getReserva());
            insereBD.setDouble(2, reserva.getValor());
            
            insereBD.execute();
            System.out.println("reserva inserida com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar  reserva: " + e.getMessage());
        }finally{
            try{
                insereBD.close();
                conex.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar as conexões: " + e.getMessage());
            }
            
        }
        
    }
     public List<Reserva> todos(){
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        
        Statement consulta = null;
        ResultSet resultado = null;
        List<Reserva> reservas = new ArrayList<>();
        String SQL = "SELECT * FROM reserva";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Reserva reserva = new Reserva();
                reserva.setReserva(resultado.getString("reserva"));
                reserva.setValor(resultado.getDouble("valor"));
               
                
                
                reservas.add(reserva);
            }
            
            for(Reserva r : reservas){
                System.out.println("categoria: " + r.getReserva());
                System.out.println("valor: " + r.getValor());
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
        return reservas;
    }
     
      public void excluir(int id){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from reserva where id_reserva = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("passagem  excluído com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
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
        String SQL = "update reserva set reserva = ?, valor = ? where id_passagem = ?";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a id da reserva: ");
        int id = sc.nextInt();
        
        System.out.print("Informe a reserva: ");
        String reserva = sc.next();
        
        System.out.print("Informeo valor da reserva: ");
        double valor = sc.nextDouble();
        
        try{
            atualizaSt = conexao.prepareStatement(SQL);
            atualizaSt.setString(1, reserva);
            atualizaSt.setDouble(2, valor);
            atualizaSt.setInt(3, id);
            
            atualizaSt.executeUpdate();
            
            System.out.println("reserva atualizada com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao atualizar reserva: " + e.getMessage());
        }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
    }
}
