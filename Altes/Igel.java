package de.felten.igelgrafik;

import java.awt.Canvas;
import java.awt.Graphics;

public class Igel{
	
	private int x;
	private int y;
	private Canvas c;
	private double b=0;
	private int phi;
	
	public Igel(Canvas cc, int xx, int yy, int pphi){
		this.c=cc;
		this.x=xx;
		this.y=yy;
		this.phi=pphi;
	}
	
	public void setCanvas(Canvas cc) {
		  this.c=cc;
	}
	public void setX(int xx) {
		  this.x=xx;
	}
	public void setY(int yy) {
		  this.y=yy;
	}
	public void setPhi(int pphi) {
		this.phi=pphi;
	}
	
	public void nEck(int n) {
		for (int k=0;k<n;k++) {
			this.vor(50);
			this.rechts(360/n);
		}
	}
	
	public void vor(int d) {
		
		int dx=(int)(d*Math.sin(b));
		int dy=(int)(d*Math.cos(b));
		int xe=x+dx;
		int ye=y-dy;
		Graphics stift = c.getGraphics();
		stift.drawLine(x, y, xe, ye);
		y=ye;
		x=xe;
	}
	
	public void rechts(int winkel) {
		phi=phi+winkel;
		b=Math.PI*phi/180;
	}
	

}
