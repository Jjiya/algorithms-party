package leni;

public interface Solution {

    /**
     * ClassCreator(){
     *         System.out.println(this.getClass().getName());
     *         this.doIt();
     *     }
     * */

    default void run(Object obs){
        System.out.println(obs.getClass().getName()+" - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        process();
        System.out.println();
    }

    void process();

}


