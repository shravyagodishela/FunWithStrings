package SystemDesign.StreamsCollections;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        supplierexample();
    }
    static void supplierexample(){

        Supplier<String> randNumSupplier = ()->{
            String[] names = {"hi","hello","who"};
            int rand = new Random().nextInt(names.length);
            return names[rand];
        };
        System.out.println(randNumSupplier.get());
        System.out.println(randNumSupplier.get());
    }

}
