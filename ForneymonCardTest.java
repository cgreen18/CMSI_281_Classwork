//package forneymon.cardgame;

public class ForneymonCardTest{

    public static void main(String[] args){
        FlippingForneymonCard burny = new FlippingForneymonCard(true,"burnes","Burneymon");
        System.out.println(burny);
        burny.flip();
        System.out.println(burny);

        FlippingForneymonCard missingNu = new FlippingForneymonCard();
        System.out.println(missingNu);
        missingNu.flip();
        System.out.println(missingNu);
        System.out.println(burny.match(missingNu));
        burny.flip();
        System.out.println(burny.match(missingNu));

    }
}
