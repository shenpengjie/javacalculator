package myjava;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class spj implements ActionListener
	{
		String s="",s1;
		double d1,d2;
		JFrame jf = new JFrame("spj�Ĺ�ƨ������") ;
		JTextField tf = new JTextField();
		public void init()//ʵ�ּ���������
		{
			Container c=jf.getContentPane();
			tf.setHorizontalAlignment(JTextField.RIGHT);//�ı���
			c.add(tf,"North");
			JPanel pn3 = new JPanel(new BorderLayout());
			c.add(pn3,"Center");
			JPanel pn2 = new JPanel();//���ܼ����棨������͹رռ���
			pn2.setLayout(new BorderLayout());
			JPanel pn1 = new JPanel();//�������
			pn1.setLayout(new GridLayout(4,4));
			pn3.add(pn2,"North");
			pn3.add(pn1);
			//���ð�ť
			JButton b = new JButton("CLEAR");
			b.setToolTipText("�밴�����!");//���������
			b.setForeground(Color.RED);//����������ɫ
			b.setBackground(Color.YELLOW);//���ñ���ɫ
			b.addActionListener(this);
			pn2.add(b,"Center");
			b = new JButton("OFF");
			b.setToolTipText("�밴�˳���!");//����off��������˳�Ӧ�ó���b.addActionListener(this);
			b.setForeground(Color.RED);//������ɫ
			b.setBackground(Color.YELLOW);//����ɫ
			pn2.add(b,"East");
			b = new JButton("1");//add butten 1
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("2");//add butten 2
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("3");//add butten 3
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("+");//add butten +
			b.setForeground(Color.BLUE);//����������ɫ
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("4");//add butten 4
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("5");//add butten 5
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("6");//add button 6
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("-");//add button -
			b.setForeground(Color.BLUE);//����������ɫ
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("7");//add button 7
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("8");//add button 8
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("9");//add button 9
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("*");//add button *
			b.setForeground(Color.BLUE);//����������ɫ
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("0");//add button 0
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton(".");//add button .
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("=");//add button =
			b.setForeground(Color.RED);//����������ɫ
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("\\");//add button \
			b.setForeground(Color.BLUE);//����������ɫ
			b.addActionListener(this);
			pn1.add(b);
			jf.setSize(300,300);//���ô�С
			jf.setVisible(true);//����Ϊ����
		}
		//����ť����ʱ�Ķ�����������Ӧ�Ĵ���
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			tf.setText(tf.getText()+command);
			if(command.equals("CLEAR")) //����� ����ʱ���س�ʼ״̬
			{
				s1=null;
				s="";
				tf.setText("");//��¼����ֵ�ı������
			}
			else if(command.equals("OFF")) System.exit(0);//off�� �ر�Ӧ�ó���
			else if(!command.equals("*")&&!command.equals("\\")
					&&!command.equals("+")&&!command.equals("-")
					&&!command.equals("="))//�ж������Ƿ�Ϊ����
			{
				if(s1==null)//�ж������Ƿ�Ϊ��һ��
					s1 = command;
				else s1+=command;
				d1 = new Double(s1).doubleValue();//�ַ�����ת��Ϊ˫������,��ԭ��������
				try
				{
					if(s.equals("+")) d1 = d1+d2;//�ӷ�����
					else if(s.equals("-")) d1 = d2-d1;//��������
					else if(s.equals("*")) d1 = d1*d2;//�˷�����
					else if(s.equals("\\"))d1 = d2/d1;//��������
				}
				catch(Exception ex)
				{
					tf.setText("Error");//������ʾ"Error"
					System.out.println(ex.getMessage());
				}
			}
			else if(!command.equals("=")) //�ж������Ƿ�Ϊ+ - * \
			{
				s = command;
				s1 = null;
				d2 = d1;
			}
			else//����=ʱ,��ʾ������
			{
				tf.setText(tf.getText()+d1);
			}
		}
		public static void main(String [] args)
		{
			new spj().init();
		}
	} 
