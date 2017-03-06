package myjava;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class spj implements ActionListener
	{
		String s="",s1;
		double d1,d2;
		JFrame jf = new JFrame("spj的狗屁计算器") ;
		JTextField tf = new JTextField();
		public void init()//实现计算器界面
		{
			Container c=jf.getContentPane();
			tf.setHorizontalAlignment(JTextField.RIGHT);//文本框
			c.add(tf,"North");
			JPanel pn3 = new JPanel(new BorderLayout());
			c.add(pn3,"Center");
			JPanel pn2 = new JPanel();//功能键界面（清除键和关闭键）
			pn2.setLayout(new BorderLayout());
			JPanel pn1 = new JPanel();//运算界面
			pn1.setLayout(new GridLayout(4,4));
			pn3.add(pn2,"North");
			pn3.add(pn1);
			//设置按钮
			JButton b = new JButton("CLEAR");
			b.setToolTipText("请按清除键!");//设置清零键
			b.setForeground(Color.RED);//设置字体颜色
			b.setBackground(Color.YELLOW);//设置背景色
			b.addActionListener(this);
			pn2.add(b,"Center");
			b = new JButton("OFF");
			b.setToolTipText("请按退出键!");//设置off键，点击退出应用程序b.addActionListener(this);
			b.setForeground(Color.RED);//字体颜色
			b.setBackground(Color.YELLOW);//背景色
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
			b.setForeground(Color.BLUE);//设置字体颜色
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
			b.setForeground(Color.BLUE);//设置字体颜色
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
			b.setForeground(Color.BLUE);//设置字体颜色
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("0");//add button 0
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton(".");//add button .
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("=");//add button =
			b.setForeground(Color.RED);//设置字体颜色
			b.addActionListener(this);
			pn1.add(b);
			b = new JButton("\\");//add button \
			b.setForeground(Color.BLUE);//设置字体颜色
			b.addActionListener(this);
			pn1.add(b);
			jf.setSize(300,300);//设置大小
			jf.setVisible(true);//设置为可视
		}
		//处理按钮按下时的动作，进行相应的处理
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			tf.setText(tf.getText()+command);
			if(command.equals("CLEAR")) //清零键 按下时返回初始状态
			{
				s1=null;
				s="";
				tf.setText("");//记录输入值的变量清空
			}
			else if(command.equals("OFF")) System.exit(0);//off键 关闭应用程序
			else if(!command.equals("*")&&!command.equals("\\")
					&&!command.equals("+")&&!command.equals("-")
					&&!command.equals("="))//判断输入是否为数字
			{
				if(s1==null)//判断输入是否为第一个
					s1 = command;
				else s1+=command;
				d1 = new Double(s1).doubleValue();//字符串型转换为双精度型,还原输入数字
				try
				{
					if(s.equals("+")) d1 = d1+d2;//加法运算
					else if(s.equals("-")) d1 = d2-d1;//减法运算
					else if(s.equals("*")) d1 = d1*d2;//乘法运算
					else if(s.equals("\\"))d1 = d2/d1;//除法运算
				}
				catch(Exception ex)
				{
					tf.setText("Error");//错误显示"Error"
					System.out.println(ex.getMessage());
				}
			}
			else if(!command.equals("=")) //判断输入是否为+ - * \
			{
				s = command;
				s1 = null;
				d2 = d1;
			}
			else//输入=时,显示运算结果
			{
				tf.setText(tf.getText()+d1);
			}
		}
		public static void main(String [] args)
		{
			new spj().init();
		}
	} 
