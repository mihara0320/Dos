package Base;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class MainWindow extends Option {

    public static void main (String[] args) throws Exception {

        loadContents();

        boolean loop = true;

        do {

            System.out.println("Test");

            showOptions();

            switch (askOption()) {

                case "0: Setup default target":

                    if (Attack.defaultTargetSetup){

                        System.out.println("Caution: You can only have one default target");
                        boolean confirm = askYesNo("Do you want to erase the current config, and set up new one?");

                        if (confirm){
                            GetData.defaultTargetSetup();
                        } else {
                            break;
                        }

                    }else{
                        GetData.defaultTargetSetup();
                        break;
                    }


                case "1: ICMP Flood":

                    if (Attack.defaultTargetSetup == true) {

                        boolean userChoice = askYesNo("Do you want to use default target data?");
                        if (userChoice == true) {
                            IcmpFlood.icmpAttack(Attack.getDefaultTargetIp());
                            break;
                        } else {
                            GetData.getAdhocTargetIp();
                            IcmpFlood.icmpAttack(Attack.getAdhocTargetIp());
                            Attack.setAdhocTargetIp("");
                            break;
                        }
                    } else {
                        GetData.getAdhocTargetIp();
                        IcmpFlood.icmpAttack(Attack.getAdhocTargetIp());
                        Attack.setAdhocTargetIp("");
                        break;
                    }


                case "2: SYN Flood":
                    if (Attack.defaultTargetSetup == true) {
                        boolean userChoice = askYesNo("Do you want to use default target data?");
                        System.out.println();
                        if (userChoice == true) {
                            SynFlood.synAttack(Attack.getDefaultTargetIp());
                            break;
                        } else {
                            boolean newScan = askYesNo("Do you want to scan target?");
                            System.out.println();
                            if (newScan == true) {
                                GetData.getAdhocTargetIp();
                                GetData.adhocPortScan(Attack.getAdhocTargetIp());
                                SynFlood.synAttack(Attack.getAdhocTargetIp());
                                Attack.setAdhocTargetIp("");
                                break;
                            } else {
                                GetData.getAdhocTargetIp();
                                SynFlood.synAttack(Attack.getAdhocTargetIp());
                                break;
                            }
                        }
                    } else {
                        boolean newScan = askYesNo("Do you want to scan target?");
                        System.out.println();
                        if (newScan == true) {
                            GetData.getAdhocTargetIp();
                            GetData.adhocPortScan(Attack.getAdhocTargetIp());
                            SynFlood.synAttack(Attack.getAdhocTargetIp());
                            Attack.setAdhocTargetIp("");
                            break;
                        } else {
                            GetData.getAdhocTargetIp();
                            SynFlood.synAttack(Attack.getAdhocTargetIp());
                            break;
                        }
                    }
            }

            loop = exit();

        }while(loop);

        Greeting.printI700();

    }
}