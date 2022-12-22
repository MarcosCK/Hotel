package com.reserva.servicos;
//criando classe quarto
import com.reserva.DAO.QuartosDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Quartos {
 private String numero;
    private String andar;
    private String qtdeHospede;
    private String categoria;
    private double valor;
    //chamado o bufferredreader e scanner para pegar informação do usuario
    BufferedReader br =  new BufferedReader (new InputStreamReader(System.in));
    Scanner sc = new  Scanner (System.in);
     //metodo cadastrar quartos   
    
    public void adicionar(String numero, String andar, String qntdeHospede, String categoria, double valor) throws SQLException {
    this.numero = numero;
    this.andar = andar;
    this.qtdeHospede = qntdeHospede;
    this.categoria = categoria;
    this.valor = valor;
    
    QuartosDAO dao = new QuartosDAO ();
  //  dao.cadastrar(this);
}
    public void cadastrar() throws IOException{
        System.out.println("Numero do andar: ");
        this.andar = sc.nextLine(); 
        
        System.out.println("Numero do Quarto: ");
        this.numero = sc.nextLine();
        
        System.out.println("Qual a quatidade de hospedes: ");
        this.qtdeHospede = sc.nextLine();
        
        System.out.println("Qual a categoria: ");
        this.categoria = br.readLine();
        
        QuartosDAO dao = new QuartosDAO ();
        dao.adicionar(this);
        
        
    }
    public void mostrarQuarto(){
    System.out.println("xxxxx Quarto xxxxx");
    System.out.println("Andar: " + this.andar);
    System.out.println("Número do quarto: " + this.numero);
    System.out.println("Quantidade de hospedes: " + this.qtdeHospede);
    System.out.println("Categoria: " + this.categoria);
            System.out.println("====================");
}
    
    public void atualizar(){
     //metodo atualizar quartos   
    }
    
    public void excluir(){
        //metodo cadastrar quartos   
    }
    public void buscar(){
        //metodo cadastrar quartos   
    }  

    //criado os getters e setter para pegar e encaminhar infos pois a classe está encapsulada
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getQtdeHospede() {
        return qtdeHospede;
    }

    public void setQtdeHospede(String qtdeHospede) {
        this.qtdeHospede = qtdeHospede;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
}
