package ejemploExamen3.portatiles.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;

import ejemploExamen3.portatiles.controladores.ControladorMarca;
import ejemploExamen3.portatiles.controladores.ControladorPortatil;
import ejemploExamen3.portatiles.entidades.Marca;
import ejemploExamen3.portatiles.entidades.Portatil;
import ejemploExamen3.utils.Apariencia;

import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class GestorPortatiles extends JFrame {

	
	// Establecer la apariencia típica de Windows
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfModelo;
	private JTextField jtfSN;
	private JTextField jtfFechaVenta;

	
	///  JCOMBO ////
	private JComboBox<Marca> jcbMarca;
	
	
	/// JCHECBOX  ///
	private JCheckBox checkVendido;
	
	
	/// SIMPLE DATE FORMAT ///
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	

	
	///// DECLARAMOS LOS RADIO BUTTONS ///
	
	private JRadioButton radiobt1;
	private JRadioButton radiobt2;
	private JRadioButton radiobt3;
	private JRadioButton radiobt4;
	
	
	/// BUTTON GROUP PARA LOS RADIO BUTTONS ///
	private ButtonGroup grupoProcesadores;     
	//DECLARAMOS EL GRUPO de radioButtons llamado grupoProcesadores
	// pero al igual que el resto de objetos de aquí, 
	// lo creamos dentro del constructor
	
	//RECUERDA:
	//SE DECLARA AQUÍ FUERA PARA PODER USARLO EN MÁS METODOS A PARTE DEL CONSTRUCTOR.
	// GESTORPORTATILES QUE ES DONDE VIENE POR DEFECTO DECLARADO.
	

	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorPortatiles frame = new GestorPortatiles();
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
	public GestorPortatiles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		
		////////////////////     MENU  BAR       ////////////////
		
		JButton jbtPrimero = new JButton("");
		jbtPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		jbtPrimero.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/gotostart.png")));
		toolBar.add(jbtPrimero);
		
		
		
		JButton jbtAnterior = new JButton("");
		jbtAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		jbtAnterior.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/previous.png")));
		toolBar.add(jbtAnterior);
		

		
		JButton jbtSiguiente = new JButton("");
		jbtSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		jbtSiguiente.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/next.png")));
		toolBar.add(jbtSiguiente);
		
		

		JButton jbtUltimo = new JButton("");
		jbtUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		jbtUltimo.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/gotoend.png")));
		toolBar.add(jbtUltimo);
		
		
		
		JButton jbtNuevo = new JButton("");
		jbtNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		jbtNuevo.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/nuevo.png")));
		toolBar.add(jbtNuevo);
		
		
		JButton jbtGuardar = new JButton("");
		jbtGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		jbtGuardar.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/guardar.png")));
		toolBar.add(jbtGuardar);
		
		
		JButton jbtBorrar = new JButton("");
		jbtBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		jbtBorrar.setIcon(new ImageIcon(GestorPortatiles.class.getResource("/res/eliminar.png")));
		toolBar.add(jbtBorrar);
		
////////////////////  FIN    MENU  BAR       ////////////////
		
		
		
		
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de Ordenadores Portátiles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbMarca = new JComboBox<Marca>();
		GridBagConstraints gbc_jcbMarca = new GridBagConstraints();
		gbc_jcbMarca.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMarca.gridx = 1;
		gbc_jcbMarca.gridy = 2;
		panel.add(jcbMarca, gbc_jcbMarca);
		
		JButton jbtVerMarca = new JButton("Ver Marca");
		jbtVerMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jbtVerMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_jbtVerMarca = new GridBagConstraints();
		gbc_jbtVerMarca.insets = new Insets(0, 0, 5, 0);
		gbc_jbtVerMarca.gridx = 2;
		gbc_jbtVerMarca.gridy = 2;
		panel.add(jbtVerMarca, gbc_jbtVerMarca);
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.gridwidth = 2;
		gbc_jtfModelo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 3;
		panel.add(jtfModelo, gbc_jtfModelo);
		jtfModelo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Serial Number:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfSN = new JTextField();
		GridBagConstraints gbc_jtfSN = new GridBagConstraints();
		gbc_jtfSN.gridwidth = 2;
		gbc_jtfSN.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSN.gridx = 1;
		gbc_jtfSN.gridy = 4;
		panel.add(jtfSN, gbc_jtfSN);
		jtfSN.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Num procesadores:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		
		////// ----------- RADIO BUTTONS ------------  /////
		
		///  Creo un grupo de radio buttons
		grupoProcesadores = new ButtonGroup();   //declarado al principio
		
		radiobt1 = new JRadioButton("1 Procesador");
		radiobt1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_radiobt1 = new GridBagConstraints();
		gbc_radiobt1.anchor = GridBagConstraints.WEST;
		gbc_radiobt1.insets = new Insets(0, 0, 5, 5);
		gbc_radiobt1.gridx = 0;
		gbc_radiobt1.gridy = 0;
		panel_1.add(radiobt1, gbc_radiobt1);
		grupoProcesadores.add(radiobt1); // Agrego radiobt1 al grupo
		
		radiobt2 = new JRadioButton("2 Procesadores");
		radiobt2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_radiobt2 = new GridBagConstraints();
		gbc_radiobt2.insets = new Insets(0, 0, 5, 0);
		gbc_radiobt2.gridx = 2;
		gbc_radiobt2.gridy = 0;
		panel_1.add(radiobt2, gbc_radiobt2);
		grupoProcesadores.add(radiobt2); // Agrego radiobt2 al grupo
		
		radiobt3 = new JRadioButton("3 Procesadores");
		radiobt3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_radiobt3 = new GridBagConstraints();
		gbc_radiobt3.insets = new Insets(0, 0, 0, 5);
		gbc_radiobt3.gridx = 0;
		gbc_radiobt3.gridy = 1;
		panel_1.add(radiobt3, gbc_radiobt3);
		grupoProcesadores.add(radiobt3); // Agrego radiobt3 al grupo
		
		radiobt4 = new JRadioButton("4 Procesadores");
		radiobt4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_radiobt4 = new GridBagConstraints();
		gbc_radiobt4.gridx = 2;
		gbc_radiobt4.gridy = 1;
		panel_1.add(radiobt4, gbc_radiobt4);
		grupoProcesadores.add(radiobt4); // Agrego radiobt4 al grupo

	////// ----------- FIN RADIO BUTTONS ------------  /////
		
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Vendido:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		////// ----------- CHECKBOX ---------------  /////////////
		checkVendido = new JCheckBox("");
		checkVendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkVendido.isSelected()) {
					jtfFechaVenta.setEnabled(true);
					
				} else {
					jtfFechaVenta.setEnabled(false);
					jtfFechaVenta.setText("");
				}
				
				
			}
		});
		GridBagConstraints gbc_checkVendido = new GridBagConstraints();
		gbc_checkVendido.anchor = GridBagConstraints.WEST;
		gbc_checkVendido.insets = new Insets(0, 0, 5, 5);
		gbc_checkVendido.gridx = 1;
		gbc_checkVendido.gridy = 6;
		panel.add(checkVendido, gbc_checkVendido);
		
		////// ------------ FIN CHECKBOX --------------////
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de venta:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfFechaVenta = new JTextField();
		jtfFechaVenta.setEnabled(false);
		GridBagConstraints gbc_jtfFechaVenta = new GridBagConstraints();
		gbc_jtfFechaVenta.gridwidth = 2;
		gbc_jtfFechaVenta.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaVenta.gridx = 1;
		gbc_jtfFechaVenta.gridy = 7;
		panel.add(jtfFechaVenta, gbc_jtfFechaVenta);
		jtfFechaVenta.setColumns(10);
		
		
		
		
		/////  ---------------- BOTON TOTAL PORTATILES  ------------------///
		JButton jbtNumPortatiles = new JButton("Número total de portátiles");
		jbtNumPortatiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalPortatiles();
			}
		});
		jbtNumPortatiles.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_jbtNumPortatiles = new GridBagConstraints();
		gbc_jbtNumPortatiles.anchor = GridBagConstraints.SOUTH;
		gbc_jbtNumPortatiles.insets = new Insets(0, 0, 5, 5);
		gbc_jbtNumPortatiles.gridx = 1;
		gbc_jbtNumPortatiles.gridy = 8;
		panel.add(jbtNumPortatiles, gbc_jbtNumPortatiles);
		
		
		//cargo todas las marcas en la lista.. luego 
		// se seleccionara la correspondiente al cargar el primero.
		cargarTodosMarcas();
		
		
		
		//Cargo el primero objeto Portatil
		// al terminar la construcción del panel.
		cargarPrimero();

	}

	
	
	private void cargarTodosMarcas() {
		List<Marca> l = ControladorMarca.getTodos();
		
		for (Marca m : l) {
			jcbMarca.addItem(m);
		}
	}	
	
	
	private void totalPortatiles() {
		
		int numTotalPortatiles = ControladorPortatil.contarPortatiles();
		
//		Icon icono = new ImageIcon("/res/info40.png");
//	    // Hay que crear una letra Font con el tipo, estilo y tamaño. 
//        Font font = new Font("Serif, Monospaced", Font.BOLD, 14); // Arial, negrita, tamaño 20. Pongo Arial por cambiar para el ejemplo.
//
//        
//        
        
//        String mensajeHTML = "<html><body><p style='font-size: 14pt; font-weight:bold'>Total de portátiles: " + numTotalPortatiles + "</p></body></html>";
//        String mensajeHTML = "<html><body><p style='font-size: 14pt'><b>Total de portátiles: </b>" + numTotalPortatiles  + "</p></body></html>";
//        JOptionPane.showMessageDialog(null, mensajeHTML, "Message", JOptionPane.PLAIN_MESSAGE,icono);
		
		
		
		
		
		 // Obtener el icono
        Icon icon = UIManager.getIcon("OptionPane.informationIcon");
        JLabel iconLabel = new JLabel(icon);

        // Crear un panel personalizado con un icono y un texto
        JPanel panel = new JPanel();
        panel.add(iconLabel);
        panel.add(new JLabel("Texto de Prueba"));

        // Mostrar el JOptionPane con el panel personalizado
        JOptionPane.showMessageDialog(null, panel, "Información", JOptionPane.INFORMATION_MESSAGE);
    
		
		
		
		
		
		
		
		
		
	}
	
	
	
	private void cargarPrimero() {
		Portatil p = ControladorPortatil.getPrimero();
		muestraEnPantalla(p);
	}
	
	private void cargarAnterior() {
		Portatil p = ControladorPortatil.getAnterior(obtenerIdActual());
		muestraEnPantalla(p);
	}
	
	private void cargarSiguiente() {
		Portatil p = ControladorPortatil.getSiguiente(obtenerIdActual());
		muestraEnPantalla(p);
	}
	
	private void cargarUltimo() {
		Portatil p = ControladorPortatil.getUltimo();
		muestraEnPantalla(p);
	}
	
	
	///////////////////   NUEVO    //////////////////////////////////
	
	private void nuevo() {

		this.jtfId.setText("");
		
		//La Marca se carga en CargarTodosMarcas para darnos opción a elegir

		this.jtfModelo.setText("");
		this.jtfSN.setText("");
		this.grupoProcesadores.clearSelection();
		this.checkVendido.setSelected(false);
		this.jtfFechaVenta.setText("");

	}
	///////////////////   FIN  NUEVO    //////////////////////////////////

	

	/**
	 *    -------------- GUARDAR   -------------------------
	 */
	private void guardar() {

		
		// ------------ VERIFICO LO PEDIDO EN EL EXAMEN.. CODIGO VALIDO Y URL VALIDA ------------//
		// Llamo a otros dos métodos para verificar.	
		

		if (!isSerialNumberValido()) {
			JOptionPane.showMessageDialog(null, "El número de serie es incorrecto. "
				                  	+ "	Verifica que sólo son números y hay minimo 4");	
			return;
		}
		
		
		//-------------------	DATOS QUE PASO A GUARDAR           -------------------//
		
		Portatil o = new Portatil(); // creo un fabricante. mira o, te voy a asignar un
										// identificador que sirva como bandera.. -1
		o.setId(-1);
		if (!this.jtfId.getText().trim().equals("")) { // si el id del textfield tiene número (literalmente: si NO es
														// igual a algo vacio)

			o.setId(Integer.parseInt(this.jtfId.getText()));
			// paso ese número a Entero y se lo asigno
			// al Id objeto con setId, para guardarlo en la base de datos
		}

		o.setModelo(this.jtfModelo.getText());
		o.setSn(this.jtfSN.getText());

		o.setVendido(this.checkVendido.isSelected());
		// es un boolean. el SET FUNCIONA IGUAL.
		// pero EL GET CAMBIA POR IS.. GetSelected sería IsSelected.

		int idMarca = ((Marca) jcbMarca.getSelectedItem()).getId();
		o.setIdMarca(idMarca);
		// tengo que guardar el ID en el objet Marca o. con setIdMarca al que le paso
		// el id en formato INT. Prviamente he sacado ese INT con GET ID del objet
		// pero el objeto lo saco del jcombo Marca, seleccionado el item.
		// RECUERDA QUE HAY QUE CASTEARLO A OBJETO (MARCA).

		// Decido si debo insertar o modificar

		// Sí no se cambió el id, porque estaba vacío, seguirá siendo -1.. con lo que
		// verifico y creo un registro nuevo
		if (o.getId() == -1) { // Inserción
			int nuevoId = ControladorPortatil.insercion(o);
			this.jtfId.setText("" + nuevoId);
		}

		// Si no es -1, es decir exixtía un ID, entonces lo que se realiza es una
		// modificación.
		else {
			ControladorPortatil.modificacion(o);
		}

	}
		///////////////// FIN GUARDAR ///////////////////////////////////
	
	
	 
	////////////////////   VERIFICACIONES DEL GUARDADO - NUMERO DE SERIE     	/////////////////////
	
	private boolean isSerialNumberValido () {
		
		String sn = this.jtfSN.getText();
		int numLetras = 0;
		int numDigitos = 0;
		
		for (int i = 0; i < sn.length(); i++) {
			if (Character.isLetter(sn.charAt(i))) {
				numLetras++;
			}
			if (Character.isDigit(sn.charAt(i))) {
				numDigitos++;
			}
		}
		
		if (numLetras != 0 && numDigitos > 3) {
			return true;
		}
		
		
		return false;
		
	}
	
	
		
	
	

	/**
	 * 
	 */
	private void borrar() {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de Materia", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);  //Es la segunda opcion. NO. La primera opción SÍ es el 0.
		    
			if(opcionElegida == 0) {
		      if (!this.jtfId.getText().trim().equals("")) {    // Si el id en TextField NO está vacío, añadimos el id a idActual
//confirmar linea de abajo 	  //int idActual = Integer.parseInt(this.jtfId.getText());
		    	 int idActual = obtenerIdActual();
		    	  System.out.println(idActual);  //--------------------aquí BREAKPOINT  *******************
		    	  ControladorPortatil.eliminacion(idActual);
		    	  
		    	  // 1. Decido qué registro voy a mostrar en pantalla.
		    	  // 2. Voy a comprobar si existe un anterior, si existe lo muestro
		    	  // 3. Si no existe anterior compruebo si sxiste siguiente,
		    	  // 4. si existe lo muestro. En caso contratio, no quedan registros
		    	  // 5. así que muestro en blanco la pantalla. 
		    	  
		    	  Portatil portatilAMostrar = ControladorPortatil.getAnterior(idActual);   // 1.***
		    	  
		    	  if (portatilAMostrar != null) {  //Existe un anterior, lo muestro   // 2.***
		    		  muestraEnPantalla(portatilAMostrar);
		    	  }
		    	  else {     // 
		    		  portatilAMostrar = ControladorPortatil.getSiguiente(idActual);  // 3.*****
		    		  if (portatilAMostrar != null) {   // Existe un siguiente
		    			  muestraEnPantalla(portatilAMostrar);
		    		  }
		    		  else { // No quedan registros, muestro en blanco.
		    			  nuevo();
		    		  }
		    	  }
		      
		      
		      
		      }
		    }			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	
	private void muestraEnPantalla(Portatil o) {  //ordenado según se muestra en ventana
		if (o != null) {
			
			this.jtfId.setText("" + o.getId());
		
			///// JCOMBO BOX MARCA
			for (int i = 0; i < jcbMarca.getItemCount(); i++) {  
				//Bucle de i = 0 hasta i < los items contados en jcbCurso.
				if (jcbMarca.getItemAt(i).getId() == o.getIdMarca()) {
					jcbMarca.setSelectedIndex(i);
				}
			}
			
			
			this.jtfModelo.setText(o.getModelo());
			this.jtfSN.setText(o.getSn());
			
			
			////////  RADIO BUTTONS 								     ///  Cojo el número INT de procesadores
			switch (o.getNumProcesadores()) {	 //  y dependiendo selecciono un radiobt
			case 1: 
				radiobt1.setSelected(true);
				break;
			case 2:
				radiobt2.setSelected(true);
				break;
			case 3:
				radiobt3.setSelected(true);
				break;
			case 4:
				radiobt4.setSelected(true);
				break;
		
			}
			
			
			//////////  CHECK BOX
			checkVendido.setSelected(o.isVendido());  
			// o.isVendido es igual que getVendido
			// devuelve un true o False.   con lo que
			// el boton checkVendido.   se pondrá con el comando setSelected
			// en marcado (true). o desmarcado (false).
			
			
			
			
			///// DATE CON PARSE

			// Si lo pongo así, saldrá en pantalla NULL si es lo que figura en la base
			//this.jtfFechaVenta.setText("" + o.getFechaVenta());  //// revisar
			
			//Si lo pongo así, dará un error de null pointer exception
			// pero en pantalla dejará la fecha que figuara del portatil anterior
			if (o.getFechaVenta() == null) {
				this.jtfFechaVenta.setText("Sin Información");
			}else {
				this.jtfFechaVenta.setText(sdf.format(o.getFechaVenta()));
			}
			
		
			
		}
	}
	
	

//	private int mostrarTotalPortatiles() {
//		
//		int numeroTotalPortatiles = ControladorPortatil.
//		
//	}
//	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	private int obtenerIdActual() {
		String idActualText = jtfId.getText();
		int idActual = Integer.parseInt(idActualText);

		return idActual;
	}
	
	
}
