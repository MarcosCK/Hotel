package com.reserva;
// SELECT * FROM RESERVA R / HOTEL H
// INNER JOIN RESERVA R ON H.ID=R.ID

import com.reserva.DAO.Conexao;
import com.reserva.DAO.FuncionarioDAO;
import com.reserva.DAO.HospedeDAO;
import com.reserva.pessoas.Hospede;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws IOException, SQLException {
        
        Scanner sc = new Scanner(System.in);
        
    // Menu m = new Menu();
   //   m.menuPrincipal();
        
      Conexao c = new Conexao();
     c.getConexao();
       
      
     //  HospedeDAO dao = new HospedeDAO();
       // dao.todos();
       
      //  System.out.println("Informe quem você quer excluir! ");
     //   int id = sc.nextInt();
     //  dao.excluir(id);
      //  dao.atualizar(); 
     //  dao.buscarHospede(id)
       
       
       // FuncionarioDAO fdao = new FuncionarioDAO();
       // fdao.todos;
    }
    
}