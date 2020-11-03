package br.com.pc2.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.pc2.trabalho.controller.ChaleController;
import br.com.pc2.trabalho.controller.HospedagemController;
import br.com.pc2.trabalho.model.Chale;
import br.com.pc2.trabalho.model.Hospedagem;
import br.com.pc2.trabalho.util.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodH;
	private JTextField txtEstado;
	private JTextField txtPessoas;
	private JTextField txtDesconto;
	private JTextField txtValorTotal;
	private JFormattedTextField txtDTInicio;
	private JFormattedTextField txtDTFim;
	private JTable tblConsulta;
	private JComboBox cbxCodChale;
	private MaskFormatter mascaraData = null;
	private List<Chale> listaChale;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
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
	private void pesquisar() {
		List<Hospedagem> listaHospedagem = new ArrayList();
		HospedagemController hos = new HospedagemController();
		listaHospedagem = hos.listarTodosHosp();
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
		for(int i = tbm.getRowCount()-1; i >= 0; i--){
			tbm.removeRow(i);
		}
		int i = 0;
		for(Hospedagem linhaH : listaHospedagem){
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(linhaH.getCodChale(), i, 0);
			tblConsulta.setValueAt(linhaH.getCodHospedagem(), i, 1);
			tblConsulta.setValueAt(linhaH.getEstado(), i, 2);
			tblConsulta.setValueAt(linhaH.getDataInicio(), i, 3);
			tblConsulta.setValueAt(linhaH.getDataFim(), i, 4);
			tblConsulta.setValueAt(linhaH.getQtdPessoas(), i, 5);
			tblConsulta.setValueAt(linhaH.getDesconto(), i, 6);
			tblConsulta.setValueAt(linhaH.getValorFinal(), i,7);
			i++;
		}
	}
	public FrmHospedagem() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController CH = new HospedagemController();
				Integer pos = 0;
				for (Chale h1 : listaChale) {
					if (h1.getCodChale().equals(cbxCodChale.getSelectedItem())) {
						pos = listaChale.indexOf(h1);
					}
				}
				hos.setCodChale(listaChale.get(pos).getCodChale());
				hos.setCodHospedagem(txtCodH.getText());
				hos.setEstado(txtEstado.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDTInicio.getText());
				hos.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				int[] dataFormatada2 = Util.formatarDataDeGuiParaLocalDate(txtDTFim.getText());
				hos.setDataFim(LocalDate.of(dataFormatada2[2], dataFormatada2[1],dataFormatada2[0]));
				hos.setQtdPessoas(Integer.parseInt(txtPessoas.getText()));
				hos.setDesconto(Double.parseDouble(txtDesconto.getText()));
				hos.setValorFinal(Double.parseDouble(txtValorTotal.getText()));
				CH.inserir(hos);
				pesquisar();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController CH = new HospedagemController();
				Integer pos = 0;
				for (Chale h1 : listaChale) {
					if (h1.getCodChale().equals(cbxCodChale.getSelectedItem())) {
						pos = listaChale.indexOf(h1);
					}
				}
				hos.setCodChale(listaChale.get(pos).getCodChale());
				hos.setCodHospedagem(txtCodH.getText());
				hos.setEstado(txtEstado.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDTInicio.getText());
				hos.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				int[] dataFormatada2 = Util.formatarDataDeGuiParaLocalDate(txtDTFim.getText());
				hos.setDataFim(LocalDate.of(dataFormatada2[2], dataFormatada2[1],dataFormatada2[0]));
				hos.setQtdPessoas(Integer.parseInt(txtPessoas.getText()));
				hos.setDesconto(Double.parseDouble(txtDesconto.getText()));
				hos.setValorFinal(Double.parseDouble(txtValorTotal.getText()));
				CH.alterar(hos);
				pesquisar();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController CH = new HospedagemController();
				Integer pos = 0;
				for (Chale h1 : listaChale) {
					if (h1.getCodChale().equals(cbxCodChale.getSelectedItem())) {
						pos = listaChale.indexOf(h1);
					}
				}
				hos.setCodChale(listaChale.get(pos).getCodChale());
				hos.setCodHospedagem(txtCodH.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir essa Hospedagem: "+txtCodH.getText()+"?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					CH.excluir(hos);
				}
				pesquisar();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Pesquisar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagem.this.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Limpar");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodH.setText("");
				txtEstado.setText("");
				txtDTInicio.setText("");
				txtDTFim.setText("");
				txtPessoas.setText("");
				txtDesconto.setText("");
				txtValorTotal.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
					tbm.removeRow(i);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnNewButton_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
		);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CodChal\u00E9", "CodHospedagem", "Estado", "DT In\u00EDcio", "DT Fim", "Qtd Pessoas", "Desconto", "Valor Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		
		JLabel lblCdigoChal = new JLabel("C\u00F3digo Chal\u00E9");
		lblCdigoChal.setForeground(Color.WHITE);
		
		JLabel lblCdigoHospedagem = new JLabel("C\u00F3digo Hospedagem");
		lblCdigoHospedagem.setForeground(Color.WHITE);
		
		txtCodH = new JTextField();
		txtCodH.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		JLabel lblQtdPessoas = new JLabel("QTD Pessoas");
		lblQtdPessoas.setForeground(Color.WHITE);
		
		txtPessoas = new JTextField();
		txtPessoas.setColumns(10);
		
		JLabel lblDtIncio = new JLabel("DT In\u00EDcio");
		lblDtIncio.setForeground(Color.WHITE);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setColumns(10);
		
		JLabel lblDtFim = new JLabel("DT Fim");
		lblDtFim.setForeground(Color.WHITE);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setForeground(Color.WHITE);
		
		JLabel lblValor = new JLabel("Valor Total");
		lblValor.setForeground(Color.WHITE);
		
		ChaleController ch = new ChaleController();
			listaChale = ch.listarTodos();
			cbxCodChale = new JComboBox();
		for(Chale e : listaChale){
			cbxCodChale.addItem(e.getCodChale());
		}
		
		JButton button = new JButton("..");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale Fch = new FrmChale();
				Fch.setVisible(true);
			}
		});
		try {
			mascaraData = new MaskFormatter("##/##/####");
			} catch (ParseException e) {
			System.err.println(e.getMessage());
			}
		txtDTInicio = new JFormattedTextField(mascaraData);
		
		txtDTFim = new JFormattedTextField(mascaraData);
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCdigoHospedagem)
						.addComponent(lblCdigoChal)
						.addComponent(lblEstado)
						.addComponent(lblQtdPessoas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addComponent(txtPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbxCodChale, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCodH)
								.addComponent(txtEstado))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
							.addGroup(gl_panel_2_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblDesconto)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblDtIncio)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDTInicio, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2_1.createSequentialGroup()
									.addComponent(lblDtFim)
									.addGap(18)
									.addComponent(txtDTFim, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))))))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoChal)
						.addComponent(lblDtIncio)
						.addComponent(cbxCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(txtDTInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoHospedagem)
						.addComponent(txtCodH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDtFim)
						.addComponent(txtDTFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesconto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQtdPessoas)
						.addComponent(txtPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValor))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
