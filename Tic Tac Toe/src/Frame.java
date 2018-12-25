import java.awt.*; 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 class Frame extends JFrame implements Runnable, ActionListener {
		
	private JButton P1,P2,P3,P4,P5,P6,P7,P8,P9,P10;
	private JLabel l1,l2;
	private int p=0,player;
	int n;
	Thread t;
	
	public Frame(){
		super();
		n=0;
		t = new Thread(this);	
		this.setTitle("         TIC TAC TOE");
		this.setSize(400,500);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		
		//BUTTONS
		P1 = new JButton("");
		P2 = new JButton("");
		P3 = new JButton("");
		P4 = new JButton("");
		P5 = new JButton("");
		P6 = new JButton("");
		P7 = new JButton("");
		P8 = new JButton("");
		P9 = new JButton("");
		
		// ACTOIN BUTTON
		P1.addActionListener(this);   P2.addActionListener(this);
		P3.addActionListener(this);   P4.addActionListener(this);
		P5.addActionListener(this);   P6.addActionListener(this);
		P7.addActionListener(this);   P8.addActionListener(this);
		P9.addActionListener(this);   
		
		//LABELS
		l1 = new JLabel("0");
		l2 = new JLabel(" Time : ");
		
		//ADD
		this.add(P1); this.add(P2);
		this.add(P3); this.add(P4);
		this.add(P5); this.add(P6);
		this.add(P7); this.add(P8);
		this.add(P9); this.add(l1);
		this.add(l2); 
		
	
		l1.setBounds(195,15,90,30);
		l2.setBounds(140,15,90,30);
		P1.setBounds(70,115,80,80);
		P2.setBounds(155,115,80,80);
		P3.setBounds(240,115,80,80);
		P4.setBounds(70,200,80,80);
		P5.setBounds(155,200,80,80);
		P6.setBounds(240,200,80,80);
		P7.setBounds(70,285,80,80);
		P8.setBounds(155,285,80,80);
		P9.setBounds(240,285,80,80);
		
	}
	
	public void run() {	
		while(true){
			l1.setText(n+++" sec");
			try{Thread.sleep(1000);}catch(Exception e){}
		}
	}
	
		
	public void actionPerformed(ActionEvent e){	
		JButton b = (JButton) e.getSource();
		if(p==0) { b.setBackground(Color.blue);   }
		else if (p==1){ b.setBackground(Color.red);  }
		p=1-p;
		whowin();
		if (player==0){
			System.out.println(" BLUE IS WON "); 
		P1.setEnabled(false); P2.setEnabled(false); P3.setEnabled(false); P4.setEnabled(false);
		P5.setEnabled(false); P6.setEnabled(false); P7.setEnabled(false); P8.setEnabled(false);
		P9.setEnabled(false);} 
		else if (player==1){  
			System.out.println(" RED IS WON "); 
		P1.setEnabled(false); P2.setEnabled(false); P3.setEnabled(false); P4.setEnabled(false);
		P5.setEnabled(false); P6.setEnabled(false); P7.setEnabled(false); P8.setEnabled(false);
		P9.setEnabled(false);} 
		else if (player==-1){ }
		}

	private void whowin(){
		if(P1.getBackground().equals(Color.blue)&&P2.getBackground().equals(Color.blue) && P3.getBackground().equals(Color.blue)||
		   P4.getBackground().equals(Color.blue)&&P5.getBackground().equals(Color.blue) && P6.getBackground().equals(Color.blue)||
		   P7.getBackground().equals(Color.blue)&&P8.getBackground().equals(Color.blue) && P9.getBackground().equals(Color.blue)||
		   P1.getBackground().equals(Color.blue)&&P4.getBackground().equals(Color.blue) && P7.getBackground().equals(Color.blue)||
		   P2.getBackground().equals(Color.blue)&&P5.getBackground().equals(Color.blue) && P8.getBackground().equals(Color.blue)||
		   P3.getBackground().equals(Color.blue)&&P6.getBackground().equals(Color.blue) && P9.getBackground().equals(Color.blue)||
		   P1.getBackground().equals(Color.blue)&&P5.getBackground().equals(Color.blue) && P9.getBackground().equals(Color.blue)||
		   P3.getBackground().equals(Color.blue)&&P5.getBackground().equals(Color.blue) && P7.getBackground().equals(Color.blue) )
	                                	{    player=0; t.stop(); }
		else {
               if(
			P1.getBackground().equals(Color.red)&&P2.getBackground().equals(Color.red) && P3.getBackground().equals(Color.red)||
			P4.getBackground().equals(Color.red)&&P5.getBackground().equals(Color.red) && P6.getBackground().equals(Color.red)||
			P7.getBackground().equals(Color.red)&&P8.getBackground().equals(Color.red) && P9.getBackground().equals(Color.red)||
			P1.getBackground().equals(Color.red)&&P4.getBackground().equals(Color.red) && P7.getBackground().equals(Color.red)||
			P2.getBackground().equals(Color.red)&&P5.getBackground().equals(Color.red) && P8.getBackground().equals(Color.red)||
			P3.getBackground().equals(Color.red)&&P6.getBackground().equals(Color.red) && P9.getBackground().equals(Color.red)||
			P1.getBackground().equals(Color.red)&&P5.getBackground().equals(Color.red) && P9.getBackground().equals(Color.red)||
			P3.getBackground().equals(Color.red)&&P5.getBackground().equals(Color.red) && P7.getBackground().equals(Color.red) )
                                         {   player=1; t.stop(); }
                                     else{   player=-1; }
	}
}
	public static void main(String [] args){
	   new Frame();
	}	
}
