package hellojpa;

import hellojpa.training.Address;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10;
        int b = a;

        a = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Integer c = new Integer(10);
        Integer d = c;

        System.out.println("c = " + c);
        System.out.println("d = " + d);

        int aa = 10;
        int bb = 10;
        System.out.println("(aa == bb) = " + (aa == bb));

        Address address1 = new Address("city", "street", "zipcode");
        Address address2 = new Address("city", "street", "zipcode");
        System.out.println("address1 == address2 = " + (address1 == address2));
        System.out.println("address1 equals address2 = " + (address1.equals(address2)));

    }
}
