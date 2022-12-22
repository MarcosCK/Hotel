
package com.reserva.pessoas;

import com.reserva.DAO.HospedeDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hospede extends Pessoa {

//variaveis       
     private double renda;

//cadastro de Hospede
@Override
public void cadastrar(){
    //EXIBINDO AO USÚARIO PERGUNTAS
     System.out.println("xxxxxxx Criar Hospede xxxxxxx"); 
        super.cadastrar();
     System.out.println("Renda: ");
     this.renda = sc.nextDouble();
      
     HospedeDAO dao = new HospedeDAO();
         try {
             dao.adicionar(this);
         } catch (SQLException ex) {
             Logger.getLogger(Hospede.class.getName()).log(Level.SEVERE, null, ex);
         }
} 
public void mostrarHospede(){
        System.out.println("xxxxx Hospede xxxxx");    
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("CPF: " + this.nome);
        System.out.println("Renda: " + this.renda);
        System.out.println("====================");     
}
//atualizar Hospede
public void atualizar(){
    
    //falta implementação 
    
    
}
//buscar Hospede
public void buscar(){
 
}
//excluir hospede
public void excluir(){
     //sla
}   
//getting e setters
public double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

@Override
    public String getNome() {
        return nome;
    }

@Override
    public void setNome(String nome) {
        this.nome = nome;
    }

@Override
    public String getCpf() {
        return cpf;
    }

@Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


@Override
    public String getEmail() {
        return email;
    }

@Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String renda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}