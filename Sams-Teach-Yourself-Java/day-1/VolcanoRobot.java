// Listing 1.1 The Full Text of VolcanoRobot.java

class VolcanoRobot {
    String status ;
    int speed ;
    float temperature ;

    void checkTemperature() {
        if (temperature > 660) {
            status = "returning home" ;
            speed = 5 ;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
    }
}