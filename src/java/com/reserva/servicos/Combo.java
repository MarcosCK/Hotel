
package com.reserva.servicos;

import com.reserva.DAO.ComboDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combo {

    //variaveis
private String nomeCombo;
private double valor;

public void adicionar(String nomeCombo, double valor)throws
SQLException {
    this.nomeCombo = nomeCombo;
    this.valor = valor;
            
     ComboDAO dao = new ComboDAO();
     dao.cadastrar(this);
}       

public String getNomeCombo() {
        return nomeCombo;
    }

    public void setNomeCombo(String nomeCombo) {
        this.nomeCombo = nomeCombo;
    }





    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void setHoteis(List<Hotel> hoteis) {
        this.hoteis = hoteis;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

//listas
private List<Hotel> hoteis = new ArrayList<>();
private List<Passagem> passagens = new ArrayList<>();

//scanner
Scanner sc = new Scanner(System.in);

// add das listas
public void addHotel(Hotel hotel){
this.hoteis.add(hotel);
}   
public void addPassagem(Passagem passagem){
this.passagens.add(passagem);
}

//Visualizar o combo
public void mostrarCombo(){
    System.out.println("xxxxx Combo xxxxx");
    
        System.out.println("Combo " + this.nomeCombo);
        System.out.println("Valor R$ " + this.valor);
        
     for(Hotel h : hoteis){
         System.out.println("Hotel: " + h.getNomeHotel());
         System.out.println("Hotel: " + h.getCnpj());
                 System.out.println("====================");
         
     }

}

//cadastrar combo

//atualizar combo
public void atualizar(){
    
}
//buscar combo
public void buscar(){
    
}
//excluir o excluir
public void excluir(){
       
}
}
