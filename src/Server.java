
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Server extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Server
     */
	ServerSocket server;
	Socket connection;
	ObjectInputStream input;
	ObjectOutputStream output;
	Move move=new Move();
	
    public Server() {
   
        initComponents();
        
        
    }
    public void deactivate(){
    if(move.getPlayer1Left()==0){
          jButton4.setEnabled(false);
          jButton9.setEnabled(false);
          jButton11.setEnabled(false);
          jButton1.setEnabled(false);
          jButton2.setEnabled(false);
          jButton3.setEnabled(false);          
        }
         if(move.getPlayer1Right()==0){
          jButton1.setEnabled(false);
          jButton8.setEnabled(false);
          jButton12.setEnabled(false);
          jButton4.setEnabled(false);
          jButton5.setEnabled(false);
          jButton6.setEnabled(false);
        }
         if(move.getPlayer2Left()==0){
          jButton3.setEnabled(false);
          jButton5.setEnabled(false);
          jButton10.setEnabled(false);
          jButton7.setEnabled(false);
          jButton8.setEnabled(false);
          jButton9.setEnabled(false);
         }
         if(move.getPlayer2Right()==0){
          jButton2.setEnabled(false);
          jButton6.setEnabled(false);
          jButton7.setEnabled(false);
          jButton10.setEnabled(false);
          jButton11.setEnabled(false);
          jButton12.setEnabled(false);
         }
         if(move.getPlayer1Left()+move.getPlayer1Right()%2!=0){
        	 jButton17.setEnabled(false);
         }
         if(move.getPlayer2Left()+move.getPlayer2Right()%2!=0){
        	 jButton18.setEnabled(false);
         }
         
    }
    public void deactivatePlayer1(){
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton17.setEnabled(false);
        
    }
    
    public void activatePlayer2(){
    	jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        jButton10.setEnabled(true);
        jButton11.setEnabled(true);
        jButton12.setEnabled(true);
        jButton18.setEnabled(true);
        
    }
    public void deactivatePlayer2(){
        
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        jButton10.setEnabled(false);
        jButton11.setEnabled(false);
        jButton12.setEnabled(false);
        jButton18.setEnabled(false);
        
    }
    public void activatePlayer1(){
    	jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton17.setEnabled(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    new Thread(new Runnable() {
			
			@Override
			public void run() {
				Board board=new Board("Server: Player 1");
				board.repaint();
			}
		}).start();
    	
    	
        
       // startRunning();
    }
                                             
    public void startRunning(){
    	try {
			server=new ServerSocket(3128);
			
				System.out.println("Waiting for Client to Connect");
				connection=server.accept();
				System.out.println();
				System.out.println("Connected with "+connection.getInetAddress().getHostName());
				System.out.println("Setting Stream");
				output=new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input=new ObjectInputStream(connection.getInputStream());
				System.out.println("Stream Completed");
				 new Thread(new Runnable() {
						
						@Override
						public void run() {
							 whilePlaying();
						}
					}).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    public void send(){
    	try {
			output.writeObject(move);
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public synchronized void whilePlaying(){
    	while(move.isGameOver()==false){
    		try {
				move=(Move)input.readObject();
				activatePlayer1();
				deactivate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		showScreen();
    	}
    }
    public int getLastHandValue(JTextField hand){
    	int lastHandValue=0;
    	if(hand.getName().equals("jTextField1"))
    	{lastHandValue=move.getPlayer1Left();System.out.println("Text1");}
    	else if(hand.getName().equals("jTextField2"))
    	{lastHandValue=move.getPlayer1Right();System.out.println("Text2");}
    	else if(hand.getName().equals("jTextField3"))
    	{lastHandValue=move.getPlayer2Left();System.out.println("Text3");}
    	else if(hand.getName().equals("jTextField4"))
    	{lastHandValue=move.getPlayer2Right();System.out.println("Text4");}
    	
    	return lastHandValue;
    	
    }
    
    public void showScreen(){
		 new Thread(new Runnable(){
			@Override
			 public void run() {
				
				int player1left = Integer.parseInt(jTextField1.getText());
				int player1right = Integer.parseInt(jTextField2.getText());
				int player2left = Integer.parseInt(jTextField3.getText());
				int player2right = Integer.parseInt(jTextField4.getText());
				
				 //player1 left
				 for(int i=player1left;(i%5)!=(move.getPlayer1Left()+1)%5;i++){
					 jTextField1.setText(""+i%5);
					 try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {

						e.printStackTrace();
		    			}		    			
				 }
				 
				 //player1 right
				 for(int i=player1right;(i%5)!=(move.getPlayer1Right()+1)%5;i++){
					 jTextField2.setText(""+i%5);
					 try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {

						e.printStackTrace();
		    			}		    			
				 }
				 //player2 left
				 for(int i=player2left;(i%5)!=(move.getPlayer2Left()+1)%5;i++){
					 jTextField3.setText(""+i%5);
					 try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {

						e.printStackTrace();
		    			}		    			
				 }
				 //player1 left
				 for(int i=player2right;(i%5)!=(move.getPlayer2Right()+1)%5;i++){
					 jTextField4.setText(""+i%5);
					 try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {

						e.printStackTrace();
		    			}		    			
				 }
				 

				 
				 /*JTextField curHand= move.getLastMoveOn();
				 System.out.println("curHand="+curHand.getName());
				 if(move.getLastMoveOn()==null)
		    	{
		    		jTextField1.setText(""+move.getPlayer1Left());
		    		jTextField2.setText(""+move.getPlayer1Right());
		    		jTextField3.setText(""+move.getPlayer2Left());
		    		jTextField4.setText(""+move.getPlayer2Right());
		    		System.out.println("Hand is null");

		    	}
		    	else{
		    		int lastHandValue=getLastHandValue(curHand);
		    		System.out.println(lastHandValue);
		    		int assertVal = lastHandValue;
		    		for(int i=Integer.parseInt(curHand.getText());(i%5)!=(lastHandValue+1)%5;i++)
		    		{
		    			
		    			assert(lastHandValue==assertVal):"lasthand value changed!!!!";
		    			final int another = i; 
		    			
		    			System.out.println("i="+i%5);
		    			try {
		    				Thread.sleep(1000);
		    			} catch (InterruptedException e) {

						e.printStackTrace();
		    			}
		    			
		    			
		    			SwingUtilities.invokeLater(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								curHand.setText(""+(another%5));
				    			repaint();
				    					
							}
						});

		    			//repaint();
		    		}
		    	}
		    	
		    	*/
		    	/*
				 jTextField1.setText(""+move.getPlayer1Left());
				 jTextField2.setText(""+move.getPlayer1Right());
				 jTextField3.setText(""+move.getPlayer2Left());
				 jTextField4.setText(""+move.getPlayer2Right());
				*/
			 }	
		 }).start();
	 }
    
    public void checkWin(){
    	if(move.getPlayer2Left()==0&&move.getPlayer2Right()==0)
        {
            JOptionPane.showMessageDialog(null,"Player 1 Wins");
            move.setGameOver(true);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        move.setPlayer1Right((move.getPlayer1Left()+move.getPlayer1Right())%5);
        move.setLastMoveOn(jTextField2);
        showScreen();
        deactivatePlayer1();
        checkWin();  
        send();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        move.setPlayer2Right((move.getPlayer1Left()+move.getPlayer2Right())%5);
        move.setLastMoveOn(jTextField4);
        showScreen();
        deactivatePlayer1();
        checkWin();  
        send(); 
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        move.setPlayer2Left((move.getPlayer1Left()+move.getPlayer2Left())%5);
        move.setLastMoveOn(jTextField3);
        showScreen();
        deactivatePlayer1();
        checkWin();  
        send();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	move.setPlayer1Left((move.getPlayer1Left()+move.getPlayer1Right())%5);
    	move.setLastMoveOn(jTextField1);
        showScreen();
        deactivatePlayer1();
        checkWin();  
        send();
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	move.setPlayer2Left((move.getPlayer1Right()+move.getPlayer2Left())%5);
    	move.setLastMoveOn(jTextField3);
        showScreen();
        deactivatePlayer1();
        checkWin();  
        send();
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	move.setPlayer2Right((move.getPlayer2Right()+move.getPlayer1Right())%5);
    	move.setLastMoveOn(jTextField4);
        showScreen();
        deactivatePlayer1();
        checkWin();  
        send();
    }                                        

   
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	
    	int player1Left=move.getPlayer1Left();
    	int player1Right=move.getPlayer1Right();
    	int total=player1Left+player1Right;
    	move.setPlayer1Left(total/2);
    	move.setPlayer1Right(total-(total/2));
    	showScreen();
        deactivatePlayer1();
        checkWin();  
        send();
     }
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
     
       jButton1.setEnabled(true);
       jButton2.setEnabled(true);
       jButton3.setEnabled(true);
       jButton4.setEnabled(true);
       jButton5.setEnabled(true);
       jButton6.setEnabled(true);
       jTextField1.setEditable(false);
       jTextField2.setEditable(false);
       jTextField3.setEditable(false);
       jTextField4.setEditable(false);
       
       
    }                                 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        Server server=new Server();
        
        //server.setVisible(true);
        server.startRunning();
        System.out.println("HI dljvnksjdbvks bdvkbsjkdv");
        

        /* Create and display the form */
        		System.out.println("Server main");
                
                //server.setVisible(true);
                //server.startRunning();
           
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    
    // End of variables declaration                   
}
