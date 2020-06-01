package bs;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login extends JFrame
{
    public login()
    {
     super("   ");
     NewPanel p = new NewPanel();
     
     ImageIcon ico1 = new ImageIcon("src//image//b1.jpg");
    
     JButton b1 = new JButton("",ico1);
     b1.setBorder(null);
     b1.setBounds(400, 440, 150,50);
 
     
     
     
     
     //JLabel l1=new JLabel();
     //l1.add(b1,BorderLayout.WEST);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					
					login.this.setVisible(false);
					myEditor frame= new myEditor();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
       
		 ImageIcon ico2 = new ImageIcon("src//image//b2.jpg");
		    
	     JButton b2 = new JButton("",ico2);
	     b2.setBorder(null);
	  b2.setBounds(600, 440, 150,50);
	  b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	    p.setLayout(null);
	  
	  p.add(b1);
	  p.add(b2); 
	     
     this.getContentPane().add(p); 
     //将面板添加到JFrame上
     this.setSize(960,600); //初始窗口的大小
     this.setLocationRelativeTo(null); //设置窗口居中
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
    }

    protected Window login() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args)
    {
     new login();
    }

    class NewPanel extends JPanel
   {
     public NewPanel()
     {

     }

     public void paintComponent(Graphics g)
     {
        int x=0,y=0;
//        java.net.URL imgURL=getClass().getResource("F:/bg2.jpg");

        //test.jpg是测试图片，与Demo.java放在同一目录下
        ImageIcon icon=new ImageIcon("src//image//bg2.jpg");//
        g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
        while(true)
        {
          g.drawImage(icon.getImage(),x,y,this);
          if(x>getSize().width && y>getSize().height)break;
          //这段代码是为了保证在窗口大于图片时，图片仍能覆盖整个窗口
          if(x>getSize().width)
          {
             x=0;
             y+=icon.getIconHeight();
          }
          else
           x+=icon.getIconWidth();
        
   }
}


} 
    public class ImageButton extends JButton {
    	 
    	public ImageButton(ImageIcon ico1){
    		//setSize(string.getImage().getWidth(null),
    				//string.getImage().getHeight(null));
    		
    		setMargin(new Insets(0,0,0,0));//将边框外的上下左右空间设置为0
    		setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0
    		setBorderPainted(false);//不打印边框
    		setBorder(null);//除去边框
    		setText(null);//除去按钮的默认名称
    		setFocusPainted(false);//除去焦点的框
    		setContentAreaFilled(false);//除去默认的背景填充
    	}

		public void setSize(int i, int j, int k, int l) {
			// TODO Auto-generated method stub
			
		}
    }
    }