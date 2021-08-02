package MyTestRunner;

public class AssertsCollection {
    private static final String reply_template = "%sExpect result: %s Actual result: %s";

    public static class AssertException extends Exception {
        public AssertException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static <E,A> void assertEquals(E expected, A received) throws AssertException {
        if (!expected.equals(received)) {
            String reply = String.format(reply_template, "The given objects aren't equal. ->\n\t", expected, received);
            throw new AssertException(reply);
            //System.out.println(reply);
        }
    }

    public static <E,A> void assertArntEquals(E expected, A received) throws AssertException {
        if (expected.equals(received)) {
            String reply = String.format(reply_template, "The given objects are equal. ->\n\t", expected, received);
            throw new AssertException(reply);
            //System.out.println(reply);
        }
    }
}
