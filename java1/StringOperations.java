public class StringOperations {
    public static void main(String[] args) {
        String myName = "Sean";
        System.out.println(myName);

        String newName = "A" + myName.substring(1, myName.length()-1) + "Z";
        System.out.println(newName);

        String webAddress = "www.gatech.edu";
        System.out.println(webAddress);

        String webName = webAddress.substring(4,webAddress.length()-4);
        System.out.println(webName);

    }
}
