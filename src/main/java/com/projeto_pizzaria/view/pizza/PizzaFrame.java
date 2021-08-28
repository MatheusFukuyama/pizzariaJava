package com.projeto_pizzaria.view.pizza;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.projeto_pizzaria.model.model.PedidoPizza;
import com.projeto_pizzaria.model.model.Pizza;
import com.projeto_pizzaria.model.service.PedidoPizzaService;
import com.projeto_pizzaria.model.service.PizzaService;
import com.projeto_pizzaria.util.ProcessamentoDados;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PizzaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5396295213403791762L;
	
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldSabor;
	private JTextField textFieldPreco;
	private JTextField textFieldQuantidade;
	JButton btnAlterar;
	JButton btnIncluir;
	PizzaService pizzaService;
	PedidoPizzaService pedidoPizzaService;
	Pizza pizza;
	PedidoPizza pedidoPizza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaFrame frame = new PizzaFrame();
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
	public PizzaFrame() {
		pizzaService = new PizzaService();
		pedidoPizzaService = new PedidoPizzaService();
		pizza = new Pizza();
		pedidoPizza = new PedidoPizza();
		
		
		iniComponents();
		createEvents();
	}

	private void createEvents() {
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					incluirPizza();
				}	
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					alterarPizza();
				}	
			}
		});
		
	}
	
	private void incluirPizza() {
		pizzaService.save(pizza);
		pedidoPizzaService.save(pedidoPizza);
	}
	
	private void alterarPizza() {
		pizzaService.update(pizza);
		pedidoPizzaService.update(pedidoPizza);
	}
	
	
	private void getData() {
		pizza.setSabor(textFieldSabor.getText());
		pizza.setPrecoSabor(Double.parseDouble(textFieldPreco.getText()));
		pedidoPizza.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
		System.out.println(pizza.toString());
		System.out.println(pedidoPizza.toString());
	}	
	
	
	private void buscarPizza() {
		pizza.setIdPizza(Integer.parseInt(textFieldCodigo.getText()));
		pizza = pizzaService.findPizzaById(pizza.getIdPizza());
		
		pedidoPizza.setIdPedidoPizza(Integer.parseInt(textFieldCodigo.getText()));
		pedidoPizza = pedidoPizzaService.findPedidoPizzaById(pedidoPizza.getIdPedidoPizza());
		System.out.println(pizza.toString());
		
		textFieldSabor.setText(pizza.getSabor());
		textFieldPreco.setText(Double.toString(pizza.getPrecoSabor()));
		textFieldQuantidade.setText(Integer.toString(pedidoPizza.getQuantidade()));
	}
	
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDados.digitacaoCampo(textFieldSabor.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do sabor da pizza", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldSabor.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldPreco.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do preço da pizza", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldQuantidade.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do quantidade da pizza", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldQuantidade.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		return ProcessamentoDados.FALSO;
	}
	

	private void iniComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(147, 58, 411, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(83, 24, 219, 13);
		panel.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarPizza();
			}
		});
		textFieldCodigo.setBounds(83, 39, 219, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setBounds(83, 68, 219, 13);
		panel.add(lblSabor);
		
		textFieldSabor = new JTextField();
		textFieldSabor.setBounds(83, 83, 219, 19);
		panel.add(textFieldSabor);
		textFieldSabor.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(83, 112, 219, 13);
		panel.add(lblPreco);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(83, 127, 219, 19);
		panel.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(83, 156, 219, 13);
		panel.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(83, 168, 219, 19);
		panel.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(145, 276, 413, 31);
		contentPane.add(panel_1);
		
		btnAlterar = new JButton("Alterar");
		
		panel_1.add(btnAlterar);
		
		btnIncluir = new JButton("Incluir");
		
		panel_1.add(btnIncluir);
		
		JButton btnRemover = new JButton("Remover");
		panel_1.add(btnRemover);
		
		JLabel lblTitulo = new JLabel("Pizza");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(331, 31, 45, 13);
		contentPane.add(lblTitulo);
		
	}

}
