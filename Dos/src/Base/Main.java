package Base;

public class Main {

    public static void main(String[] args) throws Exception {


        Option.loadContents();

        Option.showOptions();

        boolean x = true;

        while (x == true) {

            switch (Option.getOption()) {

                case "0: ICMP_Flood":
                    IpAddress.getIP();
                    ICMP_Flood.attack(IpAddress.targetIp);

                    x = false;
                    break;

                case "1: SYN_Flood":
                    IpAddress.getIP();
                    PortScan.scan(IpAddress.targetIp);
                    PortScan.showOpenPorts();
                    Run.run();

                    x = false;
                    break;
            }
        }

    }
}