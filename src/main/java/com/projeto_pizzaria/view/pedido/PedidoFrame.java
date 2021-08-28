package com.projeto_pizzaria.view.pedido;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.projeto_pizzaria.model.model.Pedido;
import com.projeto_pizzaria.model.service.PedidoService;
import com.projeto_pizzaria.util.ProcessamentoDados;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PedidoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNumPedido;
	private JTextField textFieldFormaPagamento;
	private JTextField textFieldPreco;
	JButton btnAlterar;
	JButton btnIncluir;
	PedidoService pedidoService;
	Pedido pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedidoFrame frame = new PedidoFrame();
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
	public PedidoFrame() {
		pedidoService = new PedidoService();
		pedido = new Pedido();
		
		initComponent();
		createEvents();
	}

	private void createEvents() {
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					incluirPedido();
				}	
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					alterarPedido();
				}	
			}
		});	
	}
	
	private void incluirPedido() {
		pedidoService.save(pedido);
	}
	
	private void alterarPedido() {
		pedidoService.update(pedido);
	}
	
	
	private void getData() {
		pedido.setFormaPagamanto(textFieldFormaPagamento.getText());
		pedido.setNumPedido(Integer.parseInt(textFieldNumPedido.getText()));
		pedido.setPrecoTotal(Double.parseDouble(textFieldPreco.getText()));
		System.out.println(pedido.toString());
	}	
	
	
	private void buscarPedido() {
		pedido.setIdPedido(Integer.parseInt(textFieldCodigo.getText()));		
		pedido = pedidoService.findPedidoById(pedido.getIdPedido());
		System.out.println(pedido.toString());
		
		textFieldFormaPagamento.setText(pedido.getFormaPagamanto());
		textFieldNumPedido.setText(Integer.toString(pedido.getNumPedido()));
		textFieldPreco.setText(Double.toString(pedido.getPrecoTotal()));
	}
	

	private boolean verificarDigitacao() {
		
		if(ProcessamentoDados.digitacaoCampo(textFieldNumPedido.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do número do pedido", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNumPedido.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldFormaPagamento.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação da forma de pagamento do pedido", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldFormaPagamento.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldPreco.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do preço do pedido", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		return ProcessamentoDados.FALSO;
	}
	
	
	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(284, 70, 301, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(56, 21, 176, 22);
		panel.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarPedido();
			}
		});
		textFieldCodigo.setBounds(56, 42, 176, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNumPedido = new JLabel("N\u00FAmero do Pedido:");
		lblNumPedido.setBounds(56, 71, 176, 13);
		panel.add(lblNumPedido);
		
		textFieldNumPedido = new JTextField();
		textFieldNumPedido.setBounds(56, 85, 176, 19);
		panel.add(textFieldNumPedido);
		textFieldNumPedido.setColumns(10);
		
		JLabel lblFormaPagamento = new JLabel("Forma de Pagamento:");
		lblFormaPagamento.setBounds(56, 114, 176, 13);
		panel.add(lblFormaPagamento);
		
		textFieldFormaPagamento = new JTextField();
		textFieldFormaPagamento.setBounds(56, 128, 176, 19);
		panel.add(textFieldFormaPagamento);
		textFieldFormaPagamento.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(56, 157, 176, 13);
		panel.add(lblPreco);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(56, 172, 176, 19);
		panel.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(280, 309, 305, 31);
		contentPane.add(panel_1);
		
		btnAlterar = new JButton("Alterar");
		
		panel_1.add(btnAlterar);
		
		btnIncluir = new JButton("Incluir");
		
		panel_1.add(btnIncluir);
		
		JButton btnRemover = new JButton("Remover");
		panel_1.add(btnRemover);
		
		JLabel lblTitulo = new JLabel("Pedido");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(411, 47, 93, 13);
		contentPane.add(lblTitulo);
		
	}
	
	

}
