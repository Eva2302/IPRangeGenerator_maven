public class IPAddress {
    protected String address;
    protected int[] members;
    protected long longValue;

    public IPAddress(String pAddress)
    {
        address = pAddress;
    }

    //Parsing IP-Address into 4 elements
    public void split()
    {
        String mem[] = address.split("\\.");
        members = new int[mem.length];

        for (int i=0; i < mem.length; i++)
        {
            members[i] = Integer.parseInt(mem[i]);
        }

        longValue = ((long) members[0]<<24) +
                 ((long) members[1]<<16) +
                 ((long) members[2]<<8)  +
                 ((long) members[3]);

    }

    //For Debugging purpose
    public void chckObjInfo()
    {
        System.out.println("Obj.address="+address);

        System.out.println("Obj.members:");

        for (int i=0; i<members.length; i++)
        {
            System.out.println(members[i]);
        }
    }
}
