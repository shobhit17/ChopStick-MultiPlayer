
import java.io.Serializable;

import javax.swing.JTextField;


public class Move implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int turn;
 private boolean isGameOver;
 private int player1Left;
 private int player1Right;
 private int player2Left;
 private int player2Right;
 private JTextField lastMoveOn;
 
 public JTextField getLastMoveOn() {
	return lastMoveOn;
}
public void setLastMoveOn(JTextField lastMoveOn) {
	this.lastMoveOn = lastMoveOn;
}
Move(){
	 turn=0;
	 isGameOver=false;
	 player1Left=1;
	 player1Right=1;
	 player2Left=1;
	 player2Right=1;
	 lastMoveOn=null;
 }
public int getTurn() {
	return turn;
}
public void setTurn(int turn) {
	this.turn = turn;
}
public boolean isGameOver() {
	return isGameOver;
}
public void setGameOver(boolean isGameOver) {
	this.isGameOver = isGameOver;
}
public int getPlayer1Left() {
	return player1Left;
}
public void setPlayer1Left(int player1Left) {
	this.player1Left = player1Left;
}
public int getPlayer1Right() {
	return player1Right;
}
public void setPlayer1Right(int player1Right) {
	this.player1Right = player1Right;
}
public int getPlayer2Left() {
	return player2Left;
}
public void setPlayer2Left(int player2Left) {
	this.player2Left = player2Left;
}
public int getPlayer2Right() {
	return player2Right;
}
public void setPlayer2Right(int player2Right) {
	this.player2Right = player2Right;
}
 	
}
