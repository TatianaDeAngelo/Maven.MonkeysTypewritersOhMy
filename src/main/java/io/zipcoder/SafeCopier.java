package io.zipcoder;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    private final StringBuffer stringBuffer;

    public SafeCopier(String copy) {
        super(copy);

        this.stringBuffer = new StringBuffer();
    }

    public void run() {
        while (stringIterator.hasNext()) {
            stringBuffer.append(stringIterator.next()).append(" ");
        }
        this.copied = stringBuffer.toString();
    }
}
