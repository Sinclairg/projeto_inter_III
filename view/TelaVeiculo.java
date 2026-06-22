package view;

import dao.VeiculoDAO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Veiculo;

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
    
    private JTable tabela;

    private JScrollPane scrollPane;

    private DefaultTableModel modeloTabela;

    private VeiculoDAO dao = new VeiculoDAO();

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

        btnListar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            carregarTabela();

    }
    });

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

        setVisible(true);
    }

        private void carregarTabela() {

        modeloTabela.setRowCount(0);

        List<Veiculo> lista = dao.listarTodos();

        for (Veiculo v : lista) {

            modeloTabela.addRow(new Object[] {

                v.getId(),
                v.getNome(),
                v.getCor(),
                v.getAno(),
                v.getModelo(),
                v.getPlaca()

            });
        }
    }

}