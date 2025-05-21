package art.aelaort.models.servers.display;

import lombok.With;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record K8sAppRow(
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
		String memoryLimit,
		String strategy,
		String route
) implements Comparable<K8sAppRow> {

	@Override
	public int compareTo(K8sAppRow o) {
		return Comparator.comparing(K8sAppRow::cluster)
				.thenComparing(K8sAppRow::namespace)
				.thenComparing(K8sAppRow::kind)
				.thenComparing(K8sAppRow::name)
				.compare(this, o);
	}

	public static List<K8sAppRow> addNumbers(List<K8sAppRow> k8sAppRows) {
		AtomicInteger inc = new AtomicInteger(1);
		return k8sAppRows.stream()
				.sorted()
				.map(car -> car.withId(inc.getAndIncrement()))
				.toList();
	}
}