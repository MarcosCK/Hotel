
package com.reserva.servicos;

import com.reserva.DAO.AlimentacaoDAO;
import com.reserva.pessoas.Hospede;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alimentacao {

//variaveis 
private String nome;   
 private String categoria;   
  private double valor;
     
public void adicionar(String nome, String categoria, double valor) throws SQLException {
    this.nome = nome;
    this.categoria = categoria;
    this.valor = valor;
    
    AlimentacaoDAO dao = new AlimentacaoDAO ();
    dao.cadastrar(this);
}
        
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

 Scanner sc = new Scanner(System.in);
 
//cadastro de Alimentação/pedido
public void cadastrar(){
    System.out.println("xxxxx Registro de Alimentação xxxxx"); 
    System.out.println("Nome: ");
    this.nome = sc.nextLine();
    System.out.println("Categoria: ");
    this.categoria = sc.nextLine();
    System.out.println("Valor: ");
    this.valor = sc.nextDouble();
    
    AlimentacaoDAO dao = new AlimentacaoDAO();
    try {
             dao.cadastrar(this);
         } catch (SQLException ex) {
             Logger.getLogger(Hospede.class.getName()).log(Level.SEVERE, null, ex);
         }

}
public void mostrarPedido(){
    System.out.println("xxxxx Pedido xxxxx");
    System.out.println("Nome: " + this.nome);
    System.out.println("Valor: " + this.valor);
    System.out.println("====================");
}
//atualizar o pedido
public void atualizar(){
    
}
//buscar o pedido
public void buscar(){
    
}
//exluir o pedido
public void excluir(){
       
}

    public double getValor() {
     return this.valor;
    }
    
}
