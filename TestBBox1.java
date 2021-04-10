//package test;

import java.util.ArrayList;
//import animation.Point;
//import animation.BBox;

public class TestBBox1 implements BBox
{
    private Point minP;
    private Point maxP;

    public TestBBox1(final Point minPt, final Point maxPt) 
    {
        this.minP = new Point(minPt);
        this.maxP = new Point(maxPt);
    }

    public TestBBox1(final ArrayList<Point> points, final Point offset) 
    {
   /*     int minX = points.get(0).getX();
        int minY = points.get(0).getY();
        int maxX = minX;
        int maxY = minY;
        for (int i = 1; i < points.size(); ++i) {
            final Point p = points.get(i);
            if (p.getX() < minX) {
                minX = p.getX();
            }
            else if (p.getX() > maxX) {
                maxX = p.getX();
            }
            if (p.getY() < minY) {
                minY = p.getY();
            }
            else if (p.getY() > maxY) {
                maxY = p.getY();
            }
        }
        this.minP = new Point(minX + offset.getX(), minY + offset.getY());
        this.maxP = new Point(maxX + offset.getX(), maxY + offset.getY());*/
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

