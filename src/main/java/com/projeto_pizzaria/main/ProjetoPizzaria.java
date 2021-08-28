package com.projeto_pizzaria.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto_pizzaria.model.model.Bebida;
import com.projeto_pizzaria.model.model.Cliente;
import com.projeto_pizzaria.model.model.Funcionario;
import com.projeto_pizzaria.model.model.Ingrediente;
import com.projeto_pizzaria.model.model.Pedido;
import com.projeto_pizzaria.model.model.PedidoBebida;
import com.projeto_pizzaria.model.model.PedidoPizza;
import com.projeto_pizzaria.model.model.Pizza;
import com.projeto_pizzaria.model.model.Tamanho;
import com.projeto_pizzaria.model.service.BebidaService;
import com.projeto_pizzaria.model.service.ClienteService;
import com.projeto_pizzaria.model.service.FuncionarioService;
import com.projeto_pizzaria.model.service.IngredienteService;
import com.projeto_pizzaria.model.service.PedidoBebidaService;
import com.projeto_pizzaria.model.service.PedidoPizzaService;
import com.projeto_pizzaria.model.service.PedidoService;
import com.projeto_pizzaria.model.service.PizzaService;
import com.projeto_pizzaria.model.service.TamanhoService;
import com.projeto_pizzaria.view.bebida.BebidaFrame;

import javax.swing.JLabel;

public class ProjetoPizzaria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5094922139578327043L;
	private JPanel contentPane;
	
	private BebidaService bebidaService = new BebidaService();
	private ClienteService clienteService = new ClienteService();
	private FuncionarioService funcionarioService = new FuncionarioService();
	private IngredienteService ingredienteService = new IngredienteService();
	private PedidoBebidaService pedidoBebidaService = new PedidoBebidaService();
	private PedidoPizzaService pedidoPizzaService = new PedidoPizzaService();
	private PedidoService pedidoService = new PedidoService();
	private PizzaService pizzaService = new PizzaService();
	private TamanhoService tamanhoService = new TamanhoService();
	
	private Bebida bebida;
	private Cliente cliente;
	private Funcionario funcionario;
	private Ingrediente ingrediente;
	private PedidoBebida pedidoBebida;
	private PedidoPizza pedidoPizza;
	private Pedido pedido;
	private Pizza pizza;
	private Tamanho tamanho;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoPizzaria frame = new ProjetoPizzaria();
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
	public ProjetoPizzaria() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);*/
		initComponents();
		createEvents();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
		BebidaFrame bebidaFrame = new BebidaFrame();
		bebidaFrame.setVisible(true);
		
	}

	private void testeInclusao() {
		
		bebida = new Bebida();
		cliente = new Cliente();
		funcionario = new Funcionario();
		ingrediente = new Ingrediente();
		pedido = new Pedido();
		pedidoBebida = new PedidoBebida();
		pedidoPizza = new PedidoPizza();
		pizza = new Pizza();
		tamanho = new Tamanho();
		
		bebida.setNome("Coca-Cola");
		bebida.setPrecoBebida(5.00);
		
		
		cliente.setNome("João da Silva");
		cliente.setBairro("Jose Angelilo");
		cliente.setRua("Marin Berbel");
		cliente.setNumCasaCliente(2001);
		cliente.setTelefone("40028922");
		
		funcionario.setNome("Mario da Silva");
		funcionario.setBairro("Bento da Cruz");
		funcionario.setRua("Marin Berbel");
		funcionario.setNumCasaFuncionario(475);
		funcionario.setTelefone("40012312");
		funcionario.setCargo("Atendente");
		funcionario.setSalario(5000.00);
		
		ingrediente.setNome("Peperone");
		ingrediente.setPrecoIngrediente(5.00);
		ingrediente.setAddIngrediente(true);
		
		pedido.setNumPedido(1);
		pedido.setFormaPagamanto("debito");
		pedido.setPrecoTotal(45.50);
		
		pedidoBebida.setQuantidade(2);
		
		pedidoPizza.setQuantidade(1);
		
		pizza.setPrecoSabor(25.75);
		pizza.setSabor("Calabresa");
		
		
		tamanho.setPrecoTamanho(12.00);
		tamanho.setTamanho("grande");
		

		bebidaService.save(bebida);
		clienteService.save(cliente);
		funcionarioService.save(funcionario);
		ingredienteService.save(ingrediente);
		pedidoService.save(pedido);
		pedidoBebidaService.save(pedidoBebida);
		pedidoPizzaService.save(pedidoPizza);
		pizzaService.save(pizza);
		tamanhoService.save(tamanho);
	}
}
