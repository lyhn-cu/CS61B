import static java.lang.Math.sqrt;
public class Planet{
	/**
	
	*/
	double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double distance = sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
		return distance;
	}

	public double calcForceExertedBy(Planet p) {
		double force = G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double forceX = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return forceX;
	}

	public double calcForceExertedByY(Planet p) {
		double forceY = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
		return forceY;
	}

	public double calcNetForceExertedByX(Planet[] p) {
		double netforceX = 0;
		for (Planet s : p) {
			if (this.equals(s) != true) {netforceX += this.calcForceExertedByX(s);}
		}
		return netforceX;
	}

	public double calcNetForceExertedByY(Planet[] p) {
		double netforceY = 0;
		for (Planet s : p) {
			if (this.equals(s) != true) {netforceY += this.calcForceExertedByY(s);}
		}
		return netforceY;
	}

	public void update(double dt, double fX, double fY) {
		this.xxVel += fX / this.mass * dt;
		this.yyVel += fY / this.mass * dt;
		this.xxPos += this.xxVel * dt;
		this.yyPos += this.yyVel * dt;
	}

	public void draw(double r) {
		/** Sets up the universe so it goes from 
		  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-r, r);
		String img = "images/";
		img = img + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, img);
		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
		StdDraw.pause(2000);		
	}
}