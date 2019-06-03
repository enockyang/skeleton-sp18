public class PlanetTest {
/* 
double yyPos: Its current x position
double yyPos: Its current y position
double xxVel: Its current velocity in the x direction
double yyVel: Its current velocity in the y direction
double mass: Its mass
String imgFileName: The name of the file that corresponds to the image that depicts the planet (for example, jupiter.gif)
*/
	public static void main(String[] args) {

		Planet p = new Planet(1,8,3,4,5,"a");
		Planet q = new Planet(4,4,4,4,4,"b");
		if (p.calcDistance(q) == 5){
			System.out.println("Works");
		} else {
			System.out.println("Wrong");
		}


	}

}