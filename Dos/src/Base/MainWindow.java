package Base;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class MainWindow extends Option {

    // This program keeps running until this loop turns false
    static boolean loop = true;

    /**
     *  main method
     *
     *  Controls main framework of this program
     */
    public static void main (String[] args) throws Exception {

        // Perform Unit Testing before the main functionality
        TestRunner.runUnitTest(IsValidTest.class);
        TestRunner.runUnitTest(OptionTest.class);


        // Printing a cute character saying welcome
        Greeting.printWelcome();

        // Initial setup
        loadContents();

        do {
            // Show functions of this program as options
            showOptions();

            // Controls transition to selected function
            switch (askOption()) {

                // User can setup up to 1 default target data
                // Which can be used later for any functions
                case "0: Setup default target":

                    // Checks if there is already existing default target setup
                    if (Attack.defaultTargetSetup){

                        System.out.println("Caution: You can only have one default target");
                        boolean confirm = IsValid.isYesNo("Do you want to erase the current config, and set up new one?");

                        if (confirm){
                            GetData.defaultTargetSetup();
                        } else {
                            break;
                        }

                    }else{
                        GetData.defaultTargetSetup();
                        break;
                    }

                // Perform ICMP Flood function
                // User can choose whether use default target data or not if there is any
                case "1: ICMP Flood":

                    if (Attack.defaultTargetSetup == true) {

                        boolean userChoice = IsValid.isYesNo("Do you want to use default target data?");
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

                // Perform SYN Flood function
                // User can choose whether use default target data or not if there is any
                // If user didn't use default target data, portScan function can be used here
                // User need to manually choose attacking ports
                case "2: SYN Flood":
                    if (Attack.defaultTargetSetup == true) {
                        boolean userChoice = IsValid.isYesNo("Do you want to use default target data?");
                        System.out.println();
                        if (userChoice == true) {
                            SynFlood.synAttack(Attack.getDefaultTargetIp());
                            break;
                        } else {
                            boolean newScan = IsValid.isYesNo("Do you want to scan target?");
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
                        boolean newScan = IsValid.isYesNo("Do you want to scan target?");
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

            // Exit loop and finish this program
            loop = exit();

        }while(loop);

        // Print out author's name and group
        Greeting.printI700();

    }

}