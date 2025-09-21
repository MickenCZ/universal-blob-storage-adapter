package micken.ubsa;

import micken.ubsa.testclients.AWSTest;
import micken.ubsa.testclients.AzureTest;
import micken.ubsa.testclients.BlobStoreTest;
import micken.ubsa.testclients.GCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WrapperFactory {
    public static BlobStoreTest getWrapper() throws IOException {
        Properties config = new Properties();
        try (InputStream input = WrapperFactory.class.getResourceAsStream("/config.properties")) {
            config.load(input);
        }

        String SDKType = config.getProperty("blobstorage.provider");

        if ("AWS".equalsIgnoreCase(SDKType)) {
            return new AWSTest();
        } else if ("Azure".equalsIgnoreCase(SDKType)) {
            return new AzureTest();
        } else if ("GCP".equalsIgnoreCase(SDKType)) {
            return new GCPTest();
        }

        throw new IllegalArgumentException("Unknown Blobstorage provider");
    }
}
