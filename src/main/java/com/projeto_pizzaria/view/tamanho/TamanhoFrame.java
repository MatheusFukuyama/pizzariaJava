package com.projeto_pizzaria.view.tamanho;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.projeto_pizzaria.model.model.Tamanho;
import com.projeto_pizzaria.model.service.TamanhoService;
import com.projeto_pizzaria.util.ProcessamentoDados;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TamanhoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldTamanho;
	private JTextField textFieldPreco;
	JButton btnAlterar;
	JButton btnIncluir;
	TamanhoService tamanhoService;
	Tamanho tamanho;
	
	/**
	 * Launch the applicat;ion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TamanhoFrame frame = new TamanhoFrame();
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
	public TamanhoFrame() {
		tamanhoService = new TamanhoService();
		tamanho = new Tamanho();
		
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
					incluirTamanho();
				}	
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					alterarTamanho();
				}	
			}
		});
		
	}
	private void incluirTamanho() {
		tamanhoService.save(tamanho);
	}
	
	private void alterarTamanho() {
		tamanhoService.save(tamanho);
	}
	
	private void getData() {
		tamanho.setTamanho(textFieldTamanho.getText());
		tamanho.setPrecoTamanho(Double.parseDouble(textFieldPreco.getText()));
		System.out.println(tamanho.toString());
	}	
	
	
	private void buscarTamanho() {
		tamanho.setIdTamanho(Integer.parseInt(textFieldCodigo.getText()));
		tamanho = tamanhoService.findTamanhoById(tamanho.getIdTamanho());
		
		System.out.println(tamanho.toString());
		
		textFieldTamanho.setText(tamanho.getTamanho());
		textFieldPreco.setText(Double.toString(tamanho.getPrecoTamanho()));
	}
	
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDados.digitacaoCampo(textFieldTamanho.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do nome tamanho da Pizza", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldTamanho.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldPreco.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do preço do tamanho", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		return ProcessamentoDados.FALSO;
	}
	

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(174, 63, 395, 171);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(115, 20, 170, 13);
		panel.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarTamanho();
			}
		});
		textFieldCodigo.setBounds(115, 37, 170, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(115, 66, 170, 13);
		panel.add(lblTamanho);
		
		textFieldTamanho = new JTextField();
		textFieldTamanho.setBounds(115, 78, 170, 19);
		panel.add(textFieldTamanho);
		textFieldTamanho.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(115, 107, 170, 13);
		panel.add(lblPreco);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(115, 123, 170, 19);
		panel.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(172, 245, 397, 31);
		contentPane.add(panel_1);
		
		btnAlterar = new JButton("Alterar");
		
		panel_1.add(btnAlterar);
		
		btnIncluir = new JButton("Incluir");
		
		panel_1.add(btnIncluir);
		
		JButton btnRemover = new JButton("Remover");
		panel_1.add(btnRemover);
		
	}

}
