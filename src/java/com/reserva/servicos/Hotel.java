
package com.reserva.servicos;

import com.reserva.DAO.HotelDAO;
import com.reserva.pessoas.Hospede;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hotel {
    
    //variaveis
private String nomeHotel;
 private String cnpj;  
  private String estado;
   private String cidade;
   //add nas listas 


//scanner
Scanner sc = new Scanner(System.in);



public void adicionar(String nomeHotel, String cnpj, String estado, String cidade) throws SQLException {
    this.nomeHotel = nomeHotel;
    this.cnpj = cnpj;
    this.estado = estado;
    this.cidade = cidade;
    
    HotelDAO dao = new HotelDAO ();
    dao.cadastrar(this);
}

//cadastrar hotel
public void cadastrar(){
    
    System.out.println("xxxxxxx Cadastrar Hotel xxxxxxx");
    //CADASTRO DE HOTEL
    System.out.println("Hotel: ");
     this.nomeHotel = sc.nextLine();
    
    System.out.println("Cnpj: ");
     this.cnpj = sc.nextLine();
    
    System.out.println("Estado: ");
     this.estado = sc.nextLine();
    
    System.out.println("Cidade: ");
     this.cidade = sc.nextLine();
    

     
        HotelDAO dao = new HotelDAO();
    try {
             dao.cadastrar(this);
         } catch (SQLException ex) {
             Logger.getLogger(Hospede.class.getName()).log(Level.SEVERE, null, ex);
         }
              
    
}
//mostrar hoteis
public void mostrarHoteis(){
    
    //MOSTRAR DADOS DE HOTEL PRA USÚARIO
    System.out.println("xxxxx Hotel xxxxx");
    System.out.println("Hotel: " + this.nomeHotel);
    
    
}
//atualizar hotel
public void Atualizar(){

    
}
//buscar hotel
public void Buscar(){
 
}
//excluir hotel
public void Excluir(){
  
}  

//getting e setters
 public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        System.out.println("Método setNomeHotel, recebi nome");
        this.nomeHotel = nomeHotel;
        System.out.println("Gravei o nome do Hotel: " + nomeHotel);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
