// Listing 7.1 The Full Text of HexReader.java

class HexReader {
    public String[] input = { "000A110D1D260219 ", "78700F1318141E0C ", "6A197D45B0FFFFFF " };

    public static void main(String[] arguments) {
        HexReader hex = new HexReader();
        for (int i = 0 ; i < hex.input.length ;i++ ) {
            hex.readLine(hex.input[i]);
        }
    }

    void readLine(String code) {
        try
        {
            for (int j = 0 ; j + 1 < code.length() ; j+= 2) {
                String sub = code.substring(j, j+2);
                int num = Integer.parseInt(sub, 16);
                if (num == 255) {
                    return;
                }
                System.out.print(num + " ");
            }
        }
        finally {
            System.out.println("**");
        }
    }
}

// $ java HexReader
// 0 10 17 13 29 38 2 25 **
// 120 112 15 19 24 20 30 12 **
// 106 25 125 69 176 **