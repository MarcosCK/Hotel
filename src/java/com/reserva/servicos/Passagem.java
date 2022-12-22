
package com.reserva.servicos;

import com.reserva.DAO.PassagemDAO;
import java.sql.SQLException;
import java.util.Scanner;

public class Passagem {
 
//variaveis
private String empresaAerea;
private String itinerario;    
private Double valor; 

Scanner sc = new Scanner (System.in);

//cadastrar passagem

public void adicionar(String itinerario, Double valor) throws SQLException {
    this.itinerario = itinerario;
    this.valor = valor;
    
    PassagemDAO dao = new PassagemDAO ();
    dao.cadastrar(this);
    
    
}
 public void cadastrar(){
     
     System.out.println("Itinerario: ");
     this.itinerario = sc.nextLine();
     System.out.println("Valor: ");
     this.valor = sc.nextDouble();  
   
 }
 public void mostrarPassagem(){
     System.out.println("xxxxx Passagem xxxxx");
     System.out.println("Itinerario: " + this.itinerario);
     System.out.println("Empresa Aérea: " + empresaAerea);
     System.out.println("Valor: " + this.valor);
             System.out.println("====================");
 }
 //atualizar passagem
 public void atualizar(){
       
   }
 //buscar passagem
 public void buscar(){
       
   }
 //excluir passagem
 public void excluir(){
       
   }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
}
