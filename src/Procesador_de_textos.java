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

		//Barra de Herramientas
		JToolBar barra=new JToolBar(1); //1: orientacion vertical de la barra

		JButton botonNegrita=new JButton(new ImageIcon("src/img/Negrita.png"));
		JButton botonCursiva=new JButton(new ImageIcon("src/img/Cursiva.png"));
		JButton botonSubrayado=new JButton(new ImageIcon("src/img/Subrayado.png"));

		botonNegrita.addActionListener(new StyledEditorKit.BoldAction());
		botonCursiva.addActionListener(new StyledEditorKit.ItalicAction());
		botonSubrayado.addActionListener(new StyledEditorKit.UnderlineAction());

		barra.add(botonNegrita);
		barra.add(botonCursiva);
		barra.add(botonSubrayado);

		//Cambiar colores la letra
		JButton botonVerde=new JButton(new ImageIcon("src/img/corazon_verde.png"));
		JButton botonAmarillo=new JButton(new ImageIcon("src/img/corazon_amarillo.png"));
		JButton botonRojo=new JButton(new ImageIcon("src/img/corazon_rojo.png"));
		JButton botonAzul=new JButton(new ImageIcon("src/img/corazon_azul.png"));

		botonVerde.addActionListener(new StyledEditorKit.ForegroundAction("verde", Color.green));
		botonAmarillo.addActionListener(new StyledEditorKit.ForegroundAction("amarillo", Color.yellow));
		botonRojo.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.red));
		botonAzul.addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.blue));

		barra.add(botonVerde);
		barra.add(botonAmarillo);
		barra.add(botonRojo);
		barra.add(botonAzul);

		add(barra, BorderLayout.WEST);
	}

}
