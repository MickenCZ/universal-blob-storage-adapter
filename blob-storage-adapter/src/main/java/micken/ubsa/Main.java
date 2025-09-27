package micken.ubsa;

import micken.ubsa.testclients.AWSTest;
import micken.ubsa.testclients.AzureTest;
import micken.ubsa.testclients.GCPTest;

public class Main {
    public static void main(String[] args) {
        new AWSTest().test();
        new AzureTest().test();
        new GCPTest().test();


    }





}