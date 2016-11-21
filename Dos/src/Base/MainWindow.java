package Base;




public class MainWindow extends Option {

    public static void main (String[] args) throws Exception {

        Test.printURI();

        loadContents();

        boolean loop = true;

        do {

            showOptions();

            switch (getOption()) {

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
                            IcmpFlood.icmpAttack(Attack.defaultTargetIp);
                            break;
                        } else {
                            GetData.getAdhocTargetIp();
                            IcmpFlood.icmpAttack(Attack.adhocTargetIp);
                            Attack.adhocTargetIp = "";
                            break;
                        }
                    } else {
                        GetData.getAdhocTargetIp();
                        IcmpFlood.icmpAttack(Attack.adhocTargetIp);
                        Attack.adhocTargetIp = "";
                        break;
                    }


                case "2: SYN Flood":
                    if (Attack.defaultTargetSetup == true) {
                        boolean userChoice = askYesNo("Do you want to use default target data?");
                        System.out.println();
                        if (userChoice == true) {
                            SynFlood.synAttack(Attack.defaultTargetIp);
                            break;
                        } else {
                            boolean newScan = askYesNo("Do you want to scan target?");
                            System.out.println();
                            if (newScan == true) {
                                GetData.getAdhocTargetIp();
                                GetData.adhocPortScan(Attack.adhocTargetIp);
                                SynFlood.synAttack(Attack.adhocTargetIp);
                                Attack.adhocTargetIp = "";
                                break;
                            } else {
                                SynFlood.synAttack(Attack.adhocTargetIp);
                                break;
                            }
                        }
                    } else {
                        boolean newScan = askYesNo("Do you want to scan target?");
                        System.out.println();
                        if (newScan == true) {
                            GetData.getAdhocTargetIp();
                            GetData.adhocPortScan(Attack.adhocTargetIp);
                            SynFlood.synAttack(Attack.adhocTargetIp);
                            Attack.adhocTargetIp = "";
                            break;
                        } else {
                            SynFlood.synAttack(Attack.adhocTargetIp);
                            break;
                        }
                    }
            }

            loop = exit();

        }while(loop);

        Greeting.byebye();
    }
}