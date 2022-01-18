class Main{
    public static void main(String[] args) {
        Field field = new Field();
        field.display();
        Agent r1 = new Agent(-1.25, -1.6, false);
        Agent r2 = new Agent(-1.6,1.5 , false);
        Agent r3 = new Agent(-1.9, 0.4, false);

        Agent r4 = new Agent(-r1.x, -r1.y, true);
        Agent r5 = new Agent(-r2.x, -r2.y, true);
        Agent r6 = new Agent(-r3.x, -r3.y, true);

        double[] ball1 = {3.174  ,2.243,1};
        double[] ball2 = {3.79  , 0.858,0};
        double[] ball3 = {3.278, -2.074,0};
        double[] ball4 = {2.243, -3.174,1};
        double[] ball5 = {0.858,  -3.79,0};
        double[] ball6 = {-0.658, -3.83,1};
        double[] ball7 =  {-3.174  , -2.243,1};
        double[] ball8 =  {-3.79  , -0.858,0};
        double[] ball9 =  {-3.278, 2.074,1};
        double[] ball10 = {-2.243, 3.174,0};
        double[] ball11 = {-0.858,  3.79,1};
        double[] ball12 = {0.658, 3.83,0};
        field.addBall(ball1);
        field.addBall(ball2);
        field.addBall(ball3);
        field.addBall(ball4);
        field.addBall(ball5);
        field.addBall(ball6);
        field.addBall(ball7);
        field.addBall(ball8);
        field.addBall(ball9);
        field.addBall(ball10);
        field.addBall(ball11);
        field.addBall(ball12);

        field.addRobot(r1);
        field.addRobot(r2);
        field.addRobot(r3);
        field.addRobot(r4);
        field.addRobot(r5);
        field.addRobot(r6);
        

    }
}