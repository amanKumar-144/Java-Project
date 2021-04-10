//package test;

import java.util.ArrayList;
//import animation.Point;
//import animation.BBox;

public class TestBBox implements BBox
{
    private Point minP;
    private Point maxP;

    public TestBBox(final Point minPt, final Point maxPt)
    {
        this.minP = new Point(minPt);
        this.maxP = new Point(maxPt);
    }

    public TestBBox(final ArrayList<Point> points, final Point offset)
    {
        int minX=points.get(0).getX();
        int minY=points.get(0).getY();
        int maxX=points.get(2).getX();
        int maxY=points.get(2).getY();
        this.minP=new Point(minX,minY);
        this.maxP=new Point(maxX,maxY);
    }

    public Point getMinPt() {
        return new Point(this.minP);
    }

    public Point getMaxPt() {
        return new Point(this.maxP);
    }

    public boolean intersects(final BBox b)
    {
	    System.out.println("Shskdfhkdsghks");
        if(this.minP.getX()>=b.getMinPt().getX() && this.minP.getX()<=b.getMaxPt().getX() && this.minP.getY()>=b.getMinPt().getY() && this.minP.getY()<=b.getMaxPt().getY())
                return true;
        if(this.maxP.getX()>=b.getMinPt().getX() && this.maxP.getX()<=b.getMaxPt().getX() && this.maxP.getY()>=b.getMinPt().getY() && this.maxP.getY()<=b.getMaxPt().getY())
                return true;

        return false;
    }


    @Override
    public String toString() {
        return "[( " + this.minP.getX() + " ," + this.minP.getY() + " ), ( " + this.maxP.getX() + " , " + this.maxP.getY() + " )]";
    }
}

