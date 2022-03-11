import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;


public class Procesador_de_textos 
{
	public static void main(String[] args) 
	{
		MarcoProcesador marco=new MarcoProcesador();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoProcesador extends JFrame
{
	MarcoProcesador()
	{
		setBounds(200,200,600,400);
		setTitle("Procesador de Textos");
		LaminaProcesador lamina=new LaminaProcesador();
		add(lamina);
		setVisible(true);
	}
}
class LaminaProcesador extends JPanel
{
	private JTextPane areaTexto;
	private JToolBar barra;

	LaminaProcesador()
	{
		setLayout(new BorderLayout());
		areaTexto=new JTextPane();
		add(areaTexto, BorderLayout.CENTER);

		JPanel laminaMenu=new JPanel();
		JMenuBar menu=new JMenuBar();

		JMenu fuente=new JMenu("Fuente");
		JMenuItem timesNewRoman=new JMenuItem("Times New Roman");
		JMenuItem comicSans=new JMenuItem("Comic Sans");
		JMenuItem arial=new JMenuItem("Arial");

		fuente.add(timesNewRoman);
		fuente.add(comicSans);
		fuente.add(arial);
		menu.add(fuente);

		timesNewRoman.addActionListener(new StyledEditorKit.FontFamilyAction("times new roman", "Times New Roman"));
		comicSans.addActionListener(new StyledEditorKit.FontFamilyAction("Comic", "Comic Sans MS"));
		arial.addActionListener(new StyledEditorKit.FontFamilyAction("arial", "Arial"));


		JMenu estilo=new JMenu("Estilo");

		JMenuItem negrita=new JMenuItem("Negrita", new ImageIcon("src/img/Negrita.png"));
		JMenuItem cursiva=new JMenuItem("Cursiva", new ImageIcon("src/img/Cursiva.png"));
		JMenuItem subrayado=new JMenuItem("Subrayado", new ImageIcon("src/img/Subrayado.png"));

		estilo.add(negrita);
		estilo.add(cursiva);
		estilo.add(subrayado);
		menu.add(estilo);

		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		subrayado.addActionListener(new StyledEditorKit.UnderlineAction());

		//Atajos de teclado
		negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		subrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));


		JMenu tamaño=new JMenu("Tamaño");

		ButtonGroup grupo=new ButtonGroup();
		JRadioButtonMenuItem dieciocho=new JRadioButtonMenuItem("18");
		JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24");
		JRadioButtonMenuItem treinta=new JRadioButtonMenuItem("30");

		grupo.add(dieciocho);
		grupo.add(veinte);
		grupo.add(veinticuatro);
		grupo.add(treinta);

		tamaño.add(dieciocho);
		tamaño.add(veinte);
		tamaño.add(veinticuatro);
		tamaño.add(treinta);

		menu.add(tamaño);

		dieciocho.addActionListener(new StyledEditorKit.FontSizeAction("18",18));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("20",20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("24", 24));
		treinta.addActionListener(new StyledEditorKit.FontSizeAction("30",30));

		laminaMenu.add(menu);

		add(laminaMenu,BorderLayout.NORTH);

		//Menu Emergente
		JPopupMenu emergente=new JPopupMenu();

		JMenuItem negritaE=new JMenuItem("Negrita");
		JMenuItem cursivaE=new JMenuItem("Cursiva");
		JMenuItem subrayadoE=new JMenuItem("Subrayado");

		emergente.add(negritaE);
		emergente.add(cursivaE);
		emergente.add(subrayadoE);

		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		subrayadoE.addActionListener(new StyledEditorKit.UnderlineAction());
		areaTexto.setComponentPopupMenu(emergente);
		
		//Barra de herramientas
		
		barra=new JToolBar(1);

		agregarBotonBarra("src/img/Negrita.png").addActionListener(new StyledEditorKit.BoldAction());
		agregarBotonBarra("src/img/Cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		agregarBotonBarra("src/img/Subrayado.png").addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		agregarBotonBarra("src/img/corazon_verde.png").
		addActionListener(new StyledEditorKit.ForegroundAction("verde", Color.green));
		agregarBotonBarra("src/img/corazon_amarillo.png").
		addActionListener(new StyledEditorKit.ForegroundAction("amarillo", Color.yellow));
		agregarBotonBarra("src/img/corazon_azul.png").
		addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.blue));
		agregarBotonBarra("src/img/corazon_rojo.png").
		addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.red));
		barra.addSeparator();
		agregarBotonBarra("src/img/alineacionIzquierda.png").
		addActionListener(new StyledEditorKit.AlignmentAction("Alineacion izquierda", 0));
		agregarBotonBarra("src/img/alineacionDerecha.png").
		addActionListener(new StyledEditorKit.AlignmentAction("Alineacion derecha", 2));
		agregarBotonBarra("src/img/alineacionCentrada.png").
		addActionListener(new StyledEditorKit.AlignmentAction("Alineacion centrada", 1));
		agregarBotonBarra("src/img/alineacionJustificado.png").
		addActionListener(new StyledEditorKit.AlignmentAction("Alineacion justificado", 3));
	
		add(barra, BorderLayout.WEST);
	}
	
	public JButton agregarBotonBarra(String ruta)
	{
		JButton boton=new JButton(new ImageIcon(ruta));
		barra.add(boton);
		return boton;
	}

}
