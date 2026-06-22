package dao;

import java.io.FileWriter;
import java.io.IOException;
import model.Veiculo;

public class ArquivoVeiculo {

    public void salvarEmArquivo(Veiculo veiculo) {

        try {

            FileWriter writer =
                    new FileWriter("veiculo.txt", true);

            writer.write("Nome: " + veiculo.getNome() + "\n");
            writer.write("Cor: " + veiculo.getCor() + "\n");
            writer.write("Ano: " + veiculo.getAno() + "\n");
            writer.write("Modelo: " + veiculo.getModelo() + "\n");
            writer.write("Chassi: " + veiculo.getnChassi() + "\n");
            writer.write("Placa: " + veiculo.getPlaca() + "\n");
            writer.write("Único Dono: " + veiculo.isUnicoDono() + "\n");
            writer.write("---------------------------------\n");

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}