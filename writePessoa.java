package ex13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class writePessoa {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Adicionar por console ou diretamente no código?");
        int escolha = teclado.nextInt();
        teclado.nextLine();

        if (escolha == 1) {
            System.out.println("Quantas pessoas vai adicionar?");
            int quantidade = teclado.nextInt();
            teclado.nextLine();

            for (int aux = 0; aux < quantidade; aux++) {
                System.out.println("ID: ");
                int id = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Nome: ");
                String nome = teclado.nextLine();

                pessoas.add(new Pessoa(id, nome));
            }
        }
        // segunda opção add pelo codigo
        else {
            pessoas.add(new Pessoa(123, "João"));
            pessoas.add(new Pessoa(456, "Felipe"));
            pessoas.add(new Pessoa(789, "Rafa"));

        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(pessoas);
            System.out.println("Pessoas salvas com sucesso");


        } catch (IOException e) {
            System.out.println("ERRO AO SALVAR AS PESSOAS" + e.getMessage());
        }
        teclado.close();
    }
}

