//package demo;

import java.util.*;
//import animation.BBox;
//import animation.Point;
//import animation.SceneObject;

public class TestObject extends SceneObject
{

        private static int id=0;
        private int objectId;
        private Point presentPosition,destPosition;
        public ArrayList<Point>pointCollection;
        private Point minPoint;
        private Point maxPoint;
        private double speed;

        public TestObject()
        {
                this.speed=10.0;
                this.objectId=TestObject.id;
                TestObject.id++;
                this.presentPosition=new Point(0,0);
                this.destPosition=new Point(0,0);

		
		this.pointCollection = new ArrayList<Point>();
                this.pointCollection.add(new Point(0,0));
                this.pointCollection.add(new Point(10,0));
                this.pointCollection.add(new Point(10,10));
                this.pointCollection.add(new Point(0,10));
        }
        @Override
        public String getObjName() 
	{
                return "The Actor is  " + this.objectId;
        }

        @Override
        public Point getPosition() {
                return this.presentPosition;
        }

        @Override
        public void setPosition(int x, int y)
        {
                this.presentPosition.setPos(x,y);
                this.pointCollection.clear();
                this.pointCollection.add(this.presentPosition);
                this.pointCollection.add(new Point(this.presentPosition.getX()+10,this.presentPosition.getY()));
                this.pointCollection.add(new Point(this.presentPosition.getX()+10,this.presentPosition.getY()+10));
                this.pointCollection.add(new Point(this.presentPosition.getX(),this.presentPosition.getY()+10));
        }

        public void setDestPosition(int x, int y)
        {
                this.destPosition.setPos(x,y);
        }

        @Override
        public BBox getBBox()
        {
		return (BBox)new TestBBox(this.pointCollection,this.presentPosition);
        }

        @Override
        protected ArrayList<Point> getOutline()
        {
                return this.pointCollection;
        }

        @Override
        protected void updatePos(int deltaT)
        {
                final int ds = (int)(this.speed * (deltaT / 500.0));
        final int delx = this.destPosition.getX() - this.presentPosition.getX();
        final int dely = this.destPosition.getY() - this.presentPosition.getX();
        final double dist = Math.sqrt(delx * delx + dely * dely);
        double dx = 0.0;
        double dy = 0.0;
                if (dist > 0.001)
                {
            dx = delx / dist * ds;
            dy = dely / dist * ds;
        }
        this.presentPosition.setPos((int)(this.presentPosition.getX() + dx), (int)(this.presentPosition.getY() + dy));
        }



}

