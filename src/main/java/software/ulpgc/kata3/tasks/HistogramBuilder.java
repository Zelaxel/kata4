package software.ulpgc.kata3.tasks;

import software.ulpgc.kata3.model.Monster;
import software.ulpgc.kata3.viewModel.Histogram;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public record HistogramBuilder(List<Monster> monsters) {
    public <T> Histogram<T> build(Function<Monster, Stream<T>> binarize) {
        Histogram<T> histogram = new Histogram<>();
        monsters.stream().flatMap(binarize).forEach(histogram::put);
        return histogram;
    }
}
