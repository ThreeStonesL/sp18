import edu.princeton.cs.algs4.StdDraw;

public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    private static final double G = 6.67e-11;
    public Planet(double xp, double yp, double xV, double yV, double m, String img){
        xxPos = xp;
        yyPos = yp;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        return G * mass * p.mass / distance / distance;
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return  calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double xForceSum = 0;
        for (Planet planet : allPlanets) {
            if (!equals(planet))
                xForceSum += calcForceExertedByX(planet);
        }
        return xForceSum;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double yForceSum = 0;
        for (Planet planet : allPlanets) {
            if(!equals(planet))
                yForceSum += calcForceExertedByY(planet);
        }
        return yForceSum;
    }

    public void update(double dt, double fX, double fY) {
        xxVel += fX / mass * dt;
        yyVel += fY / mass * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "/images/" + imgFileName);
    }
}
