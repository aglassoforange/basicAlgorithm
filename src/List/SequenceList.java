package List;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{

    private T[] eles;
    private int N;

    public SequenceList(int capacity){
        this.eles = (T[])new Object[capacity];
        this.N = 0;
    }

    public void clear(){
        this.N = 0;
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    public int length(){
        return this.N;
    }

    public T get(int i){
        return this.eles[i];
    }

    public void insert(T a){
        this.eles[N++] = a;
    }

    public void insert(int i, T a){
        for(int j = N + 1; j > i; j--){
            this.eles[j] = this.eles[j - 1];
        }
        this.eles[i] = a;
        this.N++;
        if(N > eles.length){
            resize(N*2);
        }
    }

    public void remove(int i){
        for(int j = i; j <= N; j++){
            this.eles[j] = this.eles[i + 1];
        }
        this.N--;
        if(N < eles.length/4){
            resize(N/2);
        }
    }

    public int indexOf(T t){
        for(int i = 0; i < N; i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public void resize(int newSize){
        T[] temp = this.eles;
        this.eles = (T[]) new Object[newSize];
        for(int i = 0; i < newSize; i++){
            eles[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {

        private int cur;

        public SIterator() {
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < N;
        }

        @Override
        public Object next() {
            return eles[cur++];
        }
    }


    public static void main(String[] args) {
        SequenceList<String> sequence = new SequenceList<>(10);
        sequence.insert(0,"姚明");
        sequence.insert(1,"科比");
        sequence.insert(2,"麦迪");
        sequence.insert(1,"字母歌");
        for(String s:sequence){
            System.out.println(s);
        }
    }
}
