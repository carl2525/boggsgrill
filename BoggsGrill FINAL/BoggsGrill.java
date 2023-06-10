import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.applet.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class BoggsGrill extends JFrame implements ActionListener
{

	JPanel logIn = new JPanel();
	JLabel JL1,JL2,JL3, logo,logo2;
    JTextField JT1,JT2;
    JPasswordField JP1;
    JButton JB1, JB2;
    
    JPanel Register = new JPanel();
    JLabel Passmo,Useer,Pangalan1, design;
    JTextField Pangalan, UserMo;
    JPasswordField PasswordMo;
    JButton RegisterDong,Babalik;
    

    JPanel menus = new JPanel();
    JLabel boggs = new JLabel(new ImageIcon(getClass().getResource("1.png")));
    JPanel forAccessBut = new JPanel();
    JButton AccessButton[] = {new JButton("P.O.S"),
					   new JButton("INVENTORY REPORT"),
					   new JButton("SALES REPORT"),
					   new JButton("MASTER CONTROL")};


    JPanel PointOfSales = new JPanel();
    JPanel Foods = new JPanel();
    JPanel numericPanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JScrollPane scrollPane;
    JTextArea summaryField;
    JLabel orderLabel,totalLabel,paymentLabel,changeLabel,neymLabel,stakLabel;
    JTextField orderField,totalField,paymentField,changeField,neymField,stakField;
    JButton Foody[] = {new JButton("GRILLED"),
					   new JButton("SIZZLING"),
					   new JButton("BEVERAGES"),
					   new JButton("BEER BUCKET")};
	JButton Pindutan[] = {new JButton("1"),
					   new JButton("2"),
					   new JButton("3"),
					   new JButton("4"),
					   new JButton("5"),
					   new JButton("6"),
					   new JButton("7"),
					   new JButton("8"),
					   new JButton("9"),
					   new JButton("0"),
					   new JButton("."),
					   new JButton("CLEAR"),
					   new JButton("ENTER"),
					   new JButton("CANCEL"),
					   new JButton("PAY")};

    JButton menuButton[] = {new JButton("NEXT TRANSACTION"),
					   new JButton("VOID"),  
					    new JButton("PRINT RECEIPT"), 
					   new JButton("BACK")};

	JPanel p[] = {new JPanel(),new JPanel(),new JPanel(),new JPanel()};

    JButton Produkto1[] = {new JButton("PORK BBQ - PHP 30"),
                       new JButton("CHICKEN BBQ - PHP 80"),
					   new JButton("ISAW CHIX - PHP 20"),
					   new JButton("ISAW PORK - PHP 20"),
					   new JButton("BETAMAX(CHIX BLOOD) - PHP 15"),
					   new JButton("WALKMAN(PIG EARS) - PHP 20"),
					   new JButton("HOTDOG(KING SIZE) - PHP 18"),
					   new JButton("TILAPIA - PHP 60"),
					   new JButton("HITO - PHP 70"),
					   new JButton("PUSIT - PHP 85")};

    JButton Produkto2[] = {new JButton("SIZZLING SISIG - PHP 145"),
                       new JButton("SIZZLING HOTDOG - PHP 125"),
					   new JButton("CALAMARES(BIG) - PHP 200"),
					   new JButton("KILAWIN(TANIGUE-SOLO) - PHP 85"),
					   new JButton("KILAWIN(3 TO 4 PERSON)  - PHP 150"),
					   new JButton("DINAKDAKAN - PHP 85"),
					   new JButton("CHICHARON BULAKLAK - PHP 155"),
					   new JButton("NACHOS - PHP 185"),
					   new JButton("PAPAITAN - PHP 65"),
					   new JButton("RICE - PHP 12")};

    JButton Produkto3[] = {new JButton("RED HORSE(STALLION) - PHP 50"),
					   new JButton("SAN MIG LIGHT - PHP 50"),
					   new JButton("PALE PILSEN - PHP 50"),
					   	new JButton("FLAVORED BEER(A&L) - PHP 50"),
					   new JButton("TIGER BEER - PHP 60"),
					   new JButton("COKE - PHP 16"),
					   new JButton("ROYAL - PHP 16"),
					   new JButton("SPRITE - PHP 16"),
					   	new JButton("CRANBERRY JUICE - PHP 15"),
					   new JButton("LEMON ICE TEA - PHP 15")};

    JButton Produkto4[] = {new JButton("BEER BUCKET(BOTTLES OF ANY - PHP 285"),
    					   	 new JButton("NEW PRODUCT 0"),
					  		 new JButton("NEW PRODUCT 1"),
					   		 new JButton("NEW PRODUCT 2"),
					   		 new JButton("NEW PRODUCT 3"),
					   		 new JButton("NEW PRODUCT 4")};													

    String numero[] = {"1","2","3","4","5","6","7","8","9","0","."};

    JPanel salesPanel8 = new JPanel();
    JLabel salesLabel8,grossLabel8,transactLabel8; JTextField grossField8,transactField8; JTextArea summaryField8; JScrollPane scrollPane8; JButton backButton8, resetsales, print,print1;

    JPanel inventoryPanel = new JPanel();

    JLabel inventoryLabel; JTextArea summaryField3; JScrollPane scrollPane3; JButton backButton2;

	Scanner i,i2;
	PrintWriter wrfile,wrfile2;
	String prodId[] = new String[200];
	String prodName[] = new String[200];

	double prodSales[] = new double[200];
	String prodSaless[] = new String[200];

	int prodPrice[] = new int[200];
	int prodStocks[] = new int[200];
	String prodStockss[] = new String[200];
	double totalSales;
	double totalSales1;


    String prodPrices[] = new String[200];
	String newStocks2s[] = new String[200];

	int beks=0;
	

	int itemSold[] = new int[200];
	String itemSolds[] = new String[200];
	int newStocks2[] = new int[200];

	int newStocks[] = new int[200];
	int Norder[] = new int[200];
	int b=-1;
	int c=-1;
	String id;
	int order =0; int transaction=0;
	double total;
	double newtimes[] = new double[200];
	double payment;
	double gross;
	String[] itemline = new String[1000];
	
	String[] itemlines = new String[100];
	String itemline2[] = new String[10000];
	String itemline3;
	int t[] = new int[9000];
	int tr;
	String d1[] = new String[9000];
	String d2[] = new String[9000];
	double s[] = new double[9000];
	double sum;

    int jadine=30;

	public void openFile()
	{
		try{
			i = new Scanner(new FileReader("inventory1.txt"));
		}
		catch(IOException e){
			System.out.println("could not find file");
		}
	}



	public void writeFile()
	{
		try{
			wrfile = new PrintWriter(new FileWriter("inventory1.txt"));
		}
		catch(IOException e){
			System.out.println("could not find file");
		}

	}

	public void readFile()
	{

     	while(i.hasNext())
		{
			++b;
			prodId[b] = i.next();
			prodName[b] = i.next();
			beks = Integer.parseInt(prodId[b]);

			prodPrices[b] = i.next();
			prodPrice[b] = Integer.parseInt(prodPrices[b]);

			prodStockss[b] = i.next();
			prodStocks[b] = Integer.parseInt(prodStockss[b]);

            itemSolds[b] = i.next();
			itemSold[b] = Integer.parseInt(itemSolds[b]);

			newStocks2s[b] = i.next();
			newStocks2[b] = Integer.parseInt(newStocks2s[b]);

			prodSaless[b] = i.next();
			prodSales[b] = Double.parseDouble(prodSaless[b]);
		}


	}


	public void printInventory()
	{
		summaryField3.setText("=====================================================================================================================================================\nPROD. ID\t    \t\t\tPROD. NAME\t\t\tINITIAL STOCKS\tITEM SOLD\t                  STOCKS LEFT\n=====================================================================================================================================================\n");


		for(int x =0; x<=(beks-1); x++)
        {
        	itemline[x] = prodId[x] + "\t" + prodName[x] + "\t" + prodPrices[x] + "\t" + prodStockss[x] + "\t" + itemSolds[x]+ "\t" + newStocks2s[x]+ "\t" + prodSaless[x];
        	wrfile.println(itemline[x]);
        	summaryField3.append(""+prodId[x]+"\t    \t\t\t"+prodName[x]+"\t\t"+prodStockss[x]+"\t\t"+itemSolds[x]+"\t\t"+newStocks2s[x]+"\n");

        }


	}

	public void printAdmin()
	{

        productList.setText("====================================================================\nID\tNAME\t\tSTOCKS\tPRICE\n====================================================================\n");

		for(int x =0; x<=(beks-1); x++)
        {
        	itemline[x] = prodId[x] + "\t" + prodName[x] + "\t" + prodPrices[x] + "\t" + prodStockss[x] + "\t" + itemSolds[x]+ "\t" + newStocks2s[x]+ "\t" + prodSaless[x];
        	wrfile.println(itemline[x]);
        	itemlines[x]=""+prodId[x]+"\t"+prodName[x]+"\t"+newStocks2s[x]+"\t"+prodPrices[x]+"\n";
        	productList.append(""+itemlines[x]);

        }


	}


	public void printSalesReport()
	{
		summaryField8.setText("======================================================================\nPROD. ID\tPROD. NAME\t                    PRICE\tITEM SOLD\tSALES\n======================================================================\n");


		for(int x =0; x<=(beks-1); x++)
        {

        	summaryField8.append(""+prodId[x]+"\t"+prodName[x]+"\t"+prodPrices[x]+"\t"+itemSolds[x]+"\t"+prodSaless[x]+"\n");
        }

	}


	public void closeFile1()
	{
		i.close();
	}

	public void closeFile2()
	{
		wrfile.close();
	}

	public void totalSales()
	{
		totalSales = prodSales[0]+prodSales[1]+prodSales[2]+prodSales[3]+prodSales[4]+prodSales[5]+prodSales[6]+prodSales[7]+prodSales[7]+prodSales[9]+prodSales[10]+prodSales[11]+prodSales[12]+prodSales[13]+prodSales[14]+prodSales[15]+prodSales[16]+prodSales[17]+prodSales[18]+prodSales[19]+prodSales[20]+prodSales[21]+prodSales[22]+prodSales[23]+prodSales[24]+prodSales[25]+prodSales[26]+prodSales[27]+prodSales[28]+prodSales[29]+prodSales[30]+prodSales[31]+prodSales[32]+prodSales[33]+prodSales[34];
		grossField8.setText(""+totalSales);
	}
	
	public void totalSales1()
	{
		totalSales = prodSales[0]+prodSales[1]+prodSales[2]+prodSales[3]+prodSales[4]+prodSales[5]+prodSales[6]+prodSales[7]+prodSales[7]+prodSales[9]+prodSales[10]+prodSales[11]+prodSales[12]+prodSales[13]+prodSales[14]+prodSales[15]+prodSales[16]+prodSales[17]+prodSales[18]+prodSales[19]+prodSales[20]+prodSales[21]+prodSales[22]+prodSales[23]+prodSales[24]+prodSales[25]+prodSales[26]+prodSales[27]+prodSales[28]+prodSales[29]+prodSales[30]+prodSales[31]+prodSales[32]+prodSales[33]+prodSales[34]*0;
		
	}
	
	
	
	Scanner u,u2;
	PrintWriter sulat,sulat2;
	String IdNo[] = new String[200];
	String fullname[] = new String[200];
	String user[] = new String[200];
	String pass[] = new String[200];
	String[] Account = new String [1000];
	int numerouno = 0;
	int a = -1;
	
	public void tagabukas()
	{
		try{
			u = new Scanner(new FileReader("userlist.txt"));
		}
		catch(IOException d){
			System.out.println("could not find file");
		}
	}
	public void tagasulat()
	{
		try{
			sulat = new PrintWriter(new FileWriter("userlist.txt"));
		}
		catch(IOException d){
			System.out.println("could not find file");
		}

	}
	public void tagabasa()
	{

     	while(u.hasNext())
		{
			++a;
			IdNo[a] = u.next();
			user[a] = u.next();
			pass[a] = u.next();
			numerouno = Integer.parseInt(IdNo[a]);
			fullname[a] = u.next();

            
		}


	}
	public void printingAccount()
	{
		Listahan.setText("=====================================================================================================================================================\nID. NO\t   \t\t\tUSERNAME      \t\tPASSWORD   \t\tUSER LEVEL\t \n=====================================================================================================================================================\n");


		for(int x =0; x<=(numerouno-1); x++)
        {
        	Account[x] = IdNo[x] + "\t" + user[x] + "\t" + pass[x] + "\t" + fullname[x];
        	sulat.println(Account[x]);
        	Listahan.append(""+IdNo[x]+"\t    \t\t\t"+user[x]+"\t\t"+pass[x]+"\t\t"+fullname[x]+"\n");

        }


	}
	public void tagasara1()
	{
		u.close();
	}

	public void tagasara2()
	{
		sulat.close();
	}
	public Scanner x;
	public Scanner x1;
	
	 public void Login(String Id ,String username, String password, String filepath, String admin){
        boolean found = false;
        String tempId = "";
        String tempUsername = "";
        String tempPassword = "";
        String tempType = "";
        
        
        try{
            x = new Scanner(new File(filepath));
            x.useDelimiter("[\t\n]");
            
            do{
            	tempId = x.next();
                tempUsername = x.next();
                tempPassword = x.next();
                tempType = x.next();
                
                FileWriter fw = new FileWriter("temp.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(tempType);
                pw.flush();
                pw.close();
                
                if( tempId.trim().equals(Id.trim())&&tempUsername.trim().equals(username.trim())&&tempPassword.trim().equals(password.trim())){
                    found = true;
                    
                 if(tempType.trim().equals(admin)){
                     JOptionPane.showMessageDialog(null, "LOGGED IN AS ADMIN", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                     x.close();
                    menus.setVisible(true);
                    logIn.setVisible(false);             
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "LOGGED IN AS USER", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                     x.close();
                    found = true;
                    menus.setVisible(true);
                    logIn.setVisible(false);
                    AccessButton[2].setVisible(false);
                    AccessButton[3].setVisible(false);
                    
                 }
                }
            }
                 while(x.hasNext()&& !found);
                
            
        }
        catch(Exception e){
            
        }
	 }
   

    JPanel adminPanel = new JPanel();

	JTextArea productList;
	JScrollPane productScroll;

	JPanel optionsPanel = new JPanel();

	JButton options[] = {new JButton("ADD"),
					   new JButton("EDIT"),
					   new JButton("DELETE"),
					   new JButton("CANCEL")};
	JButton accounts, delete;
	JPanel AccountsList = new JPanel();
	JLabel AllAcounts; JTextArea Listahan; JScrollPane babaan; JButton alis;
	JLabel nameLabel,stockLabel,priceLabel;
	JTextField nameField,stockField,priceField;

	JButton okButton,beckButton,ReStock;
    String pidmo;

    
    Font font1 = new Font ("Trebuchet MS", Font.BOLD, 15);
    Font font2 = new Font ("Trebuchet MS", Font.BOLD, 30);
    Font font3 = new Font ("Trebuchet MS", Font.BOLD, 15);

	Color Red = new Color (102, 102, 102);
    Color Blue = new Color (0, 64, 64);
    Color Yellow =  new Color (51, 51, 51);
    Color TextF = new Color (204, 204, 204);

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
    Date date = new Date();

	Container C = getContentPane();

	public BoggsGrill()
	{
		C.setLayout(null);
		C.setBackground(Yellow);
		setIconImage(Toolkit.getDefaultToolkit().getImage("32.jpg"));

		logIn.setLayout(null);
		C.add(logIn);
		logIn.setBackground(Yellow);

		logo = new JLabel();
		logIn.add(logo);

	    logo.setIcon(new ImageIcon(getClass().getResource("32.jpg")));

		JL3 = new JLabel("ID NO.");
		logIn.add(JL3);
		JT2 = new JTextField();
		logIn.add(JT2);
		
		JL1 = new JLabel("USERNAME:");
		logIn.add(JL1);
		JT1 = new JTextField();
		logIn.add(JT1);

		JL2 = new JLabel("PASSWORD:");
		logIn.add(JL2);
		JP1 = new JPasswordField();
		logIn.add(JP1);

		JB1 = new JButton("LOG-IN");
		logIn.add(JB1);
		
		JB2 = new JButton("REGISTER");
        logIn.add(JB2);
        
        Register.setLayout(null);
		C.add(Register);
		Register.setBackground(Yellow);
        
        design = new JLabel();
        design.setIcon(new ImageIcon(getClass().getResource("32.jpg")));
        Register.add(design);
		
		Pangalan1 = new JLabel("Admin or User");
		Register.add(Pangalan1);
		Pangalan = new JTextField();
		Register.add(Pangalan);
		Useer = new JLabel("USERNAME:");
		Register.add(Useer);
		UserMo = new JTextField();
		Register.add(UserMo);
		Passmo = new JLabel("PASSWORD:");
		Register.add(Passmo);
		PasswordMo = new JPasswordField();
		Register.add(PasswordMo);
		RegisterDong = new JButton("Create Account");
		Register.add(RegisterDong);
		Babalik = new JButton("BACK");
		Register.add(Babalik);
        

		JP1.addActionListener(this);
		JB1.addActionListener(this);
		JB2.addActionListener(this);
		
		RegisterDong.addActionListener(this);
		Babalik.addActionListener(this);

        logo.setBounds(543,120,225,225);
        JL3.setBounds(495,375,200,30);
        JT2.setBounds(685,375,140,25);
		JL1.setBounds(495,410,200,30);
        JT1.setBounds(685,410,140,25);
        JL2.setBounds(495,445,200,30);
        JP1.setBounds(685,445,140,25);
        JB1.setBounds(530,480,100,25);
        logIn.setBounds(0,0,1364,727);
        JB2.setBounds(675,480,125,25);
        
        design.setBounds(543,120,225,225);
        Pangalan1.setBounds(495,375,200,30);
        Pangalan.setBounds(685,375,140,25);
        Useer.setBounds(495,410,200,30);
        UserMo.setBounds(685,410,140,25);
        Passmo.setBounds(495,445,200,25);
        PasswordMo.setBounds(685,445,140,25);
        RegisterDong.setBounds(575,485,150,25);
        Register.setBounds(0,0,1364,727);
        Babalik.setBounds(1120,610,230,80);
        	
        
        Pangalan1.setFont(font1);
        Pangalan.setFont(font1);
        Useer.setFont(font1);
        UserMo.setFont(font1);
        Passmo.setFont(font1);
        PasswordMo.setFont(font1);
        RegisterDong.setFont(font1);
        Babalik.setFont(font3);
        	

        JL1.setFont(font1);
        JL3.setFont(font1);
        JT2.setFont(font1);
        JT1.setFont(font1);
        JL2.setFont(font1);
        JP1.setFont(font1);
        JB1.setFont(font1);
      	JB2.setFont(font1);
        

        JL1.setForeground(Color.WHITE);
        JL2.setForeground(Color.WHITE);
        JL3.setForeground(Color.WHITE);
        JB1.setBackground(Blue);
        JB1.setForeground(Color.WHITE);
        JB2.setBackground(Blue);
        JB2.setForeground(Color.WHITE);
        
        Pangalan1.setForeground(Color.WHITE);
        Useer.setForeground(Color.WHITE);
        Passmo.setForeground(Color.WHITE);
        RegisterDong.setBackground(Blue);
        RegisterDong.setForeground(Color.WHITE);
        Babalik.setForeground(Color.WHITE);
        Babalik.setBackground(Blue);
        
        

        logIn.setVisible(true);
        Register.setVisible(false);
        
       

        menus.setLayout(null);
        menus.setBackground(Yellow);
        forAccessBut.setLayout(new GridLayout(1,3));
        C.add(menus);
        menus.add(forAccessBut);

        menus.add(boggs);

        for(int x = 0; x < AccessButton.length; x++)
		{
			forAccessBut.add(AccessButton[x]);
			AccessButton[x].addActionListener(this);
			AccessButton[x].setBackground(Blue);
			AccessButton[x].setForeground(Color.WHITE);
			AccessButton[x].setFont(font3);
		}

		

        boggs.setBounds(395,150,565,230);
		forAccessBut.setBounds(285,400,800,50);
		menus.setBounds(0,0,1364,727);
		

        menus.setVisible(false);

		PointOfSales.setLayout(null);
        Foods.setLayout(new GridLayout(2,2));
        numericPanel.setLayout(new GridLayout(5,3));
        menuPanel.setLayout(new GridLayout(2,3));
        C.add(PointOfSales);
        PointOfSales.setBackground(Red);
        Foods.setBackground(Red);
        numericPanel.setBackground(Red);
        menuPanel.setBackground(Red);


        for(int x = 0; x < Foody.length; x++)
		{
			Foods.add(Foody[x]);
			Foody[x].addActionListener(this);
			Foody[x].setBackground(Yellow);
			Foody[x].setForeground(Color.WHITE);
			Foody[x].setFont(font2);
		}


	    p[0].setLayout(new GridLayout(5,2));
	    p[1].setLayout(new GridLayout(5,2));
	    p[2].setLayout(new GridLayout(5,2));
	    p[3].setLayout(new GridLayout(2,3));
	    
	    for(int x = 0; x < p.length; x++)
	    {
	    	p[x].setBackground(Red);
	    }

		for(int x = 0; x < Produkto1.length; x++)
		{
			p[0].add(Produkto1[x]);
			Produkto1[x].addActionListener(this);
			Produkto1[x].setBackground(Yellow);
			Produkto1[x].setForeground(Color.WHITE);
			Produkto1[x].setFont(font3);
		}

		for(int x = 0; x < Produkto2.length; x++)
		{
			p[1].add(Produkto2[x]);
			Produkto2[x].addActionListener(this);
			Produkto2[x].setBackground(Yellow);
			Produkto2[x].setForeground(Color.WHITE);
			Produkto2[x].setFont(font3);
		}

		for(int x = 0; x < Produkto3.length; x++)
		{
			p[2].add(Produkto3[x]);
			Produkto3[x].addActionListener(this);
			Produkto3[x].setBackground(Yellow);
			Produkto3[x].setForeground(Color.WHITE);
			Produkto3[x].setFont(font3);
		}

		for(int x = 0; x < Produkto4.length; x++)
		{
			p[3].add(Produkto4[x]);
			Produkto4[x].addActionListener(this);
			Produkto4[x].setBackground(Yellow);
			Produkto4[x].setForeground(Color.WHITE);
			Produkto4[x].setFont(font3);
		}

	

        for(int x = 0; x < p.length; x++)
		{
		    PointOfSales.add(p[x]);
		}

		for(int x = 0; x < p.length; x++)
		{
	       	p[x].setVisible(false);
		}

		for(int x = 0; x < p.length; x++)
		{
		    p[x].setBounds(0,0,690,321);
		}

		for(int x = 0; x < Pindutan.length; x++)
		{
			numericPanel.add(Pindutan[x]);
			Pindutan[x].addActionListener(this);
			Pindutan[x].setBackground(Blue);
			Pindutan[x].setForeground(Color.WHITE);
			Pindutan[x].setFont(font2);
			Pindutan[x].setEnabled(false);
		}

		for(int x = 0; x < menuButton.length; x++)
		{
			menuPanel.add(menuButton[x]);
			menuButton[x].addActionListener(this);
			menuButton[x].setBackground(Blue);
			menuButton[x].setForeground(Color.WHITE);
			menuButton[x].setFont(font3);
		}


        PointOfSales.add(Foods);
        PointOfSales.add(numericPanel);
        PointOfSales.add(menuPanel);

        scrollPane = new JScrollPane();
        PointOfSales.add(scrollPane);
        summaryField = new JTextArea(20,20);
        PointOfSales.add(summaryField);
        scrollPane.setViewportView(summaryField);
        summaryField.setEditable(false);

        summaryField.append("============================================================================================\n");
    	summaryField.append("\t\t\t    BOGGS GRILL\n");
    	summaryField.append("\t\t  #92 SCOUT CHUATOCO STREET BARANGAY\n \t                        ROXAS DISTRICT QUESZON CITY, PHILLIPINES 1103\n");
  	    summaryField.append("\t\t\t"+dateFormat.format(date));
  	    summaryField.append("\n\t\t\tOFFICIAL RECEIPT");
	    summaryField.append("\n============================================================================================\n");
        summaryField.append("PROD ID.\t               QTY.\t\t     PRODUCT  \t\tPRICE\t               AMOUNT\n");
        summaryField.setForeground(Color.WHITE);
        summaryField.setBackground(Color.BLACK);

        neymLabel = new JLabel("NAME:");
        PointOfSales.add(neymLabel);

        neymField = new JTextField(10);
        PointOfSales.add(neymField);
        neymField.setEditable(false);

        stakLabel = new JLabel("STOCKS:");
        PointOfSales.add(stakLabel);

        stakField = new JTextField(10);
        PointOfSales.add(stakField);
        stakField.setEditable(false);

        orderLabel = new JLabel("ORDER:");
        PointOfSales.add(orderLabel);

        orderField = new JTextField(10);
        PointOfSales.add(orderField);
        orderField.setEnabled(false);
        orderField.setEditable(false);

        totalLabel = new JLabel("TOTAL AMOUNT:");
    	PointOfSales.add(totalLabel);

    	totalField = new JTextField(10);
    	PointOfSales.add(totalField);
    	totalField.setEditable(false);

    	paymentLabel = new JLabel("PAYMENT:");
    	PointOfSales.add(paymentLabel);

    	paymentField = new JTextField(10);
    	PointOfSales.add(paymentField);
    	paymentField.setEnabled(false);
    	paymentField.setEditable(false);

    	changeLabel = new JLabel("CHANGE:");
    	PointOfSales.add(changeLabel);

    	changeField = new JTextField(10);
    	PointOfSales.add(changeField);
    	changeField.setEditable(false);

    	orderLabel.setFont(font2);
        orderField.setFont(font2);
        totalLabel.setFont(font2);
        totalField.setFont(font2);
        paymentLabel.setFont(font2);
        paymentField.setFont(font2);
        changeLabel.setFont(font2);
        changeField.setFont(font2);
        neymLabel.setFont(font1);
        stakLabel.setFont(font1);
        neymField.setFont(font1);
        stakField.setFont(font1);

    	orderField.setForeground(Color.GREEN);
        totalField.setForeground(Color.GREEN);
        paymentField.setForeground(Color.GREEN);
        changeField.setForeground(Color.GREEN);

        orderLabel.setForeground(Color.WHITE);
        totalLabel.setForeground(Color.WHITE);
        paymentLabel.setForeground(Color.WHITE);
        changeLabel.setForeground(Color.WHITE);
        neymLabel.setForeground(Color.WHITE);
        stakLabel.setForeground(Color.WHITE);
        neymField.setForeground(Color.WHITE);
        stakField.setForeground(Color.WHITE);

        orderField.setBackground(Color.BLACK);
        totalField.setBackground(Color.BLACK);
        paymentField.setBackground(Color.BLACK);
        changeField.setBackground(Color.BLACK);
        neymField.setBackground(Color.BLACK);
        stakField.setBackground(Color.BLACK);

        Foods.setBounds(0,0,690,321);
        numericPanel.setBounds(0,320,690,380);
        menuPanel.setBounds(690,585,690,120);
        PointOfSales.setBounds(0,0,1364,727);

        scrollPane.setBounds(691,0,665,270);
        summaryField.setBounds(691,0,665,270);

        neymLabel.setBounds(720,280,100,30);
        neymField.setBounds(780,280,212,30);
        stakLabel.setBounds(1040,280,100,30);
        stakField.setBounds(1110,280,212,30);

        orderLabel.setBounds(695,335,400,30);
        orderField.setBounds(945,322,412,55);
        totalLabel.setBounds(695,400,400,30);
        totalField.setBounds(945,387,412,55);
        paymentLabel.setBounds(695,465,400,30);
        paymentField.setBounds(945,452,412,55);
        changeLabel.setBounds(695,530,400,30);
        changeField.setBounds(945,517,412,55);

        menuButton[0].setEnabled(false);
        menuButton[1].setEnabled(false);
        PointOfSales.setVisible(false);

        openFile();
        readFile();
        closeFile1();
        
        


        inventoryPanel.setLayout(null);
        inventoryPanel.setBackground(Yellow);
        C.add(inventoryPanel);

        inventoryLabel = new JLabel("INVENTORY");
    	inventoryPanel.add(inventoryLabel);

    	scrollPane3 = new JScrollPane();
        inventoryPanel.add(scrollPane3);
        summaryField3 = new JTextArea(20,20);
        inventoryPanel.add(summaryField3);
        scrollPane3.setViewportView(summaryField3);
        summaryField3.setEditable(false);


	    summaryField3.append("============================================================================================\n");
        summaryField3.append("PROD. ID\t    \t\t\tPROD. NAME\t\tBEGINNING BALANCEt\tITEM SOLD\t\tENDING BALANCE\n");
        summaryField3.append("============================================================================================\n");


        writeFile();
        printInventory();
        closeFile2();

        backButton2 = new JButton("BACK");
        inventoryPanel.add(backButton2);
        backButton2.addActionListener(this);


        summaryField3.setForeground(Color.ORANGE);
        summaryField3.setBackground(Color.BLACK);
        inventoryLabel.setForeground(Color.GREEN);

        backButton2.setForeground(Color.WHITE);
        backButton2.setBackground(Blue);

    	inventoryLabel.setFont(font2);
    	backButton2.setFont(font3);

        inventoryPanel.setBounds(0,0,1364,727);
    	inventoryLabel.setBounds(580,15,400,30);
    	scrollPane3.setBounds(165,50,1065,550);
    	summaryField3.setBounds(165,50,1065,550);
    	backButton2.setBounds(1120,610,230,80);
    	inventoryPanel.setVisible(false);

        salesPanel8.setLayout(null);
        salesPanel8.setBackground(Yellow);
        C.add(salesPanel8);

        salesLabel8 = new JLabel("SALES REPORT");
    	salesPanel8.add(salesLabel8);

    	scrollPane8 = new JScrollPane();
        salesPanel8.add(scrollPane8);
        summaryField8 = new JTextArea(20,20);
        salesPanel8.add(summaryField8);
        scrollPane8.setViewportView(summaryField8);
        summaryField8.setEditable(false);

	    summaryField8.setText("====================================================================================================\nPROD. ID\t    \t\t\tPROD. NAME\t\t\tPRICE\t                   ITEM SOLD\t               SALES\n=====================================================================================================================================================\n");
        printSalesReport();

        grossLabel8 = new JLabel("TOTAL SALES:");
    	salesPanel8.add(grossLabel8);

    	grossField8 = new JTextField(""+String.valueOf(totalSales));
    	salesPanel8.add(grossField8);
    	grossField8.setEditable(false);

    	totalSales();

        backButton8 = new JButton("BACK");
        salesPanel8.add(backButton8);
        backButton8.addActionListener(this);
       
        print = new JButton("PRINT ITEMS");
        salesPanel8.add(print);
        print.addActionListener(this);
        
        print1 = new JButton("PRINT SALES");
        salesPanel8.add(print1);
        print1.addActionListener(this);
        
        resetsales = new JButton("RESET");
        salesPanel8.add(resetsales);
        resetsales.addActionListener(this);



        summaryField8.setForeground(Color.ORANGE);
        summaryField8.setBackground(Color.BLACK);
        salesLabel8.setForeground(Color.GREEN);
        grossLabel8.setForeground(Color.GREEN);;

        grossField8.setBackground(Color.BLACK);
        grossField8.setForeground(Color.GREEN);

        backButton8.setForeground(Color.WHITE);
        backButton8.setBackground(Blue);
        
        print.setForeground(Color.WHITE);
        print.setBackground(Blue);
        
        print1.setForeground(Color.WHITE);
        print1.setBackground(Blue);
        
        resetsales.setForeground(Color.WHITE);
        resetsales.setBackground(Blue);

    	salesLabel8.setFont(font2);
    	backButton8.setFont(font3);
    	print.setFont(font3);
    	print1.setFont(font3);
    	resetsales.setFont(font3);
    	grossLabel8.setFont(font2);
        grossField8.setFont(font2);

        salesPanel8.setBounds(0,0,1364,727);
    	salesLabel8.setBounds(580,15,400,30);
    	scrollPane8.setBounds(420,50,510,550);
    	summaryField8.setBounds(420,50,510,550);
    	backButton8.setBounds(1120,610,230,80);
    	print.setBounds(1120,510,230,80);
    	print1.setBounds(1120,410,230,80);
    	resetsales.setBounds(800,610,260,80);
    	grossLabel8.setBounds(165,637,400,30);
        grossField8.setBounds(415,620,155,55);
        backButton2.setBounds(1120,610,230,80);
    	salesPanel8.setVisible(false);

        C.add(adminPanel);
        adminPanel.setLayout(null);
        adminPanel.setBackground(Yellow);

        productScroll = new JScrollPane();
        adminPanel.add(productScroll);
        productList = new JTextArea();
        adminPanel.add(productList);
        productScroll.setViewportView(productList);
        productList.setEditable(false);

        printAdmin();

        optionsPanel.setLayout(new GridLayout (1,3));
        adminPanel.add(optionsPanel);

        productList.setBackground(Color.BLACK);
        productList.setForeground(Color.GREEN);

        beckButton = new JButton("BACK");
        adminPanel.add(beckButton);
        beckButton.addActionListener(this);
        
        ReStock = new JButton("RE-STOCK");
        adminPanel.add(ReStock);
        ReStock.addActionListener(this);

        beckButton.setForeground(Color.WHITE);
        beckButton.setBackground(Blue);
        beckButton.setFont(font3);
        
        ReStock.setForeground(Color.WHITE);
        ReStock.setBackground(Blue);
        ReStock.setFont(font3);
        
   


        for(int x=0; x<options.length; x++)
        {
        	optionsPanel.add(options[x]);
        	options[x].setBackground(Blue);
            options[x].setForeground(Color.WHITE);
            options[x].addActionListener(this);
            options[x].setFont(font1);

        }

        logo2 = new JLabel();
		adminPanel.add(logo2);

	    logo2.setIcon(new ImageIcon(getClass().getResource("32.jpg")));

        nameLabel = new JLabel("NAME:");
        adminPanel.add(nameLabel);

        stockLabel = new JLabel("STOCK:");
        adminPanel.add(stockLabel);

        priceLabel = new JLabel("PRICE:");
        adminPanel.add(priceLabel);

        nameField = new JTextField();
        adminPanel.add(nameField);

        stockField = new JTextField();
        adminPanel.add(stockField);

        priceField = new JTextField();
        adminPanel.add(priceField);

        okButton = new JButton("OK");
        adminPanel.add(okButton);
        okButton.addActionListener(this);
        
        alis = new JButton("ACCOUNTS");
        adminPanel.add(alis);
        alis.addActionListener(this);

        nameLabel.setFont(font2);
        stockLabel.setFont(font2);
        priceLabel.setFont(font2);

        nameField.setFont(font2);
        stockField.setFont(font2);
        priceField.setFont(font2);
        okButton.setFont(font2);
        alis.setFont(font3);
        

        nameLabel.setForeground(Color.WHITE);
        stockLabel.setForeground(Color.WHITE);
        priceLabel.setForeground(Color.WHITE);
        nameField.setForeground(Color.WHITE);
        stockField.setForeground(Color.WHITE);
        priceField.setForeground(Color.WHITE);
        okButton.setForeground(Color.WHITE);
        alis.setForeground(Color.WHITE);
        

        nameField.setBackground(Color.black);
        stockField.setBackground(Color.black);
        priceField.setBackground(Color.black);
        okButton.setBackground(Blue);
        alis.setBackground(Blue);



        productScroll.setBounds(35,35,500,500);
        productList.setBounds(35,35,500,500);
        optionsPanel.setBounds(35,550,500,100);

        nameLabel.setBounds(695,335,400,30);
        beckButton.setBounds(1120,610,230,80);
        ReStock.setBounds(830,610,260,80);
        alis.setBounds(560,610,260,80);
        nameField.setBounds(845,322,412,55);
        stockLabel.setBounds(695,400,400,30);
        stockField.setBounds(845,387,412,55);
        priceLabel.setBounds(695,465,400,30);
        priceField.setBounds(845,452,412,55);
        okButton.setBounds(845,530,412,55);
        
        
        logo2.setBounds(880,60,225,225);
        
        C.add(AccountsList);
        AccountsList.setLayout(null);
        AccountsList.setBackground(Yellow);
        
        babaan = new JScrollPane();
        AccountsList.add(babaan);
        Listahan = new JTextArea();
        AccountsList.add(Listahan);
        babaan.setViewportView(Listahan);
        Listahan.setEditable(false);


        adminPanel.setBounds(0,0,1364,727);
        options[3].setEnabled(false);
        adminPanel.setVisible(false);
        setButtons();
        
        tagabukas();
        tagabasa();
        tagasara1();


        AccountsList.setLayout(null);
        AccountsList.setBackground(Red);
        C.add(AccountsList);

        AllAcounts = new JLabel("ALL ACCOUNTS");
    	AccountsList.add(AllAcounts);

    	babaan = new JScrollPane();
        AccountsList.add(babaan);
        Listahan = new JTextArea(20,20);
        AccountsList.add(Listahan);
        babaan.setViewportView(Listahan);
        Listahan.setEditable(false);
        
        Listahan.append("============================================================================================\n");
        Listahan.append("ID. NO\t    \t\t\tFULL NAME\t\tUSERNAME\t\tPASSWORD\n");
        Listahan.append("============================================================================================\n");
        
        tagasulat();
        printingAccount();
        tagasara2();
        
        accounts = new JButton("BACK");
        AccountsList.add(accounts);
        accounts.addActionListener(this);
        
        delete = new JButton("DELETE");
        AccountsList.add(delete);
		delete.addActionListener(this);
        	
        
        accounts.setForeground(Color.WHITE);
        accounts.setBackground(Blue);
        
        delete.setForeground(Color.WHITE);
        delete.setBackground(Blue);
        
        
        Listahan.setForeground(Color.ORANGE);
        Listahan.setBackground(Color.BLACK);
        AllAcounts.setForeground(Color.GREEN);
        
        AllAcounts.setFont(font2);
    	accounts.setFont(font3);
    	
    	AccountsList.setBounds(0,0,1364,727);
    	AllAcounts.setBounds(580,15,400,30);
    	babaan.setBounds(165,50,1065,550);
    	Listahan.setBounds(165,50,1065,550);
    	accounts.setBounds(1120,610,230,80);
    	delete.setBounds(860,610,230,80);
    	AccountsList.setVisible(false);


		setTitle("BOGGS GRILL - P.O.S BETA");
		setSize(1364,727);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==JB2){
			Register.setVisible(true);
			logIn.setVisible(false);
			
		}	
		
		if(e.getSource()==Babalik){
			Register.setVisible(false);
			logIn.setVisible(true);
			UserMo.setText(null);
			PasswordMo.setText(null);
			Pangalan.setText(null);
				
		}
		


        if(e.getSource()==beckButton)
	    {
	    	
	    	menus.setVisible(true);
            adminPanel.setVisible(false);
            nameField.setText("");
        	stockField.setText("");
        	priceField.setText("");
	    	options[0].setEnabled(true);
	    	options[1].setEnabled(true);
	    	options[2].setEnabled(true);
	    	options[3].setEnabled(false);


	    }
	    
	    if(e.getSource()==alis){
			AccountsList.setVisible(true);
			adminPanel.setVisible(false);
			
		}
		
		if(e.getSource()==accounts){
			AccountsList.setVisible(false);
			adminPanel.setVisible(true);
		}	
			
		if(e.getSource()==delete)
	    {

	    	pidmo = JOptionPane.showInputDialog(null,"Enter I.D No.:");
	    	 for(int x=0; x < IdNo.length; x++)
                    {
                    	if(pidmo.equals(IdNo[x]))
        	            {

        	            	tagasulat();
        	            	IdNo[x]="";
        	            	user[x]="";
        	            	pass[x]="";
        	            	fullname[x]="";
        	                printingAccount();
        	                tagasara2();
        	                
        	            }
                    }

                    
                    
                 JOptionPane.showMessageDialog(null, "ACCOUNT DELETED!!", "DELETE", JOptionPane.INFORMATION_MESSAGE);


	    }

	    
	    
	    if(e.getSource()==ReStock)
	    {
	    	
            JPasswordField pf = new JPasswordField();
            String pass1;
	    	int passs1;
            passs1 = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);


            pass1 = new String(pf.getPassword());
            
            if (passs1 == JOptionPane.OK_OPTION)
            {
	    	if(pass1.equals("BOGGSGRILL")|| pass1.equals("boggsgrill"))
	    	{
	    	JOptionPane.showMessageDialog(null, "PLEASE RESTART SYSTEM", "NEED RESTART TO APPLY", JOptionPane.INFORMATION_MESSAGE);
	    	writeFile();

	    	for(int x=0; x < prodId.length; x++)
             {
	    		
	    		prodStockss[x]="100";
	    		newStocks2s[x]="100";
	    		
        		
             }
             

        	printInventory();
			printAdmin();printSalesReport();
			closeFile2();
			
	    }
            
            else
        	{
        		JOptionPane.showMessageDialog(null, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
        	}
            }
	    }
	    
	
	    
	    if(e.getSource()==RegisterDong)
	    {
	    	JPasswordField pf = new JPasswordField();
            String pass1;
	    	int passs1;
            passs1 = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);


            pass1 = new String(pf.getPassword());
            
            if (passs1 == JOptionPane.OK_OPTION)
            {
	    	if(pass1.equals("BOGGSGRILL")|| pass1.equals("boggsgrill"))
	    	{

                           tagasulat();
                           printingAccount();
                            

                            numerouno++;
                            String NumeroUno ="0"+numerouno;

                            String pangulo = Pangalan.getText();
        	                String balaka = UserMo.getText();
        	                String passo = new String(PasswordMo.getPassword());

        	                String fullname1= pangulo;
        	                String user1 = balaka;
        	                String passc1 = passo;

        	                IdNo[numerouno-1]= NumeroUno;
        	                fullname[numerouno-1]= fullname1; 
        	                user[numerouno-1]= user1;    
        	                pass[numerouno-1]= passc1;

        	                String sulattt = IdNo[numerouno-1] + "\t" + user[numerouno-1] + "\t" + pass[numerouno-1] + "\t" + fullname[numerouno-1] ;
        	                Listahan.append(""+IdNo[numerouno-1]+"\t    \t\t\t"+user[numerouno-1]+"\t\t"+pass[numerouno-1]+"\t\t"+fullname[numerouno-1]+"\n");
        	                
                            sulat.println(sulattt);

        	                tagasara2();

        	                JOptionPane.showMessageDialog(null, "SUCCESSFULLY CREATED!!", "CREATE ACCOUNT!", JOptionPane.INFORMATION_MESSAGE);
        	                JOptionPane.showMessageDialog(null, "GOTO MASTER CONTROL TO SEE ALL ACCOUNTS!!", "ACCOUNTS!", JOptionPane.INFORMATION_MESSAGE);
        	                
        	                Pangalan.setText("");
        	                UserMo.setText("");
        	                PasswordMo.setText("");               
        	                	
	    	}
	    	
        	else
        	{
        		JOptionPane.showMessageDialog(null, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
        		Pangalan.setText("");
        	    UserMo.setText("");
        	    PasswordMo.setText("");
        	}
        	

	    	}
            }
	    
	    
	
	    	

	    if(e.getSource()==AccessButton[3])
	    {
	    	

            JPasswordField pf = new JPasswordField();
            String pass1;
	    	int passs1;
            passs1 = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);


            pass1 = new String(pf.getPassword());
			for(int j=0; j < pass.length; j++)
			{

            if (passs1 == JOptionPane.OK_OPTION)
            {
	    	if(pass1.equals(pass[j])|| pass1.equals("boggsgrill"))
	    	{
	    			JOptionPane.showMessageDialog(null, "SUCESFULLY LOGIN", "LOGIN SUCCESFUL", JOptionPane.INFORMATION_MESSAGE);
	    	        menus.setVisible(false);
                    adminPanel.setVisible(true);
                    break;
                    
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		break;
	    	}

	    	
            }
			}
				
        		



	    }

	    if(e.getSource()==options[0])
	    {
	    	
	    	options[1].setEnabled(false);
	    	options[2].setEnabled(false);
	    	options[3].setEnabled(true);

	    }

	    if(e.getSource()==options[1])
	    {
	    	
	    	options[0].setEnabled(false);
	    	options[2].setEnabled(false);
	    	options[3].setEnabled(true);

                   pidmo = JOptionPane.showInputDialog(null,"Enter Product I.D.:");


                    for(int x=0; x < prodId.length; x++)
                    {
                    	if(pidmo.equals(prodId[x]))
        	            {
        	            	nameField.setText(""+prodName[x]);
        	            	stockField.setText(""+newStocks2s[x]);
        	            	priceField.setText(""+prodPrices[x]);

        	            }
                    }
	    }


	    if(e.getSource()==options[2])
	    {
	    	

	    	pidmo = JOptionPane.showInputDialog(null,"Enter Product I.D.:");
	    
	    for(int x = 0; x <=3; x++)
		{
			if(pidmo.equals(prodId[x]))
			{
				Produkto1[x].setVisible(false);
			}

		}


		for(int x = 0; x <=3; x++)
		{
			if(pidmo.equals(prodId[x+10]))
			{Produkto2[x].setVisible(false);}
			
		}

		for(int x =0; x <=4; x++)
		{
			if(pidmo.equals(prodId[x+20]))
			Produkto3[x].setVisible(false);
			
		}

		for(int x = 0; x <=3; x++)
		{
			if(pidmo.equals(prodId[x+30]))
			Produkto4[x].setVisible(false);
			
		}

	


                    for(int x=0; x < prodId.length; x++)
                    {
                    	if(pidmo.equals(prodId[x]))
        	            {

        	            	writeFile();
        	            	prodId[x]="";
        	            	prodName[x]="";
        	            	prodPrices[x]="";
        	            	newStocks2s[x]="";
        	            	prodStockss[x]="";
        	            	prodSaless[x]="";
        	            	itemSolds[x]="";

        	            	printInventory();

        	            	closeFile2();
        	                printAdmin();printSalesReport();
        	            }
                    }
                 JOptionPane.showMessageDialog(null, "ITEM DELETED!!", "DELETE", JOptionPane.INFORMATION_MESSAGE);


	    }

	    if(e.getSource()==options[3])
	    {
	    	
	    	 nameField.setText("");
        	stockField.setText("");
        	priceField.setText("");
	    	options[0].setEnabled(true);
	    	options[1].setEnabled(true);
	    	options[2].setEnabled(true);
	    	options[3].setEnabled(false);

	    }


	    if(e.getSource()==okButton)
	    {
	    	


	    	if(options[0].isEnabled())
	    	{
                            printAdmin();printSalesReport();
                            writeFile();
                            printInventory();

                            beks++;
                            String bekss ="0"+beks;

                            String neym = nameField.getText();
        	                int stack = Integer.parseInt(stockField.getText());
        	                int prays = Integer.parseInt(priceField.getText());

        	                String newNeym =neym;
        	                int newStack= stack;
        	                int newPrays =prays;

        	                prodId[beks-1]=bekss;
        	                prodName[beks-1]=newNeym;
        	                prodPrice[beks-1]=newPrays;
        	                prodPrices[beks-1]=""+prodPrice[beks-1];
        	                prodStocks[beks-1]=newStack;
        	                prodStockss[beks-1]=""+prodStocks[beks-1];
        	                itemSold[beks-1]=0;
        	                itemSolds[beks-1]=""+itemSold[beks-1];
        	                newStocks2[beks-1]=newStack;
        	                newStocks2s[beks-1]=""+newStocks2[beks-1];
        	                prodSales[beks-1]=0;
        	                prodSaless[beks-1]=""+prodSales[beks-1];

        	                String itemLineerr = prodId[beks-1] + "\t" + prodName[beks-1] + "\t" + prodPrice[beks-1] + "\t" + prodStocks[beks-1] + "\t" +itemSold[beks-1]+ "\t" + newStocks2[beks-1]+ "\t" +prodSales[beks-1];
        	                String itemliness  =""+prodId[beks-1]+"\t"+prodName[beks-1]+"\t"+newStocks2[beks-1]+"\t"+ prodPrice[beks-1]+"\n";

                            productList.append(""+itemliness);
                            summaryField3.append(""+prodId[beks-1]+"\t    \t\t\t"+prodName[beks-1]+"\t\t"+prodStocks[beks-1]+"\t\t"+itemSold[beks-1]+"\t\t"+newStocks2[beks-1]+"\n");
                            summaryField8.append(""+prodId[beks-1]+"\t    \t\t\t"+prodName[beks-1]+"\t\t"+prodPrice[beks-1]+"\t\t"+itemSold[beks-1]+"\t\t"+prodSales[beks-1]+"\n");
                            wrfile.println(itemLineerr);

        	                closeFile2();

        	                JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED!!", "ADD ITEM!", JOptionPane.INFORMATION_MESSAGE);

	    	}



            if(options[1].isEnabled())
            {

                    for(int x=0; x < prodId.length; x++)
                    {
                    	if(pidmo.equals(prodId[x]))
        	            {
        	            	writeFile();

        	                String neym = nameField.getText();
        	                int stack = Integer.parseInt(stockField.getText());
        	                int prays = Integer.parseInt(priceField.getText());
                            prodName[x]=neym;
                            newStocks2[x]=stack;
                            prodPrice[x]=prays;
                            newStocks2s[x]=""+newStocks2[x];
                            prodPrices[x]=""+prodPrice[x];
                            printInventory();printAdmin();printSalesReport();
                            closeFile2();
        	            }
                    }
                 setButtons();
                 JOptionPane.showMessageDialog(null, "SUCCESSFULLY EDITED!!", "EDIT!", JOptionPane.INFORMATION_MESSAGE);

            }

	    	nameField.setText("");
        	stockField.setText("");
        	priceField.setText("");
	    	options[0].setEnabled(true);
	    	options[1].setEnabled(true);
	    	options[2].setEnabled(true);
	    	options[3].setEnabled(false);

	    }



		if(e.getSource()==JB1||e.getSource()==JP1)
	    {
	    	
           String Id = JT2.getText();
           String password = new String(JP1.getPassword());
    	   String username = JT1.getText();
    		String filepath = "userlist.txt";
    		String admin ="Admin";
    		Login(Id,username,password,filepath, admin); 
	    }
	    

	    if(e.getSource()==backButton8)
	    {
	    	
         	menus.setVisible(true);
            salesPanel8.setVisible(false);
            PointOfSales.setVisible(false);
	    	inventoryPanel.setVisible(false);
	  
                    	


	    
	    }
	    
	    if(e.getSource()==resetsales)
	    {
	    JPasswordField pf = new JPasswordField();
            String pass1;
	    	int passs1;
            passs1 = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);


            pass1 = new String(pf.getPassword());
            
            if (passs1 == JOptionPane.OK_OPTION)
            {
	    	if(pass1.equals("BOGGSGRILL")|| pass1.equals("boggsgrill"))
	    	{
	    	JOptionPane.showMessageDialog(null, "PLEASE RESTART SYSTEM", "NEED RESTART TO APPLY", JOptionPane.INFORMATION_MESSAGE);
	    	writeFile();
	    	totalSales();
	    	for(int x=0; x < prodId.length; x++)
             {
	    		prodSaless[x]="0.0";
        		itemSolds[x]="0";
             }
             
            grossField8.setText(""+String.valueOf(totalSales*0));
        	
        	printInventory();
			closeFile2();
			printAdmin();printSalesReport();

	    
	    }
	     	else
        	{
        		JOptionPane.showMessageDialog(null, "WRONG PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
        	}
            }
	    }
	    

         if(e.getSource()==AccessButton[0])
         {
         	
         	menus.setVisible(false);
            PointOfSales.setVisible(true);
         }

         if(e.getSource()==AccessButton[1])
         {
         	
         	menus.setVisible(false);
            inventoryPanel.setVisible(true);

         }

         if(e.getSource()==AccessButton[2])
         {
         	
         	menus.setVisible(false);
            salesPanel8.setVisible(true);

         }


	    if(e.getSource()==menuButton[0])
	    {
	    	
	    	clear();
	    	

	    }

	    if(e.getSource()==menuButton[1])
	    {
	    	

	    	JPasswordField pf = new JPasswordField();
            String pass1;
	    	int passs1;
            passs1 = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);


            pass1 = new String(pf.getPassword());
            
            if (passs1 == JOptionPane.OK_OPTION)
            {
	    	if(pass1.equals("password")|| pass1.equals("PASSWORD"))
	    	{
	    	Pindutan[14].setEnabled(false);

	    	for(int x =0; x < prodId.length; x++)
	    	{
	    	    	newStocks2[x]=newStocks2[x]+Norder[x];
	    	    	itemSold[x]=itemSold[x]-Norder[x];
	    	    	prodSales[x] =prodSales[x] - newtimes[x];
					prodSaless[x]=""+prodSales[x];
	    	    	newStocks2s[x]=""+newStocks2[x];
	    	    	itemSolds[x]=""+itemSold[x];


	    	}
	    	clear();
	    	writeFile();
	    	printInventory();
	    	closeFile2();
	    	printAdmin();
	    	printSalesReport();
	    	}


	    	else
            {
            	
                JOptionPane.showMessageDialog(null, "INVALID PASSWORD", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            }
	    }
	    
	    
	    String receipt1;
	    if(e.getSource()==menuButton[2])
	    {
	    try{
	    receipt1 = summaryField.getText();
	   if(receipt1.equals(""))
	   {
	   	JOptionPane.showMessageDialog(null, "Please Order First");
	   }
	   else{
	   	boolean ppt = summaryField.print();
	   
	   
	   if(ppt)
	   {
	   	JOptionPane.showMessageDialog(null, "Done");
	   }
	   else{
	   	JOptionPane.showMessageDialog(null, "Printing");
	   }
	   
	    
	    	}
	    }
	    
	   catch(Exception O)
	   {
	   	JOptionPane.showMessageDialog(null,O);
	   }
	    }
	    
	     String receipt2;
	    if(e.getSource()==print)
	    {
	    try{
	    receipt2 = summaryField8.getText();
	   if(receipt2.equals(""))
	   {
	   	JOptionPane.showMessageDialog(null, "Please Order First");
	   }
	   else{
	   	boolean ppf = summaryField8.print();
	   
	   
	   if(ppf)
	   {
	   	JOptionPane.showMessageDialog(null, "Done");
	   }
	   else{
	   	JOptionPane.showMessageDialog(null, "Printing");
	   }
	   
	    
	    	}
	    }
	    
	   catch(Exception i)
	   {
	   	JOptionPane.showMessageDialog(null,i);
	   }
	    }
	    
	     String receipt3;
	    if(e.getSource()==print1)
	    {
	    try{
	    receipt3 = grossField8.getText();
	   if(receipt3.equals(""))
	   {
	   	JOptionPane.showMessageDialog(null, "Please Order First");
	   }
	   else{
	   	boolean ppi = grossField8.print();
	   
	   
	   if(ppi)
	   {
	   	JOptionPane.showMessageDialog(null, "Done");
	   }
	   else{
	   	JOptionPane.showMessageDialog(null, "Printing");
	   }
	   
	    
	    	}
	    }
	    
	   catch(Exception p)
	   {
	   	JOptionPane.showMessageDialog(null,p);
	   }
	    }
	   


	   

	    if(e.getSource()==menuButton[3])
	    {
	    	
	    	menus.setVisible(true);
            PointOfSales.setVisible(false);


	    }

	    if(e.getSource()==Pindutan[14])
	    {
	    	
	    	for(int x =0; x < Pindutan.length; x++)
	    	{
	    		Pindutan[x].setEnabled(true);
	    	}

	    	for(int x =0; x <Foody.length; x++)
	    	{
	    		Foody[x].setEnabled(true);
	    	}

	    	menuButton[0].setEnabled(false);
	    	menuButton[1].setEnabled(true);
        	paymentField.setEnabled(true);
	    }

	    if(e.getSource()==Pindutan[13])
	    {
	    	
	    	for(int x = 0; x < p.length; x++)
		    {
	        	p[x].setVisible(false);
	     	}

	     	for(int y = 0; y < Pindutan.length; y++)
	    	{
	    	    Pindutan[y].setEnabled(false);
	    	}

	    	enabledProd();

	    	if(orderField.isEnabled())
			{
				orderField.setText("");

			}

			else if(paymentField.isEnabled())
			{
				paymentField.setText("");
			}

			if(total!=0)
			{
				Pindutan[14].setEnabled(true);
				menuButton[1].setEnabled(true);
			}

            neymField.setText("");
	        stakField.setText("");
	     	Foods.setVisible(true);
	     	Pindutan[13].setEnabled(false);
	    }

	    if(e.getSource()==Pindutan[12])
	    {
	    


	    	if(orderField.isEnabled())
			{
				orderField.setEnabled(false);
				for(int y=0; y < prodId.length; y++)
				{
					newStocks[y]=prodStocks[y];
				    if(id==prodId[y])
					{
						order = Integer.parseInt(orderField.getText());

						if(order<=newStocks2[y])
						{
							Norder[y]=order;
							itemSold[y]=itemSold[y]+order;
							itemSolds[y]=""+itemSold[y];
							newStocks2[y] = newStocks2[y]-order;
							newStocks2s[y]= ""+newStocks2[y];
							orderObject order1 =  new orderObject(order,prodPrice[y]); 
							newtimes[y]=newtimes[y]+order1.order();
							prodSales[y] =prodSales[y] + newtimes[y];
							prodSaless[y]=""+prodSales[y];
							summaryField.append(""+prodId[y]+"\t               "+order+"\t\t      "+prodName[y]+"  \t"+prodPrice[y]+"\t               "+order1.order()+"\n");
						    orderField.setText("");
						}

						if(order>newStocks[y])
			            {
							
							orderField.setText("");
							JOptionPane.showMessageDialog(null, "INSUFFICIENT STOCK","INSUFFICIENT STOCK",JOptionPane.WARNING_MESSAGE);
			            }

			            if(newStocks2[y]==0)
			            {
							
      						JOptionPane.showMessageDialog(null, "0 STOCKS LEFT!","OUT OF STOCK!!!",JOptionPane.WARNING_MESSAGE);
			            }

					}

				}
                total = newtimes[0]+newtimes[1]+newtimes[2]+newtimes[3]+newtimes[4]+newtimes[5]+newtimes[6]+newtimes[7]+newtimes[8]+newtimes[9]+newtimes[10]+newtimes[11]+newtimes[12]+newtimes[13]+newtimes[14]+newtimes[15]+newtimes[16]+newtimes[17]+newtimes[18]+newtimes[19]+newtimes[20]+newtimes[21]+newtimes[22]+newtimes[23]+newtimes[24]+newtimes[25]+newtimes[26]+newtimes[27]+newtimes[28]+newtimes[29]+newtimes[30]+newtimes[31]+newtimes[32]+newtimes[33]+newtimes[34];
        	    totalField.setText(String.valueOf(total));
				orderField.setText("");
				writeFile();
				printInventory();
				printSalesReport();
				printAdmin();
				closeFile2();

			}

			for(int x = 0; x < p.length; x++)
		    {
	        	p[x].setVisible(false);
	     	}

	    	for(int x = 0; x < Pindutan.length; x++)
	    	{
	    	    Pindutan[x].setEnabled(false);
	    	}


            if(total>0)
            {
              Pindutan[14].setEnabled(true);
            }

	     	menuButton[1].setEnabled(true);
	    	enabledProd();
            Foods.setVisible(true);

			if(paymentField.isEnabled())
			{
				payment = Double.parseDouble(paymentField.getText());


            	if(payment<total)
				{
					
					JOptionPane.showMessageDialog(null, "INSUFFICIENT CASH!!!","HEY!", JOptionPane.ERROR_MESSAGE);
					paymentField.setText("");
				}

				else
				{
					
			  		orderField.setEnabled(false);

			  		for(int x =0; x < Pindutan.length; x++)
			  		{
			  			Pindutan[x].setEnabled(false);
			  		}

			  		for(int x =0; x < Foody.length; x++)
			  		{
			  			Foody[x].setEnabled(false);
			  		}


			  		paymentObject p =  new paymentObject(payment,total); 

			  		changeField.setText(String.valueOf(p));

			  		summaryField.append("\n============================================================================================");
		      		summaryField.append("\nTOTAL: P "+total);
		      		summaryField.append("\n============================================================================================\n");
		      		summaryField.append("CASH: P "+payment+"\nCHANGE: P "+(p));
		      		menuButton[0].setEnabled(true);
		      		Pindutan[14].setEnabled(false);
				}



				totalSales();
			}

            neymField.setText("");
	        stakField.setText("");


	    }

	    if(e.getSource()==Pindutan[11])
	    {
	    	
			if(orderField.isEnabled())
			{
				orderField.setText("");

			}

			else if(paymentField.isEnabled())
			{
				paymentField.setText("");
			}
	    }

	    if(e.getSource()==backButton2)
	    {
	    	
	    	PointOfSales.setVisible(false);
	    	inventoryPanel.setVisible(false);
	    	menus.setVisible(true);

	    }





	    for(int x = 0; x < Foody.length; x++)
	    {
	    	if(e.getSource()==Foody[x])
	    	{
	    		
	    		Pindutan[13].setEnabled(true);
	    		Foods.setVisible(false);
	    		p[x].setVisible(true);
        	}
	    }

	    for(int x = 0; x < Produkto1.length; x++)
	    {
	    	if(e.getSource()==Produkto1[x])
	    	{
	    		
	    		
	    		id=prodId[x];
	    		orderField.setEnabled(true);
	    		paymentField.setEnabled(false);
	    		for(int a = 0; a < Produkto1.length; a++)
	    		{
	    		if(x==a)
	    		{
	    			for(int y = 0; y < Produkto1.length; y++)
	    			{
	    			    Produkto1[y].setEnabled(false);
	    			}
	    			Produkto1[x].setEnabled(true);
	    			neymField.setText(prodName[x]);
	    			stakField.setText(""+newStocks2s[x]);
	    		}
	    		}

	    		for(int z = 0; z <= 13; z++)
	    		{
	    			Pindutan[z].setEnabled(true);
	    		}
	    	}
	    }

	    for(int x = 0; x < Produkto2.length; x++)
	    {
	    	if(e.getSource()==Produkto2[x])
	    	{
	    		

                id=prodId[x+10];

	    		orderField.setEnabled(true);
	    		paymentField.setEnabled(false);

	    	    for(int a = 0; a < Produkto2.length; a++)
	    		{
	    		if(x==a)
	    		{
	    			for(int y = 0; y < Produkto2.length; y++)
	    			{
	    			    Produkto2[y].setEnabled(false);
	    			}
	    			Produkto2[x].setEnabled(true);
	    			neymField.setText(prodName[x+10]);
	    			stakField.setText(""+newStocks2s[x+10]);

	    		}
	    		}

	    		for(int z = 0; z <= 13; z++)
	    		{
	    			Pindutan[z].setEnabled(true);
	    		}
	    	}
	    }

	    for(int x = 0; x < Produkto3.length; x++)
	    {
	    	if(e.getSource()==Produkto3[x])
	    	{
	    		
	    		id=prodId[x+20];
	    		orderField.setEnabled(true);
	    		paymentField.setEnabled(false);

	    	    for(int a = 0; a < Produkto3.length; a++)
	    		{
	    		if(x==a)
	    		{
	    			for(int y = 0; y < Produkto3.length; y++)
	    			{
	    			    Produkto3[y].setEnabled(false);
	    			}
	    			Produkto3[x].setEnabled(true);
	    			neymField.setText(prodName[x+20]);
	    			stakField.setText(""+newStocks2s[x+20]);
	    		}
	    		}


	    		for(int z = 0; z <= 13; z++)
	    		{
	    			Pindutan[z].setEnabled(true);
	    		}
	    	}
	    }

	    for(int x = 0; x < Produkto4.length; x++)
	    {
	    	if(e.getSource()==Produkto4[x])
	    	{
	    		
	    		id=prodId[x+30];
	    		orderField.setEnabled(true);
	    		paymentField.setEnabled(false);

	    		for(int a = 0; a < Produkto4.length; a++)
	    		{
	    		if(x==a)
	    		{
	    			for(int y = 0; y < Produkto4.length; y++)
	    			{
	    			    Produkto4[y].setEnabled(false);
	    			}
	    			Produkto4[x].setEnabled(true);
	    			neymField.setText(prodName[x+30]);
	    			stakField.setText(""+newStocks2s[x+30]);
	    		}
	    		}

	    		for(int z = 0; z <= 13; z++)
	    		{
	    			Pindutan[z].setEnabled(true);
	    		}
	    	}
	    }


	    for(int x = 0; x <=10; x++)
	    {
	    	if(e.getSource()==Pindutan[x])
	    	{
	    		
	    		if(orderField.isEnabled())
		     	{
				    orderField.setText(orderField.getText()+numero[x]);
			    }

			    else if(paymentField.isEnabled())
			    {
				    paymentField.setText(paymentField.getText()+numero[x]);
			    }
	    	}
	    }



	}



	public void enabledProd()
	{
		for(int z= 0; z < Produkto1.length; z++)
	    	{
	    		Produkto1[z].setEnabled(true);
	    	}

	    	for(int z= 0; z < Produkto2.length; z++)
	    	{
	    		Produkto2[z].setEnabled(true);
	    	}

	    	for(int z= 0; z < Produkto3.length; z++)
	    	{
	    		Produkto3[z].setEnabled(true);
	    	}

	    	for(int z= 0; z < Produkto4.length; z++)
	    	{
	    		Produkto4[z].setEnabled(true);
	    	}

	    
	}

    public void clear()
    {

            for(int x=0; x < Foody.length; x++)
            {
            	Foody[x].setEnabled(true);
            }
        	orderField.setEnabled(false);
        	paymentField.setEnabled(false);
        	Pindutan[12].setEnabled(false);
        	menuButton[1].setEnabled(false);
        	menuButton[0].setEnabled(false);

        	summaryField.setText("============================================================================================\n\t\t\t    BOGGS GRILL\n\t\t  #92 SCOUT CHUATOCO STREET BARANGAY\n \t                        ROXAS DISTRICT QUESZON CITY, PHILLIPINES 1103\n\t\t\t"+dateFormat.format(date)+"\n\t\t\tOFFICIAL RECEIPT\n============================================================================================\nPROD ID.\t               QTY.\t\t     PRODUCT  \t\tPRICE\t               AMOUNT\n");

            for(int x=0; x < prodId.length; x++)
            {
            	newtimes[x]=newtimes[x]*0;
            }

            total=total*0;
            sum=sum*0;

            orderField.setText("");
            totalField.setText("");
			changeField.setText("");
			paymentField.setText("");
    }

    public void setButtons()
    {
                 Produkto1[0].setText("PORK BBQ - PHP "+prodPrice[0]);
                 Produkto1[1].setText("CHICKEN BBQ - PHP "+prodPrice[1]);
                 Produkto1[2].setText("ISAW CHIX - PHP "+prodPrice[2]);
                 Produkto1[3].setText("ISAW PORK - PHP "+prodPrice[3]);
                 Produkto1[4].setText("BETAMAX(CHIX BLOOD) - "+prodPrice[4]);
                 Produkto1[5].setText("WALKMAN(PIG EARS) - PHP "+prodPrice[5]);
                 Produkto1[6].setText("HOTDOG(KING SIZE) - PHP "+prodPrice[6]);
                 Produkto1[7].setText("TILAPIA - PHP "+prodPrice[7]);
                 Produkto1[8].setText("HITO - PHP "+prodPrice[8]);
                 Produkto1[9].setText("PUSIT - PHP "+prodPrice[9]);
                 
                 Produkto2[0].setText("SIZZLING SISIG - PHP "+prodPrice[10]);
                 Produkto2[1].setText("SIZZLING HOTDOG - PHP "+prodPrice[11]);
                 Produkto2[2].setText("CALAMARES(BIG) - PHP "+prodPrice[12]);
                 Produkto2[3].setText("KILAWIN(TANIGUE-SOLO) - PHP "+prodPrice[13]);
                 Produkto2[4].setText("KILAWIN(3 TO 4 PERSON) - PHP "+prodPrice[14]);
                 Produkto2[5].setText("DINAKDAKAN - PHP "+prodPrice[15]);
                 Produkto2[6].setText("CHICHARON BULAKLAK - PHP "+prodPrice[16]);
                 Produkto2[7].setText("NACHOS - PHP "+prodPrice[17]);
                 Produkto2[8].setText("PAPAITAN - "+prodPrice[18]);
                 Produkto2[9].setText("RICE - PHP "+prodPrice[19]);
                
                 Produkto3[0].setText("RED HORSE(STALLION) - PHP "+prodPrice[20]);
                 Produkto3[1].setText("SAN MIG LIGHT - PHP "+prodPrice[21]);
                 Produkto3[2].setText("PALE PILSEN - PHP "+prodPrice[22]);
                 Produkto3[3].setText("FLAVORED BEER(A & L) - PHP "+prodPrice[23]);
                 Produkto3[4].setText("TIGER BEER - PHP "+prodPrice[24]);
                 Produkto3[5].setText("COKE - PHP "+prodPrice[25]);
                 Produkto3[6].setText("ROYAL - PHP "+prodPrice[26]);
                 Produkto3[7].setText("SPRITE - PHP "+prodPrice[27]);
                 Produkto3[8].setText("CRANBERRY JUICE - PHP "+prodPrice[28]);
                 Produkto3[9].setText("LEMON ICE TEA - PHP "+prodPrice[29]);
                 
                 Produkto4[0].setText("BEER BUCKET - PHP "+prodPrice[30]);

         
    }



	public static void main(String[] args)
	{
		JDialog.setDefaultLookAndFeelDecorated(true);
		BoggsGrill X = new BoggsGrill();
		X.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}