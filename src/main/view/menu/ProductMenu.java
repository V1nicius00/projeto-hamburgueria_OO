package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;
import main.controller.*;
import main.model.*;

public class ProductMenu {
    
    private List<ItemMenu> itens = new ArrayList<>();
    private ProductController control = ProductController.getInstance();

    public ProductMenu(){

        Command ProductList = new Command() {
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.LISTA_DE_PRODUTOS);

                List<Produto> produto = control.getProduct();
                if(produto.isEmpty()){
                    Prompt.print(Message.NAO_HA_PRODUTOS);
                }else{
                    for (Produto product : produto){
                        Prompt.print(product.toString());   
                    }
                }
                Prompt.blankLine();
                Prompt.pressEnter();
                ProductView.getInstance().show();
            }
        };

        adicionar(1, Message.CREATE, new Command() {
            public void exe(){
                Prompt.separator();
                Prompt.print(Message.MSG_CADASTRO_PRODUTO);
                Prompt.separator();
                Integer id = Prompt.intReader(Message.INFORME_ID);
                String nome = Prompt.lineReader(Message.INFORME_NOME_PRODUTO);
        	    String marca = Prompt.lineReader(Message.INFORME_MARCA);
        	    double preco  = Prompt.decimalReader(Message.INFORME_PRECO);
        	    int codBarra = Prompt.intReader(Message.INFORME_CODBARRA);
                Long longID = id.longValue();
                if(ProductController.getInstance().produtoExists(longID) != null){
                    Prompt.separator();
                    Prompt.print(Message.ID_JA_EXISTE);
                    Prompt.separator();
                    Prompt.blankLine();
                    ProductView.getInstance().show();
                }
                Prompt.blankLine();
                Prompt.separator();
                Prompt.print(Message.PRODUTO_CADASTRADO_ESTOQUE);
                Prompt.separator();
                Prompt.blankLine();

                if(!nome.isEmpty()){
                    Produto newProduct = new Produto(id, nome, marca, preco, codBarra);
                    control.create(newProduct);
                }
                Prompt.blankLine();
                ProductList.exe();
            }
        });

        adicionar(2, Message.READ, ProductList);

        adicionar(3, Message.UPDATE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.UPDATE_PRODUTO);
                Long id = (long) Prompt.intReader(Message.INFORME_ID);
                if(id > 0){
                    Produto ProductUpdate = control.search(id);

                    if(ProductUpdate != null){
                        String nome = Prompt.lineReader(Message.INFORME_NOME_PRODUTO);
				        String marca = Prompt.lineReader(Message.INFORME_MARCA);
				        double preco = Prompt.decimalReader(Message.INFORME_PRECO);
				        int codBarra = Prompt.intReader(Message.INFORME_CODBARRA);

                        if(!nome.isEmpty() && id != null){
                            ProductUpdate.setNome(nome);
                	        ProductUpdate.setMarca(marca);
                	        ProductUpdate.setPreco(preco);
                	        ProductUpdate.setCodBarra(codBarra);

                            control.update(ProductUpdate);
                            Prompt.blankLine();
                            Prompt.print(Message.PRODUTO_ALTERADO_COM_SUCESSO);
                        }
                    
                    }
                    else{
                        Prompt.blankLine();
                        Prompt.print(Message.PRODUTO_NAO_ENCONTRADO);
                    }
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
            ProductList.exe();
            }
        });

        adicionar(4, Message.DELETE, new Command(){
            public void exe(){
                Prompt.blankLine();
                Prompt.print(Message.MSG_EXCLUSAO_PRODUTO);
                Long id = (long) Prompt.intReader(Message.INFORME_ID);
				
                if(id > 0) {
                    control.delete(id);
                    Prompt.blankLine();
                    Prompt.print(Message.PRODUTO_EXCLUIDO_SUCESSO);
                    Prompt.blankLine();
                    Prompt.pressEnter();
                }
            ProductList.exe();
            }
        });

        adicionar(5, Message.VOLTAR, new Command(){
            public void exe(){
                new MainView().show(); // Chama a View Principal
            }
        });
    }

    public void adicionar(Integer index, String texto, Command command) {
		itens.add(new ItemMenu(index, texto, command));
	}

	public List<ItemMenu> getItens() {
		return itens;
	}
}
