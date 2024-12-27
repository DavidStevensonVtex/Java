// Listing 1.3 Adding a new VolcanoRobot named virgil in the VolcanoApplication.java file

public class VolcanoApplication {
    public static void main(String[] arguments) {
        VolcanoRobot dante = new VolcanoRobot();
        dante.status = "exploring" ;
        dante.speed = 2;
        dante.temperature = 510;

        VolcanoRobot virgil = new VolcanoRobot();
        virgil.status = "researching" ;
        virgil.speed = 4;
        virgil.temperature = 533;
        virgil.showAttributes();
    
        dante.showAttributes();
        System.out.println("Increasing speed to 3.");
        dante.speed = 3;
        dante.showAttributes();
        System.out.println("Changing temperature to 670");
        dante.temperature = 670;
        dante.showAttributes();
        System.out.println("Checking the temperature.");
        dante.checkTemperature();
        dante.showAttributes();
    }
}
