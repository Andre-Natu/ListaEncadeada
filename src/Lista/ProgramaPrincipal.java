package Lista;

import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		int posicaoCelula = 0, valor = 0, opcaoMenu;
		boolean loop = true;

		ListaEncadeada<Integer> lista = new ListaEncadeada<>();

		Scanner scr = new Scanner(System.in);
		while (loop) {
			try {
				System.out.println("\nDigite a operação que deseja realizar:"
						+ "\n1 - Criar Lista vazia \n2 - Obter tamanho da lista" + "\n3 - Obter o valor de um elemento"
						+ "\n4 - modificar o valor de um elemento" + "\n5 - Adicionar um elemento na lista"
						+ "\n6 - Remover elemento da lista" + "\n7 - Mostrar todos os elementos da lista"
						+ "\n8 - Esvaziar todos os elementos da lista" + "\n9 - Sair do programa");
				opcaoMenu = scr.nextInt();

				switch (opcaoMenu) {
				case 1:
					lista.criarLista();
					System.out.println("A lista foi criada");
					break;
				case 2:
					System.out.println("Tamanho da lista: " + lista.getTamanho());
					break;
				case 3:
					System.out.println("Digite a posição que deseja obter o valor: ");
					posicaoCelula = scr.nextInt();
					System.out.println("\nO valor do " + posicaoCelula + "º elemento é: "
							+ lista.obterCelula(posicaoCelula - 1).getElemento());
					break;
				case 4:
					System.out.println("Digite a posição do elemento: ");
					posicaoCelula = scr.nextInt();
					System.out.println("Agora digite o novo valor do elemento: ");
					valor = scr.nextInt();
					lista.modificarElemento(posicaoCelula - 1, valor);
					break;
				case 5:
					System.out.println("Digite a posição onde o novo elemento ficará: ");
					posicaoCelula = scr.nextInt();
					System.out.println("Agora digite o valor do novo elemento: ");
					valor = scr.nextInt();
					lista.adicionarCelula(posicaoCelula - 1, valor);
					break;
				case 6:
					System.out.println("Digite a posição do elemento que deseja remover: ");
					posicaoCelula = scr.nextInt();
					lista.removerCelula(posicaoCelula - 1);
					break;
				case 7:
					lista.visualisarLista();
					break;
				case 8:
					lista.esvaziarLista();
					System.out.println("A lista foi esvaziada.");
					break;
				case 9:
					System.out.println("Terminando o programa");
					loop = false;
					break;
				default:
					System.out.println("Opção inválida.");
				}
			} catch (Exception e) {
				scr.next();
				System.out.println("Opção inválida, voltando para o menu.");
			}
		}
		scr.close();

	}

}
