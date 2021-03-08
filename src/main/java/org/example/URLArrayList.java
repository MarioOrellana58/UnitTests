package org.example;

import java.util.Arrays;

public class URLArrayList implements List{

    private int size = 0;
    private Object elements[];

    public URLArrayList() {
        elements = new Object[2];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0 ){
            throw new IndexOutOfBoundsException();
        }

        return elements[i];
    }

    @Override
    public Object set(int i, Object o) throws IndexOutOfBoundsException {
        if (i >= size || i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Object replaced = elements[i];
        elements[i] = o;
        return replaced;
    }

    @Override
    public void add(int i, Object o) throws IndexOutOfBoundsException {
        if (i > size || i < 0 ){
            throw new IndexOutOfBoundsException();
        }

        size++;

        if (size == elements.length) {
            increaseSize();
        }

        Object aux1 = elements[i];
        elements[i] = o;
        Object aux2 = null;
        var usarAux1 = false;

        for (int j = i + 1; j < size; j++){
            if (!usarAux1){
                aux2 = elements[j];
                elements[j] = aux1;
                usarAux1 = true;
            }
            else{
                aux1 = elements[j];
                elements[j] = aux2;
                usarAux1 = false;
            }
        }
    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Object removed = elements[i];

        for (int j = i; j <= size; j++){

            if (j + 1 < size){
                elements[j] = elements[j+1];
            }
            else{
                elements[j] = null;
                break;
            }
        }

        if (elements[elements.length / 2] == null){
            decreaseSize();
        }

        size--;

        return removed;
    }

    private void increaseSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void decreaseSize() {
        int newSize = elements.length / 2;
        elements = Arrays.copyOf(elements, newSize);
    }


}
