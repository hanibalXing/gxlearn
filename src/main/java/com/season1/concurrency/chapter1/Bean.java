package com.season1.concurrency.chapter1;

import java.util.Objects;

public class Bean {
    private String name;
    private String set;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean bean = (Bean) o;
        return Objects.equals(name, bean.name) &&
                Objects.equals(set, bean.set);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, set);
    }
}
