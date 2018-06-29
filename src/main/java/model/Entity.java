package model;

import java.io.Serializable;

public class Entity implements Serializable {


    //Constants//
    //----------------------------------------------------------------------------------------------------------------//
    public static final String ID = "id";

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    protected int id;

    //Methods//
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entity other = (Entity) obj;
        if (id != other.id)
            return false;
        return true;
    }

    //Getters & Setters//
    //----------------------------------------------------------------------------------------------------------------//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String primaryKeyColumnName(){
        return ID;
    }
}
