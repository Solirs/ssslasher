package solirsayple.sshbrutewj;

public class out {
    // this is just the same thing from the python script. I thought it looked
    // cool :~) - AyPle
    public static void outputText(String color, String text) {
        System.out.println(color + "[+] " + text + Colors.RESET);
    }

    public static void timedoutputText(String color, String text) {
        System.out.println(color + "[+] " + text + " ["+ timeutils.rightnow() + "]" + Colors.RESET);
    }

    // this doesn't work too well but would be cool to implement.
    public static void outputSameLineText(String color, String text) {
        System.out.print(color + "\r[+] " + text + "\r                            ");
    }
    
}
