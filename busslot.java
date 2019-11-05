import java.text.SimpleDateFormat;
import java.util.*;

public class busslot
{
    void first() {
        int totalbuses;
        int slot=1;
        Scanner sc = new Scanner(System.in);
        totalbuses=sc.nextInt();
        SimpleDateFormat format=new SimpleDateFormat("hh:mm a");
        String[] in = new String[totalbuses];
        String[] out = new String[totalbuses];
        Date[]   intime=new Date[totalbuses];
        Date[]   outtime=new Date[totalbuses];
        sc.nextLine();
        for (int i = 0; i < totalbuses; i++) {
            System.out.println("Enter the bus in time:");
            in[i] = sc.nextLine();
            System.out.println("Enter the bus out time:");
            out[i] = sc.nextLine();
        }
        for(int i=0;i<totalbuses;i++) {
            try {
                intime[i] = format.parse(in[i]);
                outtime[i] = format.parse(out[i]);
                for (int j = i + 1; j < 5; j++) {
                    intime[j] = format.parse(in[j]);
                    outtime[j] = format.parse(out[j]);
                    if (intime[i].compareTo(outtime[j])>0) {
                        Date temp = intime[j];
                        intime[j] = intime[i];
                        intime[i] = temp;
                        temp = outtime[j];
                        outtime[j] = outtime[i];
                        outtime[i] = temp;
                    }
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        for (int i=1;i<totalbuses;i++)
        {
            for(int j=0;j<i;j++)
            {
                if (intime[i].compareTo(outtime[j])>0)
                {
                    if(j==i-1)
                    {
                        slot++;
                    }
                    continue;
                }
                else
                {
                    outtime[j]=outtime[i];
                    break;
                }

            }
        }
        System.out.println(slot);

    }
    public static void main(String[] args)
    {
        new busslot().first();
    }
}
