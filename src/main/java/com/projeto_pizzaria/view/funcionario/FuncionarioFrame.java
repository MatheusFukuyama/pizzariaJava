package com.projeto_pizzaria.view.funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

import com.projeto_pizzaria.model.model.Funcionario;
import com.projeto_pizzaria.model.service.FuncionarioService;
import com.projeto_pizzaria.util.ProcessamentoDados;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FuncionarioFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -130083927171856377L;
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldNumCasa;
	private JTextField textFieldTelefone;
	private JTextField textFieldCargo;
	private JTextField textFieldSalario;
	JButton btnAlterar;
	JButton btnIncluir;
	FuncionarioService funcionarioService;
	Funcionario funcionario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioFrame frame = new FuncionarioFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FuncionarioFrame() {
		funcionarioService = new FuncionarioService();
		funcionario = new Funcionario();
		
		initComponents();
		createEvents();
	}

	private void createEvents() {
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					incluirFuncionario();
				}
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					alterarFuncionario();
				}
			}
		});
		
	}
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDados.digitacaoCampo(textFieldNome.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do nome do funcionario", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNome.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldRua.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação da rua do funcionario", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldRua.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldNumCasa.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do número da residência do funcionario", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNumCasa.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldBairro.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do bairro do funcionario", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldBairro.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		
		if(ProcessamentoDados.digitacaoCampo(textFieldTelefone.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação da telefone do funcionairo", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldTelefone.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldCargo.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do cargo do funcionario", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldCargo.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		
		if(ProcessamentoDados.digitacaoCampo(textFieldSalario.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do salario do funcionario", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldSalario.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		return ProcessamentoDados.FALSO;
	}
	
	public void incluirFuncionario() {
		funcionarioService.save(funcionario);
	}
	
	public void alterarFuncionario() {
		funcionarioService.update(funcionario);
	}
	
	private void getData() {
		funcionario.setNome(textFieldNome.getText());
		funcionario.setBairro(textFieldBairro.getText());
		funcionario.setRua(textFieldRua.getText());
		funcionario.setNumCasaFuncionario(Integer.parseInt(textFieldNumCasa.getText()));
		funcionario.setCargo(textFieldCargo.getText());
		funcionario.setSalario(Double.parseDouble(textFieldSalario.getText()));
		funcionario.setTelefone(textFieldTelefone.getText());
		
		System.out.println(funcionario.toString());
	}
	
	private void buscarFuncionario() {
		funcionario.setIdFuncionario(Integer.parseInt(textFieldCodigo.getText()));
		funcionario = funcionarioService.findFuncionarioById(funcionario.getIdFuncionario());
		
		textFieldNome.setText(funcionario.getNome());
		textFieldBairro.setText(funcionario.getBairro());
		textFieldRua.setText(funcionario.getRua());
		textFieldNumCasa.setText(Integer.toString(funcionario.getNumCasaFuncionario()));
		textFieldCargo.setText(funcionario.getCargo());
		textFieldSalario.setText(Double.toString(funcionario.getSalario()));
		textFieldTelefone.setText(funcionario.getTelefone());
	}


	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(172, 77, 439, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarFuncionario();
			}
		});
		textFieldCodigo.setBounds(110, 27, 216, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigo.setBounds(110, 10, 216, 13);
		panel.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(110, 54, 216, 13);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 66, 216, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.LEFT);
		lblRua.setBounds(110, 95, 216, 13);
		panel.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 108, 216, 19);
		panel.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setBounds(110, 182, 216, 13);
		panel.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(110, 196, 216, 19);
		panel.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblNumCasa = new JLabel("N\u00FAmero Resid\u00EAncia:");
		lblNumCasa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumCasa.setBounds(110, 137, 216, 13);
		panel.add(lblNumCasa);
		
		textFieldNumCasa = new JTextField();
		textFieldNumCasa.setBounds(110, 153, 216, 19);
		panel.add(textFieldNumCasa);
		textFieldNumCasa.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setBounds(110, 225, 216, 13);
		panel.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(110, 237, 216, 19);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setBounds(110, 266, 216, 13);
		panel.add(lblCargo);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setBounds(110, 277, 216, 19);
		panel.add(textFieldCargo);
		textFieldCargo.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalario.setBounds(110, 306, 216, 13);
		panel.add(lblSalario);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setBounds(110, 321, 216, 19);
		panel.add(textFieldSalario);
		textFieldSalario.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(172, 452, 440, 31);
		contentPane.add(panel_1);
		
		btnAlterar = new JButton("Alterar");
		
		panel_1.add(btnAlterar);
		
		btnIncluir = new JButton("Inserir");
		
		panel_1.add(btnIncluir);
		
		JButton btnRemover = new JButton("Remover");
		panel_1.add(btnRemover);
		
		JLabel lblTitulo = new JLabel("Funcion\u00E1rio");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(343, 54, 100, 13);
		contentPane.add(lblTitulo);
		
	}

}
