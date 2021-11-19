public class scratch {

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";
        String d = b + 2;
        String e = c + 2;
        System.out.println(d == a);
        System.out.println(e == a);
    }
}
