package view;

import dao.VeiculoDAO;
import dao.ArquivoVeiculo;
import model.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaVeiculo extends JFrame {

    private JLabel lblNome;
    private JLabel lblCor;
    private JLabel lblAno;
    private JLabel lblModelo;
    private JLabel lblChassi;
    private JLabel lblPlaca;

    private JTextField txtNome;
    private JTextField txtCor;
    private JTextField txtAno;
    private JTextField txtModelo;
    private JTextField txtChassi;
    private JTextField txtPlaca;

    private JCheckBox chkUnicoDono;

    private JButton btnSalvar;
    private JButton btnBuscar;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JButton btnListar;
    private JButton btnUnicoDono;
    private JButton btnTotal;

    private JTable tabela;
    private JScrollPane scrollPane;
    private DefaultTableModel modeloTabela;

    private VeiculoDAO dao = new VeiculoDAO();
    private ArquivoVeiculo arquivo = new ArquivoVeiculo();

    private int idAtual = 0;

    public TelaVeiculo() {

        setTitle("Sistema de Veículos");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 200, 25);
        add(txtNome);

        lblCor = new JLabel("Cor:");
        lblCor.setBounds(20, 60, 80, 25);
        add(lblCor);

        txtCor = new JTextField();
        txtCor.setBounds(100, 60, 200, 25);
        add(txtCor);

        lblAno = new JLabel("Ano:");
        lblAno.setBounds(20, 100, 80, 25);
        add(lblAno);

        txtAno = new JTextField();
        txtAno.setBounds(100, 100, 200, 25);
        add(txtAno);

        lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(20, 140, 80, 25);
        add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(100, 140, 200, 25);
        add(txtModelo);

        lblChassi = new JLabel("Chassi:");
        lblChassi.setBounds(20, 180, 80, 25);
        add(lblChassi);

        txtChassi = new JTextField();
        txtChassi.setBounds(100, 180, 200, 25);
        add(txtChassi);

        lblPlaca = new JLabel("Placa:");
        lblPlaca.setBounds(20, 220, 80, 25);
        add(lblPlaca);

        txtPlaca = new JTextField();
        txtPlaca.setBounds(100, 220, 200, 25);
        add(txtPlaca);

        chkUnicoDono = new JCheckBox("Único Dono");
        chkUnicoDono.setBounds(100, 260, 150, 25);
        add(chkUnicoDono);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(350, 20, 120, 30);
        add(btnSalvar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(350, 60, 120, 30);
        add(btnBuscar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(350, 100, 120, 30);
        add(btnAtualizar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(350, 140, 120, 30);
        add(btnExcluir);

        btnListar = new JButton("Listar");
        btnListar.setBounds(350, 180, 120, 30);
        add(btnListar);

        btnUnicoDono = new JButton("Único Dono");
        btnUnicoDono.setBounds(500, 180, 120, 30);
        add(btnUnicoDono);

        btnTotal = new JButton("Total");
        btnTotal.setBounds(500, 220, 120, 30);
        add(btnTotal);

        modeloTabela = new DefaultTableModel();

        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Cor");
        modeloTabela.addColumn("Ano");
        modeloTabela.addColumn("Modelo");
        modeloTabela.addColumn("Placa");

        tabela = new JTable(modeloTabela);

        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 330, 840, 200);

        add(scrollPane);

        btnSalvar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (txtNome.getText().trim().isEmpty()
                || txtCor.getText().trim().isEmpty()
                || txtAno.getText().trim().isEmpty()
                || txtModelo.getText().trim().isEmpty()
                || txtChassi.getText().trim().isEmpty()
                || txtPlaca.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Preencha todos os campos!"
            );

            return;
        }

        try {

            Integer.parseInt(txtAno.getText());
            Integer.parseInt(txtModelo.getText());

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ano e Modelo devem conter apenas números!"
            );

            return;
        }

        Veiculo existente =
                dao.buscarPorPlaca(txtPlaca.getText());

        if (existente != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Já existe um veículo com esta placa!"
            );

            return;
        }

        Veiculo veiculo = new Veiculo();

        veiculo.setNome(txtNome.getText());
        veiculo.setCor(txtCor.getText());
        veiculo.setAno(Integer.parseInt(txtAno.getText()));
        veiculo.setModelo(Integer.parseInt(txtModelo.getText()));
        veiculo.setnChassi(txtChassi.getText());
        veiculo.setPlaca(txtPlaca.getText());
        veiculo.setUnicoDono(chkUnicoDono.isSelected());

        dao.salvar(veiculo);

        arquivo.salvarEmArquivo(veiculo);

        JOptionPane.showMessageDialog(
                null,
                "Veículo cadastrado com sucesso!"
        );

        carregarTabela();
        limparCampos();
    }
});
        btnBuscar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        Veiculo v =
                dao.buscarPorPlaca(txtPlaca.getText());

        if (v != null) {

            idAtual = v.getId();

            txtNome.setText(v.getNome());
            txtCor.setText(v.getCor());
            txtAno.setText(String.valueOf(v.getAno()));
            txtModelo.setText(String.valueOf(v.getModelo()));
            txtChassi.setText(v.getnChassi());
            txtPlaca.setText(v.getPlaca());

            chkUnicoDono.setSelected(
                    v.isUnicoDono()
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Veículo não encontrado!"
            );
        }
    }
});
        btnAtualizar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (idAtual == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Busque um veículo primeiro!"
            );

            return;
        }

        try {

            Integer.parseInt(txtAno.getText());
            Integer.parseInt(txtModelo.getText());

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ano e Modelo devem conter apenas números!"
            );

            return;
        }

        Veiculo v = new Veiculo();

        v.setId(idAtual);

        v.setNome(txtNome.getText());
        v.setCor(txtCor.getText());
        v.setAno(Integer.parseInt(txtAno.getText()));
        v.setModelo(Integer.parseInt(txtModelo.getText()));
        v.setnChassi(txtChassi.getText());
        v.setPlaca(txtPlaca.getText());
        v.setUnicoDono(chkUnicoDono.isSelected());

        dao.atualizar(v);

        JOptionPane.showMessageDialog(
                null,
                "Veículo atualizado com sucesso!"
        );

        carregarTabela();
        limparCampos();

        idAtual = 0;
    }
});

        btnExcluir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (idAtual == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Busque um veículo primeiro!"
            );

            return;
        }

        int resposta =
                JOptionPane.showConfirmDialog(
                        null,
                        "Deseja realmente excluir?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );

        if (resposta == JOptionPane.YES_OPTION) {

            dao.excluir(idAtual);

            JOptionPane.showMessageDialog(
                    null,
                    "Veículo excluído com sucesso!"
            );

            carregarTabela();
            limparCampos();

            idAtual = 0;
        }
    }
});
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                carregarTabela();
            }
        });

            btnUnicoDono.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
    
                    List<Veiculo> lista = dao.listarUnicoDono();
    
                    modeloTabela.setRowCount(0);
    
                    for (Veiculo v : lista) {
    
                        modeloTabela.addRow(new Object[]{
                                v.getId(),
                                v.getNome(),
                                v.getCor(),
                                v.getAno(),
                                v.getModelo(),
                                v.getPlaca()
                        });
                    }
                }
            });
    
            btnTotal.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    int total = dao.totalVeiculos();

                    JOptionPane.showMessageDialog(
                        null,
                        "Total de veículos cadastrados: " + total
        );
    }
});

            carregarTabela();

        setVisible(true);
    }

    private void carregarTabela() {

        modeloTabela.setRowCount(0);

        List<Veiculo> lista = dao.listarTodos();

        for (Veiculo v : lista) {

            modeloTabela.addRow(new Object[]{
                    v.getId(),
                    v.getNome(),
                    v.getCor(),
                    v.getAno(),
                    v.getModelo(),
                    v.getPlaca()
            });
        }
    }

    private void limparCampos() {

        txtNome.setText("");
        txtCor.setText("");
        txtAno.setText("");
        txtModelo.setText("");
        txtChassi.setText("");
        txtPlaca.setText("");

        chkUnicoDono.setSelected(false);
    }
}
