package smlogx.UnitTest;

import smlogx.api.v1.Configuration.Prefs.Config;
import smlogx.api.v1.Configuration.Prefs.Node;

public class Test {

    public void test() {
        System.out.println("From Unit.Test.test()");
    }

    public static void main(String[] args) {
        Config config = new Config(Node.DB_ROOT);

    }
}
