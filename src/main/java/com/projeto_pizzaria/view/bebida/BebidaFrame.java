package com.projeto_pizzaria.view.bebida;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import org.hibernate.internal.build.AllowSysOut;

import com.projeto_pizzaria.util.ProcessamentoDados;
import com.projeto_pizzaria.model.model.Bebida;
import com.projeto_pizzaria.model.model.PedidoBebida;
import com.projeto_pizzaria.model.service.BebidaService;
import com.projeto_pizzaria.model.service.PedidoBebidaService;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class BebidaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361441050636942081L;
	
	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	JButton btnIncluir;
	JButton btnAlterar;
	JButton btnRemover;
	BebidaService bebidaService;
	Bebida bebida;
	PedidoBebidaService pedidoBebidaService;
	PedidoBebida pedidoBebida;
	private JLabel lblQuantidade;
	private JTextField textFieldQuantidade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BebidaFrame frame = new BebidaFrame();
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
	public BebidaFrame() {
		
		bebidaService = new BebidaService();
		bebida = new Bebida();
		pedidoBebidaService = new PedidoBebidaService();
		pedidoBebida = new PedidoBebida();
		
		
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
					incluirBebida();
				}	
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					boolean toReturn = ProcessamentoDados.FALSO;
					toReturn = verificarDigitacao();
					if(toReturn == ProcessamentoDados.FALSO) {
						getData();
						alterarBebida();
					}	
			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void incluirBebida() {
		bebidaService.save(bebida);
		pedidoBebidaService.save(pedidoBebida);
	}
	
	private void alterarBebida() {
		bebidaService.update(bebida);
		pedidoBebidaService.update(pedidoBebida);
	}
	
	private void getData() {
		bebida.setNome(textFieldNome.getText());
		bebida.setPrecoBebida(Double.parseDouble(textFieldPreco.getText()));
		pedidoBebida.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
		System.out.println(bebida.toString());
		System.out.println(pedidoBebida.toString());
	}	
	
	
	private void buscarBebida() {
		bebida.setIdBebida(Integer.parseInt(textFieldCodigo.getText()));
		bebida = bebidaService.findBebidaById(bebida.getIdBebida());
		
		pedidoBebida.setIdPedidoBebida(Integer.parseInt(textFieldCodigo.getText()));
		pedidoBebida = pedidoBebidaService.findPedidoBebidaById(pedidoBebida.getIdPedidoBebida());
		System.out.println(bebida.toString());
		
		textFieldNome.setText(bebida.getNome());
		textFieldPreco.setText(Double.toString(bebida.getPrecoBebida()));
		textFieldQuantidade.setText(Integer.toString(pedidoBebida.getQuantidade()));
	}
	
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDados.digitacaoCampo(textFieldNome.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do nome da bebida", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNome.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldPreco.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do preço da bebida", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldQuantidade.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do quantidade da bebida", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldQuantidade.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		return ProcessamentoDados.FALSO;
	}
	
	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(304, 65, 452, 236);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(166, 27, 58, 13);
		panel.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarBebida();
			}
		});
		textFieldCodigo.setBounds(166, 46, 96, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(166, 75, 45, 13);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(166, 93, 96, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setBounds(166, 122, 45, 13);
		panel.add(lblPreco);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(166, 140, 96, 19);
		panel.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(166, 163, 96, 13);
		panel.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(166, 181, 96, 19);
		panel.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(304, 311, 452, 31);
		contentPane.add(panel_1);
		
		btnAlterar = new JButton("Alterar");
		panel_1.add(btnAlterar);
		
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.add(btnIncluir);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBackground(UIManager.getColor("ColorChooser.background"));
		panel_1.add(btnRemover);
		
		JLabel lblTitulo = new JLabel("Bebida");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(489, 24, 64, 31);
		contentPane.add(lblTitulo);
		
	}
}
