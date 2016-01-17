package myself.powerdotstry2;

import java.io.Serializable;

public class singleDot implements Serializable{
    public float x;
    public float y;

    //private int xLength, yLength;

    private float xSpeed;
    private float ySpeed;

    private float xAcceleration;
    private float yAcceleration;
    private float mouseDotDistance, acceleration;
    private float mouseDotAngle;
    protected static float maxAcceleration = .25f;

    public singleDot() {}

    public singleDot(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() { return "singleDot.Float["+x+", "+y+"]"; }

    private static final long serialVersionUID = -2870572449815403710L;

    void updateAcceleration(float xMouse, float yMouse){
        //mouseDotDistance = Math.sqrt((x - xMouse)*(x - xMouse) + (y - yMouse)*(y - yMouse));

        mouseDotAngle = (float)Math.atan2( (yMouse - y),(xMouse - x));

        xAcceleration = maxAcceleration * angleTable.cos(mouseDotAngle);
        yAcceleration = maxAcceleration * angleTable.sin(mouseDotAngle);

        xSpeed = xSpeed + xAcceleration;
        ySpeed = ySpeed + yAcceleration;
    }

    public void update()
    {
//		if ((x + xSpeed)> xLength)
//			xSpeed = xSpeed*-1;
//		else if ((x + xSpeed)<0)
//			xSpeed = xSpeed*-1;
//		if ((y + ySpeed)> yLength)
//			ySpeed = ySpeed*-1;
//		else if ((y + ySpeed)<0)
//			ySpeed = ySpeed*-1;

        x += xSpeed;
        y += ySpeed;


        //System.out.println("xCoord = " + xCoord);
        //System.out.println("yCoord = " + yCoord);
        xSpeed = xSpeed*.99f;
        ySpeed = ySpeed*.99f;


    }
}
