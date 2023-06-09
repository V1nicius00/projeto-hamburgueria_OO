package main.view.menu;

import java.util.ArrayList;
import java.util.List;
import main.util.*;
import main.view.*;

import main.view.Command;

public class MainMenu extends Menu {

    private List<ItemMenu> itens = new ArrayList<>();

    public MainMenu(){

        adicionar(1, Message.MENU_CLIENTE, new Command(){
            public void exe(){
               ClientView.getInstance().show();
            }
        });

        adicionar(2, Message.MENU_FUNCIONARIO, new Command(){
            public void exe(){
                WorkerView.getInstance().show();
            }
        });

        adicionar(3, Message.MENU_ESTOQUE, new Command(){
            public void exe(){
                StockView.getInstance().show();
            }
        });

        adicionar(4, Message.MENU_GERENTE, new Command(){
            public void exe(){
               ManagerView.getInstance().show();
            }
        });

        adicionar(5, Message.MENU_CARDAPIO, new Command(){
            public void exe(){
                CardapioView.getInstance().show();
            }
        });

        adicionar(6, Message.MENU_PEDIDO, new Command(){
            public void exe(){
                FoodOrderView.getInstance().show();
            }
        });

        adicionar(7, Message.FINALIZAR_PROGRAMA, new Command(){
            public void exe(){
                Prompt.print(Message.FINALIZADO);
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
