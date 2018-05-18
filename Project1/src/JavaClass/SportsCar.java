package JavaClass;

public class SportsCar implements Coupe, Car {

    private final String name;

    public void getName(Thread thread) {
        final String name = thread.getName();
        thread.setRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println(SportsCar.this.name);
            }
        });


        thread.setRunnable(() -> System.out.println(SportsCar.this.name));
    }

    private Runnable getLambda() {
        return () -> {
            while (!Thread.currentThread().isInterrupted()) {
                //TODO
            }
        };
    }

    public void apply(Thread thread) {
        final String name = thread.getName();

        modifyName(name, String::toUpperCase);
        modifyName(name::toUpperCase);
    }

    private void modifyName(Function<String, String> function) {
        //TODO

        function.apply();
    }


    @Override public int getNum() {
        return Coupe.super.getNum();
    }

    (int x, int y) -> {x+y}

    public int plus(int x,int y){
        return x+y;
    }


}
