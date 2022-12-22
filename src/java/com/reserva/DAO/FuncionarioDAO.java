package com.reserva.DAO;

import com.reserva.pessoas.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioDAO {
 

    public void adicionar(Funcionario funcionario) throws SQLException{

        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        PreparedStatement insereBD = null;
        String SQL = "INSERT INTO funcionario (nome, email, cpf, salario, cargo) VALUES (?, ?, ?, ?, ?)";

        try{
            insereBD = conex.prepareStatement(SQL);
            insereBD.setString(1, funcionario.getNome());
            insereBD.setString(2, funcionario.getEmail());
            insereBD.setString(3, funcionario.getCpf());
            insereBD.setDouble(4, funcionario.getSalario());
            insereBD.setString(5, funcionario.getCargo());

            insereBD.execute();
            System.out.println("Funcionario inserido com sucesso!");
}catch(SQLException e) {
            System.out.println("Erro ao cadastrar o Funcionario:" + e.getMessage());
        }finally{
        try{
        insereBD.close(); 
        conex.close();
        }catch(SQLException e) {
            System.out.println("Erro ao fechar as conexões: " + e.getMessage());
        }
        } 
        }
    public List<Funcionario> todos() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conex = conexao.getConexao();
        Statement consulta = null;
        ResultSet resultado = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        String SQL = "SELECT * FROM funcionario";
try{
            consulta = conex.createStatement();
            resultado = consulta.executeQuery(SQL);

            while(resultado.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setSalario(resultado.getDouble("Salario"));
                funcionario.setCargo(resultado.getString("Cargo"));

                funcionarios.add(funcionario);
            }
            for(Funcionario h : funcionarios){
                System.out.println("Nome: " + h.getNome());
                System.out.println("Email: " + h.getEmail());
                System.out.println("CPF: " + h.getCpf());
                System.out.println("Salario: " + h.getSalario());
                System.out.println("Cargo: " + h.getCargo());
            }
        }catch(SQLException e){
            System.out.println("Erro ao carregar a lista: " + e.getMessage());
        }finally{
            try{
                consulta.close();
                resultado.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar as conexões: " + e.getMessage());
            }
        }
        return funcionarios;
    }
public void excluir(int id) {
        Conexao conex = new Conexao();
        Connection conexao = conex.getConexao();
        
        PreparedStatement excluiSt = null;
        String SQL = "delete from funcionario where pkid_funcionario = ?";
        
        try{
            excluiSt = conexao.prepareStatement(SQL);
            excluiSt.setInt(1, id);
            excluiSt.executeUpdate();
            
            System.out.println("Funcionario excluido com sucesso");
            
        }catch(SQLException e){
            System.out.println("Erro ao excluir funcionario:" + e.getMessage());
        }finally{
            try{
                excluiSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

            public void atualizar (){
            Conexao conex = new Conexao();
            Connection conexao = conex.getConexao();
            
            PreparedStatement atualizaSt = null;
            String SQL = "update funcionario set nome = ?, email = ?, cpf = ?, salario = ?, cargo = ?,"
                    + "where pkid_funcionario = ?";
            
            Scanner sc = new Scanner(System.in);
            
                System.out.print("informe a id do funcionario: ");
                int id = sc.nextInt();
                
                System.out.print("informe o nome do funcionario: ");
                String nome = sc.nextLine();
                System.out.print("informe o emaill do funcionario: ");
                String email = sc.nextLine();
                System.out.print("informe o cpf do funcionario: ");
                String cpf = sc.nextLine();
                System.out.print("informe o salario do funcionario: ");
                double salario = sc.nextDouble();
                System.out.print("informe o cargo do funcionario: ");
                String cargo = sc.nextLine();
                
                try{
                    atualizaSt = conexao.prepareStatement(SQL);
                    atualizaSt.setString(1, nome);
                    atualizaSt.setString(2, email);
                    atualizaSt.setString(3, cpf);
                    atualizaSt.setDouble(4, salario);
                    atualizaSt.setString(6, cargo);
                    atualizaSt.setInt(6, id);
                    atualizaSt.executeUpdate();
                    
                    System.out.println("Funcionario atualizado com sucesso!");
                    
                }catch(SQLException e){
                    System.out.println("Erro ao atualizar funcionario" + e.getMessage());
                }finally{
            try{
                atualizaSt.close();
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
            }
public Funcionario buscarFuncionario(int id){
      Conexao conex = new Conexao();
         Connection conexao = conex.getConexao();

         Funcionario funcionario = new Funcionario();

         PreparedStatement buscaSt = null;
         String SQL = "select * from hospede where pkid_funcionario = ?";

         try{
             buscaSt = conexao.prepareCall(SQL);
             buscaSt.setInt(1, id);

             ResultSet resultado = buscaSt.executeQuery();

             if(resultado.next()){
                 funcionario.setNome(resultado.getString("Nome"));
                 funcionario.setEmail(resultado.getString("Email"));
                 funcionario.setCpf(resultado.getString("Cpf"));
                 funcionario.setSalario(resultado.getDouble("Salario"));
                 funcionario.setCargo(resultado.getString("Cargo"));

                 System.out.println("Nome: " + funcionario.getNome());
                 System.out.println("Email: " + funcionario.getEmail());
                 System.out.println("Cpf: " + funcionario.getCpf());
                 System.out.println("Salario: " + funcionario.getSalario());
                 System.out.println("Cargo: " + funcionario.getCargo());
             }
         }catch(SQLException e){
                 System.out.println("Erro ao buscar funcionario" + e.getMessage());
              
                 }finally{
           try{
              buscaSt.close();
              conexao.close();
           }catch(SQLException e){
               System.out.println("Erro ao fechar conexao " + e.getMessage());
           } 
       return funcionario;
    }
    }  
 }
