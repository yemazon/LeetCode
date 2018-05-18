//package javaConcurrency;
//
//import java.util.concurrent.Callable;
//
//public class RaceCondition {
//
//    public static void main(String[] args) throws Exception {
//
//        final UniqueNumberGenerator generator = new UniqueNumberGenerator();
//        Callable<Long> logic = new Callable<Long>() {
//            @Override
//            public Long call() throws Exception {
//                return generator.next();
//            }
//        };
//
//        //Concurrent.run(logic, 2);
//    }
//}
