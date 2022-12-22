package com.reserva.pessoas;

import java.util.Scanner;

public abstract class Pessoa {
    
    //variaveis
     String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
     String email;
     String cpf;
    //scanner
    Scanner sc = new Scanner(System.in);
    //classe pessoa
    public void cadastrar(){
        
        
        System.out.println("Nome: ");
        this.nome = sc.nextLine();
        
        System.out.println("Email: ");
        this.email = sc.nextLine();
        
        System.out.println("Cpf: ");
        this.cpf = sc.nextLine();

    }

    }
//getting e setters

    
