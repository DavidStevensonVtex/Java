public class Zone {
    int x, y, width, height;
    
    class Center { // inner class begins
        int cx, cy;

        Center(int x, int y) {
            cx = y;
            cy = x;
        }
    } // inner class ends
    
    public Zone(int x1, int y1, int x2, int y2) {
        x = x1;
        y = y1;
        width = y2 - y1;
        height = x2 - x1;
        // create object of inner class
        Center c = new Center((x1 + x2) / 2, (y1 + y2) / 2);
    }
}
