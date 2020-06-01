package bs;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.security.PublicKey;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

public class myEditor extends JFrame{

	public static String outputresult = "";
	public static String tishi1 = "遍历第";
	public static String tishi2 = "个节点:  ";
	static int count1 = 1;
	public static String stepoutput = "分步遍历:"+"\n";
	static int count2 = 0;
	static int count3 = 0;
	public static String s1 = null;
	public static String s2 = null;
	public static String s3 = null;
	public static String s4 = null;
	public static String s5 = null;
	public static String s6 = null;
	public static String s7 = null;
	public static String s8 = null;
	public static String s9 = null;
	public static String s10 = null;
	public static String s11 = null;
	public static String s12 = null;
	public static String s13 = null;
	public static String s14 = null;
	public static String s15 = null;
	//boolean stopKey = false;
	public static int a1 = 0;
	public static int a2 = 0;
	public static int a3 = 0;
	public static int a4 = 0;
	public static int a5 = 0;
	public static int a6 = 0;
	public static int a7 = 0;
	public static int a8 = 0;
	public static int a9 = 0;
	public static int a10 = 0;
	public static int a11 = 0;
	public static int a12 = 0;
	public static int a13 = 0;
	public static int a14 = 0;
	public static int a15 = 0;
	static int xuanze=0;
	public static JTextField jt[] =new JTextField[15];
	public static JTextField jt1[] =new JTextField[15];;
     public int numIndex[]={0,1,3,7,8,4,10,9,2,5,12,11,6,14,13};
     public int numIndex1[]={7 ,3 ,8 ,1 ,10, 4 ,9 ,0 ,12 ,5, 11, 2 , 14 ,6 ,13};
     public int numIndex2[]={7 ,8, 3 ,10 ,9 ,4, 1 ,12 ,11 ,5 ,14 ,13 , 6 ,2 ,0};
     public int numIndex3[]={0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,10 ,9 ,12 ,11 ,14 ,13};

	JTextArea textArea = new JTextArea();
	JScrollPane sc1 = new JScrollPane(textArea);

	public myEditor() {
		
		NewEditor contentPane = new NewEditor();
		this.getContentPane().add(contentPane); 
		setTitle("二叉树遍历算法动态演示系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
//		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("键入数据");
		btnNewButton.setContentAreaFilled(false);//填充透明
		btnNewButton.setBorderPainted(false);//边框透明
		btnNewButton.setBounds(800, 0, 160, 70);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BinTreeTraverse2.setArray(a1, a2, a3, a4, a5, a6, a7, a8, a9,
						a10, a11, a12, a13, a14, a15);

			}

		});
	
		JButton button = new JButton("前序遍历");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(800, 70, 160, 70);
		contentPane.add(button);
		button.addActionListener(new x());

		JButton button_1 = new JButton("中序遍历");
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(800, 140, 160, 70);
		contentPane.add(button_1);
		button_1.addActionListener(new y());

		JButton button_2 = new JButton("后序遍历");
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(800, 210, 160, 70);
		contentPane.add(button_2);
		button_2.addActionListener(new z());
		
		JButton button_6 = new JButton("层序遍历");
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setBounds(700, 0, 160, 70);
		contentPane.add(button_6);
		button_6.addActionListener(new c());

		
		JButton jbEnd = new JButton("暂停");
		jbEnd.setContentAreaFilled(false);//填充透明
		jbEnd.setBorderPainted(false);//边框透明
		jbEnd.setBounds(800, 405, 160, 70);
		contentPane.add(jbEnd);
		jbEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
					if(StopBoolean.stopKey == false){
						StopBoolean.stopKey = true;
					}else if(StopBoolean.stopKey == true){
						StopBoolean.stopKey = false;
					}
				}
			});

		
		JButton button_3 = new JButton("一键生成");
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(800, 280, 160, 70);
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// BinTreeTraverse2.preOrder();preOrderStack();
				// System.out.println(outputresult);
				
				
				if(count2>=15)
				    count2=0;
				Runnable r = new w();
				Thread t = new Thread(r);
				t.start();
				if(StopBoolean.stopKey==true){
					count2=0;
					t.stop();
				}
			}
			
		});
	
		JButton button_4 = new JButton("分步遍历");
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(800, 350, 160, 70);
		contentPane.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(count2==15)
				    count2=0;
				 step();
			}

			private void step() {
                switch(xuanze){
                case 1:
        			if (count2 < 15&&count3<15) {
    					stepoutput = "前序遍历出的第" + (count2 + 1) + "节点: "
    							+ BinTreeTraverse2.array2[count2];
    					// System.out.println(stepoutput);
    					textArea.append(stepoutput + "\n");
    					//System.out.println(stepoutput + "\n");
    					jt[numIndex[count3]].setBackground(Color.yellow);
    					count2++;count3++;
    				}

    				else {
    					for(int i=0;i<15;i++){
    						jt[numIndex[i]].setBackground(null);
    						
    					}
    					textArea.append("前序遍历完成：" + BinTreeTraverse2.array2[0] + " "
    							+ BinTreeTraverse2.array2[1] + " "
    							+ BinTreeTraverse2.array2[2] + " "
    							+ BinTreeTraverse2.array2[3] + " "
    							+ BinTreeTraverse2.array2[4] + " "
    							+ BinTreeTraverse2.array2[5] + " "
    							+ BinTreeTraverse2.array2[6] + " "
    							+ BinTreeTraverse2.array2[7] + " "
    							+ BinTreeTraverse2.array2[8] + " "
    							+ BinTreeTraverse2.array2[9] + " "
    							+ BinTreeTraverse2.array2[10] + " "
    							+ BinTreeTraverse2.array2[11] + " " + " "
    							+ BinTreeTraverse2.array2[12] + " "
    							+ BinTreeTraverse2.array2[13] + " "
    							+ BinTreeTraverse2.array2[14] + "\n");
    					count1 = 1;count3=0;
    				}
        			break; 
                case 4:if(count2 < 15 && count3<15){
					jt[numIndex3[count2]].setBackground(Color.magenta); 
					stepoutput = "层序遍历出的第" + (count2 + 1) + "节点: "
					+BinTreeTraverse2.array1[count2];
                     
					textArea.append(stepoutput + "\n");
					
					count2++;count3++;
					}
                else {
					for(int i=0;i<15;i++){
						jt[numIndex3[i]].setBackground(null);
						
					}
					textArea.append("层序遍历完成：" + BinTreeTraverse2.array1[0] + " "
							+ BinTreeTraverse2.array1[1] + " "
							+ BinTreeTraverse2.array1[2] + " "
							+ BinTreeTraverse2.array1[3] + " "
							+ BinTreeTraverse2.array1[4] + " "
							+ BinTreeTraverse2.array1[5] + " "
							+ BinTreeTraverse2.array1[6] + " "
							+ BinTreeTraverse2.array1[7] + " "
							+ BinTreeTraverse2.array1[8] + " "
							+ BinTreeTraverse2.array1[9] + " "
							+ BinTreeTraverse2.array1[10] + " "
							+ BinTreeTraverse2.array1[11] + " " + " "
							+ BinTreeTraverse2.array1[12] + " "
							+ BinTreeTraverse2.array1[13] + " "
							+ BinTreeTraverse2.array1[14] + "\n");
					count1 = 1;count3=0;
				}
            	
            	break;
        			
                case 2:
        			if (count2 < 15&&count3<15) {
    					stepoutput = "中序遍历出的第" + (count2 + 1) + "节点: "
    							+ BinTreeTraverse2.array2[count2];
    					textArea.append(stepoutput + "\n");
    					jt[numIndex1[count3]].setBackground(Color.red);
    					count2++;count3++;
    				}

    				else {
    					for(int i=0;i<15;i++){
    						jt[numIndex1[i]].setBackground(null);
    						
    					}
    					textArea.append("中序遍历完成：" + BinTreeTraverse2.array2[0] + " "
    							+ BinTreeTraverse2.array2[1] + " "
    							+ BinTreeTraverse2.array2[2] + " "
    							+ BinTreeTraverse2.array2[3] + " "
    							+ BinTreeTraverse2.array2[4] + " "
    							+ BinTreeTraverse2.array2[5] + " "
    							+ BinTreeTraverse2.array2[6] + " "
    							+ BinTreeTraverse2.array2[7] + " "
    							+ BinTreeTraverse2.array2[8] + " "
    							+ BinTreeTraverse2.array2[9] + " "
    							+ BinTreeTraverse2.array2[10] + " "
    							+ BinTreeTraverse2.array2[11] + " " + " "
    							+ BinTreeTraverse2.array2[12] + " "
    							+ BinTreeTraverse2.array2[13] + " "
    							+ BinTreeTraverse2.array2[14] + "\n");
    					count1 = 1;count3=0;
    				}
                	
                	break;
                	
                case 3:
                
                	if (count2 < 15&&count3<15) {
    					stepoutput = "后序遍历出的第" + (count2 + 1) + "节点: "
    							+ BinTreeTraverse2.array2[count2];
    					textArea.append(stepoutput + "\n");
    					jt[numIndex2[count3]].setBackground(Color.blue);
    					count2++;count3++;
    				}

    				else {
    					for(int i=0;i<15;i++){
    						jt[numIndex2[i]].setBackground(null);
    						
    					}
    					textArea.append("后续遍历完成：" + BinTreeTraverse2.array2[0] + " "
    							+ BinTreeTraverse2.array2[1] + " "
    							+ BinTreeTraverse2.array2[2] + " "
    							+ BinTreeTraverse2.array2[3] + " "
    							+ BinTreeTraverse2.array2[4] + " "
    							+ BinTreeTraverse2.array2[5] + " "
    							+ BinTreeTraverse2.array2[6] + " "
    							+ BinTreeTraverse2.array2[7] + " "
    							+ BinTreeTraverse2.array2[8] + " "
    							+ BinTreeTraverse2.array2[9] + " "
    							+ BinTreeTraverse2.array2[10] + " "
    							+ BinTreeTraverse2.array2[11] + " " + " "
    							+ BinTreeTraverse2.array2[12] + " "
    							+ BinTreeTraverse2.array2[13] + " "
    							+ BinTreeTraverse2.array2[14] + "\n");
    					count1 = 1;count3=0;
    				}
                
                
                
                
                
                }
                
				
			}

		});

		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(800, 420, 160, 132);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}

		});
		contentPane.add(btnNewButton_1);
		
		for (int i=0;i<15;i++){
			jt[i]=new JTextField();
			
		}
		//jt[0] = new JTextField();
		jt[0].setBounds(380, 30, 50, 30);
		//textField.setBackground(Color.RED);
		contentPane.add(jt[0]);
		jt[0].setColumns(10);
		jt[0].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				String s1 = jt[0].getText();
				a1 = Integer.parseInt(s1);
			}
		});

	
		jt[1].setColumns(10);
		jt[1].setBounds(196, 111, 50, 30);
		contentPane.add(jt[1]);
		jt[1].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s2 = jt[1].getText();
				a2 = Integer.parseInt(s2);
			}
		});

		
		jt[2].setColumns(10);
		jt[2].setBounds(583, 109, 50, 30);
		contentPane.add(jt[2]);
		jt[2].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s3 = jt[2].getText();
				a3 = Integer.parseInt(s3);
			}
		});

		
		jt[3].setColumns(10);
		jt[3].setBounds(103, 179, 50, 30);
		contentPane.add(jt[3]);
		jt[3].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s4 = jt[3].getText();
				a4 = Integer.parseInt(s4);
			}
		});

		
		jt[4].setColumns(10);
		jt[4].setBounds(284, 179, 50, 30);
		contentPane.add(jt[4]);
		jt[4].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s5 = jt[4].getText();
				a5 = Integer.parseInt(s5);
			}
		});

	
		jt[5].setColumns(10);
		jt[5].setBounds(492, 179, 50, 30);
		contentPane.add(jt[5]);
		jt[5].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s6 = jt[5].getText();
				a6 = Integer.parseInt(s6);
			}
		});

		
		jt[6].setColumns(10);
		jt[6].setBounds(691, 179, 50, 30);
		contentPane.add(jt[6]);
		jt[6].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s7 = jt[6].getText();
				a7 = Integer.parseInt(s7);
			}
		});

		
		jt[7].setColumns(10);
		jt[7].setBounds(51, 249, 50, 30);
		contentPane.add(jt[7]);
		jt[7].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s8 = jt[7].getText();
				a8 = Integer.parseInt(s8);
			}
		});

		
		jt[8].setColumns(10);
		jt[8].setBounds(154, 249, 50, 30);
		contentPane.add(jt[8]);
		jt[8].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s9 = jt[8].getText();
				a9 = Integer.parseInt(s9);
			}
		});

		
		jt[9].setColumns(10);
		jt[9].setBounds(338, 249, 50, 30);
		contentPane.add(jt[9]);
		jt[9].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s10 = jt[9].getText();
				a11 = Integer.parseInt(s10);
			}
		});

		
		jt[10] .setColumns(10);
		jt[10] .setBounds(235, 249, 50, 30);
		contentPane.add(jt[10] );
		jt[10] .addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s11 = jt[10] .getText();
				a10 = Integer.parseInt(s11);
			}
		});

		
		jt[11].setColumns(10);
		jt[11].setBounds(540, 249, 50, 30);
		contentPane.add(jt[11]);
		jt[11].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s12 = jt[11].getText();
				a13 = Integer.parseInt(s12);
			}
		});

		
		jt[12] .setColumns(10);
		jt[12] .setBounds(437, 249, 50, 30);
		contentPane.add(jt[12] );
		jt[12] .addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s13 = jt[12] .getText();
				a12 = Integer.parseInt(s13);
			}
		});

		jt[13].setColumns(10);
		jt[13].setBounds(740, 249, 50, 30);
		contentPane.add(jt[13]);
		jt[13].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s14 = jt[13].getText();
				a15 = Integer.parseInt(s14);
			}
		});

		jt[14] .setColumns(10);
		jt[14] .setBounds(637, 249, 50, 30);
		contentPane.add(jt[14] );
		jt[14] .addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				s15 = jt[14] .getText();
				a14 = Integer.parseInt(s15);
			}
		});
		
		
		//jt1[15] ={jt[0],jt[1],jt[3],jt[7],jt[8],jt[4],jt[9],jt[10],jt[2],jt[5],jt[11],jt[12],jt[6],jt[13],jt[14]};
		// paint(this.getGraphics());
		// Graphics graphics = myEditor.this.getGraphics();
		// graphics.drawLine(0, 0, 50, 50);
		//
		//textArea.setBounds(10, 400, 790, 150);
		
		sc1.setBounds(10, 400, 790, 150);
		textArea.setLineWrap(true);
		 //textArea.setText(a1);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setFont(new Font("de",Font.BOLD,12));
		textArea.setForeground(Color.black);
		sc1.getViewport().setOpaque(false);
		//sc1.add(textArea);
		sc1.setOpaque(false);
		contentPane.add(sc1);

	}

	class x implements ActionListener {
		JTextArea textArea1 = textArea;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			BinTreeTraverse2.preOrder1(); 
			xuanze=1;
			// textArea.setText(output);

		}

	}

	
	
	class y implements ActionListener {
		JTextArea textArea1 = textArea;
       
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			BinTreeTraverse2.inOrder1();
			xuanze=2;

			// String output1 = BinTreeTraverse2.inOrder1();
			// textArea.setText(output1);
		}

	}
	
	class c implements ActionListener {
	JTextArea textArea1 = textArea;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		BinTreeTraverse2.cnOrder1();
		xuanze=4;
		// String output = BinTreeTraverse2.postOrder1();
		// textArea.setText(output);
	}

}
	
	
	class z implements ActionListener {
		JTextArea textArea1 = textArea;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			BinTreeTraverse2.postOrder1();
			xuanze=3;
			// String output = BinTreeTraverse2.postOrder1();
			// textArea.setText(output);
		}

	}

	class w extends StopBoolean  implements Runnable  {
	
		/*public void changeKy(){
			if(StopBoolean.stopKey = false){
				StopBoolean.stopKey = true;
			}else{
				StopBoolean.stopKey = false;
			}
		}*/
		
		public void run() {

			for (int i = 0; i < 17; i++) {
				try {
					new Thread();
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				if (true) {
					switch(xuanze){
					
					
				/*	if(stopKey=false){
						t.stop();
					 count2=0;*/
					
					case 1:
					if (count2 < 15 && stopKey == false){
					jt[numIndex[count2]].setBackground(Color.orange); 
					stepoutput = "前序遍历出的第" + (count2 + 1) + "节点: "
							+ BinTreeTraverse2.array2[count2];
                     
					textArea.append(stepoutput + "\n");
					
					count2++;
					
					 }
					else{
						if (count2 <=15 &&stopKey == false){
						System.out.println("");

						textArea.append(outputresult);
						textArea.append("前序遍历完成：" + BinTreeTraverse2.array2[0] + " "
								+ BinTreeTraverse2.array2[1] + " "
								+ BinTreeTraverse2.array2[2] + " "
								+ BinTreeTraverse2.array2[3] + " "
								+ BinTreeTraverse2.array2[4] + " "
								+ BinTreeTraverse2.array2[5] + " "
								+ BinTreeTraverse2.array2[6] + " "
								+ BinTreeTraverse2.array2[7] + " "
								+ BinTreeTraverse2.array2[8] + " "
								+ BinTreeTraverse2.array2[9] + " "
								+ BinTreeTraverse2.array2[10] + " "
								+ BinTreeTraverse2.array2[11] + " " + " "
								+ BinTreeTraverse2.array2[12] + " "
								+ BinTreeTraverse2.array2[13] + " "
								+ BinTreeTraverse2.array2[14] + "\n");
						count2 = count2 + 4;
						count1 = 1;
						
					}
					}
						
					
					break;
					case 2:
						if(count2 < 15 && stopKey == false){
					jt[numIndex1[count2]].setBackground(Color.lightGray); 
					stepoutput = "中序遍历出的第" + (count2 + 1) + "节点: "
							+ BinTreeTraverse2.array2[count2];
                     
					textArea.append(stepoutput + "\n");
					
					count2++;
					
					}
						else{
							if (count2 <=15 &&stopKey == false){
								System.out.println("");
							
							textArea.append(outputresult);
							textArea.append("中序遍历完成：" + BinTreeTraverse2.array2[0] + " "
									+ BinTreeTraverse2.array2[1] + " "
									+ BinTreeTraverse2.array2[2] + " "
									+ BinTreeTraverse2.array2[3] + " "
									+ BinTreeTraverse2.array2[4] + " "
									+ BinTreeTraverse2.array2[5] + " "
									+ BinTreeTraverse2.array2[6] + " "
									+ BinTreeTraverse2.array2[7] + " "
									+ BinTreeTraverse2.array2[8] + " "
									+ BinTreeTraverse2.array2[9] + " "
									+ BinTreeTraverse2.array2[10] + " "
									+ BinTreeTraverse2.array2[11] + " " + " "
									+ BinTreeTraverse2.array2[12] + " "
									+ BinTreeTraverse2.array2[13] + " "
									+ BinTreeTraverse2.array2[14] + "\n");
							count2 = count2 + 4;
							count1 = 1;
							}
						}
						break;
					case 4:
						if(count2 < 15 && stopKey == false){
							jt[numIndex3[count2]].setBackground(Color.pink); 
							stepoutput = "层序遍历出的第" + (count2 + 1) + "节点: "
							+BinTreeTraverse2.array1[count2];
		                     
							textArea.append(stepoutput + "\n");
							
							count2++;
							
						}
						else{
							if (count2 <=15 &&stopKey == false){
							System.out.println("");

							textArea.append(outputresult);
							textArea.append("层序遍历完成：" + BinTreeTraverse2.array1[0] + " "
									+ BinTreeTraverse2.array1[1] + " "
									+ BinTreeTraverse2.array1[2] + " "
									+ BinTreeTraverse2.array1[3] + " "
									+ BinTreeTraverse2.array1[4] + " "
									+ BinTreeTraverse2.array1[5] + " "
									+ BinTreeTraverse2.array1[6] + " "
									+ BinTreeTraverse2.array1[7] + " "
									+ BinTreeTraverse2.array1[8] + " "
									+ BinTreeTraverse2.array1[9] + " "
									+ BinTreeTraverse2.array1[10] + " "
									+ BinTreeTraverse2.array1[11] + " " + " "
									+ BinTreeTraverse2.array1[12] + " "
									+ BinTreeTraverse2.array1[13] + " "
									+ BinTreeTraverse2.array1[14] + "\n");
							count2 = count2 + 4;
							count1 = 1;
							}
						}
						break;
					case 3:
						if(count2 < 15 && stopKey == false){
					jt[numIndex2[count2]].setBackground(Color.cyan);  
					stepoutput = "后序遍历出的第" + (count2 + 1) + "节点: "
							+ BinTreeTraverse2.array2[count2];
                     
					textArea.append(stepoutput + "\n");
					
					count2++; 
					
						}
						else{
							if (count2 <=15 &&stopKey == false){
							System.out.println("");

							textArea.append(outputresult);
							textArea.append("后序遍历完成：" + BinTreeTraverse2.array2[0] + " "
									+ BinTreeTraverse2.array2[1] + " "
									+ BinTreeTraverse2.array2[2] + " "
									+ BinTreeTraverse2.array2[3] + " "
									+ BinTreeTraverse2.array2[4] + " "
									+ BinTreeTraverse2.array2[5] + " "
									+ BinTreeTraverse2.array2[6] + " "
									+ BinTreeTraverse2.array2[7] + " "
									+ BinTreeTraverse2.array2[8] + " "
									+ BinTreeTraverse2.array2[9] + " "
									+ BinTreeTraverse2.array2[10] + " "
									+ BinTreeTraverse2.array2[11] + " " + " "
									+ BinTreeTraverse2.array2[12] + " "
									+ BinTreeTraverse2.array2[13] + " "
									+ BinTreeTraverse2.array2[14] + "\n");
							count2 = count2 + 4;
							count1 = 1;
							}
						}
					
					}
					
					
				}


			}
			/*System.out.println("");
			
			

			textArea.append(outputresult);
			textArea.append("遍历完成：" + BinTreeTraverse2.array2[0] + " "
					+ BinTreeTraverse2.array2[1] + " "
					+ BinTreeTraverse2.array2[2] + " "
					+ BinTreeTraverse2.array2[3] + " "
					+ BinTreeTraverse2.array2[4] + " "
					+ BinTreeTraverse2.array2[5] + " "
					+ BinTreeTraverse2.array2[6] + " "
					+ BinTreeTraverse2.array2[7] + " "
					+ BinTreeTraverse2.array2[8] + " "
					+ BinTreeTraverse2.array2[9] + " "
					+ BinTreeTraverse2.array2[10] + " "
					+ BinTreeTraverse2.array2[11] + " " + " "
					+ BinTreeTraverse2.array2[12] + " "
					+ BinTreeTraverse2.array2[13] + " "
					+ BinTreeTraverse2.array2[14] + "\n");
			count1 = 1;
*/
		count2 = 0;
		}

	}

	
	
	
	
	
	class NewEditor extends JPanel {

		public NewEditor() {

		}

		public void paintComponent(Graphics g) {
			int x = 0, y = 0;
			ImageIcon icon = new ImageIcon("src//image//bg1.jpg");//
			g.drawImage(icon.getImage(), x, y, getSize().width,
					getSize().height, this);
			while (true) {
				g.drawImage(icon.getImage(), x, y, this);
				if (x > getSize().width && y > getSize().height)
					break;
				// 这段代码是为了保证在窗口大于图片时，图片仍能覆盖整个窗口
				if (x > getSize().width) {
					x = 0;
					y += icon.getIconHeight();
				} else
					x += icon.getIconWidth();

			}

		}
	}
}
