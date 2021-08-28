package com.projeto_pizzaria.view.ingrediente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.projeto_pizzaria.model.model.Ingrediente;
import com.projeto_pizzaria.model.service.IngredienteService;
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

public class IngredienteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldPreco;
	private JTextField textFieldNome;
	private JTextField textFieldAddRemove;
	JButton btnIncluir;
	JButton btnAlterar;
	IngredienteService ingredienteService;
	Ingrediente ingrediente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngredienteFrame frame = new IngredienteFrame();
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
	public IngredienteFrame() {
		ingredienteService = new IngredienteService();
		ingrediente = new Ingrediente();
		
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
					incluirIngrediente();
				}	
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean toReturn = ProcessamentoDados.FALSO;
				toReturn = verificarDigitacao();
				if(toReturn == ProcessamentoDados.FALSO) {
					getData();
					alterarIngrediente();
				}	
			}
		});
	}
	
	private void incluirIngrediente() {
		ingredienteService.save(ingrediente);
	}

	private void alterarIngrediente() {
		ingredienteService.update(ingrediente);
	}

	private void getData() {
		ingrediente.setNome(textFieldNome.getText());
		ingrediente.setPrecoIngrediente(Double.parseDouble(textFieldPreco.getText()));
		if(textFieldAddRemove.getText().equals("Adicionar"))
			ingrediente.setAddIngrediente(true);
		else
			ingrediente.setAddIngrediente(false);
			
		System.out.println(ingrediente.toString());
	}	
	
	
	private void buscarIngrediente() {
		ingrediente.setIdIngrediente(Integer.parseInt(textFieldCodigo.getText()));
		ingrediente = ingredienteService.findIngredienteById(ingrediente.getIdIngrediente());
		System.out.println(ingrediente.toString());
		
		textFieldNome.setText(ingrediente.getNome());
		textFieldPreco.setText(Double.toString(ingrediente.getPrecoIngrediente()));
		if(ingrediente.getAddIngrediente())
			textFieldAddRemove.setText("Adicionar");
		else
			textFieldAddRemove.setText("Remover");
	}
	
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDados.digitacaoCampo(textFieldNome.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do nome do Ingrediente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldNome.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldPreco.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do preço do Ingrediente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(ProcessamentoDados.digitacaoCampo(textFieldAddRemove.getText())) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do Adicionar/Remover do Ingrediente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
		
		if(!textFieldAddRemove.getText().equals("Adicionar") && !textFieldAddRemove.getText().equals("Remover")) {
			JOptionPane.showMessageDialog(null, "Erro de digitação do Adicionar/Remover do Ingrediente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			textFieldPreco.requestFocus();
			return ProcessamentoDados.VERDADEIRO;
		}
			
		
		return ProcessamentoDados.FALSO;
	}
	
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(198, 58, 351, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(95, 29, 141, 13);
		panel.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarIngrediente();
			}
		});
		textFieldCodigo.setBounds(95, 44, 147, 19);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(95, 122, 147, 13);
		panel.add(lblPreco);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(95, 139, 147, 19);
		panel.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(95, 80, 147, 13);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(95, 93, 147, 19);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblAddRemover = new JLabel("Adicionar/ Remover:");
		lblAddRemover.setBounds(95, 168, 147, 13);
		panel.add(lblAddRemover);
		
		textFieldAddRemove = new JTextField();
		textFieldAddRemove.setBounds(95, 186, 147, 19);
		panel.add(textFieldAddRemove);
		textFieldAddRemove.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(198, 301, 351, 25);
		contentPane.add(panel_1);
		
		btnAlterar = new JButton("Alterar");
		
		panel_1.add(btnAlterar);
		
		btnIncluir = new JButton("Incluir");
		
		panel_1.add(btnIncluir);
		
		JButton btnRemover = new JButton("Remover");
		panel_1.add(btnRemover);
		
		JLabel lblTitulo = new JLabel("Ingrediente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(321, 27, 102, 13);
		contentPane.add(lblTitulo);
		
	}

}
