package ejemploExamen3.portatiles.vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class VentanaMarca extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtfId;
	private JTextField jtfDenominacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaMarca dialog = new VentanaMarca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaMarca() {   
		
		
		setBounds(100, 100, 350, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Gestión de Marcas");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Id:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jtfId = new JTextField();
			jtfId.setEnabled(false);
			jtfId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_jtfId = new GridBagConstraints();
			gbc_jtfId.insets = new Insets(0, 0, 5, 0);
			gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfId.gridx = 1;
			gbc_jtfId.gridy = 2;
			contentPanel.add(jtfId, gbc_jtfId);
			jtfId.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Denominación:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jtfDenominacion = new JTextField();
			jtfDenominacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_jtfDenominacion = new GridBagConstraints();
			gbc_jtfDenominacion.insets = new Insets(0, 0, 5, 0);
			gbc_jtfDenominacion.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfDenominacion.gridx = 1;
			gbc_jtfDenominacion.gridy = 3;
			contentPanel.add(jtfDenominacion, gbc_jtfDenominacion);
			jtfDenominacion.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Continente:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JComboBox jcbContinente = new JComboBox();
			jcbContinente.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_jcbContinente = new GridBagConstraints();
			gbc_jcbContinente.insets = new Insets(0, 0, 5, 0);
			gbc_jcbContinente.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcbContinente.gridx = 1;
			gbc_jcbContinente.gridy = 4;
			contentPanel.add(jcbContinente, gbc_jcbContinente);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("País:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			JComboBox jcbPais = new JComboBox();
			jcbPais.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_jcbPais = new GridBagConstraints();
			gbc_jcbPais.insets = new Insets(0, 0, 5, 0);
			gbc_jcbPais.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcbPais.gridx = 1;
			gbc_jcbPais.gridy = 5;
			contentPanel.add(jcbPais, gbc_jcbPais);
		}
		{
			JButton jbtGuardar = new JButton("Guardar");
			jbtGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
			gbc_jbtGuardar.gridwidth = 2;
			gbc_jbtGuardar.gridx = 0;
			gbc_jbtGuardar.gridy = 6;
			contentPanel.add(jbtGuardar, gbc_jbtGuardar);
		}
	}

}
