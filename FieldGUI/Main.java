class Main{
    public static void main(String[] args) {
        Field field = new Field();
        field.display();
        Agent r1 = new Agent(0, 0, true);

        double[] ball1 = {3,3,1};

        field.addBall(ball1);
        field.addRobot(r1);

    }
}