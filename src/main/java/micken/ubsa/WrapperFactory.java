package micken.ubsa;

import micken.ubsa.testclients.AWSTest;
import micken.ubsa.testclients.AzureTest;
import micken.ubsa.testclients.BlobStoreTest;
import micken.ubsa.testclients.GCPTest;

public class WrapperFactory {
    public static BlobStoreTest getWrapper() {
        String SDKType = System.getProperty("blobstorage.provider");

        if ("AWS".equalsIgnoreCase(SDKType)) {
            return new AWSTest();
        } else if ("Azure".equalsIgnoreCase(SDKType)) {
            return new AzureTest();
        } else if ("GCP".equalsIgnoreCase(SDKType)) {
            return new GCPTest();
        }

        throw new IllegalArgumentException(String.format("Invalid Blobstorage provider: %s. Pass blobstorage.provider as a VM option.", SDKType));
    }
}
