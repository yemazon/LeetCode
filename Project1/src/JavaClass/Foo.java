package JavaClass;

public class Foo extends RuntimeException {

    public Foo(String message) {
        super(message);
    }

    public static void main(String[] args) throws Foo {
        try {
            throw new Foo("\u2603");
        } catch (Foo foo) {
            System.out.printf("%s%n", foo.getMessage());
        } catch (Exception f) {
            System.out.printf("%s - %s%n", f.getMessage(), (f instanceof Foo));
        }
    }

    @Override
    public String getMessage() {
        return "aaa";
    }
}
