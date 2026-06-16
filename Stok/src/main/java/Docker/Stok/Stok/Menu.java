package Docker.Stok.Stok;

import Docker.Stok.Stok.model.Item;
import Docker.Stok.Stok.service.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner{

    private final ItemService itemService;

    public Menu(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar Item");
            System.out.println("2 - Consultar Itens");
            System.out.println("3 - Atualizar Item");
            System.out.println("4 - Excluir Item");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrar(sc);
                    break;

                case 2:
                    consultar();
                    break;

                case 3:
                    atualizar(sc);
                    break;

                case 4:
                    excluir(sc);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

    }

    private void cadastrar(Scanner sc) {

        Item item = new Item();

        System.out.print("Nome: ");
        item.setName(sc.nextLine());

        System.out.print("Descrição: ");
        item.setDescription(sc.nextLine());

        System.out.print("Quantidade: ");
        item.setQuantity(sc.nextInt());

        itemService.save(item);

        System.out.println("Item cadastrado com sucesso!");
    }

    private void consultar() {

        System.out.println("\n===== ITENS CADASTRADOS =====");

        itemService.getAll().forEach(item -> {
            System.out.println(
                    "ID: " + item.getId() +
                            " | Nome: " + item.getName() +
                            " | Descrição: " + item.getDescription() +
                            " | Quantidade: " + item.getQuantity()
            );
        });
    }

    private void atualizar(Scanner sc) {

        System.out.print("Informe o ID do item: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Optional<Item> itemOpt = itemService.findById(id);

        if (itemOpt.isPresent()) {

            Item item = itemOpt.get();

            System.out.print("Novo nome: ");
            item.setName(sc.nextLine());

            System.out.print("Nova descrição: ");
            item.setDescription(sc.nextLine());

            System.out.print("Nova quantidade: ");
            item.setQuantity(sc.nextInt());

            itemService.save(item);

            System.out.println("Item atualizado!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private void excluir(Scanner sc) {

        System.out.print("Informe o ID do item: ");
        Long id = sc.nextLong();

        itemService.delete(id);

        System.out.println("Item removido!");
    }

}
