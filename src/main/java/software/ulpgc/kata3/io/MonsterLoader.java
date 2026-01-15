package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Monster;

import java.util.List;

public interface MonsterLoader {
    List<Monster> loadAll();
}
