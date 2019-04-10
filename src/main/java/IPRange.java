public class IPRange {

    private IPAddress ip1;
    private IPAddress ip2;

    private static final int maxRange = 256;

    public IPRange(String pStart, String pEnd)
    {
        ip1 = new IPAddress(pStart);
        ip1.split();

        ip2 = new IPAddress(pEnd);
        ip2.split();
    }

    //Defining Min and Max IP-addresses
    //return 0 - if we can build a range
    //return 1 - if equals ip-addresses were entered
    //return 2 - if sequenced ip-addresses were entered
    public int findBorders()
    {
        if (ip1.longValue == ip2.longValue) {return 1;}

        if (Math.abs(ip1.longValue-ip2.longValue) == 1) {return 2;}


        long    min = Math.min(ip1.longValue, ip2.longValue);

        if (min != ip1.longValue)
        {
            IPAddress ip = ip1;
            ip1 = ip2;
            ip2 = ip;
        }

        return 0;
    }

    public void makeIPRange()
    {   int position0 = ip1.members[0];
        int position1 = ip1.members[1];
        int position2 = ip1.members[2];
        int position3 = ip1.members[3]+1;

        int correction1 = maxRange;
        int correction2 = maxRange;
        int correction3 = maxRange;

        do {//First octet cycle
            if (position0 == ip2.members[0]) {
                correction1 = ip2.members[1] + 1;
            }
            do {//Second octet cycle
                if (position1 == ip2.members[1]) {
                    correction2 = ip2.members[2] + 1;
                }
                //Third octet cycle
                do {
                    if (position0 == ip2.members[0] && position1 == ip2.members[1] && position2 == ip2.members[2])
                    {
                        correction3 = ip2.members[3];
                    }
                    //Fourth octet cycle
                    do {

                        System.out.println(position0 + "." + position1 + "." + position2 + "." + position3);
                        position3++;
                    }
                    while ((position3 + correction3) % correction3 != 0);
                    position2++;
                    position3 = 0;
                }
                while ((position2 + correction2) % correction2 != 0);

                position1++;
                position2 = 0;
                position3 = 0;
            }
            while ((position1 + correction1) % correction1 != 0);

            position0++;
            position1 = 0;
            position2 = 0;
            position3 = 0;
        } while (position0 <= ip2.members[0]);
    }

    public void go()
    {
        //Finding min and max IP-addresses
        int result = findBorders();

        switch (result)
        {
            case 0: break;
            case 1: System.out.println("You've probably entered equals IP Addresses. Try one more time.");
                break;
            case 2: System.out.println("You've probably entered sequenced IP Addresses. Try one more time.");
                break;
            default: break;
        }

        makeIPRange();

    }
}
