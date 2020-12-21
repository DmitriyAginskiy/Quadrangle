package by.aginskiy.figure.model.repository;

import by.aginskiy.figure.model.entity.Quadrangle;

import java.util.*;
import java.util.stream.Collectors;

public class QuadrangleRepository {

    private List<Quadrangle> quadrangleList = new ArrayList<>();

    public int size() {
        return quadrangleList.size();
    }

    public boolean add(Quadrangle quadrangle) {
        return quadrangleList.add(quadrangle);
    }

    public boolean remove(Object o) {
        return quadrangleList.remove(o);
    }

    public boolean addAll(Collection<? extends Quadrangle> c) {
        return quadrangleList.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return quadrangleList.removeAll(c);
    }

    public Quadrangle get(int index) {
        return quadrangleList.get(index);
    }

    public Quadrangle set(int index, Quadrangle element) {
        return quadrangleList.set(index, element);
    }

    public void add(int index, Quadrangle element) {
        quadrangleList.add(index, element);
    }

    public Quadrangle remove(int index) {
        return quadrangleList.remove(index);
    }

    public List<Quadrangle> query(Specification specification) {
        List<Quadrangle> result = quadrangleList.stream().filter(quadrangle -> specification.specify(quadrangle)).collect(Collectors.toList());
        return result;
    }
}
