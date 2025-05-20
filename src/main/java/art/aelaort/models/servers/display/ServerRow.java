package art.aelaort.models.servers.display;

import lombok.With;

public record ServerRow(
		@With Integer id,
		String name,
		String ip,
		Integer port,
		boolean monitoring,
		Integer price,
		String k8s,
		String sshKey,
		String services
) {
}
