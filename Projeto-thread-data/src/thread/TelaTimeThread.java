package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread  extends JDialog{
	
	//painel
	private JPanel jPanel = new JPanel(new GridBagLayout());//painel de componente
	
	//primeiro atributos descricao e label
	private JLabel descricaoHora1 = new JLabel("Hora Thread 1");
	private JTextField mostraHora1 = new JTextField();
	
	
	//segundos atributos descricao e label
	private JLabel descricaoHora2 = new JLabel("Hora Thread 2");
	private JTextField mostraHora2 = new JTextField();
	
	//butoes 
	private JButton jButton1 = new JButton("Start");
	private JButton jButton2 = new JButton("Stop");
	
	//primeira thread
	private Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			while (true) {
				//poderia colocar duas thread dessa q funcionaria normal
				mostraHora1.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	
	// segunda thread
	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			while (true) {
				// poderia colocar duas thread dessa q funcionaria normal
				mostraHora2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").
						format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	
	private Thread threadHora1;//objeto thread 1
	private Thread threadHora2;//objeto thread 2

	
	public TelaTimeThread() {//executa oque estiver dentro, no momento da abertura ou execu�ao 
		
		/** PRIMEIRA PARTE CONCLUIDA **/
		setTitle("Tela de Data e Hora com Thread");//titulo
		setSize(new Dimension(260, 260));//autura e largura 
		setLocationRelativeTo(null);//centralizando 
		setResizable(false);//nao permite aumentar e diminuir o tamanho da tela 
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();//controlador de posicionamento de componentes
		gridBagConstraints.gridx = 0;//largura
		gridBagConstraints.gridy = 0;//coluna
		gridBagConstraints.gridwidth = 2;//inicianado a largura com 2 para a descir�ao e o label
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);//top,esquerda,butao,direita
		gridBagConstraints.anchor = GridBagConstraints.WEST;
	
		
		//primeiro componete descri�ao e label
		descricaoHora1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora1, gridBagConstraints);
		
		mostraHora1.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++; //andado uma possicao
		mostraHora1.setEditable(false);
		jPanel.add(mostraHora1, gridBagConstraints);
		
		
		//segundo componente de desacri�ao e label
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		mostraHora2.setEditable(false);
		jPanel.add(mostraHora2, gridBagConstraints);
		
		
		//para os botes fica na largura de 1
		gridBagConstraints.gridwidth = 1;
		
		//butoes
		jButton1.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton1, gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jPanel.add(jButton2, gridBagConstraints);
		
		
		//acao do butao start
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//executa o click no butao
				
				threadHora1 = new Thread(thread1);
				threadHora1.start();//executando o start
				
				threadHora2 = new Thread(thread2);
				threadHora2.start();//executando o start
				
				//desabilitando o botao de start e abilitando o stop
				jButton1.setEnabled(false);
				jButton2.setEnabled(true);
				
			}
		});
		
		// acao do butao stop
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// executa o click no butao
				threadHora1.stop();//stop da thread
				threadHora2.stop();
				
				//desabilitando o botao de stop e abilitando o start
				jButton1.setEnabled(true);
				jButton2.setEnabled(false);
			}
		});
		
		
		//deixando o botao stop disabilitado ao iniciar a tela
		jButton2.setEnabled(false);
		
		add(jPanel, BorderLayout.WEST);
		//sempre ser� o ultimo comando
		setVisible(true);// torna a tela visivel para o usuario 
		
	}

}
