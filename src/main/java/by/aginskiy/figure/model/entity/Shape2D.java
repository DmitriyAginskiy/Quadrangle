package by.aginskiy.figure.model.entity;

import by.aginskiy.figure.util.IdGenerator;

public abstract class Shape2D {

    protected long id = IdGenerator.getId();

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shape2D shape2D = (Shape2D) o;

        return id == shape2D.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape2D{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
