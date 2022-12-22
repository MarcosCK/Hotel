
package com.reserva.servicos;

import com.reserva.DAO.EmpresaAereaDAO;
import com.reserva.pessoas.Hospede;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaAerea {
    
    //variaveis
private String nomeEmpresa;
private String cnpj;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

//scanner
Scanner sc = new Scanner(System.in);

public void adicionar(String nomeEmpresa, String cnpj) throws SQLException {
    this.nomeEmpresa = nomeEmpresa;
    this.cnpj = cnpj;
    
    EmpresaAereaDAO dao = new EmpresaAereaDAO ();
    dao.cadastrar(this);
}

//cadastrar empresaAerea
public void cadastrar(){
    
    System.out.println("xxxx Criar Empresa Aérea xxxx");  
    System.out.println("Nome da Empresa: ");
    this.nomeEmpresa = sc.nextLine();
    System.out.println("CNPJ: ");
    this.cnpj = sc.nextLine();  
    
    EmpresaAereaDAO dao = new EmpresaAereaDAO();
    try {
             dao.cadastrar(this);
         } catch (SQLException ex) {
             Logger.getLogger(Hospede.class.getName()).log(Level.SEVERE, null, ex);
         }
}
public void mostrarAerea(){
    System.out.println("xxxxx Empresa Aérea xxxxx");
    System.out.println("Nome da Empresa: " + this.nomeEmpresa);
    System.out.println("CNPJ: " + this.cnpj);
            System.out.println("====================");
}
//atualizar empresaAerea
public void atualizar(){
    
}
//buscar empresaAerea
public void buscar(){
    
}
//excluir empresaAerea
public void excluir(){
       
}

}
