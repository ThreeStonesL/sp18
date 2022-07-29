import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class NBody {
    public static double readRadius(String file){
        In in = new In(file);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int num = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i ++)
            planets[i] = new Planet(
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readString());
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for (Planet planet : planets)
            planet.draw();
        StdDraw.show();
        for(double time = 0; time <= T; time += dt){
            int num = planets.length;
            double[] xForces=new double[num], yForces=new double[num];
            for(int i = 0; i < num; i ++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
                StdDraw.clear();
                StdDraw.picture(0, 0, "./images/starfield.jpg");
                for (Planet planet : planets)
                    planet.draw();
                StdDraw.show();
                StdDraw.pause(10);
            }
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
