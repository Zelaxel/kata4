package software.ulpgc.kata3.App;

import software.ulpgc.kata3.io.RemoteMonsterLoader;

public class Main {
    static void main() {
        new RemoteMonsterLoader().loadAll().forEach(System.out::println);
    }
}
