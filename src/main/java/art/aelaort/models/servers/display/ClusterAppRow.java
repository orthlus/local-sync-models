package art.aelaort.models.servers.display;

import lombok.With;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record ClusterAppRow(
		@With
		Integer id,
		String cluster,
		String namespace,
		String image,
		String name,
		String kind,
		String imagePullPolicy,
		String ports,
		String service,
		String schedule,
		String memoryLimit,
		String strategy,
		String route
) implements Comparable<ClusterAppRow> {

	@Override
	public int compareTo(ClusterAppRow o) {
		return Comparator.comparing(ClusterAppRow::cluster)
				.thenComparing(ClusterAppRow::namespace)
				.thenComparing(ClusterAppRow::kind)
				.thenComparing(ClusterAppRow::name)
				.compare(this, o);
	}

	public static List<ClusterAppRow> addNumbers(List<ClusterAppRow> clusterAppRows) {
		AtomicInteger inc = new AtomicInteger(1);
		return clusterAppRows.stream()
				.sorted()
				.map(car -> car.withId(inc.getAndIncrement()))
				.toList();
	}
}