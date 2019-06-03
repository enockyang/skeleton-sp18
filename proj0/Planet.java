public class Planet {
/* 
double yyPos: Its current x position
double yyPos: Its current y position
double xxVel: Its current velocity in the x direction
double yyVel: Its current velocity in the y direction
double mass: Its mass
String imgFileName: The name of the file that corresponds to the image that depicts the planet (for example, jupiter.gif)
*/
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double g = 6.67e-11;  /*why this should be private*/


	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}


	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}


	public double calcDistance(Planet p){
		return Math.pow((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos) + (this.yyPos-p.yyPos)*(this.yyPos-p.yyPos),0.5);

	}


	public double calcForceExertedBy(Planet p){
		return (g*(this.mass)*(p.mass)/(calcDistance(p)*(calcDistance(p))));
	}


	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double fx = 0;
 		for (Planet p : allPlanets){
			if (this.equals(p)){
				continue;
			} else{
				fx += calcForceExertedByX(p);
			}
		}
		return fx;
	}

	
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double fy = 0;
 		for (Planet p : allPlanets){
			if (this.equals(p)){
				continue;
			} else{
				fy += calcForceExertedByY(p);
			}
		}
		return fy;
	}

	public void update(double dt, double fX, double fY){
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		this.xxVel += dt*aX;
		this.yyVel += dt*aY;
		this.xxPos += dt*this.xxVel;
		this.yyPos += dt*this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
	}



	
	
			
		
		
	

}