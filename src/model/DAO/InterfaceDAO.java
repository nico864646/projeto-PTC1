package model.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
    
    public abstract void create(T objeto);
    public abstract List<T> read();
    public abstract T read(int codigo);
    public abstract T read(String descricao);
    public abstract void update(T objeto);
    public abstract void delete(T objeto);
}
