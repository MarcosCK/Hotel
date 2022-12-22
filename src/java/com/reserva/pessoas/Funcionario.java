package com.reserva.pessoas;

import com.reserva.DAO.FuncionarioDAO;
import com.reserva.DAO.HospedeDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcionario extends Pessoa{
    //variaveis
    private double salario;
    private String cargo;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //cadastro de funcionario
    @Override
    public void cadastrar(){
    System.out.println("xxxxxxx Criar Funcionario xxxxxxx");
     
    super.cadastrar();

    System.out.println("Salario: ");
     this.salario = sc.nextDouble();
     
    System.out.println("Cargo: ");
        try {
            this.cargo = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        FuncionarioDAO dao = new FuncionarioDAO();
         try {
             dao.adicionar(this);
         } catch (SQLException ex) {
             Logger.getLogger(Hospede.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void mostrarFuncionario(){
        System.out.println("xxxxx Funcionario xxxxx");
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("CPF: " + this.nome);
        System.out.println("Salario: " + this.salario);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("====================");

    }
     
    //atualização de funcionario
    public void atualizar(){
 
    }
     
    //busca de funcionario
    public void buscar(){
  
    }
        
}
