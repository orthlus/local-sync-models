package art.aelaort.models.servers.ssh;

public record SshConfigServer(String name, String host, String keyPath, int port) implements SshServer {
}
