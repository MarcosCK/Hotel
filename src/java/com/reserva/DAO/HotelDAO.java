
package com.reserva.DAO;

import com.reserva.servicos.Alimentacao;
import com.reserva.servicos.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HotelDAO {
    
        public void cadastrar(Hotel hotel) throws SQLException{
        
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO hotel (nome, cnpj, estado, cidade) VALUES (?, ?, ?, ?)";
        
        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, hotel.getNomeHotel());
            insereBD.setString(2, hotel.getCnpj());
            insereBD.setString(3, hotel.getEstado());
            insereBD.setString(4, hotel.getCidade());
            
            insereBD.execute();
            System.out.println("Hotel cadastrado com sucesso!");

        }catch(SQLException e) {
            System.out.println("Erro ao cadastrar Hotel:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }   
public List<Hotel> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        Statement consulta = null;
        ResultSet resultado = null;
        List<Hotel> hoteis = new ArrayList<>();
        
        String SQL = "SELECT * FROM hotel";
        
        try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);
            
            while(resultado.next()){
                Hotel hotel = new Hotel();
                hotel.setNomeHotel(resultado.getString("nome"));
                hotel.setCnpj(resultado.getString("cnpj"));
                hotel.setEstado(resultado.getString("estado"));
                hotel.setCidade(resultado.getString("cidade"));
                
                hoteis.add(hotel);
            }
            for(Hotel h : hoteis){
                System.out.println("Nome: " + h.getNomeHotel());
                System.out.println("CNPJ: " + h.getCnpj());
                System.out.println("Estado: " + h.getEstado());
                System.out.println("Cidade: " + h.getCidade());
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
        return hoteis;
    }
public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from hotel where pkid_hotel = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("Hotel excluido com sucesso");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir hotel:" + e.getMessage());
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
            String SQL = "update hotel set nome = ?, cnpj = ?, estado = ?, cidade = ?,"
                    + "where pkid_hotel = ?";
            
            Scanner sc = new Scanner(System.in);
            
                System.out.print("informe a id do hotel: ");
                int id = sc.nextInt();
                
                System.out.print("informe o nome do hotel: ");
                String nome = sc.nextLine();
                System.out.print("informe o CNPJ: ");
                String cnpj = sc.nextLine();
                System.out.print("informe o Estado: ");
                String estado = sc.nextLine();
                System.out.print("informe a Cidade: ");
                String cidade = sc.nextLine();
                
                try{
                    atualizaSt = conexao.prepareStatement(SQL);
                    atualizaSt.setString(1, nome);
                    atualizaSt.setString(2, cnpj);
                    atualizaSt.setString(3, estado);
                    atualizaSt.setString(4, cidade);
                    atualizaSt.setInt(5, id);
                    atualizaSt.executeUpdate();
                    
                    System.out.println("Hotel atualizado com sucesso!");
                    
                }catch(SQLException e){
                    System.out.println("Erro ao atualizar hotel" + e.getMessage());
                }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
            }
                
 public Hotel buscarHotel(int id){
      Conexao conex = new Conexao();
         Connection conexao = conex.getConexao();

         Hotel hotel = new Hotel();

         PreparedStatement buscaSt = null;
         String SQL = "select * from hotel where pkid_hotel = ?";

         try{
             buscaSt = conexao.prepareCall(SQL);
             buscaSt.setInt(1, id);

             ResultSet resultado = buscaSt.executeQuery();

             if(resultado.next()){
                 hotel.setNomeHotel(resultado.getString("Nome"));
                 hotel.setCnpj(resultado.getString("Cnpj"));
                 hotel.setEstado(resultado.getString("Estado"));
                 hotel.setCidade(resultado.getString("Cidade"));

                 System.out.println("Nome: " + hotel.getNomeHotel());
                 System.out.println("Cnpj: " + hotel.getCnpj());
                 System.out.println("Estado: " + hotel.getEstado());
                 System.out.println("Cidade: " + hotel.getCidade());
             }
         }catch(SQLException e){
                 System.out.println("Erro ao buscar Hotel" + e.getMessage());
              
                 }finally{
           try{
              buscaSt.close();
              conexao.close();
           }catch(SQLException e){
               System.out.println("Erro ao fechar conexao " + e.getMessage());
           } 
       return hotel;
    }
    }  
 }
    

