package software.ulpgc.kata4.io;

import software.ulpgc.kata4.model.Monster;

import java.util.List;

public interface MonsterLoader {
    List<Monster> loadAll();
}
