package Base;


import java.nio.file.Path;
import java.nio.file.Paths;


public class test{
    public static void test()

    {

        Path p = Paths.get("syn.py");
        Path folder = p.getParent();

        System.out.println(folder);

    }
}