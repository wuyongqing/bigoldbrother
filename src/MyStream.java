import java.util.List;

class MyStream<T>{

    private List<T> list;

    public void setList(List<T> list) {
        this.list = list;
    }

    public void myForEach(ConsumerInterface<T> consumer){// 1
        for(T t : list){
            consumer.accept(t);
        }
    }
}