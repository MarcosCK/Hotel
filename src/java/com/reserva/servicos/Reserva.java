
package com.reserva.servicos;

import com.reserva.pessoas.Hospede;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Reserva {
    
    //variaveis
    private String reserva;
     private double valor;
       private Hotel hotel;
        private Quartos quarto;
         private Hospede hospede;
    
         //listas
    private List<Quartos> quartos = new ArrayList<>();
     private List<Hospede> hospedes = new ArrayList<>();
    
    //scanners
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     Scanner sc = new Scanner(System.in);
    

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }
    
    //add das listas
    public void addHospede(Hospede hospedes){
     this.hospedes.add(hospedes);
    }  
    
    //cadastrar reserva
  public void cadastrar() throws IOException {
 
      System.out.println("============================");
       System.out.println("XXXXXXXX RESERVA XXXXXXXXXXX");                      
        System.out.println("============================");

      System.out.println("Classe Reserva: ");
       this.reserva = sc.nextLine();
   
      System.out.println("Valor de Reserva:: ");
       this.valor =  sc.nextDouble(); 
    
}
  //mostrar a reserva
  public void mostrarReservas(){
      
      //REPETIÇÃO PARA MOSTRAR DADOS DA RESERVA
      System.out.println("xxxxx Reserva xxxxx");
      for (Quartos q : quartos){
          System.out.println("Número de quarto: " + q.getNumero());
           System.out.println("Andar do quarto: " + q.getAndar());
             if (q.getCategoria().equalsIgnoreCase ("premium")){
                 System.out.println("Obrigado por escolher categoria premium, você recebeu benefícios!");  
             } else {
                 System.out.println("Categoria: " + q.getCategoria());
                         System.out.println("====================");
             }
          
      }
      
      //REPETIÇÃO PARA MOSTRAR DADOS DOS HOSPEDES
      for (Hospede r : hospedes){
          System.out.println("Nome: " + r.getNome());
           System.out.println("Cpf : " + r.getCpf());
             System.out.println("Email: " + r.getEmail());
              System.out.println("Renda: " + r.renda());
      }
      
  }

  //atualizar reserva
public void atualizar(){
 
}
//buscar reserva
public void buscar(){

}
//excluir reserva
public void excluir(){
  
}     

//getting e setters
    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Quartos getQuarto() {
        return quarto;
    }

    public void setQuarto(Quartos quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public List<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quartos> quartos) {
        this.quartos = quartos;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
        public void addQuarto(Quartos quartos){
     this.quartos.add(quartos);
    }

}
