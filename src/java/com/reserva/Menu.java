
package com.reserva;

import com.reserva.pessoas.Funcionario;
import com.reserva.pessoas.Hospede;
import com.reserva.servicos.Alimentacao;
import com.reserva.servicos.Combo;
import com.reserva.servicos.EmpresaAerea;
import com.reserva.servicos.Hotel;
import com.reserva.servicos.Passagem;
import com.reserva.servicos.Promocao;
import com.reserva.servicos.Quartos;
import com.reserva.servicos.Reserva;
import java.io.IOException;
import java.util.Scanner;


public class Menu {
    Alimentacao alimentacao = new Alimentacao();
    Combo combo = new Combo();
    EmpresaAerea aerea = new EmpresaAerea();
    Hotel hotel = new Hotel();
    Passagem passagem = new Passagem();
    Promocao promocao = new Promocao();
    Quartos quarto = new Quartos();
    Reserva reserva = new Reserva();
    
    private int escolha;
    
    Scanner sc = new Scanner(System.in);
    
    public void menuPrincipal() throws IOException{
        
        do {
            
        System.out.println("Escolha sua opcção: ");
        System.out.println("1 - Pessoas");
        System.out.println("2 - Serviços ");
        System.out.println("0 - Sair");
        
        this.escolha = sc.nextInt(); 
        
         switch(escolha){
          
          case 0:
                System.out.println("Volte sempre!");
               break;
          
          case 1:  
              this.menuPessoa();
              break;
              
          case 2:
              this.menuServicos();
              break;
              
           default:
              System.out.println("Valor inválido!");
        }
        }while(this.escolha != 0);
    }
    
    
    public void menuPessoa() throws IOException{
        
          Hospede hospede = new Hospede();
          Funcionario funcionario = new Funcionario();
          
        do {
            
        System.out.println("Escolha sua opcção: ");
        System.out.println("1 - Criar Funcionario");
        System.out.println("2 - Mostrar Funcionario");
        System.out.println("3 - Criar Hospede");
        System.out.println("4 - Mostrar Hospede");
        System.out.println("0 - Voltar ao menu principal");
        
        this.escolha = sc.nextInt(); 
        
         switch(escolha){
          
                    case 0:
                        this.menuPrincipal();
                        break;
                     
                    case 1:
                        funcionario.cadastrar();
                        break;
                    
                    case 2:
                        funcionario.mostrarFuncionario();
                        break;
                        
                    case 3:
                        hospede.cadastrar();
                        break;
                        
                    case 4:
                        hospede.mostrarHospede();
                        break;
                
           default:
              System.out.println("Valor inválido!");
        }
        }while(this.escolha != 0);
    }
    
  
    public void menuServicos() throws IOException{
        do {
            
        System.out.println("Escolha sua opcção: ");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Visualizar");
        System.out.println("0 - Voltar ao Menu Principal");
        
        this.escolha = sc.nextInt(); 
        
         switch(escolha){
          
                    case 0:
                        this.menuPrincipal();
                        break;
                    case 1:
                        this.cadastros();
                        break;
                    case 2:
                        this.visualizar();
                        break;
                        
                     

           default:
              System.out.println("Valor inválido!");
        }
        }while(this.escolha != 0);
    }
    
    public void cadastros() throws IOException{
         do {
            
        System.out.println("Escolha sua opcção de CADASTRO: ");
        System.out.println("1 - Alimentação");
        System.out.println("2 - Combo");
        System.out.println("3 - Empresa Aérea");
        System.out.println("4 - Hotel");
        System.out.println("5 - Passagem");
        System.out.println("6 - Promoção");
        System.out.println("7 - Quarto");
        System.out.println("8 - Reserva");
        System.out.println("0 - Voltar");
        
        this.escolha = sc.nextInt(); 
        
         switch(escolha){
          
          case 0:
                this.menuServicos();
               break;              
          case 1:    
              alimentacao.cadastrar();
              break;
          case 2:    
              combo.cadastrar(aerea);
              break;
          case 3:    
              aerea.cadastrar();
              break;
          case 4:    
              hotel.cadastrar();
              break;
          case 5:    
              passagem.cadastrar(aerea);
              break;
          case 6:    
              promocao.cadastrar();
              break;
          case 7:    
              quarto.cadastrar();
              break;
          case 8:    
              reserva.cadastrar();
              break;
              
           default:
              System.out.println("Valor inválido!");
        }
        }while(this.escolha != 0);
    
    }
    
    public void visualizar() throws IOException{
         do {
            
        System.out.println("Escolha sua opcção de VISUALIÇÃO: ");
        System.out.println("1 - Alimentação");
        System.out.println("2 - Combo");
        System.out.println("3 - Empresa Aérea");
        System.out.println("4 - Hotel");
        System.out.println("5 - Passagem");
        System.out.println("6 - Promoção");
        System.out.println("7 - Quarto");
        System.out.println("8 - Reserva");
        System.out.println("0 - Voltar");
        
        this.escolha = sc.nextInt(); 
        
         switch(escolha){
          
          case 0:
              this.menuServicos();
              break;
          case 1:    
              alimentacao.mostrarPedido();
              break;
          case 2:    
              combo.mostrarCombo();
              break;
          case 3:    
              aerea.mostrarAerea();
              break;
          case 4:    
              hotel.mostrarHoteis();
              break;
          case 5:    
              passagem.mostrarPassagem();
              break;
          case 6:    
              promocao.mostrarPromocao();
              break;
          case 7:    
              quarto.mostrarQuarto();
              break;
          case 8:    
              reserva.mostrarReservas();
              break;
             
           default:
              System.out.println("Valor inválido!");
        }
        }while(this.escolha != 0);
    }
        
        
        
}

