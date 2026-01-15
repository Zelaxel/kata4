package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Monster;

public interface MonsterParser<T> {
    Monster parse(T input);
}
