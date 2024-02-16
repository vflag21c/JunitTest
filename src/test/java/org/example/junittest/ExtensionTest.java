package org.example.junittest;

import org.example.junittest.extension.FindSlowTestExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class ExtensionTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @Test
//    @SlowTest
    void test1() throws InterruptedException {
        Thread.sleep(2003L);
    }
}
