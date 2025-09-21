package art.aelaort.models.servers.ssh;

public interface SshServer {
	String name();
	String host();
	String keyPath();
	int port();
}
