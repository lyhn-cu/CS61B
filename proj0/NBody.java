public class NBody {
	public static double readRadius(String path) {
		In in = new In (path);
		int pnum = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String path) {
		In in = new In (path);
		int pnum = in.readInt();
		double radius = in.readDouble();
		Planet[] planetarray = new Planet[pnum];

		for(int i=0; i < pnum; i = i + 1) {
			
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m  = in.readDouble();
			String img = in.readString();

			planetarray[i] = new Planet(xP, yP, xV, yV, m, img);
			
		}
		return planetarray;
	}

	// Draws the background img.
	public static void background(double r) {
		/** Sets up the universe so it goes from 
		  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-r, r);
		/* Clears the drawing window. */
		StdDraw.clear();
		String imgBG = "images/starfield.jpg";
		StdDraw.picture(0, 0, imgBG);

		/* Shows the drawing to the screen, and waits 1000 milliseconds. */
		StdDraw.show();
		//get rid of the waiting since the background is drawn each loop.
		//StdDraw.pause(1000);		
	}
		public static void main(String[] args){
			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String filename = args[2];
			double universeR = readRadius(filename);
			Planet[] planets = readPlanets(filename);
			//background(universeR);
			//for(Planet p : planets) {
			//	p.draw(universeR);
			//}
			StdDraw.enableDoubleBuffering();
			double t = 0;
			background(universeR);
			while (t < T) {
				//StdDraw.clear();
				background(universeR);
				//init
				double[] fX = new double[5];
				double[] fY = new double[5];
				String[] img = new String[5];
				String imghead = "images/";
				int i = 0; int j = 0;
				//calc fX,fY
				for(Planet p : planets) {
					img[i] = imghead + p.imgFileName;
					fX[i] = p.calcNetForceExertedByX(planets);
					fY[i] = p.calcNetForceExertedByY(planets);
					i = i + 1;
				}
				//update simultaneously
				for(Planet p : planets) {
					p.update(dt,fX[j],fY[j]);
					StdDraw.picture(p.xxPos, p.yyPos, img[j]);
					StdDraw.show();
					StdDraw.pause(10);
					t = t + dt;
					j = j + 1;
				}

			}
			StdOut.printf("%d\n", planets.length);
			StdOut.printf("%.2e\n", universeR);
			for (int i = 0; i < planets.length; i++) {
   				StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
		}
}