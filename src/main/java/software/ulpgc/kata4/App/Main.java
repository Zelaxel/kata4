package software.ulpgc.kata4.App;

import org.json.JSONArray;
import org.json.JSONObject;
import software.ulpgc.kata4.io.RemoteMonsterLoader;
import software.ulpgc.kata4.model.Monster;
import software.ulpgc.kata4.tasks.HistogramBuilder;
import software.ulpgc.kata4.viewModel.Histogram;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main() {
        List<Monster> monsters = new RemoteMonsterLoader(Main::parse).loadAll();
        Histogram<Boolean> histogram = new HistogramBuilder(monsters).build(m -> Stream.of(m.isLarge()));
        histogram.forEach(bin -> System.out.println(bin + ": " + histogram.count(bin)));
    }

    public static Monster parse(JSONObject input) {
        return new Monster(
                input.getString("name"),
                toType(input.getString("type")),
                input.getBoolean("isLarge"),
                toGames(input.getJSONArray("games"))
        );
    }

    private static List<String> toGames(JSONArray jsonArray) {
        List<JSONObject> jsonObjects = new ArrayList<>();
        jsonArray.forEach(j -> jsonObjects.add((JSONObject) j));
        return jsonObjects.stream().map(j -> j.getString("game")).toList();
    }

    private static Monster.Type toType(String type) {
        return Monster.Type.valueOf(type.replace(" ", "_").replace("???", "unknown"));
    }
}
