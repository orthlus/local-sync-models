package art.aelaort.models.servers.display;

import lombok.With;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record K8sCronJobRow(
		@With
		Integer id,
		String cluster,
		String namespace,
		String image,
		String name,
		String schedule,
		String imagePullPolicy,
		String memoryLimit
) implements Comparable<K8sCronJobRow> {
	@Override
	public int compareTo(K8sCronJobRow o) {
		return Comparator.comparing(K8sCronJobRow::cluster)
				.thenComparing(K8sCronJobRow::namespace)
				.thenComparing(K8sCronJobRow::name)
				.compare(this, o);
	}

	public static List<K8sCronJobRow> addNumbers(List<K8sCronJobRow> k8sCronJobRows) {
		AtomicInteger inc = new AtomicInteger(1);
		return k8sCronJobRows.stream()
				.sorted()
				.map(car -> car.withId(inc.getAndIncrement()))
				.toList();
	}
}
