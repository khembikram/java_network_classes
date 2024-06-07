
public  class  SpamCheck{
    public static  final String BLACKHOLE = "sbl.spamhaus.org";
    
    public static void main(String[] args) {
        for(String arg: args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known Spammer.");
            }else{
                System.out.println(arg + " appears legitimate.");
            }
        }
    }
}