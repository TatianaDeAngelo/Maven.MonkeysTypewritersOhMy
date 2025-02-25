package io.zipcoder;

import java.util.ArrayList;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the worst of times,\n" +  //blurst?
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe),
        // create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


/**
 * similar to the threadbare lab,
 * 1 the way the code was written each monkey is just getting the next word
 * so it wouldn't give the entire into
 * 2 the unsafe and safe cannot be run "concurrently"?
 */

//        UnsafeCopier unsafeCopy = new UnsafeCopier(introduction);
//        for (int i = 0; i < 5; i++) {
//            monkeyList.add(new Thread(unsafeCopy));
//        }
//            for (Thread keyWord : monkeyList) {
//            keyWord.start();
//            }
        ArrayList<Thread> monkeyList = new ArrayList<Thread>();
        SafeCopier safeCopy = new SafeCopier(introduction);
        for (int j = 0; j < 5; j++) {
            monkeyList.add(new Thread(safeCopy));
        }
        for (Thread keyWord : monkeyList) {
            keyWord.start();
        }

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        //System.out.println(unsafeCopy.copied);
        System.out.println(safeCopy.copied);
    }
}