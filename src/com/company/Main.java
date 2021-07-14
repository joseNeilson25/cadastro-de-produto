package com.company;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    List<produto> produto = new ArrayList();

        public static void main(String[]args){
            Main main = new Main();
            main.exibirMenu();
        }

        public void exibirMenu() {
            boolean var1 = false;

            int escolhaMenu;
            do {
                String textoMenu = "escolha uma opção \n\n 1-cadastrar \n 2-consultar";
                String escolhaInformada = JOptionPane.showInputDialog(textoMenu);
                escolhaMenu = Integer.parseInt(escolhaInformada);
                this.processarEscolha(escolhaMenu);
            } while (escolhaMenu != 0);
        }

            public void processarEscolha(int escolha) {
                switch(escolha) {
                    case 0:
                        JOptionPane.showMessageDialog((Component)null, "Até a próxima:)");
                        break;
                    case 1:
                        this.cadastrarProduto();
                        break;
                    case 2:
                        this.imprimirProduto();
                        break;

                    default:
                        JOptionPane.showMessageDialog((Component)null, "opção invalida:)");
                }
            }

        public void cadastrarProduto(){

            produto produto = new produto();
            String nome = JOptionPane.showInputDialog("informe o nome do produto");
            String cod = JOptionPane.showInputDialog("informe o codigo do produto");
            String desc = JOptionPane.showInputDialog("informe a descrição do produto");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("informe o preço do produto"));
            produto.nome = nome;
            produto.codigo = cod;
            produto.desc = desc;
            produto.preco = preco;
            this.produto.add(produto);
        }

    public produto buscarProduto(String codigo){
          Iterator var2 = this.produto.iterator();

          produto produto;
          do{
              if(!var2.hasNext()){
                  return null;
              }
              produto = (produto)var2.next();
          } while(!produto.codigo.equals(codigo));
          return produto;
    }

    public void imprimirProduto(){
            String codigo = JOptionPane.showInputDialog("informe o codigo do produto");
            produto produto = this.buscarProduto(codigo);
            if (produto == null) {
                JOptionPane.showMessageDialog((Component)null, "codigo não encontrado");
            } else {
                JOptionPane.showMessageDialog((Component)null, produto.toString());
            }
      }
}