package model;

public class Veiculo {

    private int id;
    private String nome;
    private String cor;
    private int ano;
    private int modelo;
    private String nChassi;
    private String placa;
    private boolean unicoDono;

    public Veiculo() {

    }

    public Veiculo(String nome, String cor, int ano,
                   int modelo, String nChassi,
                   String placa, boolean unicoDono) {

        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.modelo = modelo;
        this.nChassi = nChassi;
        this.placa = placa;
        this.unicoDono = unicoDono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }


    public String getnChassi() {
        return nChassi;
    }

    public void setnChassi(String nChassi) {
        this.nChassi = nChassi;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public boolean isUnicoDono() {
        return unicoDono;
    }

    public void setUnicoDono(boolean unicoDono) {
        this.unicoDono = unicoDono;
    }

    @Override
    public String toString() {

        return "Veiculo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                ", modelo=" + modelo +
                ", nChassi='" + nChassi + '\'' +
                ", placa='" + placa + '\'' +
                ", unicoDono=" + unicoDono +
                '}';
    }
}