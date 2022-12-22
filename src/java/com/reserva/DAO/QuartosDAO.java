/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reserva.DAO;


import com.reserva.servicos.Quartos;
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
public class QuartosDAO {
   public void adicionar(Quartos quartos){
         Conexao conexao= new Conexao();
        
        Connection conex  = conexao.getConexao();
        PreparedStatement insereBD = null ;
        String SQL = "INSERT INTO  quartos (numero,andar,qtdeHospede,categoria,valor) VALUES (?,?,?,?,?)";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, quartos.getNumero());
             insereBD.setString(2, quartos.getAndar());
            insereBD.setString(3, quartos.getQtdeHospede());
            insereBD.setString(4, quartos.getCategoria());
            insereBD.setDouble(5, quartos.getValor());
            
            insereBD.execute();
            System.out.println("Quarto  inserido com sucesso");
           
        } catch(SQLException e){
            System.out.println(" Erro ao cadastrar quarto "+ e.getMessage());
    }finally{
        try{
            insereBD.close();
            conex.close();
        }catch(SQLException e){
            System.out.println("Erro ao fechar as conexões : "+ e.getMessage());
            
        }
    }
        
}
   
    public List <Quartos> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex  = conexao.getConexao();
     Statement consulta = null;
     ResultSet resultado = null;
     
     String SQL = "SELECT * FROM quartos";
     List <Quartos> quartos = new ArrayList<>();
       try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Quartos quarto = new Quartos ();
                quarto.setNumero(resultado.getString("numero"));
                quarto.setAndar(resultado.getString("andar"));
                quarto.setQtdeHospede(resultado.getString("quantidade de hospede"));
                quarto.setCategoria(resultado.getString("Categoria:"));
                quarto.setValor(resultado.getDouble("valor :"));
                
                
                quartos.add(quarto);
                
            }
            
            for(Quartos q : quartos){
                System.out.println("Nome: " + q.getNumero());
                System.out.println("Email: " + q.getAndar());
                System.out.println("Cpf: " + q.getQtdeHospede());
                System.out.println("Cargo: " + q.getCategoria());
                System.out.println("Salario: " + q.getValor());
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
        return quartos;
       
   }
    
      public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        PreparedStatement excluiSt = null;
        String SQL = "delete from quarto where id_funcionario = ?";

        try {
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            System.out.println("quarto excluido com sucesso! ");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir quarto : " + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();

            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexões: " + e.getMessage());
            }
        }
    }
       public void atualizar(){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement atualizaSt = null;
        String SQL = "update quarto set numero = ?, andar = ?, qtdeHospede = ?, categoria = ? , valor = ?"
                + " where id_hospede = ?";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe a id do quarto: ");
        int id = sc.nextInt();
        
        System.out.print("Informe o numero do quarto: ");
        int numero = sc.nextInt();
        
        System.out.print("Informe o andar do quarto: ");
        int andar = sc.nextInt();
        
        System.out.print("Informe o quantidade de hospedes do quarto: ");
        int qtdeHospede = sc.nextInt();
        
        System.out.print("Informe a categoria do quarto: ");
        String categoria = sc.nextLine();
        
        System.out.print("Informe a valor do quarto: ");
        double valor  = sc.nextDouble();
        
        try{
            atualizaSt = conexao.prepareStatement(SQL);
            atualizaSt.setInt(1, numero);
            atualizaSt.setInt(2, andar);
            atualizaSt.setInt(3, qtdeHospede);
            atualizaSt.setString(4, categoria);
            atualizaSt.setDouble(5, valor);
            atualizaSt.setInt(6, id);
            
            atualizaSt.executeUpdate();
            
            System.out.println("Funcionario atualizado com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao atualizar quarto: " + e.getMessage());
        }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
    }
    
 public void buscar(int id){
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        Quartos quarto = new Quartos();
        
        PreparedStatement buscaSt = null;
        String SQL = "select * from quartos where id_quarto = ?";
        
        try{
            buscaSt = conexao.prepareCall(SQL);
            buscaSt.setInt(1, id);
            
            ResultSet resultado = buscaSt.executeQuery();
            
            if(resultado.next()){
                
                quarto.setNumero(resultado.getString("numero "));
                quarto.setAndar(resultado.getString("andar "));
                quarto.setQtdeHospede(resultado.getString("quantida de hospede "));
                quarto.setCategoria(resultado.getString("categoria "));
                quarto.setValor(resultado.getDouble("valor "));
                
                System.out.println("Numero: " + quarto.getNumero());
                System.out.println("Andar:  " + quarto.getAndar());
                System.out.println("Quantidade de hospedes:  " + quarto.getQtdeHospede());
                System.out.println("Categoria:  " + quarto.getCategoria());
                System.out.println("Valor:  " + quarto.getValor());
            }
            
        }catch(SQLException e ){
            System.out.println("Erro ao buscar quarto:  " + e.getMessage());
        }finally{
            try{
                buscaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        
    }
}
