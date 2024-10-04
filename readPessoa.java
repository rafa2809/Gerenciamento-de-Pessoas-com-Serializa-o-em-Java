package ex13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class readPessoa {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            List<Pessoa> pessoas = (List<Pessoa>) ois.readObject();
            System.out.println("Pessoas lidas");
            for (Pessoa pessoa : pessoas){
                System.out.println(pessoa);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }
    }
}
