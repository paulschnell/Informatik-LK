package de.paulschnell.fraktale;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Igel {

	private double x;
	private double y;
	private Canvas canvas;
	private double b = 0;
	private int phi;

	public Igel(Canvas cc, int xx, int yy, int pphi) {
		this.canvas = cc;
		this.x = xx;
		this.y = yy;
		this.phi = pphi;
	}
	
	public void setColor(Color color) {
		Graphics graphics = canvas.getGraphics();
		graphics.setColor(Color.BLUE);
	}

	public void setCanvas(Canvas cc) {
		this.canvas = cc;
	}

	public void setX(int xx) {
		this.x = xx;
	}

	public void setY(int yy) {
		this.y = yy;
	}

	public void setPhi(int pphi) {
		this.phi = pphi;
	}

	public void nEck(int n, int l) {
		for (int k = 0; k < n; k++) {
			this.vor(l);
			this.rechts(360 / n);
		}
	}

	public void vor(double d) {

		double dx = d * Math.sin(b);
		double dy = d * Math.cos(b);
		double xe = x + dx;
		double ye = y - dy;
		Graphics stift = canvas.getGraphics();
		Graphics2D graphics = (Graphics2D) stift;
		graphics.draw(new Line2D.Double(x, y, xe, ye));
		y = ye;
		x = xe;
	}

	public void rechts(int winkel) {
		phi = phi + winkel;
		b = Math.PI * phi / 180;
	}

	public void koch(int k) {
		if (k > 10) {
			koch(k / 3);
			rechts(-60);
			koch(k / 3);
			rechts(120);
			koch(k / 3);
			rechts(-60);
			koch(k / 3);
		} else {
			vor(k);
		}
	}

	public void kochFlocke(int k) {
		koch(k);
		rechts(120);
		koch(k);
		rechts(120);
		koch(k);
	}

	public void krasserName(int k) {
		setY(canvas.getHeight() / 6);
		andererName(k);
		rechts(90);
		andererName(k);
		rechts(90);
		andererName(k);
		rechts(90);
		andererName(k);
	}

	public void andererName(int k) {
		if (k > 10) {
			andererName(k / 3);
			rechts(-90);
			andererName(k / 3);
			rechts(90);
			andererName(k / 3);
			rechts(90);
			andererName(k / 3);
			rechts(-90);
			andererName(k / 3);
		} else {
			vor(k);
		}
	}
	
	public void dreieck(int k) {
		rechts(30);
		vor(k);
		rechts(120);
		vor(k);
		rechts(120);
		vor(k);
		rechts(90);
	}
	
	public void sierpinski(int k) {
		if (k > 8) {
			sierpinski(k / 2);
			rechts(30);
			vor(k/2);
			rechts(-30);
			sierpinski(k/ 2);
			rechts(150);
			vor(k/2);
			rechts(-150);
			sierpinski(k/2);
			rechts(-90);
			vor(k/2);
			rechts(90);
		} else {
			dreieck(k);
		}
	}
	
	public void quadrat(double c) {
		vor(c);
		rechts(90);
		vor(c);
		rechts(90);
		vor(c);
		rechts(90);
		vor(c);
		rechts(90);
		vor(c);
	}
	
	public void pythagoras(double c, int alpha) {
		int beta = 90 - alpha;
		double b = c * Math.cos(beta * Math.PI / 180);
 		double a = c * Math.sin(alpha* Math.PI / 180);
		
		if (c > Math.PI * 3) {
			quadrat(c);
			
			rechts(-alpha);
			pythagoras(b, alpha);
			
			rechts(90);
			vor(b);
			rechts(90);
			vor(b);
			rechts(-90);
			
			pythagoras(a, beta);
			
			rechts(180);
			vor(a + b);
			rechts(90 + beta);
		} else {
			quadrat(c);
		}
	}

}
