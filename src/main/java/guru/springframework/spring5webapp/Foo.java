package guru.springframework.spring5webapp;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;

import java.io.File;

public class Foo {


    public static void main(String[] args) {

        try {
            Scp scp = new Scp();
            scp.setPort(22);

            scp.setRemoteFile("ieca" + ":" + "ieca-services" + "@" + "10.240.151.23" + ":" + "webapps/DroolsTestingUI.war");

            scp.setLocalTodir("src\\main\\java\\guru\\springframework\\spring5webapp");

            scp.setProject(new Project());
            scp.setTrust(true);
            scp.execute();

            File file= new File("src\\main\\java\\guru\\springframework\\spring5webapp");

            System.out.println(file.hashCode());
        }
        catch (Exception ex){

            System.out.println("re bro");
        }

    }
}
