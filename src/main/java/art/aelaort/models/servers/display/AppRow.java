package art.aelaort.models.servers.display;

import lombok.With;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record AppRow(@With Integer id, String server, String image, String app, String file) {
	public static List<AppRow> addNumbers(List<AppRow> appRows) {
		AtomicInteger inc = new AtomicInteger(1);
		return appRows.stream()
				.sorted(Comparator.comparing(AppRow::server))
				.map(ar -> ar.withId(inc.getAndIncrement()))
				.toList();
	}
}
