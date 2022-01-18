class Main{
    public static void main(String[] args) {
        Field field = new Field();
        field.display();
        Agent r1 = new Agent(0, 0, true);
        Agent r2 = new Agent(0, 0, true);
        Agent r3 = new Agent(0, 0, true);

        Agent r4 = new Agent(0, 0, true);
        Agent r5 = new Agent(0, 0, true);
        Agent r6 = new Agent(0, 0, true);

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

    }
}