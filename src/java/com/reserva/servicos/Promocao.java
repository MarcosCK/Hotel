
package com.reserva.servicos;

import com.reserva.DAO.PromocaoDAO;
import java.sql.SQLException;
import java.util.Scanner;

public class Promocao {
    
    //variaveis
private String nomePromocao;    
private String beneficio;


public void adicionar(String nomePromocao, String beneficio) throws SQLException {
    this.nomePromocao = nomePromocao;
    this.beneficio = beneficio;
    
    PromocaoDAO dao = new PromocaoDAO ();
    dao.cadastrar(this);
}

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }
    
//scanner
Scanner sc = new Scanner(System.in);

//cadastrar promoção
public void cadastrar (){
    
    System.out.println("Nome da promoção: ");
    this.nomePromocao = sc.nextLine();
 
    System.out.println("Benefício: ");
    this.beneficio = sc.nextLine();    
}
public void mostrarPromocao(){
    System.out.println("xxxxx Promoção xxxxx");
    System.out.println("Nome da promoção: " + this.nomePromocao);
    System.out.println("Benefício: " + this.beneficio);
            System.out.println("====================");
}
//atualizar promoção
public void atualizar (){
    
}
//atualizar promoção
public void buscar (){
    
}
//excluir promoção
public void excluir (){
    
}
}