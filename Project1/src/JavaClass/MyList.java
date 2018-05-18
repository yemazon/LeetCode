package JavaClass;

public abstract class MyList implements List {


    //re-declare
    //这个类的子类，必须重现实现shuffle
    @Override public abstract void shuffle();


    // re-define
    //如果是concrete class的话，也可以直接@Override

}
