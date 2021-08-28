package com.projeto_pizzaria.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.projeto_pizzaria.model.model.Cliente;
import com.projeto_pizzaria.model.service.ClienteService;
import com.projeto_pizzaria.util.ProcessamentoDados;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ClienteFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6393148587843351202L;
	
	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldNumCasa;
	private JTextField textFieldBairro;
	private JTextField textFieldTelefone;
	JButton btnAlterar;
	JButton btnIncluir;
	ClienteService clienteService;
	Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteFrame frame = new ClienteFrame();
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
	public ClienteFrame() {
		clienteService = new ClienteService();
		cliente = new Cliente();
		
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
					incluirCliente();
				}	
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					alterarCliente();
				}	
			}
		});
		
	}
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDados.digitacaoCampo(textFieldNome.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do nome do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNome.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldRua.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação da rua do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldRua.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldNumCasa.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do número da residência do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNumCasa.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldBairro.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do bairro do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldBairro.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldTelefone.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação da telefone do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldTelefone.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		return ProcessamentoDados.FALSO;
	}
	
	private void incluirCliente() {
		clienteService.save(cliente);
	}
	
	private void alterarCliente() {
		clienteService.update(cliente);
	}
	
	private void getData() {
		cliente.setNome(textFieldNome.getText());
		cliente.setBairro(textFieldBairro.getText());
		cliente.setRua(textFieldRua.getText());
		cliente.setNumCasaCliente(Integer.parseInt(textFieldNumCasa.getText()));
		cliente.setTelefone(textFieldTelefone.getText());
		
		System.out.println(cliente.toString());
	}
	
	private void buscarCliente() {
		cliente.setIdCliente(Integer.parseInt(textFieldCodigo.getText()));
		cliente = clienteService.findClienteById(cliente.getIdCliente());
		
		textFieldNome.setText(cliente.getNome());
		textFieldBairro.setText(cliente.getBairro());
		textFieldRua.setText(cliente.getRua());
		textFieldNumCasa.setText(Integer.toString(cliente.getNumCasaCliente()));
		textFieldTelefone.setText(cliente.getTelefone());
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(210, 44, 360, 284);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(99, 10, 153, 13);
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarCliente();
			}
		});
		textFieldCodigo.setBounds(99, 26, 153, 19);
		panel_1.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(99, 55, 153, 13);
		panel_1.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(99, 72, 153, 19);
		panel_1.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.LEFT);
		lblRua.setBounds(99, 101, 153, 13);
		panel_1.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(99, 117, 153, 19);
		panel_1.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblNumCasa = new JLabel("N\u00FAmero Resid\u00EAncia:");
		lblNumCasa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumCasa.setBounds(99, 146, 153, 13);
		panel_1.add(lblNumCasa);
		
		textFieldNumCasa = new JTextField();
		textFieldNumCasa.setBounds(99, 162, 153, 19);
		panel_1.add(textFieldNumCasa);
		textFieldNumCasa.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setBounds(99, 191, 153, 13);
		panel_1.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(99, 203, 153, 19);
		panel_1.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setBounds(99, 232, 153, 13);
		panel_1.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(99, 245, 153, 19);
		panel_1.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBounds(208, 338, 362, 36);
		panel.add(panel_2);
		
		btnAlterar = new JButton("Alterar");
		
		panel_2.add(btnAlterar);
		
		btnIncluir = new JButton("Incluir");
		
		panel_2.add(btnIncluir);
		
		JButton btnRemover = new JButton("Remover");
		panel_2.add(btnRemover);
		
		JLabel lblTitulo = new JLabel("Cliente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(359, 21, 79, 13);
		panel.add(lblTitulo);
	}

}
