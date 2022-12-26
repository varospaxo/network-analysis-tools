//Developed By- Vedant Farkade, Akash Kolakkal, Atharva Gandhi, Swayam Dhanawade//


import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Tools {

	private JFrame frmTools;
	private JTextField txtEnterOurUrl;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	public static JTextArea outputArea;
	private JTextField ip1;
	private JTextField ip2;
	private JTextField ip3;
	private static JTextField ip4;
	private static JTextField range;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tools window = new Tools();
					window.frmTools.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tools() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Window Frame//
		frmTools = new JFrame();
		frmTools.getContentPane().setBounds(new Rectangle(0, 0, 1280, 1080));
		frmTools.setResizable(false);
		frmTools.getContentPane().setBackground(new Color(0, 16, 100));
		frmTools.getContentPane().setForeground(new Color(255, 255, 255));
		frmTools.setTitle("NetOSINT");
		frmTools.setBounds(100, 100, 1280, 675);
		frmTools.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTools.getContentPane().setLayout(null);
		
		//Label//
		JLabel lblNewLabel = new JLabel("URL ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(13, 14, 63, 33);
		frmTools.getContentPane().add(lblNewLabel);
		
		//URL Text Field//
		txtEnterOurUrl = new JTextField();
		txtEnterOurUrl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterOurUrl.setBounds(104, 13, 944, 36);
		frmTools.getContentPane().add(txtEnterOurUrl);
		txtEnterOurUrl.setColumns(10);
		
		
		//Find IP Button//
		JButton btnNewButton = new JButton("Find IP Address");
		btnNewButton.setToolTipText("Find the IP Address of the URL.");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(40, 53, 147));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = txtEnterOurUrl.getText();
				try{
					InetAddress ia = InetAddress.getByName(url);
					String ip = ia.getHostAddress();
					outputArea.setText("Primary IP : "+ip);
					if (txtEnterOurUrl.getText().equals(""))
					{
						outputArea.append(" (localhost)");
					}
				}
				catch (UnknownHostException g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(103, 55, 218, 33);
		frmTools.getContentPane().add(btnNewButton);
		
		//Find All IPs Button//
		JButton btnNewButton_1 = new JButton("Find All IPs");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(40, 53, 147));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputArea.setText("Fetched IPs : ");
				outputArea.append("\n");
				String url = txtEnterOurUrl.getText();
				try {
					InetAddress[] myHost = InetAddress.getAllByName(url);
					for(InetAddress host:myHost){
						outputArea.append("[+] "+host.getHostAddress());
						if (txtEnterOurUrl.getText().equals(""))
						{
							outputArea.append(" (localhost)");
						}
						outputArea.append("\n");
					}
				 } catch (UnknownHostException ex) {
					ex.printStackTrace();
				 }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(596, 55, 193, 33);
		frmTools.getContentPane().add(btnNewButton_1);
		
		//Reset Button//
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(40, 53, 147));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputArea.setText("");
				txtEnterOurUrl.setText("");
				ip1.setText("");
				ip2.setText("");
				ip3.setText("");
				ip4.setText("");
				range.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_2.setBounds(1058, 14, 181, 114);
		frmTools.getContentPane().add(btnNewButton_2);
		
		//Ping IP Address Button//
		JButton btnNewButton_3 = new JButton("Ping IP Address");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(40, 53, 147));
		btnNewButton_3.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = txtEnterOurUrl.getText();
					InetAddress inet = InetAddress.getByName(url);
					if(txtEnterOurUrl.getText().equals("")) {
				        url="localhost";
				    }
					if (inet.isReachable(5000)){
						outputArea.setText("Sending Ping Request to " + url);
						outputArea.append("\n");
						outputArea.append(url + " is reachable.");
					} else {
						outputArea.setText("\n");
						outputArea.append(url + " NOT reachable via ICMP.");
					}
				  } catch ( Exception ep ) {
					outputArea.setText("Exception:" + ep.getMessage());
				  }

			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(344, 55, 228, 33);
		frmTools.getContentPane().add(btnNewButton_3);
		
		//Default Gateway Button//
		JButton Default_Gateway_btn = new JButton("Default Gateway");
		Default_Gateway_btn.setForeground(Color.WHITE);
		Default_Gateway_btn.setBorder(null);
		Default_Gateway_btn.setBackground(new Color(40, 53, 147));
		Default_Gateway_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	final String DEFAULT_GATEWAY = "Default Gateway";
		        if (Desktop.isDesktopSupported()) {
		            try {
		                Process process = Runtime.getRuntime().exec("ipconfig");

		                try (BufferedReader bufferedReader = new BufferedReader(
		                        new InputStreamReader(process.getInputStream()))) {

		                    String line;
		                    while ((line = bufferedReader.readLine()) != null) {
		                        if (line.trim().startsWith(DEFAULT_GATEWAY)) {
		                            String ipAddress = line.substring(line.indexOf(":")+2).trim(),
		                                    routerURL = String.format("http://%s", ipAddress);

		                            // opening router setup in browser
		                            Desktop.getDesktop().browse(new URI(routerURL));
		                            outputArea.setText("");
		                            outputArea.append("Default Gateway: "+ipAddress);
			        				outputArea.append("\n");
		                        }
		                        

		                        System.out.println(line);
		                    }
		                }
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }
		        }
			}
		});
		Default_Gateway_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Default_Gateway_btn.setBounds(750, 95, 298, 33);
		frmTools.getContentPane().add(Default_Gateway_btn);
		frmTools.setVisible(true);
		
		//LAN Scan Button//
		JButton LAN_Scan = new JButton("LAN Scan");
		LAN_Scan.setForeground(Color.WHITE);
		LAN_Scan.setBorder(null);
		LAN_Scan.setBackground(new Color(40, 53, 147));
		LAN_Scan.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				long initialT = System.currentTimeMillis();
		        try {
		        	String ip1in = ip1.getText();
		        	String ip2in = ip2.getText();
		        	String ip3in = ip3.getText();
					checkHosts(ip1in+"."+ip2in+"."+ip3in);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		        long finalT = System.currentTimeMillis();
		        outputArea.append("\nScan Completed taking " + (finalT - initialT) + " miliseconds approximately!");
		    }
			
		    
		    public static void checkHosts(String subnet) throws Exception{
		    	
		        String ip4in = ip4.getText();
		        Integer intip4in = Integer.valueOf(ip4in);
	        	String rangein = range.getText();
	        	Integer intrangein = Integer.valueOf(rangein);
		   int timeout=1;
		   for (int i=intip4in;i<intrangein;i++){
		       String host=subnet + "." + i;
		       //outputArea.append(host);
		       try {
		    	   
				if (InetAddress.getByName(host).isReachable(timeout)){
					System.out.println(host + " is reachable");
					outputArea.append("\n" + host + " is reachable");
				   }
			} catch (IOException e) {
				e.printStackTrace();
			}
		   }

		}	
		});
		LAN_Scan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LAN_Scan.setBounds(478, 95, 250, 33);
		frmTools.getContentPane().add(LAN_Scan);
		
		//Scan All Ports Button//
		JButton btnNewButton_4 = new JButton("Scan All Ports");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(new Color(40, 53, 147));
		btnNewButton_4.addActionListener(new ActionListener() {
			 private void checkPort(String url, int portNumber) {
			        Thread thread = new Thread(() -> {
			            Socket clientSocket = new Socket();
			            try{
			            	clientSocket.connect(new InetSocketAddress(url, portNumber), 5000);
			            	
			            	if (portNumber==80){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (HTTP) is open");
							} 
			            	
			            	else if (portNumber==7){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Echo) is open");
							}
			            	
			            	else if (portNumber==1){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (TCPMUX) is open");
							}
			            	
			            	else if (portNumber==18){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MSP) is open");
							}
							
							else if (portNumber==5){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (RJE) is open");
							}
							
			            	else if (portNumber==20){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (FTP-data) is open");
							}
			            	
			            	else if (portNumber==21){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (FTP) is open");
							}
							
							else if (portNumber==22){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SSH) is open");
							}
			            	
			            	else if (portNumber==23){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Telnet) is open");
							}
			            	
			            	else if (portNumber==25){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SMTP) is open");
							}
							
							else if (portNumber==42){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Nameserv) is open");
							}
							
							else if (portNumber==43){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (WhoIs) is open");
							}
							
							else if (portNumber==49){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (TACACS) is open");
							}
			            	
			            	else if (portNumber==53){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (DNS) is open");
							}
			            	
			            	else if (portNumber==88){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Kerberos) is open");
							}
			            	
			            	else if (portNumber==102){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (ISO TSAP) is open");
							}
							
							else if (portNumber==109){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (POP2) is open");
							}
			            	
			            	else if (portNumber==110){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (POP3) is open");
							}
			            	
			            	else if (portNumber==115){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SFTP) is open");
							}
							
							else if (portNumber==118){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SQL) is open");
							}
							
			            	else if (portNumber==135){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MS RPC) is open");
							}
			            	
			            	else if (portNumber==137){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (NetBIOS-ns) is open");
							}
			            	
			            	else if (portNumber==139){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (NetBios-ssn) is open");
							}
			            	
			            	else if (portNumber==143){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (IMAP4) is open");
							}
							
							else if (portNumber==123){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (NTP) is open");
							}
							
							else if (portNumber==161){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SNMP) is open");
							}
							
							else if (portNumber==179){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (BGP) is open");
							}
							
							else if (portNumber==190){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (GACP) is open");
							}
							
							else if (portNumber==194){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (IRC) is open");
							}
							
							else if (portNumber==197){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (DLS) is open");
							}
							
							else if (portNumber==389){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (LDAP) is open");
							}
			            	
			            	else if (portNumber==443){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (HTTP-SSL) is open");
							}
							
							else if (portNumber==444){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SNPP) is open");
							}
			            	
			            	else if (portNumber==465){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SMTPS) is open");
							}
			            	
			            	else if (portNumber==500){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (ISAKMP) is open");
							}
							
							else if (portNumber==569){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MSN) is open");
							}
							
			            	else if (portNumber==587){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (SMTP) is open");
							} 
			            	
			            	
			            	else if (portNumber==593){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MS DCOM) is open");
			            	}
			            	
			            	else if (portNumber==636){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (LDAP-TLS/SSL) is open");
			            	}
			            	
			            	else if (portNumber==691){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MS Exchange) is open");
			            	}
			            	
			            	else if (portNumber==902){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (VMware) is open");
			            	}
			            	
			            	else if (portNumber==989){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (FTP-SSL) is open");
			            	}
			            	
			            	else if (portNumber==990){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (FTP-SSL) is open");
			            	}
			            	
			            	else if (portNumber==993){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (IMAP4-SSL) is open");
			            	}
			            	
			            	else if (portNumber==995){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (POP3-SSL) is open");
			            	}
			            	
			            	else if (portNumber==1025){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MS RPC) is open");
							}
			            	
			            	else if (portNumber==1194){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (OpenVPN) is open");
							}
			            	
			            	else if (portNumber==1589){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Cisco VQP) is open");
							}
			            	
			            	else if (portNumber==1725){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Steam) is open");
							}
			            	
			            	else if (portNumber==2483){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Oracle DB) is open");
							}
			            	
			            	else if (portNumber==2484){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Oracle DB - SSL) is open");
							}
			            	
			            	else if (portNumber==2967){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Symantec AV) is open");
							}
			            	
			            	else if (portNumber==3074){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Xbox Live) is open");
							}
			            	
			            	else if (portNumber==3306){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (MySQL) is open");
							}
			            	
			            	else if (portNumber==3389){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (RDP) is open");
							}
			            	
			            	else if (portNumber==4664){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Google Desktop) is open");
							}
			            	
			            	else if (portNumber==5432){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (PostgreSQL) is open");
							}
			            	
			            	else if (portNumber==5900){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (RFB-VNC) is open");
							}
			            	
			            	else if (portNumber==6665){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (IRC) is open");
							}
			            	
			            	else if (portNumber==6669){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (IRC) is open");
							}
			            	
			            	else if (portNumber==6881){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (BitTorrent) is open");
							}
			            	
			            	else if (portNumber==6999){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (BitTorrent) is open");
							}
			            	
			            	else if (portNumber==7102){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Alternate HTTPS) is open");
							}
			            	
			            	else if (portNumber==7104){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Alternate HTTP) is open");
							}
			            	
			            	else if (portNumber==7105){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (HTTPS) is open");
							}
			            	
			            	else if (portNumber==8008){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Google Cast) is open");
							}
			            	
			            	else if (portNumber==8009){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Google Cast) is open");
							}
			            	
			            	else if (portNumber==8443){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (Tomcat) is open");
							}
			            	
			            	else if (portNumber==8222){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (VMware) is open");
							}
			            	
			            	else if (portNumber==9100){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (PDL) is open");
							}
			            	
			            	else if (portNumber==12345){
			            		outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " (NetBus) is open");
							}
			            
			            	else {
								outputArea.append("");
				            	outputArea.append("\n Port " +portNumber+ " is open");
							}
			            	
			                clientSocket.close();
			            } catch (IOException e) {
			                //System.out.printf("[-] Could not connect %d", portNumber);
			                //e.printStackTrace();
			            } 
			        });
			        thread.start();
			    }
			public void actionPerformed(ActionEvent e) {
				String url = txtEnterOurUrl.getText();
				for (Integer portNumber = 1; portNumber <= 65535; portNumber++) {
		            checkPort(url, portNumber);
		        }
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(813, 55, 235, 33);
		frmTools.getContentPane().add(btnNewButton_4);
		
		JLabel lblLanTools = new JLabel("LAN IP");
		lblLanTools.setForeground(Color.WHITE);
		lblLanTools.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLanTools.setBounds(13, 97, 95, 33);
		frmTools.getContentPane().add(lblLanTools);
		
		ip1 = new JTextField();
		ip1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ip1.setColumns(10);
		ip1.setBounds(103, 94, 63, 33);
		frmTools.getContentPane().add(ip1);
		
		ip2 = new JTextField();
		ip2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ip2.setColumns(10);
		ip2.setBounds(175, 94, 63, 33);
		frmTools.getContentPane().add(ip2);
		
		ip3 = new JTextField();
		ip3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ip3.setColumns(10);
		ip3.setBounds(248, 94, 63, 33);
		frmTools.getContentPane().add(ip3);
		
		ip4 = new JTextField();
		ip4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ip4.setColumns(10);
		ip4.setBounds(321, 94, 63, 33);
		frmTools.getContentPane().add(ip4);
		
		range = new JTextField();
		range.setFont(new Font("Tahoma", Font.PLAIN, 18));
		range.setColumns(10);
		range.setBounds(394, 94, 63, 33);
		frmTools.getContentPane().add(range);;
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 190, 1214, 423);
		frmTools.getContentPane().add(scrollPane);
		
		//Output Text Area//
		outputArea = new JTextArea();
		scrollPane.setViewportView(outputArea);
		outputArea.setWrapStyleWord(true);
		outputArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
		outputArea.setForeground(new Color(255, 255, 255));
		outputArea.setBackground(new Color(95, 95, 196));
		
		JLabel lblNewLabel_1 = new JLabel(".");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(164, 98, 12, 26);
		frmTools.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(".");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(237, 98, 12, 26);
		frmTools.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(".");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(310, 92, 12, 40);
		frmTools.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(383, 84, 12, 49);
		frmTools.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Output");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(13, 152, 263, 28);
		frmTools.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("General");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(13, 57, 95, 31);
		frmTools.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Range 1-255");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(398, 135, 81, 13);
		frmTools.getContentPane().add(lblNewLabel_7);
		
		

		
	}
}
