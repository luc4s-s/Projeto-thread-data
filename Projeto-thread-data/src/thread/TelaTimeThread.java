package thread;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaTimeThread  extends JDialog{
	
	public TelaTimeThread() {//executa oque estiver dentro, no momento da abertura ou execuçao 
		
		/** PRIMEIRA PARTE CONCLUIDA **/
		setTitle("Tela de Data e Hora com Thread");//titulo
		setSize(new Dimension(260, 260));//autura e largura 
		setLocationRelativeTo(null);//centralizando 
		setResizable(false);//nao permite aumentar e diminuir o tamanho da tela 
		
		
		//sempre será o ultimo comando
		setVisible(true);// torna a tela visivel para o usuario 
		
	}

}
