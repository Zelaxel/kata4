package software.ulpgc.kata4.tasks;

import software.ulpgc.kata4.model.Monster;
import software.ulpgc.kata4.viewModel.Histogram;

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
