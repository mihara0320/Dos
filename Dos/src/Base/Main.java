package Base;




public class Main extends Option{

    public static void main (String[] args) throws Exception {



        // Initial Setup
        loadContents();

        // Ask user initial target setup
        targetSetup();

        if (defaultTargetSetup) {
            Setup.getInitialTargetIp();
            Setup.defaultPortScan(defaultTargetIp);
        }

        showOptions();


        switch (getOption()) {

            case "0: ICMP Flood":

                if (defaultTargetSetup == true) {

                    boolean userChoice = askYesNo("Do you want to use default target data?");
                    if(userChoice == true){
                        Attack.icmpAttack(defaultTargetIp);
                        break;
                    }else{
                        Setup.getAdhocTargetIp();
                        Attack.icmpAttack(adhocTargetIp);
                        adhocTargetIp = "";
                        break;
                    }
                }
                else {
                    Setup.getAdhocTargetIp();
                    Attack.icmpAttack(adhocTargetIp);
                    adhocTargetIp = "";
                    break;
                }

            case "1: SYN Flood":
                if(defaultTargetSetup == true) {
                    boolean userChoice = askYesNo("Do you want to use default target data?");
                    if(userChoice == true){
                        Setup.showOpenPorts(defaultOpenPorts);
                        Attack.synAttack(defaultTargetIp);
                        break;
                    } else {
                        boolean newScan = askYesNo("Do you want to scan new target?");
                        if(newScan == true){
                            Setup.getAdhocTargetIp();
                            Setup.adhocPortScan(adhocTargetIp);
                            showOpenPorts(adhocOpenPorts);
                            Attack.synAttack(adhocTargetIp);
                            adhocTargetIp = "";
                            break;
                        } else {
                            Attack.synAttack(adhocTargetIp);
                            break;
                        }
                    }
                }else{
                    boolean newScan = askYesNo("Do you want to scan new target?");
                    if(newScan == true){
                        Setup.getAdhocTargetIp();
                        Setup.adhocPortScan(adhocTargetIp);
                        showOpenPorts(adhocOpenPorts);
                        Attack.synAttack(adhocTargetIp);
                        adhocTargetIp = "";
                        break;
                    } else {
                        Attack.synAttack(adhocTargetIp);
                        break;
                    }

                }
        }
    }
}