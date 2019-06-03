public class NBody {
/* 
double yyPos: Its current x position
double yyPos: Its current y position
double xxVel: Its current velocity in the x direction
double yyVel: Its current velocity in the y direction
double mass: Its mass
String imgFileName: The name of the file that corresponds to the image that depicts the planet (for example, jupiter.gif)
*/
	public static double readRadius(String loc){
		In in = new In(loc);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;

	}

	public static Planet[] readPlanets(String loc){
		In in = new In(loc);
		int num = in.readInt();
		double radius = in.readDouble();
        Planet[] planets = new Planet[num];  
		for (int i = 0; i < num; i++){
			double a = in.readDouble();
			double b = in.readDouble();
			double c = in.readDouble();
			double d = in.readDouble();
			double e = in.readDouble();
			String f = in.readString();
			planets[i] = new Planet(a,b,c,d,e,f);
		}
		return planets;

	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fname = args[2];
		double a  = readRadius(fname);
		Planet[] b = readPlanets(fname);
		int num = b.length;
		double timestamp = 0;

		StdDraw.enableDoubleBuffering();
		
		while (timestamp <= T){
			double[] xForces = new double[num];
		    double[] yForces = new double[num];
			StdDraw.setScale(-a, a);
			StdDraw.clear();
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			
			int i = 0;
			for (Planet item : b){
				xForces[i] = item.calcNetForceExertedByX(b);
				yForces[i] = item.calcNetForceExertedByY(b);
				i += 1;
			}
			
			i = 0;
			for (Planet item : b){
				item.update(dt,xForces[i],yForces[i]);
				item.draw();
				i += 1;
			}
 

			StdDraw.show();
			StdDraw.pause(10);
            timestamp += dt;

		}

		StdOut.printf("%d\n", num);
		StdOut.printf("%.2e\n", a);
		for (int i = 0; i < num; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  b[i].xxPos, b[i].yyPos, b[i].xxVel,
                  b[i].yyVel, b[i].mass, b[i].imgFileName);   
		}


	


		


	}

}