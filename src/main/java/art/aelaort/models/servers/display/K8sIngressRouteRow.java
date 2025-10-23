package art.aelaort.models.servers.display;

import java.util.Comparator;

public record K8sIngressRouteRow(
		String cluster,
		String namespace,
		String name,
		String route
) implements Comparable<K8sIngressRouteRow> {
	@Override
	public int compareTo(K8sIngressRouteRow o) {
		return Comparator.comparing(K8sIngressRouteRow::cluster)
				.thenComparing(K8sIngressRouteRow::namespace)
				.thenComparing(K8sIngressRouteRow::name)
				.compare(this, o);
	}
}
