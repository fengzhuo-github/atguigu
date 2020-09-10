package test;


import javax.sound.midi.Soundbank;

public class Test {

    public static void main(String[] args) {
//        Test test = new Test();
//        Object copy = null;
//        try {
//             copy = test.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(copy);
        String name = "\uD835\uDD46h";
        System.out.println(name.length());
        System.out.println(name);
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println(Integer.toHexString(name.codePointAt(1)));
    }
}